/**
 * 
 */
package cl.dsoft.car.mobile.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.joda.time.DateTime ;
import org.joda.time.Months;

import cl.dsoft.car.misc.MyCarException;
import cl.dsoft.car.misc.Rendimiento;
import cl.dsoft.car.misc.UnsupportedParameterException;
import cl.dsoft.car.mobile.model.CambioRevisionModelo;
import cl.dsoft.car.mobile.db.CambioRevision;
import cl.dsoft.car.mobile.db.CargaCombustible;
import cl.dsoft.car.mobile.db.Combustible;
import cl.dsoft.car.mobile.db.MantencionBase;
import cl.dsoft.car.mobile.db.MantencionBaseHecha;
import cl.dsoft.car.mobile.db.MantencionUsuario;
import cl.dsoft.car.mobile.db.MantencionUsuarioHecha;
import cl.dsoft.car.mobile.db.Traccion;
import cl.dsoft.car.mobile.db.Vehiculo;


/**
 * @author lfhernandez
 *
 */
public class VehiculoModelo extends Vehiculo {

	/**
	 * 
	 */
	public VehiculoModelo() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	private MantencionBaseHechaModelo getMantencionMasReciente(Connection conn, MantencionBase mb) throws UnsupportedParameterException, SQLException {
		 
		ArrayList<MantencionBaseHechaModelo> list_mbh;
		ArrayList<AbstractMap.SimpleEntry<String, String>> parametros;
		MantencionBaseHechaModelo ret = null;
		
		parametros = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
		
		// encuentro ultima mantencion hecha de este tipo
		parametros.clear();
		
		parametros.add(new AbstractMap.SimpleEntry<String, String>("id_mantencion_base", String.valueOf(mb.getId())));
		parametros.add(new AbstractMap.SimpleEntry<String, String>("id_usuario", String.valueOf(getIdUsuario())));
		parametros.add(new AbstractMap.SimpleEntry<String, String>("id_vehiculo", String.valueOf(getIdVehiculo())));
		
		list_mbh = MantencionBaseHechaModelo.seeks(conn, parametros, "fecha_modificacion", "DESC", 0, 1);
		
		if (!list_mbh.isEmpty()) {
			ret = list_mbh.get(0);
		}
		
		return ret;
	}

	private MantencionBaseHechaModelo getMantencionBasePendiente(Connection conn, MantencionBase mb) throws UnsupportedParameterException, SQLException, ParseException {

		MantencionBaseHechaModelo mbh = null;
		
		// encuentro ultima mantencion hecha de este tipo
	
        mbh = getMantencionMasReciente(conn, mb);
        
        return getMantencionBasePendiente(conn, mb, mbh);
	}

	private MantencionBaseHechaModelo getMantencionBasePendiente(Connection conn, MantencionBase mb, MantencionBaseHechaModelo mbh) throws UnsupportedParameterException, SQLException, ParseException {

		MantencionBaseHechaModelo ret = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Integer n;
        Boolean bFound = false;
        
    	Integer kmInicial;
    	Date dInicial, dFinal;
    	DateTime dtInicial, dtFinal;
        
		if (mb.getDependeKm() && mb.getKmEntreMantenciones() != null && mb.getKmEntreMantenciones() > 0) {
			
			kmInicial = 0;
			
			if (mbh != null) {
    			
    			kmInicial = mbh.getKm();
    		}

    		n = (this.getKm() - kmInicial) / mb.getKmEntreMantenciones();
    		
    		if (n > 0) {
    			// hay mantencion pendiente, o bien no la ha informado
    			ret = new MantencionBaseHechaModelo();
    			
    			ret.setIdMantencionBase(mb.getId());
    			ret.setIdVehiculo(this.getIdVehiculo());
    			ret.setIdUsuario(this.getIdUsuario());
    			ret.setDescripcionItem(mb.getDescripcionItem());
    			//ret.setEsMantencion(mbh.getEsMantencion());

    			ret.setKm(kmInicial + n * mb.getKmEntreMantenciones());
    			//mbh.setFecha(formatter.format(new Date()));
    			
    			bFound = true;
    		}
		}

		if (!bFound && mb.getMesesEntreMantenciones() != null && mb.getMesesEntreMantenciones() > 0) {
			
	        formatter = new SimpleDateFormat("yyyy-MM-dd");
    		
			dInicial = formatter.parse(this.getAnio().toString() + "-01-01"); // anio de compra
			dFinal = new Date(); // now
			    			
			if (mbh != null) {
    			
				dInicial = mbh.getFechaAsDate();
    		}
			
			dtInicial = new DateTime(dInicial);
			dtFinal = new DateTime(dFinal);
			
			Months d = Months.monthsBetween(dtInicial, dtFinal);
    		
    		n = d.getMonths() / mb.getMesesEntreMantenciones();
    		
    		if (n > 0) {
    			// hay mantencion pendiente, o bien no la ha informado
    			ret = new MantencionBaseHechaModelo();
    			
    			ret.setIdMantencionBase(mb.getId());
    			ret.setIdVehiculo(this.getIdVehiculo());
    			ret.setIdUsuario(this.getIdUsuario());
    			ret.setDescripcionItem(mb.getDescripcionItem());
    			//ret.setEsMantencion(mbh.getEsMantencion());

    			ret.setFecha(dtInicial.plusMonths(n * mb.getMesesEntreMantenciones()).toDate());
    			
    			bFound = true;
    		}
		}
		
		return ret;
		
	}

