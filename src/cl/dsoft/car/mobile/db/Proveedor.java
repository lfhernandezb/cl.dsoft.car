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
public class Proveedor {
    @Element(name = "direccion", required = false)
    private String _direccion;
    @Element(name = "valorMaximo", required = false)
    private Float _valorMaximo;
    @Element(name = "detalleHtml", required = false)
    private String _detalleHtml;
    @Element(name = "telefono", required = false)
    private String _telefono;
    @Element(name = "url", required = false)
    private String _url;
    @Element(name = "nombre", required = false)
    private String _nombre;
    @Element(name = "id")
    private Integer _id;
    @Element(name = "fechaModificacion")
    private String _fechaModificacion;
    @Element(name = "calificacion", required = false)
    private Byte _calificacion;
    @Element(name = "existenValores", required = false)
    private Boolean _existenValores;
    @Element(name = "latitud", required = false)
    private Double _latitud;
    @Element(name = "longitud", required = false)
    private Double _longitud;
    @Element(name = "valorMinimo", required = false)
    private Float _valorMinimo;
    @Element(name = "correo", required = false)
    private String _correo;

    private final static String _str_sql = 
        "    SELECT" +
        "    pr.direccion AS direccion," +
        "    pr.valor_maximo AS valor_maximo," +
        "    pr.detalle_html AS detalle_html," +
        "    pr.telefono AS telefono," +
        "    pr.url AS url," +
        "    pr.nombre AS nombre," +
        "    pr.id_proveedor AS id," +
        "    strftime('%Y-%m-%d %H:%M:%S', pr.fecha_modificacion) AS fecha_modificacion," +
        "    pr.calificacion AS calificacion," +
        "    pr.existen_valores AS existen_valores," +
        "    pr.latitud AS latitud," +
        "    pr.longitud AS longitud," +
        "    pr.valor_minimo AS valor_minimo," +
        "    pr.correo AS correo" +
        "    FROM proveedor pr";

