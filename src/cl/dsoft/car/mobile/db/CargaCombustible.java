/**
 * 
 */
package cl.dsoft.car.mobile.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import cl.dsoft.car.misc.UnsupportedParameterException;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * @author Luis Hernandez
 *
 */
@Root
public class CargaCombustible {
    @Element(name = "idCargaCombustible")
    private Long _idCargaCombustible;
    @Element(name = "idUsuario")
    private Long _idUsuario;
    @Element(name = "idVehiculo")
    private Long _idVehiculo;
    @Element(name = "km", required = false)
    private Integer _km;
    @Element(name = "litros", required = false)
    private Integer _litros;
    @Element(name = "fecha", required = false)
    private String _fecha;
    @Element(name = "estanqueLleno", required = false)
    private Boolean _estanqueLleno;
    @Element(name = "costo", required = false)
    private Integer _costo;
    @Element(name = "latitud", required = false)
    private Double _latitud;
    @Element(name = "longitud", required = false)
    private Double _longitud;
    @Element(name = "fechaModificacion")
    private String _fechaModificacion;
    @Element(name = "borrado")
    private Boolean _borrado;

    private final static String _str_sql = 
        "    SELECT" +
        "    ca.id_carga_combustible AS id_carga_combustible," +
        "    ca.id_usuario AS id_usuario," +
        "    ca.id_vehiculo AS id_vehiculo," +
        "    ca.km AS km," +
        "    ca.litros AS litros," +
        "    strftime('%Y-%m-%d', ca.fecha) AS fecha," +
        "    ca.estanque_lleno AS estanque_lleno," +
        "    ca.costo AS costo," +
        "    ca.latitud AS latitud," +
        "    ca.longitud AS longitud," +
        "    strftime('%Y-%m-%d %H:%M:%S', ca.fecha_modificacion) AS fecha_modificacion," +
        "    ca.borrado AS borrado" +
        "    FROM carga_combustible ca";