	public ArrayList<MantencionBaseHechaModelo> getMantencionesBasePendientes(Connection conn) throws SQLException, UnsupportedParameterException, ParseException {
    	
    	ArrayList<MantencionBaseHechaModelo> ret;
    	ArrayList<CambioRevision> list_cr;
    	ArrayList<AbstractMap.SimpleEntry<String, String>> parametros;
    	String traccion, combustible;
    	
    	traccion = Traccion.getById(conn, this.getIdTraccion().toString()).getDescripcion();
    	combustible = Combustible.getById(conn, this.getIdCombustible().toString()).getDescripcion();
    	
    	parametros = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
    	
    	ret = new ArrayList<MantencionBaseHechaModelo>();
    	
    	list_cr = CambioRevision.seek(conn, parametros, null, null, 0, 10000);
    	
    	for (CambioRevision cr : list_cr) {
    		MantencionBase mbCambio, mbRevision;
    		MantencionBaseHechaModelo mbhCambio, mbhRevision;
    		
    		MantencionBaseHechaModelo pendiente = null;
    		    		
    		if (cr.getIdCambio() != 0 && cr.getIdRevision() != 0) {
    			// cambio?
    			
        		mbCambio = MantencionBase.getById(conn, String.valueOf(cr.getIdCambio()));
        		
        		mbRevision = MantencionBase.getById(conn, String.valueOf(cr.getIdRevision()));
        		
        		mbhCambio = getMantencionMasReciente(conn, mbCambio);
        		
        		mbhRevision = getMantencionMasReciente(conn, mbRevision);

        		pendiente = getMantencionBasePendiente(conn, mbCambio, mbhCambio);
    			
    			if (pendiente == null) {
    				// revision?
    				
            		// veo si hay cambio hecho que anule revision, notar que mbh es el ultimo cambio
    				
    				pendiente = getMantencionBasePendiente(conn, mbRevision, mbhCambio); 
    				
    				if (pendiente != null) {
    					// veo si hay revision hecha que anule revision
    					
    					MantencionBaseHecha pendienteR = getMantencionBasePendiente(conn, mbRevision, mbhRevision);
    					
    					if (pendienteR == null) {
    						pendiente = null;
    					}
    					else {
    						// es revision!
    						pendiente.setEsMantencion(false);
    					}
    				}
    				
    				
    			}
    			else {
    				// es mantencion!
    				pendiente.setEsMantencion(true);
    			}
    			
    		}
    		else if (cr.getIdRevision() == 0) {
    			// solo cambio
    			
        		mbCambio = MantencionBase.getById(conn, String.valueOf(cr.getIdCambio()));
        		
        		mbhCambio = getMantencionMasReciente(conn, mbCambio);

        		pendiente = getMantencionBasePendiente(conn, mbCambio, mbhCambio);
        		
        		if (pendiente != null) {
        			pendiente.setEsMantencion(true);
        		}
    		}
    		else if (cr.getIdCambio() == 0) {
    			// solo revision
    			
        		mbRevision = MantencionBase.getById(conn, String.valueOf(cr.getIdRevision()));
        		
        		mbhRevision = getMantencionMasReciente(conn, mbRevision);

    			pendiente = getMantencionBasePendiente(conn, mbRevision, mbhRevision);
    			
    			if (pendiente != null) {
    				pendiente.setEsMantencion(false);
    			}
    		}
    		
    		if (pendiente != null) {
    			ret.add(pendiente);
    		}
    		
    		
    	} // end for

    	return ret;
    	
    }

