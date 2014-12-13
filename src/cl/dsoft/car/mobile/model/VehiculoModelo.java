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
import java.util.Date;

import org.joda.time.DateTime ;
import org.joda.time.Months;

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

	private MantencionBaseHecha getMantencionBasePendiente(Connection conn, MantencionBase mb) throws UnsupportedParameterException, SQLException, ParseException
	{
		MantencionBaseHecha mbh = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Integer n;
        Boolean bFound = false;
        ArrayList<AbstractMap.SimpleEntry<String, String>> parametros;
        ArrayList<MantencionBaseHecha> list_mbh;
    	Integer kmInicial;
    	Date dInicial, dFinal;
    	DateTime dtInicial, dtFinal;
        
        parametros = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
        
		// encuentro ultima mantencion hecha de este tipo
		parametros.clear();
		
		parametros.add(new AbstractMap.SimpleEntry<String, String>("id_mantencion_base", String.valueOf(mb.getId())));
		
		list_mbh = MantencionBaseHecha.seek(conn, parametros, "fecha", "DESC", 0, 1);		
			
		if (mb.getDependeKm() && mb.getKmEntreMantenciones() != null && mb.getKmEntreMantenciones() > 0) {
			
			kmInicial = 0;
			
			if (list_mbh.size() > 0) {
    			
    			kmInicial = list_mbh.get(0).getKm();
    		}

    		n = (this.getKm() - kmInicial) / mb.getKmEntreMantenciones();
    		
    		if (n > 0) {
    			// hay mantencion pendiente, o bien no la ha informado
    			mbh = new MantencionBaseHecha();
    			
    			mbh.setIdMantencionBase(mb.getId());
    			mbh.setIdVehiculo(this.getIdVehiculo());
    			mbh.setIdUsuario(this.getIdUsuario());

    			mbh.setKm(kmInicial + n * mb.getKmEntreMantenciones());
    			//mbh.setFecha(formatter.format(new Date()));
    			
    			bFound = true;
    		}
		}

		if (!bFound && mb.getMesesEntreMantenciones() != null && mb.getMesesEntreMantenciones() > 0) {
			
	        formatter = new SimpleDateFormat("yyyy-MM-dd");
    		
			dInicial = formatter.parse(this.getAnio().toString() + "-01-01"); // anio de compra
			dFinal = new Date(); // now
			    			
			if (list_mbh.size() > 0) {
    			
				dInicial = list_mbh.get(0).getFechaAsDate();
    		}
			
			dtInicial = new DateTime(dInicial);
			dtFinal = new DateTime(dFinal);
			
			Months d = Months.monthsBetween(dtInicial, dtFinal);
    		
    		n = d.getMonths() / mb.getMesesEntreMantenciones();
    		
    		if (n > 0) {
    			// hay mantencion pendiente, o bien no la ha informado
    			mbh = new MantencionBaseHecha();
    			
    			mbh.setIdMantencionBase(mb.getId());
    			mbh.setIdVehiculo(this.getIdVehiculo());
    			mbh.setIdUsuario(this.getIdUsuario());

    			mbh.setFecha(dtInicial.plusMonths(n * mb.getMesesEntreMantenciones()).toDate());
    			
    			bFound = true;
    		}
		}
		
		return mbh;
		
	}

    public ArrayList<MantencionBaseHecha> getMantencionesBasePendientes(Connection conn) throws SQLException, UnsupportedParameterException, ParseException {
    	
    	ArrayList<MantencionBaseHecha> ret;
    	ArrayList<MantencionBase> list_mb;
    	ArrayList<AbstractMap.SimpleEntry<String, String>> parametros;
    	String traccion, combustible;
    	
    	traccion = Traccion.getById(conn, this.getIdTraccion().toString()).getDescripcion();
    	combustible = Combustible.getById(conn, this.getIdCombustible().toString()).getDescripcion();
    	
    	parametros = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
    	
    	ret = new ArrayList<MantencionBaseHecha>();
    	
    	// busco primeramente los cambios...
    	parametros.add(new AbstractMap.SimpleEntry<String, String>("traccion", traccion));
    	parametros.add(new AbstractMap.SimpleEntry<String, String>("combustible", combustible));
    	parametros.add(new AbstractMap.SimpleEntry<String, String>("cambio", null));
    	
    	list_mb = MantencionBase.seek(conn, parametros, null, null, 0, 10000);
    	
    	for (MantencionBase mb : list_mb) {
    		
    		MantencionBaseHecha mbh = getMantencionBasePendiente(conn, mb);

    		if (mbh == null) {
    			// no hay cambio pendiente... hay revision asociada?
    			CambioRevision cr = CambioRevisionModelo.getByIdCambio(conn, String.valueOf(mb.getId()));
    			
    			System.out.println("cr " + cr.toString());
    			
    			if (cr != null) {
    				if (cr.getIdRevision() != 0) {
    					MantencionBase mbb = MantencionBase.getById(conn, String.valueOf(cr.getIdRevision()));
    					
    					System.out.println("mbb " + mbb.toString());
    					
    					mbh = getMantencionBasePendiente(conn, mbb);
    				}
    			}
    		}
    		
    		if (mbh != null) {
    			ret.add(mbh);
    		}
    		
    		
    	} // end for
    	
    	// ahora busco las revisiones que no tienen cambio asociado
    	
    	parametros.clear();
    	
    	parametros.add(new AbstractMap.SimpleEntry<String, String>("traccion", traccion));
    	parametros.add(new AbstractMap.SimpleEntry<String, String>("combustible", combustible));
    	parametros.add(new AbstractMap.SimpleEntry<String, String>("solo revision", null));
    	
    	list_mb = MantencionBase.seek(conn, parametros, null, null, 0, 10000);
    	
    	for (MantencionBase mb : list_mb) {
    		
    		MantencionBaseHecha mbh = getMantencionBasePendiente(conn, mb);

    		if (mbh != null) {
    			ret.add(mbh);
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
    		
    		list_muh = MantencionUsuarioHecha.seek(p_conn, parametros, "fecha", "DESC", 0, 1);
    		
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
}