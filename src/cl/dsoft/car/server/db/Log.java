/**
 * 
 */
package cl.dsoft.car.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractMap;
import java.util.ArrayList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import cl.dsoft.car.misc.UnsupportedParameterException;

/**
 * @author petete-ntbk
 *
 */
public class Log {
    protected Long _idTipoVehiculo;
    protected String _fechaModificacion;
    protected Long _idUsuario;
    protected Long _idVehiculo;
    protected Boolean _borrado;
    protected String _descripcion;
    protected Double _latitud;
    protected Long _idLog;
    protected Long _idModelo;
    protected Double _longitud;
    protected Integer _km;
    protected Long _idMarca;

    private final static String _str_sql = 
        "    SELECT" +
        "    lo.id_tipo_vehiculo AS id_tipo_vehiculo," +
        "    DATE_FORMAT(lo.fecha_modificacion, '%Y-%m-%d %H:%i:%s') AS fecha_modificacion," +
        "    lo.id_usuario AS id_usuario," +
        "    lo.id_vehiculo AS id_vehiculo," +
        "    0+lo.borrado AS borrado," +
        "    lo.descripcion AS descripcion," +
        "    lo.latitud AS latitud," +
        "    lo.id_log AS id_log," +
        "    lo.id_modelo AS id_modelo," +
        "    lo.longitud AS longitud," +
        "    lo.km AS km," +
        "    lo.id_marca AS id_marca" +
        "    FROM log lo";