    public ArrayList<MantencionUsuarioHecha> getMantencionesUsuarioPendientes(Connection p_conn) throws UnsupportedParameterException, SQLException, ParseException {
    	
    	ArrayList<MantencionUsuarioHecha> ret;
    	ArrayList<MantencionUsuario> list_mu;
    	ArrayList<AbstractMap.SimpleEntry<String, String>> parametros;
    	Integer kmInicial;
    	Date dInicial, dFinal;
    	DateTime dtInicial, dtFinal;
    	
    	parametros = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
    	
    	ret = new ArrayList<MantencionUsuarioHecha>();
    	
    	parametros.add(new AbstractMap.SimpleEntry<String, String>("id_usuario", getIdUsuario().toString()));
    	//parametros.add(new AbstractMap.SimpleEntry<String, String>("id_vehiculo", getIdVehiculo().toString()));
    	
    	list_mu = MantencionUsuario.seek(p_conn, parametros, null, null, 0, 10000);
    	
    	for (MantencionUsuario mu : list_mu) {
    		
    		ArrayList<MantencionUsuarioHecha> list_muh;
    		MantencionUsuarioHecha muh; // = new MantencionUsuarioHecha();
    		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		Integer n;
            Boolean bFound = false;
            
    		// encuentro ultima mantencion hecha de este tipo
    		parametros.clear();
    		
    		parametros.add(new AbstractMap.SimpleEntry<String, String>("id_mantencion_usuario", mu.getIdMantencionUsuario().toString()));
    		parametros.add(new AbstractMap.SimpleEntry<String, String>("id_vehiculo", getIdVehiculo().toString()));
    		
    		list_muh = MantencionUsuarioHecha.seek(p_conn, parametros, "fecha_modificacion", "DESC", 0, 1);
    		
			muh = new MantencionUsuarioHecha();
			
			muh.setIdMantencionUsuario(mu.getIdMantencionUsuario());
			muh.setIdVehiculo(this.getIdVehiculo());
			muh.setIdUsuario(this.getIdUsuario());
    		
    			
    		if (mu.getDependeKm() && mu.getKmEntreMantenciones() != null && mu.getKmEntreMantenciones() > 0) {
    			
    			kmInicial = 0;
    			
    			if (list_muh.size() > 0) {
        			
        			kmInicial = list_muh.get(0).getKm();
        		}

	    		n = (this.getKm() - kmInicial) / mu.getKmEntreMantenciones();
	    		
	    		if (n > 0) {
	    			// hay mantencion pendiente, o bien no la ha informado
	    			muh.setKm(kmInicial + n * mu.getKmEntreMantenciones());
	    			//muh.setFecha(formatter.format(new Date()));
	    			
	    			ret.add(muh);
	    			
	    			bFound = true;
	    		}
    		}

    		if (!bFound && mu.getMesesEntreMantenciones() != null && mu.getMesesEntreMantenciones() > 0) {
        		
    	        formatter = new SimpleDateFormat("yyyy-MM-dd");
        		
    			dInicial = formatter.parse(this.getAnio().toString() + "-01-01"); // anio de compra
    			dFinal = new Date(); // now
    			    			
    			if (list_muh.size() > 0) {
        			
    				dInicial = list_muh.get(0).getFechaAsDate();
        		}
    			
    			dtInicial = new DateTime(dInicial);
    			dtFinal = new DateTime(dFinal);

    			Months d = Months.monthsBetween(dtInicial, dtFinal);
	    		
	    		n = d.getMonths() / mu.getMesesEntreMantenciones();
	    		
	    		if (n > 0) {
	    			// hay mantencion pendiente, o bien no la ha informado
	    			muh.setFecha(dtInicial.plusMonths(n * mu.getMesesEntreMantenciones()).toDate());
	    			
	    			ret.add(muh);
	    			
	    			bFound = true;
	    		}
    		}

    			
    		

    		
    		
    	}
    	
		return ret;
    	
    }