    public Proveedor() {
        _direccion = null;
        _valorMaximo = null;
        _detalleHtml = null;
        _telefono = null;
        _url = null;
        _nombre = null;
        _id = null;
        _fechaModificacion = null;
        _calificacion = null;
        _existenValores = null;
        _latitud = null;
        _longitud = null;
        _valorMinimo = null;
        _correo = null;

    }
    /**
     * @return the _direccion
     */
    public String getDireccion() {
        return _direccion;
    }
    /**
     * @return the _valorMaximo
     */
    public Float getValorMaximo() {
        return _valorMaximo;
    }
    /**
     * @return the _detalleHtml
     */
    public String getDetalleHtml() {
        return _detalleHtml;
    }
    /**
     * @return the _telefono
     */
    public String getTelefono() {
        return _telefono;
    }
    /**
     * @return the _url
     */
    public String getUrl() {
        return _url;
    }
    /**
     * @return the _nombre
     */
    public String getNombre() {
        return _nombre;
    }
    /**
     * @return the _id
     */
    public Integer getId() {
        return _id;
    }
    /**
     * @return the _fechaModificacion
     */
    public String getFechaModificacion() {
        return _fechaModificacion;
    }
    /**
     * @return the _calificacion
     */
    public Byte getCalificacion() {
        return _calificacion;
    }
    /**
     * @return the _existenValores
     */
    public Boolean getExistenValores() {
        return _existenValores;
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
     * @return the _valorMinimo
     */
    public Float getValorMinimo() {
        return _valorMinimo;
    }
    /**
     * @return the _correo
     */
    public String getCorreo() {
        return _correo;
    }
    /**
     * @param _direccion the _direccion to set
     */
    public void setDireccion(String _direccion) {
        this._direccion = _direccion;
    }
    /**
     * @param _valorMaximo the _valorMaximo to set
     */
    public void setValorMaximo(Float _valorMaximo) {
        this._valorMaximo = _valorMaximo;
    }
    /**
     * @param _detalleHtml the _detalleHtml to set
     */
    public void setDetalleHtml(String _detalleHtml) {
        this._detalleHtml = _detalleHtml;
    }
    /**
     * @param _telefono the _telefono to set
     */
    public void setTelefono(String _telefono) {
        this._telefono = _telefono;
    }
    /**
     * @param _url the _url to set
     */
    public void setUrl(String _url) {
        this._url = _url;
    }
    /**
     * @param _nombre the _nombre to set
     */
    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }
    /**
     * @param _id the _id to set
     */
    public void setId(Integer _id) {
        this._id = _id;
    }
    /**
     * @param _fechaModificacion the _fechaModificacion to set
     */
    public void setFechaModificacion(String _fechaModificacion) {
        this._fechaModificacion = _fechaModificacion;
    }
    /**
     * @param _calificacion the _calificacion to set
     */
    public void setCalificacion(Byte _calificacion) {
        this._calificacion = _calificacion;
    }
    /**
     * @param _existenValores the _existenValores to set
     */
    public void setExistenValores(Boolean _existenValores) {
        this._existenValores = _existenValores;
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
     * @param _valorMinimo the _valorMinimo to set
     */
    public void setValorMinimo(Float _valorMinimo) {
        this._valorMinimo = _valorMinimo;
    }
    /**
     * @param _correo the _correo to set
     */
    public void setCorreo(String _correo) {
        this._correo = _correo;
    }

    public static Proveedor fromRS(ResultSet p_rs) throws SQLException {
        Proveedor ret = new Proveedor();

        ret.setDireccion(p_rs.getString("direccion"));
        ret.setValorMaximo(p_rs.getFloat("valor_maximo"));
        ret.setDetalleHtml(p_rs.getString("detalle_html"));
        ret.setTelefono(p_rs.getString("telefono"));
        ret.setUrl(p_rs.getString("url"));
        ret.setNombre(p_rs.getString("nombre"));
        ret.setId(p_rs.getInt("id"));
        ret.setFechaModificacion(p_rs.getString("fecha_modificacion"));
        ret.setCalificacion(p_rs.getByte("calificacion"));
        ret.setExistenValores(p_rs.getString("existen_valores") != null ? p_rs.getString("existen_valores").equals("true") : null);
        ret.setLatitud(p_rs.getDouble("latitud"));
        ret.setLongitud(p_rs.getDouble("longitud"));
        ret.setValorMinimo(p_rs.getFloat("valor_minimo"));
        ret.setCorreo(p_rs.getString("correo"));

        return ret;
    }

    public static Proveedor getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        Proveedor ret = null;
        
        String str_sql = _str_sql +
            "  WHERE pr." + p_key + " = " + p_value +
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

    public static Proveedor getById(Connection p_conn, String p_id) throws SQLException {
        return getByParameter(p_conn, "id_proveedor", p_id);
    }
    
    public static ArrayList<Proveedor> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws UnsupportedParameterException, SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<Proveedor> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<Proveedor>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_proveedor")) {
                    array_clauses.add("pr.id_proveedor = " + p.getValue());
                }
                else if (p.getKey().equals("mas reciente")) {
                    array_clauses.add("pr.fecha_modificacion > datetime('" + p.getValue() + "', 'localtime')");
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


    public static Integer getNextId(Connection p_conn) throws SQLException {
        Integer ret = null;
        
        String str_sql = 
            "  SELECT COALESCE(MAX(id_proveedor), 0) + 1 AS next_id FROM proveedor";
        
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
                ret = rs.getInt("next_id");
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
            "    UPDATE proveedor" +
            "    SET" +
            "    direccion = " + (_direccion != null ? "'" + _direccion + "'" : "null") + "," +
            "    valor_maximo = " + (_valorMaximo != null ? "'" + _valorMaximo + "'" : "null") + "," +
            "    detalle_html = " + (_detalleHtml != null ? "'" + _detalleHtml + "'" : "null") + "," +
            "    telefono = " + (_telefono != null ? "'" + _telefono + "'" : "null") + "," +
            "    url = " + (_url != null ? "'" + _url + "'" : "null") + "," +
            "    nombre = " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
            "    fecha_modificacion = " + (_fechaModificacion != null ? "datetime('" + _fechaModificacion + "', 'localtime')" : "datetime('now', 'localtime')") + "," +
            "    calificacion = " + (_calificacion != null ? "'" + _calificacion + "'" : "null") + "," +
            "    existen_valores = " + (_existenValores != null ? "'" + _existenValores + "'" : "null") + "," +
            "    latitud = " + (_latitud != null ? "'" + _latitud + "'" : "null") + "," +
            "    longitud = " + (_longitud != null ? "'" + _longitud + "'" : "null") + "," +
            "    valor_minimo = " + (_valorMinimo != null ? "'" + _valorMinimo + "'" : "null") + "," +
            "    correo = " + (_correo != null ? "'" + _correo + "'" : "null") +
            "    WHERE" +
            "    id_proveedor = " + Integer.toString(this._id);

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

        if (_id == null) {
            _id = getNextId(p_conn);
        }

        String str_sql =
            "    INSERT INTO proveedor" +
            "    (" +
            "    direccion, " +
            "    valor_maximo, " +
            "    detalle_html, " +
            "    telefono, " +
            "    url, " +
            "    nombre, " +
            "    id_proveedor, " +
            "    fecha_modificacion, " +
            "    calificacion, " +
            "    existen_valores, " +
            "    latitud, " +
            "    longitud, " +
            "    valor_minimo, " +
            "    correo)" +
            "    VALUES" +
            "    (" +
            "    " + (_direccion != null ? "'" + _direccion + "'" : "null") + "," +
            "    " + (_valorMaximo != null ? "'" + _valorMaximo + "'" : "null") + "," +
            "    " + (_detalleHtml != null ? "'" + _detalleHtml + "'" : "null") + "," +
            "    " + (_telefono != null ? "'" + _telefono + "'" : "null") + "," +
            "    " + (_url != null ? "'" + _url + "'" : "null") + "," +
            "    " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
            "    " + (_id != null ? "'" + _id + "'" : "null") + "," +
            "    " + (_fechaModificacion != null ? "datetime('" + _fechaModificacion + "', 'localtime')" : "datetime('now', 'localtime')") + "," +
            "    " + (_calificacion != null ? "'" + _calificacion + "'" : "null") + "," +
            "    " + (_existenValores != null ? "'" + _existenValores + "'" : "null") + "," +
            "    " + (_latitud != null ? "'" + _latitud + "'" : "null") + "," +
            "    " + (_longitud != null ? "'" + _longitud + "'" : "null") + "," +
            "    " + (_valorMinimo != null ? "'" + _valorMinimo + "'" : "null") + "," +
            "    " + (_correo != null ? "'" + _correo + "'" : "null") +
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
            "    DELETE FROM proveedor" +
            "    WHERE" +
            "    id_proveedor = " + Integer.toString(this._id);

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
        Proveedor obj = null;
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_proveedor = " + Integer.toString(this._id) +
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

                _direccion = obj.getDireccion();
                _valorMaximo = obj.getValorMaximo();
                _detalleHtml = obj.getDetalleHtml();
                _telefono = obj.getTelefono();
                _url = obj.getUrl();
                _nombre = obj.getNombre();
                _fechaModificacion = obj.getFechaModificacion();
                _calificacion = obj.getCalificacion();
                _existenValores = obj.getExistenValores();
                _latitud = obj.getLatitud();
                _longitud = obj.getLongitud();
                _valorMinimo = obj.getValorMinimo();
                _correo = obj.getCorreo();
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
            "    id_proveedor = " + Integer.toString(this._id) +
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
        return "Proveedor [" +
	           "    _direccion = " + (_direccion != null ? "'" + _direccion + "'" : "null") + "," +
	           "    _valorMaximo = " + (_valorMaximo != null ? _valorMaximo : "null") + "," +
	           "    _detalleHtml = " + (_detalleHtml != null ? "'" + _detalleHtml + "'" : "null") + "," +
	           "    _telefono = " + (_telefono != null ? "'" + _telefono + "'" : "null") + "," +
	           "    _url = " + (_url != null ? "'" + _url + "'" : "null") + "," +
	           "    _nombre = " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
	           "    _id = " + (_id != null ? _id : "null") + "," +
	           "    _fechaModificacion = " + (_fechaModificacion != null ? "'" + _fechaModificacion + "'" : "null") + "," +
	           "    _calificacion = " + (_calificacion != null ? _calificacion : "null") + "," +
	           "    _existenValores = " + (_existenValores != null ? _existenValores : "null") + "," +
	           "    _latitud = " + (_latitud != null ? _latitud : "null") + "," +
	           "    _longitud = " + (_longitud != null ? _longitud : "null") + "," +
	           "    _valorMinimo = " + (_valorMinimo != null ? _valorMinimo : "null") + "," +
	           "    _correo = " + (_correo != null ? "'" + _correo + "'" : "null") +
			   "]";
    }


/*
    public static Proveedor fromXMLNode(Node xmlNode) {
        Proveedor ret = new Proveedor();

        Element element = (Element) xmlNode;

        ret.setDireccion(element.getElementsByTagName("direccion").item(0).getTextContent());
        ret.setValorMaximo(Float.decode(element.getElementsByTagName("valor_maximo").item(0).getTextContent()));
        ret.setDetalleHtml(element.getElementsByTagName("detalle_html").item(0).getTextContent());
        ret.setTelefono(element.getElementsByTagName("telefono").item(0).getTextContent());
        ret.setUrl(element.getElementsByTagName("url").item(0).getTextContent());
        ret.setNombre(element.getElementsByTagName("nombre").item(0).getTextContent());
        ret.setId(Integer.decode(element.getElementsByTagName("id_proveedor").item(0).getTextContent()));
        ret.setFechaModificacion(element.getElementsByTagName("fecha_modificacion").item(0).getTextContent());
        ret.setCalificacion(Byte.decode(element.getElementsByTagName("calificacion").item(0).getTextContent()));
        ret.setExistenValores(element.getElementsByTagName("existen_valores").item(0).getTextContent());
        ret.setLatitud(Double.decode(element.getElementsByTagName("latitud").item(0).getTextContent()));
        ret.setLongitud(Double.decode(element.getElementsByTagName("longitud").item(0).getTextContent()));
        ret.setValorMinimo(Float.decode(element.getElementsByTagName("valor_minimo").item(0).getTextContent()));
        ret.setCorreo(element.getElementsByTagName("correo").item(0).getTextContent());

        return ret;
    }
    */
}