    public Log() {
        _idTipoVehiculo = null;
        _fechaModificacion = null;
        _idUsuario = null;
        _idVehiculo = null;
        _borrado = null;
        _descripcion = null;
        _latitud = null;
        _idLog = null;
        _idModelo = null;
        _longitud = null;
        _km = null;
        _idMarca = null;

    }
    /**
     * @return the _idTipoVehiculo
     */
    public Long getIdTipoVehiculo() {
        return _idTipoVehiculo;
    }
    /**
     * @return the _fechaModificacion
     */
    public String getFechaModificacion() {
        return _fechaModificacion;
    }
    /**
     * @return the _idUsuario
     */
    public Long getIdUsuario() {
        return _idUsuario;
    }
    /**
     * @return the _idVehiculo
     */
    public Long getIdVehiculo() {
        return _idVehiculo;
    }
    /**
     * @return the _borrado
     */
    public Boolean getBorrado() {
        return _borrado;
    }
    /**
     * @return the _descripcion
     */
    public String getDescripcion() {
        return _descripcion;
    }
    /**
     * @return the _latitud
     */
    public Double getLatitud() {
        return _latitud;
    }
    /**
     * @return the _idLog
     */
    public Long getIdLog() {
        return _idLog;
    }
    /**
     * @return the _idModelo
     */
    public Long getIdModelo() {
        return _idModelo;
    }
    /**
     * @return the _longitud
     */
    public Double getLongitud() {
        return _longitud;
    }
    /**
     * @return the _km
     */
    public Integer getKm() {
        return _km;
    }
    /**
     * @return the _idMarca
     */
    public Long getIdMarca() {
        return _idMarca;
    }
    /**
     * @param _idTipoVehiculo the _idTipoVehiculo to set
     */
    public void setIdTipoVehiculo(Long _idTipoVehiculo) {
        this._idTipoVehiculo = _idTipoVehiculo;
    }
    /**
     * @param _fechaModificacion the _fechaModificacion to set
     */
    public void setFechaModificacion(String _fechaModificacion) {
        this._fechaModificacion = _fechaModificacion;
    }
    /**
     * @param _idUsuario the _idUsuario to set
     */
    public void setIdUsuario(Long _idUsuario) {
        this._idUsuario = _idUsuario;
    }
    /**
     * @param _idVehiculo the _idVehiculo to set
     */
    public void setIdVehiculo(Long _idVehiculo) {
        this._idVehiculo = _idVehiculo;
    }
    /**
     * @param _borrado the _borrado to set
     */
    public void setBorrado(Boolean _borrado) {
        this._borrado = _borrado;
    }
    /**
     * @param _descripcion the _descripcion to set
     */
    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }
    /**
     * @param _latitud the _latitud to set
     */
    public void setLatitud(Double _latitud) {
        this._latitud = _latitud;
    }
    /**
     * @param _idLog the _idLog to set
     */
    public void setIdLog(Long _idLog) {
        this._idLog = _idLog;
    }
    /**
     * @param _idModelo the _idModelo to set
     */
    public void setIdModelo(Long _idModelo) {
        this._idModelo = _idModelo;
    }
    /**
     * @param _longitud the _longitud to set
     */
    public void setLongitud(Double _longitud) {
        this._longitud = _longitud;
    }
    /**
     * @param _km the _km to set
     */
    public void setKm(Integer _km) {
        this._km = _km;
    }
    /**
     * @param _idMarca the _idMarca to set
     */
    public void setIdMarca(Long _idMarca) {
        this._idMarca = _idMarca;
    }

    public static Log fromRS(ResultSet p_rs) throws SQLException {
        Log ret = new Log();

        ret.setIdTipoVehiculo(p_rs.getLong("id_tipo_vehiculo"));
        ret.setFechaModificacion(p_rs.getString("fecha_modificacion"));
        ret.setIdUsuario(p_rs.getLong("id_usuario"));
        ret.setIdVehiculo(p_rs.getLong("id_vehiculo"));
        ret.setBorrado(p_rs.getBoolean("borrado"));
        ret.setDescripcion(p_rs.getString("descripcion"));
        ret.setLatitud(p_rs.getDouble("latitud"));
        ret.setIdLog(p_rs.getLong("id_log"));
        ret.setIdModelo(p_rs.getLong("id_modelo"));
        ret.setLongitud(p_rs.getDouble("longitud"));
        ret.setKm(p_rs.getInt("km"));
        ret.setIdMarca(p_rs.getLong("id_marca"));

        return ret;
    }

    public static Log getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        Log ret = null;
        
        String str_sql = _str_sql +
            "  WHERE lo." + p_key + " = " + p_value +
            "  LIMIT 0, 1";
        
        //System.out.println(str_sql);
        
        // assume that conn is an already created JDBC connection (see previous examples)
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = p_conn.createStatement();
            //System.out.println("stmt = p_conn.createStatement() ok");
            rs = stmt.executeQuery(str_sql);
            //System.out.println("rs = stmt.executeQuery(str_sql) ok");

            // Now do something with the ResultSet ....
            
            if (rs.next()) {
                //System.out.println("rs.next() ok");
                ret = fromRS(rs);
                //System.out.println("fromRS(rs) ok");
            }
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
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

    
    public static ArrayList<Log> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws UnsupportedParameterException, SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<Log> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<Log>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_usuario")) {
                    array_clauses.add("lo.id_usuario = " + p.getValue());
                }
                else if (p.getKey().equals("id_log")) {
                    array_clauses.add("lo.id_log = " + p.getValue());
                }
                else if (p.getKey().equals("id_usuario")) {
                    array_clauses.add("lo.id_usuario = " + p.getValue());
                }
                else if (p.getKey().equals("id_vehiculo")) {
                    array_clauses.add("lo.id_vehiculo = " + p.getValue());
                }
                else if (p.getKey().equals("mas reciente")) {
                    array_clauses.add("lo.fecha_modificacion > STR_TO_DATE('" + p.getValue() + "', '%Y-%m-%d %H:%i:%s')");
                }
                else if (p.getKey().equals("no borrado")) {
                    array_clauses.add("lo.borrado = 0");
                }
                else if (p.getKey().equals("borrado")) {
                    array_clauses.add("lo.borrado = 1");
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

    public int update(Connection p_conn) throws SQLException {

        int ret = -1;
        Statement stmt = null;

        String str_sql =
            "    UPDATE log" +
            "    SET" +
            "    id_tipo_vehiculo = " + (_idTipoVehiculo != null ? _idTipoVehiculo : "null") + "," +
            "    fecha_modificacion = " + (_fechaModificacion != null ? "STR_TO_DATE('" + _fechaModificacion + "', '%Y-%m-%d %H:%i:%s')" : "null") + "," +
            "    borrado = " + (_borrado != null ? "b'" + (_borrado ? 1 : 0) + "'" : "null") + "," +
            "    descripcion = " + (_descripcion != null ? "'" + _descripcion + "'" : "null") + "," +
            "    latitud = " + (_latitud != null ? _latitud : "null") + "," +
            "    id_modelo = " + (_idModelo != null ? _idModelo : "null") + "," +
            "    longitud = " + (_longitud != null ? _longitud : "null") + "," +
            "    km = " + (_km != null ? _km : "null") + "," +
            "    id_marca = " + (_idMarca != null ? _idMarca : "null") +
            "    WHERE" +
            "    id_usuario = " + Long.toString(this._idUsuario) + " AND" +
            "    id_log = " + Long.toString(this._idLog);

        try {
            stmt = p_conn.createStatement();
            
            ret = stmt.executeUpdate(str_sql);
            /*
            if (stmt.executeUpdate(str_sql) < 1) {
                throw new Exception("No hubo filas afectadas");
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
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
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
    
    public int insert(Connection p_conn) throws SQLException {
        
        int ret = -1;
        Statement stmt = null;
        ResultSet rs = null;

        String str_sql =
            "    INSERT INTO log" +
            "    (" +
            "    id_tipo_vehiculo, " +
            "    id_usuario, " +
            "    id_vehiculo, " +
            "    descripcion, " +
            "    latitud, " +
            "    id_log, " +
            "    id_modelo, " +
            "    longitud, " +
            "    km, " +
            "    id_marca)" +
            "    VALUES" +
            "    (" +
            "    " + (_idTipoVehiculo != null ? "'" + _idTipoVehiculo + "'" : "null") + "," +
            "    " + (_idUsuario != null ? "'" + _idUsuario + "'" : "null") + "," +
            "    " + (_idVehiculo != null ? "'" + _idVehiculo + "'" : "null") + "," +
            "    " + (_descripcion != null ? "'" + _descripcion + "'" : "null") + "," +
            "    " + (_latitud != null ? "'" + _latitud + "'" : "null") + "," +
            "    " + (_idLog != null ? "'" + _idLog + "'" : "null") + "," +
            "    " + (_idModelo != null ? "'" + _idModelo + "'" : "null") + "," +
            "    " + (_longitud != null ? "'" + _longitud + "'" : "null") + "," +
            "    " + (_km != null ? "'" + _km + "'" : "null") + "," +
            "    " + (_idMarca != null ? "'" + _idMarca + "'" : "null") +
            "    )";
        
        try {
            stmt = p_conn.createStatement();

            ret = stmt.executeUpdate(str_sql);

            load(p_conn);

        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
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

    public int delete(Connection p_conn) throws SQLException {

        int ret = -1;
        Statement stmt = null;

        String str_sql =
            "    DELETE FROM log" +
            "    WHERE" +
            "    id_usuario = " + Long.toString(this._idUsuario) + " AND" +
            "    id_log = " + Long.toString(this._idLog);

        try {
            stmt = p_conn.createStatement();
            
            ret = stmt.executeUpdate(str_sql);
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
            throw ex;
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
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

    public void load(Connection p_conn) throws SQLException {
        Log obj = null;
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_usuario = " + Long.toString(this._idUsuario) + " AND" +
            "    id_log = " + Long.toString(this._idLog) +
            "    LIMIT 0, 1";
        
        //System.out.println(str_sql);
        
        // assume that conn is an already created JDBC connection (see previous examples)
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = p_conn.createStatement();
            //System.out.println("stmt = p_conn.createStatement() ok");
            rs = stmt.executeQuery(str_sql);
            //System.out.println("rs = stmt.executeQuery(str_sql) ok");

            // Now do something with the ResultSet ....
            
            if (rs.next()) {
                //System.out.println("rs.next() ok");
                obj = fromRS(rs);
                //System.out.println("fromRS(rs) ok");

                _idTipoVehiculo = obj.getIdTipoVehiculo();
                _fechaModificacion = obj.getFechaModificacion();
                _idVehiculo = obj.getIdVehiculo();
                _borrado = obj.getBorrado();
                _descripcion = obj.getDescripcion();
                _latitud = obj.getLatitud();
                _idModelo = obj.getIdModelo();
                _longitud = obj.getLongitud();
                _km = obj.getKm();
                _idMarca = obj.getIdMarca();
            }
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
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
        
    }

    public void save(Connection p_conn) throws SQLException {
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_usuario = " + Long.toString(this._idUsuario) + " AND" +
            "    id_log = " + Long.toString(this._idLog) +
            "    LIMIT 0, 1";
        
        //System.out.println(str_sql);
        
        // assume that conn is an already created JDBC connection (see previous examples)
        Statement stmt = null;
        ResultSet rs = null;
        Boolean exists = false;
        
        try {
            stmt = p_conn.createStatement();
            //System.out.println("stmt = p_conn.createStatement() ok");
            rs = stmt.executeQuery(str_sql);
            //System.out.println("rs = stmt.executeQuery(str_sql) ok");

            // Now do something with the ResultSet ....

            if (rs.next()) {
                // registro existe
                exists = true;
            }

            rs.close();
            stmt.close();

            if (exists) {
            	// update
            	update(p_conn);
            }
            else {
            	// insert
            	insert(p_conn);
            }
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
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
        
    }

    @Override
    public String toString() {
        return "Log [" +
	           "    _idTipoVehiculo = " + (_idTipoVehiculo != null ? _idTipoVehiculo : "null") + "," +
	           "    _fecha_modificacion = " + (_fechaModificacion != null ? "STR_TO_DATE(" + _fechaModificacion + ", '%Y-%m-%d %H:%i:%s')" : "null") + "," +
	           "    _idUsuario = " + (_idUsuario != null ? _idUsuario : "null") + "," +
	           "    _idVehiculo = " + (_idVehiculo != null ? _idVehiculo : "null") + "," +
	           "    _borrado = " + (_borrado != null ? "b'" + _borrado : "null") + "," +
	           "    _descripcion = " + (_descripcion != null ? "'" + _descripcion + "'" : "null") + "," +
	           "    _latitud = " + (_latitud != null ? _latitud : "null") + "," +
	           "    _idLog = " + (_idLog != null ? _idLog : "null") + "," +
	           "    _idModelo = " + (_idModelo != null ? _idModelo : "null") + "," +
	           "    _longitud = " + (_longitud != null ? _longitud : "null") + "," +
	           "    _km = " + (_km != null ? _km : "null") + "," +
	           "    _idMarca = " + (_idMarca != null ? _idMarca : "null") +
			   "]";
    }


    public String toJSON() {
        return "Log : {" +
	           "    \"_idTipoVehiculo\" : " + (_idTipoVehiculo != null ? _idTipoVehiculo : "null") + "," +
	           "    \"_fecha_modificacion\" : " + (_fechaModificacion != null ? "\"" + _fechaModificacion + "\"" : "null") + "," +
	           "    \"_idUsuario\" : " + (_idUsuario != null ? _idUsuario : "null") + "," +
	           "    \"_idVehiculo\" : " + (_idVehiculo != null ? _idVehiculo : "null") + "," +
	           "    \"_borrado\" : " + (_borrado != null ? "b'" + _borrado : "null") + "," +
	           "    \"_descripcion\" : " + (_descripcion != null ? "\"" + _descripcion + "\"" : "null") + "," +
	           "    \"_latitud\" : " + (_latitud != null ? _latitud : "null") + "," +
	           "    \"_idLog\" : " + (_idLog != null ? _idLog : "null") + "," +
	           "    \"_idModelo\" : " + (_idModelo != null ? _idModelo : "null") + "," +
	           "    \"_longitud\" : " + (_longitud != null ? _longitud : "null") + "," +
	           "    \"_km\" : " + (_km != null ? _km : "null") + "," +
	           "    \"_idMarca\" : " + (_idMarca != null ? _idMarca : "null") +
			   "}";
    }


    public String toXML() {
        return "<Log>" +
	           "    <idTipoVehiculo" + (_idTipoVehiculo != null ? ">" + _idTipoVehiculo + "</idTipoVehiculo>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <fechaModificacion" + (_fechaModificacion != null ? ">" + _fechaModificacion + "</fechaModificacion>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <idUsuario" + (_idUsuario != null ? ">" + _idUsuario + "</idUsuario>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <idVehiculo" + (_idVehiculo != null ? ">" + _idVehiculo + "</idVehiculo>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <borrado" + (_borrado != null ? ">" + _borrado + "</borrado>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <descripcion" + (_descripcion != null ? ">" + _descripcion + "</descripcion>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <latitud" + (_latitud != null ? ">" + _latitud + "</latitud>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <idLog" + (_idLog != null ? ">" + _idLog + "</idLog>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <idModelo" + (_idModelo != null ? ">" + _idModelo + "</idModelo>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <longitud" + (_longitud != null ? ">" + _longitud + "</longitud>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <km" + (_km != null ? ">" + _km + "</km>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <idMarca" + (_idMarca != null ? ">" + _idMarca + "</idMarca>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
			   "</Log>";
    }


    public static Log fromXMLNode(Node xmlNode) {
        Log ret = new Log();

        Element element = (Element) xmlNode;

        ret.setIdTipoVehiculo(Long.decode(element.getElementsByTagName("id_tipo_vehiculo").item(0).getTextContent()));
        ret.setFechaModificacion(element.getElementsByTagName("fecha_modificacion").item(0).getTextContent());
        ret.setIdUsuario(Long.decode(element.getElementsByTagName("id_usuario").item(0).getTextContent()));
        ret.setIdVehiculo(Long.decode(element.getElementsByTagName("id_vehiculo").item(0).getTextContent()));
        ret.setBorrado(Boolean.valueOf(element.getElementsByTagName("borrado").item(0).getTextContent()));
        ret.setDescripcion(element.getElementsByTagName("descripcion").item(0).getTextContent());
        ret.setLatitud(Double.valueOf(element.getElementsByTagName("latitud").item(0).getTextContent()));
        ret.setIdLog(Long.decode(element.getElementsByTagName("id_log").item(0).getTextContent()));
        ret.setIdModelo(Long.decode(element.getElementsByTagName("id_modelo").item(0).getTextContent()));
        ret.setLongitud(Double.valueOf(element.getElementsByTagName("longitud").item(0).getTextContent()));
        ret.setKm(Integer.decode(element.getElementsByTagName("km").item(0).getTextContent()));
        ret.setIdMarca(Long.decode(element.getElementsByTagName("id_marca").item(0).getTextContent()));

        return ret;
    }
}