    public CargaCombustible() {
        _idCargaCombustible = null;
        _idUsuario = null;
        _idVehiculo = null;
        _km = null;
        _litros = null;
        _fecha = null;
        _estanqueLleno = null;
        _costo = null;
        _latitud = null;
        _longitud = null;
        _fechaModificacion = null;
        _borrado = null;

    }
    /**
     * @return the _idCargaCombustible
     */
    public Long getIdCargaCombustible() {
        return _idCargaCombustible;
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
     * @return the _km
     */
    public Integer getKm() {
        return _km;
    }
    /**
     * @return the _litros
     */
    public Integer getLitros() {
        return _litros;
    }
    /**
     * @return the _fecha
     */
    public String getFecha() {
        return _fecha;
    }
    /**
     * @return the _estanqueLleno
     */
    public Boolean getEstanqueLleno() {
        return _estanqueLleno;
    }
    /**
     * @return the _costo
     */
    public Integer getCosto() {
        return _costo;
    }
    /**
     * @return the _latitud
     */
    public Double getLatitud() {
        return _latitud;
    }
    /**
     * @return the _longitud
     */
    public Double getLongitud() {
        return _longitud;
    }
    /**
     * @return the _fechaModificacion
     */
    public String getFechaModificacion() {
        return _fechaModificacion;
    }
    /**
     * @return the _borrado
     */
    public Boolean getBorrado() {
        return _borrado;
    }
    /**
     * @return the _fecha as seconds from January 1, 1970, 00:00:00 GMT
     */
    public long getFechaAsLong() throws ParseException {
        Date d;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        d = formatter.parse(_fecha);

        return (long)d.getTime() / 1000L;
    }
    /**
     * @return the _fecha as Date
     */
    public Date getFechaAsDate() throws ParseException {
        Date d;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        d = formatter.parse(_fecha);

        return d;
    }
    /**
     * @param _idCargaCombustible the _idCargaCombustible to set
     */
    public void setIdCargaCombustible(Long _idCargaCombustible) {
        this._idCargaCombustible = _idCargaCombustible;
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
     * @param _km the _km to set
     */
    public void setKm(Integer _km) {
        this._km = _km;
    }
    /**
     * @param _litros the _litros to set
     */
    public void setLitros(Integer _litros) {
        this._litros = _litros;
    }
    /**
     * @param _fecha the _fecha to set
     */
    public void setFecha(String _fecha) {
        this._fecha = _fecha;
    }
    /**
     * @param _estanqueLleno the _estanqueLleno to set
     */
    public void setEstanqueLleno(Boolean _estanqueLleno) {
        this._estanqueLleno = _estanqueLleno;
    }
    /**
     * @param _costo the _costo to set
     */
    public void setCosto(Integer _costo) {
        this._costo = _costo;
    }
    /**
     * @param _latitud the _latitud to set
     */
    public void setLatitud(Double _latitud) {
        this._latitud = _latitud;
    }
    /**
     * @param _longitud the _longitud to set
     */
    public void setLongitud(Double _longitud) {
        this._longitud = _longitud;
    }
    /**
     * @param _fechaModificacion the _fechaModificacion to set
     */
    public void setFechaModificacion(String _fechaModificacion) {
        this._fechaModificacion = _fechaModificacion;
    }
    /**
     * @param _borrado the _borrado to set
     */
    public void setBorrado(Boolean _borrado) {
        this._borrado = _borrado;
    }
    /**
     * @param _fecha the _fecha to set as seconds from January 1, 1970, 00:00:00 GMT
     */
    public void setFecha(long _timestamp) {
        Date d;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        d = new Date((long)_timestamp*1000);

        this._fecha = formatter.format(d);
;
    }
    /**
     * @param _fecha the _fecha to set as java.util.Date
     */
    public void setFecha(Date _fecha) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        this._fecha = formatter.format(_fecha);
;
    }

    public static CargaCombustible fromRS(ResultSet p_rs) throws SQLException {
        CargaCombustible ret = new CargaCombustible();

        ret.setIdCargaCombustible(p_rs.getLong("id_carga_combustible"));
        ret.setIdUsuario(p_rs.getLong("id_usuario"));
        ret.setIdVehiculo(p_rs.getLong("id_vehiculo"));
        ret.setKm(p_rs.getInt("km"));
        ret.setLitros(p_rs.getInt("litros"));
        ret.setFecha(p_rs.getString("fecha"));
        ret.setEstanqueLleno(p_rs.getString("estanque_lleno") != null ? p_rs.getString("estanque_lleno").equals("true") : null);
        ret.setCosto(p_rs.getInt("costo"));
        ret.setLatitud(p_rs.getDouble("latitud"));
        ret.setLongitud(p_rs.getDouble("longitud"));
        ret.setFechaModificacion(p_rs.getString("fecha_modificacion"));
        ret.setBorrado(p_rs.getString("borrado") != null ? p_rs.getString("borrado").equals("true") : null);

        return ret;
    }

    public static CargaCombustible getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        CargaCombustible ret = null;
        
        String str_sql = _str_sql +
            "  WHERE ca." + p_key + " = " + p_value +
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

    
    public static ArrayList<CargaCombustible> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws UnsupportedParameterException, SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<CargaCombustible> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<CargaCombustible>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_carga_combustible")) {
                    array_clauses.add("ca.id_carga_combustible = " + p.getValue());
                }
                else if (p.getKey().equals("id_usuario")) {
                    array_clauses.add("ca.id_usuario = " + p.getValue());
                }
                else if (p.getKey().equals("id_vehiculo")) {
                    array_clauses.add("ca.id_vehiculo = " + p.getValue());
                }
                else if (p.getKey().equals("mas reciente")) {
                    array_clauses.add("ca.fecha_modificacion > datetime('" + p.getValue() + "')");
                }
                else if (p.getKey().equals("no borrado")) {
                    array_clauses.add("ca.borrado = 'false'");
                }
                else if (p.getKey().equals("borrado")) {
                    array_clauses.add("ca.borrado = 'true'");
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


    public static Long getNextId(Connection p_conn) throws SQLException {
        Long ret = null;
        
        String str_sql = 
            "  SELECT COALESCE(MAX(id_carga_combustible), 0) + 1 AS next_id FROM carga_combustible";
        
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
                ret = rs.getLong("next_id");
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

    public int update(Connection p_conn) throws SQLException {

        int ret = -1;
        Statement stmt = null;

        String str_sql =
            "    UPDATE carga_combustible" +
            "    SET" +
            "    km = " + (_km != null ? "'" + _km + "'" : "null") + "," +
            "    litros = " + (_litros != null ? "'" + _litros + "'" : "null") + "," +
            "    fecha = " + (_fecha != null ? "date('" + _fecha + "')" : "null") + "," +
            "    estanque_lleno = " + (_estanqueLleno != null ? "'" + _estanqueLleno + "'" : "null") + "," +
            "    costo = " + (_costo != null ? "'" + _costo + "'" : "null") + "," +
            "    latitud = " + (_latitud != null ? "'" + _latitud + "'" : "null") + "," +
            "    longitud = " + (_longitud != null ? "'" + _longitud + "'" : "null") + "," +
            "    fecha_modificacion = " + (_fechaModificacion != null ? "datetime('" + _fechaModificacion + "')" : "datetime('now', 'localtime')") + "," +
            "    borrado = " + (_borrado != null ? "'" + _borrado + "'" : "'false'") +
            "    WHERE" +
            "    id_carga_combustible = " + Long.toString(this._idCargaCombustible) + " AND" +
            "    id_usuario = " + Long.toString(this._idUsuario);

        try {
            stmt = p_conn.createStatement();

            ret = stmt.executeUpdate(str_sql);

            load(p_conn);

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

        if (_idCargaCombustible == null) {
            _idCargaCombustible = getNextId(p_conn);
        }

        String str_sql =
            "    INSERT INTO carga_combustible" +
            "    (" +
            "    id_carga_combustible, " +
            "    id_usuario, " +
            "    id_vehiculo, " +
            "    km, " +
            "    litros, " +
            "    fecha, " +
            "    estanque_lleno, " +
            "    costo, " +
            "    latitud, " +
            "    longitud, " +
            "    fecha_modificacion, " +
            "    borrado)" +
            "    VALUES" +
            "    (" +
            "    " + (_idCargaCombustible != null ? "'" + _idCargaCombustible + "'" : "null") + "," +
            "    " + (_idUsuario != null ? "'" + _idUsuario + "'" : "null") + "," +
            "    " + (_idVehiculo != null ? "'" + _idVehiculo + "'" : "null") + "," +
            "    " + (_km != null ? "'" + _km + "'" : "null") + "," +
            "    " + (_litros != null ? "'" + _litros + "'" : "null") + "," +
            "    " + (_fecha != null ? "date('" + _fecha + "')" : "null") + "," +
            "    " + (_estanqueLleno != null ? "'" + _estanqueLleno + "'" : "null") + "," +
            "    " + (_costo != null ? "'" + _costo + "'" : "null") + "," +
            "    " + (_latitud != null ? "'" + _latitud + "'" : "null") + "," +
            "    " + (_longitud != null ? "'" + _longitud + "'" : "null") + "," +
            "    " + (_fechaModificacion != null ? "datetime('" + _fechaModificacion + "')" : "datetime('now', 'localtime')") + "," +
            "    " + (_borrado != null ? "'" + _borrado + "'" : "'false'") +
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
            "    DELETE FROM carga_combustible" +
            "    WHERE" +
            "    id_carga_combustible = " + Long.toString(this._idCargaCombustible) + " AND" +
            "    id_usuario = " + Long.toString(this._idUsuario);

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
        CargaCombustible obj = null;
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_carga_combustible = " + Long.toString(this._idCargaCombustible) + " AND" +
            "    id_usuario = " + Long.toString(this._idUsuario) +
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

                _idVehiculo = obj.getIdVehiculo();
                _km = obj.getKm();
                _litros = obj.getLitros();
                _fecha = obj.getFecha();
                _estanqueLleno = obj.getEstanqueLleno();
                _costo = obj.getCosto();
                _latitud = obj.getLatitud();
                _longitud = obj.getLongitud();
                _fechaModificacion = obj.getFechaModificacion();
                _borrado = obj.getBorrado();
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
            "    id_carga_combustible = " + Long.toString(this._idCargaCombustible) + " AND" +
            "    id_usuario = " + Long.toString(this._idUsuario) +
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
        return "CargaCombustible [" +
	           "    _idCargaCombustible = " + (_idCargaCombustible != null ? _idCargaCombustible : "null") + "," +
	           "    _idUsuario = " + (_idUsuario != null ? _idUsuario : "null") + "," +
	           "    _idVehiculo = " + (_idVehiculo != null ? _idVehiculo : "null") + "," +
	           "    _km = " + (_km != null ? _km : "null") + "," +
	           "    _litros = " + (_litros != null ? _litros : "null") + "," +
	           "    _fecha = " + (_fecha != null ? "'" + _fecha + "'" : "null") + "," +
	           "    _estanqueLleno = " + (_estanqueLleno != null ? _estanqueLleno : "null") + "," +
	           "    _costo = " + (_costo != null ? _costo : "null") + "," +
	           "    _latitud = " + (_latitud != null ? _latitud : "null") + "," +
	           "    _longitud = " + (_longitud != null ? _longitud : "null") + "," +
	           "    _fechaModificacion = " + (_fechaModificacion != null ? "'" + _fechaModificacion + "'" : "null") + "," +
	           "    _borrado = " + (_borrado != null ? _borrado : "null") +
			   "]";
    }


/*
    public static CargaCombustible fromXMLNode(Node xmlNode) {
        CargaCombustible ret = new CargaCombustible();

        Element element = (Element) xmlNode;

        ret.setIdCargaCombustible(Long.decode(element.getElementsByTagName("id_carga_combustible").item(0).getTextContent()));
        ret.setIdUsuario(Long.decode(element.getElementsByTagName("id_usuario").item(0).getTextContent()));
        ret.setIdVehiculo(Long.decode(element.getElementsByTagName("id_vehiculo").item(0).getTextContent()));
        ret.setKm(Integer.decode(element.getElementsByTagName("km").item(0).getTextContent()));
        ret.setLitros(Integer.decode(element.getElementsByTagName("litros").item(0).getTextContent()));
        ret.setFecha(element.getElementsByTagName("fecha").item(0).getTextContent());
        ret.setEstanqueLleno(element.getElementsByTagName("estanque_lleno").item(0).getTextContent());
        ret.setCosto(Integer.decode(element.getElementsByTagName("costo").item(0).getTextContent()));
        ret.setLatitud(Double.decode(element.getElementsByTagName("latitud").item(0).getTextContent()));
        ret.setLongitud(Double.decode(element.getElementsByTagName("longitud").item(0).getTextContent()));
        ret.setFechaModificacion(element.getElementsByTagName("fecha_modificacion").item(0).getTextContent());
        ret.setBorrado(element.getElementsByTagName("borrado").item(0).getTextContent());

        return ret;
    }
    */
}