    /**
     * @throws SQLException 
     * @throws UnsupportedParameter 
     * @throws ParseException 
     * 
     */
    public ArrayList<Rendimiento> getRendimiento(Connection p_conn) throws UnsupportedParameterException, SQLException, ParseException {
    	ArrayList<Rendimiento> ret;
    	ArrayList<CargaCombustible> list_cc;
    	ArrayList<AbstractMap.SimpleEntry<String, String>> parametros;
    	Integer kmInicial, kmFinal;
    	Date dInicial, dFinal;
    	//DateTime dtInicial, dtFinal;
    	Boolean bFirstFound = false;
    	
    	dInicial = new Date(0);
    	kmInicial = 0;
    	
    	parametros = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
    	
    	ret = new ArrayList<Rendimiento>();
    	
    	parametros.add(new AbstractMap.SimpleEntry<String, String>("id_usuario", getIdUsuario().toString()));
    	parametros.add(new AbstractMap.SimpleEntry<String, String>("id_vehiculo", getIdVehiculo().toString()));
    	
    	list_cc = CargaCombustible.seek(p_conn, parametros, "fecha", "ASC", 0, 10000);
    	
    	// busco 2 registros consecutivos con llenado de estanque
    	
    	for (CargaCombustible cc : list_cc) {
    		if (!bFirstFound) {
    			if (cc.getEstanqueLleno()) {
    				bFirstFound = true;
    				
    				kmInicial = cc.getKm();
    				dInicial = cc.getFechaAsDate();
    			}
    		}
    		else {
    			if (cc.getEstanqueLleno()) {
    				// encontre el par, calculo rendimiento
    				kmFinal = cc.getKm();
    				dFinal = cc.getFechaAsDate();
    				
    				Rendimiento rendimiento = new Rendimiento();
    				
    				rendimiento.setInitialDate(dInicial);
    				rendimiento.setFinalDate(dFinal);
    				rendimiento.setRendimiento((float) (kmFinal - kmInicial) / cc.getLitros());
    				
    				ret.add(rendimiento);
    				
    				//System.out.println(rendimiento);
    				
    				// no vuelvo a false bFirstfound, ya que este registro me sirve como primero para la proxima
    				kmInicial = kmFinal;
    				dInicial = dFinal;
    			}
    			else {
    				// comienzo la busqueda nuevamente
    				bFirstFound = false;
    			}
    		}
    	}
    	
    	return ret;
    	
    }
    
    public void ActualizaKm(Connection p_conn) throws ParseException, SQLException, MyCarException {
    	
    	int millisecsPerDay;
    	Date ultimaFechaModificacion, ahora;
    	
    	millisecsPerDay = 24 * 60 * 60 * 1000;
    	ahora = new Date();
    	
    	// construyo fecha Enero 1 Anio vehiculo
    	Calendar calendar = new GregorianCalendar(getAnio(), 1, 1);
    	
    	if (getKmCalibrados() == null) {
    		
    		ultimaFechaModificacion = new Date(calendar.getTimeInMillis());
    	} else {
    		
    		ultimaFechaModificacion = getFechaUltimaCalibracionAsDate();    		
    	}

    	long dias = (ahora.getTime() - ultimaFechaModificacion.getTime()) / millisecsPerDay;
    	
    	if (getKmAnuales() == null) {
    		throw new MyCarException("El vehiculo no tiene estimacion de km anuales");
    	}
    	
    	int Km = (int) (dias * getKmAnuales() / 365);

    	if (getKmCalibrados() == null) {
    		setKm(Km + 500);
    	} else {
    		setKm(Km + getKmCalibrados());
    	}

    	setFechaUltimoKm(ahora);
    	
    	//update(p_conn);

    }
}
