/**
 * 
 */
package cl.dsoft.car.mobile.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractMap;
import java.util.ArrayList;

import cl.dsoft.car.misc.UnsupportedParameterException;
import cl.dsoft.car.mobile.db.MantencionBaseHecha;

/**
 * @author lfhernandez
 *
 */
public class MantencionBaseHechaModelo extends MantencionBaseHecha {

	/**
	 * 
	 */
	private String _descripcionItem;
	protected Boolean _esMantencion;
	
    private final static String _str_sql = 
            "    SELECT" +
            "    strftime('%Y-%m-%d %H:%M:%S', ma.fecha_modificacion) AS fecha_modificacion," +
            "    strftime('%Y-%m-%d %H:%M:%S', ma.fecha) AS fecha," +
            "    ma.id_usuario AS id_usuario," +
            "    ma.id_mantencion_base AS id_mantencion_base," +
            "    ma.id_vehiculo AS id_vehiculo," +
            "    ma.borrado AS borrado," +
            "    ma.costo AS costo," +
            "    ma.km AS km," +
            "    ma.id_mantencion_base_hecha AS id_mantencion_base_hecha," +
            "    mb.descripcion_item," +
            "    cr.id_cambio IS NULL AS es_mantencion" +
            "    FROM mantencion_base_hecha ma" +
            "    LEFT JOIN cambio_revision cr on cr.id_revision = ma.id_mantencion_base" +
            "    JOIN mantencion_base mb ON ma.id_mantencion_base = mb.id_mantencion_base";

    public MantencionBaseHechaModelo() {
		// TODO Auto-generated constructor stub
	}
    
    /**
	 * @return the _esMantencion
	 */
	public Boolean getEsMantencion() {
		return _esMantencion;
	}

	/**
	 * @param _esMantencion the _esMantencion to set
	 */
	public void setEsMantencion(Boolean _esMantencion) {
		this._esMantencion = _esMantencion;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcionItem() {
		return _descripcionItem;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcionItem(String descripcionItem) {
		this._descripcionItem = descripcionItem;
	}

	public static MantencionBaseHechaModelo fromRS(ResultSet p_rs) throws SQLException {
        MantencionBaseHechaModelo ret = new MantencionBaseHechaModelo();

        ret.setFechaModificacion(p_rs.getString("fecha_modificacion"));
        ret.setFecha(p_rs.getString("fecha"));
        ret.setIdUsuario(p_rs.getLong("id_usuario"));
        ret.setIdMantencionBase(p_rs.getLong("id_mantencion_base"));
        ret.setIdVehiculo(p_rs.getLong("id_vehiculo"));
        ret.setBorrado(p_rs.getString("borrado") != null ? p_rs.getString("borrado").equals("true") : null);
        ret.setCosto(p_rs.getInt("costo"));
        ret.setKm(p_rs.getInt("km"));
        ret.setIdMantencionBaseHecha(p_rs.getInt("id_mantencion_base_hecha"));
        ret.setDescripcionItem(p_rs.getString("descripcion_item"));
        ret.setEsMantencion(p_rs.getBoolean("es_mantencion"));

        return ret;
    }

	public static ArrayList<MantencionBaseHechaModelo> seeks(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws UnsupportedParameterException, SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<MantencionBaseHechaModelo> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<MantencionBaseHechaModelo>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_usuario")) {
                    array_clauses.add("ma.id_usuario = " + p.getValue());
                }
                else if (p.getKey().equals("id_mantencion_base_hecha")) {
                    array_clauses.add("ma.id_mantencion_base_hecha = " + p.getValue());
                }
                else if (p.getKey().equals("id_mantencion_base")) {
                    array_clauses.add("ma.id_mantencion_base = " + p.getValue());
                }
                else if (p.getKey().equals("id_vehiculo")) {
                    array_clauses.add("ma.id_vehiculo = " + p.getValue());
                }
                else if (p.getKey().equals("mas reciente")) {
                    array_clauses.add("ma.fecha_modificacion > datetime('" + p.getValue() + "', 'localtime')");
                }
                else if (p.getKey().equals("no borrado")) {
                    array_clauses.add("ma.borrado = 'false'");
                }
                else if (p.getKey().equals("borrado")) {
                    array_clauses.add("ma.borrado = 'true'");
                }
                else {
                    throw new UnsupportedParameterException("Parametro no soportado: " + p.getKey());
                }
            }
                                
            boolean bFirstTime = false;
            
            for(String clause : array_clauses) {
                if (!bFirstTime) {
                     bFirstTime = true;
                     str_sql += " WHERE ";
                }
                else {
                     str_sql += " AND ";
                }
                str_sql += clause;
            }
            
            if (p_order != null && p_direction != null) {
                str_sql += " ORDER BY " + p_order + " " + p_direction;
            }
            
            if (p_offset != -1 && p_limit != -1) {
                str_sql += "  LIMIT " +  Integer.toString(p_offset) + ", " + Integer.toString(p_limit);
            }
            
            //echo "<br>" . str_sql . "<br>";
        
            stmt = p_conn.createStatement();
            
            rs = stmt.executeQuery(str_sql);
            
            while (rs.next()) {
                ret.add(fromRS(rs));
            }
            /*
            if (ret.size() == 0) {
                ret = null;
            }
            */
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
            throw ex;
        }
        catch (UnsupportedParameterException ex) {
            throw ex;
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { 
                    
                } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    
                } // ignore
                stmt = null;
            }
        }        

        return ret;
    }
	
	@Override
    public String toString() {
        return "MantencionBaseHecha [" +
	           "    _fechaModificacion = " + (getFechaModificacion() != null ? "'" + getFechaModificacion() + "'" : "null") + "," +
	           "    _fecha = " + (getFecha() != null ? "'" + getFecha() + "'" : "null") + "," +
	           "    _idUsuario = " + (getIdUsuario() != null ? getIdUsuario() : "null") + "," +
	           "    _idMantencionBase = " + (getIdMantencionBase() != null ? getIdMantencionBase() : "null") + "," +
	           "    _idVehiculo = " + (getIdVehiculo() != null ? getIdVehiculo() : "null") + "," +
	           "    _borrado = " + (getBorrado() != null ? getBorrado() : "null") + "," +
	           "    _costo = " + (getCosto() != null ? getCosto() : "null") + "," +
	           "    _km = " + (getKm() != null ? getKm() : "null") + "," +
	           "    _idMantencionBaseHecha = " + (getIdMantencionBaseHecha() != null ? getIdMantencionBaseHecha() : "null") +
	           "    _descripcion_item = " + (_descripcionItem != null ? _descripcionItem : "null") + "," +
	           "    _es_mantencion = " + (getEsMantencion() != null ? getEsMantencion() : "null") + "," +	           
			   "]";
    }

}
