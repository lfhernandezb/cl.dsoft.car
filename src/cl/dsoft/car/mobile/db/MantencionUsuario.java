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
public class MantencionUsuario {
    @Element(name = "idMantencionUsuario")
    private Long _idMantencionUsuario;
    @Element(name = "idUsuario")
    private Long _idUsuario;
    @Element(name = "nombre", required = false)
    private String _nombre;
    @Element(name = "descripcion", required = false)
    private String _descripcion;
    @Element(name = "beneficios", required = false)
    private String _beneficios;
    @Element(name = "url", required = false)
    private String _url;
    @Element(name = "dependeKm", required = false)
    private Boolean _dependeKm;
    @Element(name = "kmEntreMantenciones", required = false)
    private Integer _kmEntreMantenciones;
    @Element(name = "mesesEntreMantenciones", required = false)
    private Integer _mesesEntreMantenciones;
    @Element(name = "fechaModificacion")
    private String _fechaModificacion;
    @Element(name = "borrado")
    private Boolean _borrado;

    private final static String _str_sql = 
        "    SELECT" +
        "    ma.id_mantencion_usuario AS id_mantencion_usuario," +
        "    ma.id_usuario AS id_usuario," +
        "    ma.nombre AS nombre," +
        "    ma.descripcion AS descripcion," +
        "    ma.beneficios AS beneficios," +
        "    ma.url AS url," +
        "    ma.depende_km AS depende_km," +
        "    ma.km_entre_mantenciones AS km_entre_mantenciones," +
        "    ma.meses_entre_mantenciones AS meses_entre_mantenciones," +
        "    strftime('%Y-%m-%d %H:%M:%S', ma.fecha_modificacion) AS fecha_modificacion," +
        "    ma.borrado AS borrado" +
        "    FROM mantencion_usuario ma";

    public MantencionUsuario() {
        _idMantencionUsuario = null;
        _idUsuario = null;
        _nombre = null;
        _descripcion = null;
        _beneficios = null;
        _url = null;
        _dependeKm = null;
        _kmEntreMantenciones = null;
        _mesesEntreMantenciones = null;
        _fechaModificacion = null;
        _borrado = null;

    }
    /**
     * @return the _idMantencionUsuario
     */
    public Long getIdMantencionUsuario() {
        return _idMantencionUsuario;
    }
    /**
     * @return the _idUsuario
     */
    public Long getIdUsuario() {
        return _idUsuario;
    }
    /**
     * @return the _nombre
     */
    public String getNombre() {
        return _nombre;
    }
    /**
     * @return the _descripcion
     */
    public String getDescripcion() {
        return _descripcion;
    }
    /**
     * @return the _beneficios
     */
    public String getBeneficios() {
        return _beneficios;
    }
    /**
     * @return the _url
     */
    public String getUrl() {
        return _url;
    }
    /**
     * @return the _dependeKm
     */
    public Boolean getDependeKm() {
        return _dependeKm;
    }
    /**
     * @return the _kmEntreMantenciones
     */
    public Integer getKmEntreMantenciones() {
        return _kmEntreMantenciones;
    }
    /**
     * @return the _mesesEntreMantenciones
     */
    public Integer getMesesEntreMantenciones() {
        return _mesesEntreMantenciones;
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
     * @param _idMantencionUsuario the _idMantencionUsuario to set
     */
    public void setIdMantencionUsuario(Long _idMantencionUsuario) {
        this._idMantencionUsuario = _idMantencionUsuario;
    }
    /**
     * @param _idUsuario the _idUsuario to set
     */
    public void setIdUsuario(Long _idUsuario) {
        this._idUsuario = _idUsuario;
    }
    /**
     * @param _nombre the _nombre to set
     */
    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }
    /**
     * @param _descripcion the _descripcion to set
     */
    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }
    /**
     * @param _beneficios the _beneficios to set
     */
    public void setBeneficios(String _beneficios) {
        this._beneficios = _beneficios;
    }
    /**
     * @param _url the _url to set
     */
    public void setUrl(String _url) {
        this._url = _url;
    }
    /**
     * @param _dependeKm the _dependeKm to set
     */
    public void setDependeKm(Boolean _dependeKm) {
        this._dependeKm = _dependeKm;
    }
    /**
     * @param _kmEntreMantenciones the _kmEntreMantenciones to set
     */
    public void setKmEntreMantenciones(Integer _kmEntreMantenciones) {
        this._kmEntreMantenciones = _kmEntreMantenciones;
    }
    /**
     * @param _mesesEntreMantenciones the _mesesEntreMantenciones to set
     */
    public void setMesesEntreMantenciones(Integer _mesesEntreMantenciones) {
        this._mesesEntreMantenciones = _mesesEntreMantenciones;
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

    public static MantencionUsuario fromRS(ResultSet p_rs) throws SQLException {
        MantencionUsuario ret = new MantencionUsuario();

        ret.setIdMantencionUsuario(p_rs.getLong("id_mantencion_usuario"));
        ret.setIdUsuario(p_rs.getLong("id_usuario"));
        ret.setNombre(p_rs.getString("nombre"));
        ret.setDescripcion(p_rs.getString("descripcion"));
        ret.setBeneficios(p_rs.getString("beneficios"));
        ret.setUrl(p_rs.getString("url"));
        ret.setDependeKm(p_rs.getString("depende_km") != null ? p_rs.getString("depende_km").equals("true") : null);
        ret.setKmEntreMantenciones(p_rs.getInt("km_entre_mantenciones"));
        ret.setMesesEntreMantenciones(p_rs.getInt("meses_entre_mantenciones"));
        ret.setFechaModificacion(p_rs.getString("fecha_modificacion"));
        ret.setBorrado(p_rs.getString("borrado") != null ? p_rs.getString("borrado").equals("true") : null);

        return ret;
    }

    public static MantencionUsuario getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        MantencionUsuario ret = null;
        
        String str_sql = _str_sql +
            "  WHERE ma." + p_key + " = " + p_value +
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

    
    public static ArrayList<MantencionUsuario> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws UnsupportedParameterException, SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<MantencionUsuario> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<MantencionUsuario>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_mantencion_usuario")) {
                    array_clauses.add("ma.id_mantencion_usuario = " + p.getValue());
                }
                else if (p.getKey().equals("id_usuario")) {
                    array_clauses.add("ma.id_usuario = " + p.getValue());
                }
                else if (p.getKey().equals("mas reciente")) {
                    array_clauses.add("ma.fecha_modificacion > datetime('" + p.getValue() + "')");
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


    public static Long getNextId(Connection p_conn) throws SQLException {
        Long ret = null;
        
        String str_sql = 
            "  SELECT COALESCE(MAX(id_mantencion_usuario), 0) + 1 AS next_id FROM mantencion_usuario";
        
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
            "    UPDATE mantencion_usuario" +
            "    SET" +
            "    nombre = " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
            "    descripcion = " + (_descripcion != null ? "'" + _descripcion + "'" : "null") + "," +
            "    beneficios = " + (_beneficios != null ? "'" + _beneficios + "'" : "null") + "," +
            "    url = " + (_url != null ? "'" + _url + "'" : "null") + "," +
            "    depende_km = " + (_dependeKm != null ? "'" + _dependeKm + "'" : "null") + "," +
            "    km_entre_mantenciones = " + (_kmEntreMantenciones != null ? "'" + _kmEntreMantenciones + "'" : "null") + "," +
            "    meses_entre_mantenciones = " + (_mesesEntreMantenciones != null ? "'" + _mesesEntreMantenciones + "'" : "null") + "," +
            "    fecha_modificacion = " + (_fechaModificacion != null ? "datetime('" + _fechaModificacion + "')" : "datetime('now', 'localtime')") + "," +
            "    borrado = " + (_borrado != null ? "'" + _borrado + "'" : "'false'") +
            "    WHERE" +
            "    id_mantencion_usuario = " + Long.toString(this._idMantencionUsuario) + " AND" +
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

        if (_idMantencionUsuario == null) {
            _idMantencionUsuario = getNextId(p_conn);
        }

        String str_sql =
            "    INSERT INTO mantencion_usuario" +
            "    (" +
            "    id_mantencion_usuario, " +
            "    id_usuario, " +
            "    nombre, " +
            "    descripcion, " +
            "    beneficios, " +
            "    url, " +
            "    depende_km, " +
            "    km_entre_mantenciones, " +
            "    meses_entre_mantenciones, " +
            "    fecha_modificacion, " +
            "    borrado)" +
            "    VALUES" +
            "    (" +
            "    " + (_idMantencionUsuario != null ? "'" + _idMantencionUsuario + "'" : "null") + "," +
            "    " + (_idUsuario != null ? "'" + _idUsuario + "'" : "null") + "," +
            "    " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
            "    " + (_descripcion != null ? "'" + _descripcion + "'" : "null") + "," +
            "    " + (_beneficios != null ? "'" + _beneficios + "'" : "null") + "," +
            "    " + (_url != null ? "'" + _url + "'" : "null") + "," +
            "    " + (_dependeKm != null ? "'" + _dependeKm + "'" : "null") + "," +
            "    " + (_kmEntreMantenciones != null ? "'" + _kmEntreMantenciones + "'" : "null") + "," +
            "    " + (_mesesEntreMantenciones != null ? "'" + _mesesEntreMantenciones + "'" : "null") + "," +
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
            "    DELETE FROM mantencion_usuario" +
            "    WHERE" +
            "    id_mantencion_usuario = " + Long.toString(this._idMantencionUsuario) + " AND" +
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
        MantencionUsuario obj = null;
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_mantencion_usuario = " + Long.toString(this._idMantencionUsuario) + " AND" +
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

                _nombre = obj.getNombre();
                _descripcion = obj.getDescripcion();
                _beneficios = obj.getBeneficios();
                _url = obj.getUrl();
                _dependeKm = obj.getDependeKm();
                _kmEntreMantenciones = obj.getKmEntreMantenciones();
                _mesesEntreMantenciones = obj.getMesesEntreMantenciones();
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
            "    id_mantencion_usuario = " + Long.toString(this._idMantencionUsuario) + " AND" +
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
        return "MantencionUsuario [" +
	           "    _idMantencionUsuario = " + (_idMantencionUsuario != null ? _idMantencionUsuario : "null") + "," +
	           "    _idUsuario = " + (_idUsuario != null ? _idUsuario : "null") + "," +
	           "    _nombre = " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
	           "    _descripcion = " + (_descripcion != null ? "'" + _descripcion + "'" : "null") + "," +
	           "    _beneficios = " + (_beneficios != null ? "'" + _beneficios + "'" : "null") + "," +
	           "    _url = " + (_url != null ? "'" + _url + "'" : "null") + "," +
	           "    _dependeKm = " + (_dependeKm != null ? _dependeKm : "null") + "," +
	           "    _kmEntreMantenciones = " + (_kmEntreMantenciones != null ? _kmEntreMantenciones : "null") + "," +
	           "    _mesesEntreMantenciones = " + (_mesesEntreMantenciones != null ? _mesesEntreMantenciones : "null") + "," +
	           "    _fechaModificacion = " + (_fechaModificacion != null ? "'" + _fechaModificacion + "'" : "null") + "," +
	           "    _borrado = " + (_borrado != null ? _borrado : "null") +
			   "]";
    }


/*
    public static MantencionUsuario fromXMLNode(Node xmlNode) {
        MantencionUsuario ret = new MantencionUsuario();

        Element element = (Element) xmlNode;

        ret.setIdMantencionUsuario(Long.decode(element.getElementsByTagName("id_mantencion_usuario").item(0).getTextContent()));
        ret.setIdUsuario(Long.decode(element.getElementsByTagName("id_usuario").item(0).getTextContent()));
        ret.setNombre(element.getElementsByTagName("nombre").item(0).getTextContent());
        ret.setDescripcion(element.getElementsByTagName("descripcion").item(0).getTextContent());
        ret.setBeneficios(element.getElementsByTagName("beneficios").item(0).getTextContent());
        ret.setUrl(element.getElementsByTagName("url").item(0).getTextContent());
        ret.setDependeKm(element.getElementsByTagName("depende_km").item(0).getTextContent());
        ret.setKmEntreMantenciones(Integer.decode(element.getElementsByTagName("km_entre_mantenciones").item(0).getTextContent()));
        ret.setMesesEntreMantenciones(Integer.decode(element.getElementsByTagName("meses_entre_mantenciones").item(0).getTextContent()));
        ret.setFechaModificacion(element.getElementsByTagName("fecha_modificacion").item(0).getTextContent());
        ret.setBorrado(element.getElementsByTagName("borrado").item(0).getTextContent());

        return ret;
    }
    */
}
