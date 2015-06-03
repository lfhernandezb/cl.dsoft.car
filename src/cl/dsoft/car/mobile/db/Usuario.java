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
public class Usuario {
    @Element(name = "id")
    private Long _id;
    @Element(name = "idComuna")
    private Long _idComuna;
    @Element(name = "nombre", required = false)
    private String _nombre;
    @Element(name = "correo", required = false)
    private String _correo;
    @Element(name = "fechaNacimiento", required = false)
    private String _fechaNacimiento;
    @Element(name = "hombre", required = false)
    private Boolean _hombre;
    @Element(name = "telefono", required = false)
    private String _telefono;
    @Element(name = "fechaVencimientoLicencia", required = false)
    private String _fechaVencimientoLicencia;
    @Element(name = "fechaModificacion")
    private String _fechaModificacion;
    @Element(name = "borrado")
    private Boolean _borrado;

    private final static String _str_sql = 
        "    SELECT" +
        "    us.id_usuario AS id," +
        "    us.id_comuna AS id_comuna," +
        "    us.nombre AS nombre," +
        "    us.correo AS correo," +
        "    strftime('%Y-%m-%d', us.fecha_nacimiento) AS fecha_nacimiento," +
        "    us.hombre AS hombre," +
        "    us.telefono AS telefono," +
        "    strftime('%Y-%m-%d', us.fecha_vencimiento_licencia) AS fecha_vencimiento_licencia," +
        "    strftime('%Y-%m-%d %H:%M:%S', us.fecha_modificacion) AS fecha_modificacion," +
        "    us.borrado AS borrado" +
        "    FROM usuario us";

    public Usuario() {
        _id = null;
        _idComuna = null;
        _nombre = null;
        _correo = null;
        _fechaNacimiento = null;
        _hombre = null;
        _telefono = null;
        _fechaVencimientoLicencia = null;
        _fechaModificacion = null;
        _borrado = null;

    }
    /**
     * @return the _id
     */
    public Long getId() {
        return _id;
    }
    /**
     * @return the _idComuna
     */
    public Long getIdComuna() {
        return _idComuna;
    }
    /**
     * @return the _nombre
     */
    public String getNombre() {
        return _nombre;
    }
    /**
     * @return the _correo
     */
    public String getCorreo() {
        return _correo;
    }
    /**
     * @return the _fechaNacimiento
     */
    public String getFechaNacimiento() {
        return _fechaNacimiento;
    }
    /**
     * @return the _hombre
     */
    public Boolean getHombre() {
        return _hombre;
    }
    /**
     * @return the _telefono
     */
    public String getTelefono() {
        return _telefono;
    }
    /**
     * @return the _fechaVencimientoLicencia
     */
    public String getFechaVencimientoLicencia() {
        return _fechaVencimientoLicencia;
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
     * @return the _fechaNacimiento as seconds from January 1, 1970, 00:00:00 GMT
     */
    public long getFechaNacimientoAsLong() throws ParseException {
        Date d;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        d = formatter.parse(_fechaNacimiento);

        return (long)d.getTime() / 1000L;
    }
    /**
     * @return the _fechaVencimientoLicencia as seconds from January 1, 1970, 00:00:00 GMT
     */
    public long getFechaVencimientoLicenciaAsLong() throws ParseException {
        Date d;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        d = formatter.parse(_fechaVencimientoLicencia);

        return (long)d.getTime() / 1000L;
    }
    /**
     * @return the _fechaNacimiento as Date
     */
    public Date getFechaNacimientoAsDate() throws ParseException {
        Date d;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        d = formatter.parse(_fechaNacimiento);

        return d;
    }
    /**
     * @return the _fechaVencimientoLicencia as Date
     */
    public Date getFechaVencimientoLicenciaAsDate() throws ParseException {
        Date d;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        d = formatter.parse(_fechaVencimientoLicencia);

        return d;
    }
    /**
     * @param _id the _id to set
     */
    public void setId(Long _id) {
        this._id = _id;
    }
    /**
     * @param _idComuna the _idComuna to set
     */
    public void setIdComuna(Long _idComuna) {
        this._idComuna = _idComuna;
    }
    /**
     * @param _nombre the _nombre to set
     */
    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }
    /**
     * @param _correo the _correo to set
     */
    public void setCorreo(String _correo) {
        this._correo = _correo;
    }
    /**
     * @param _fechaNacimiento the _fechaNacimiento to set
     */
    public void setFechaNacimiento(String _fechaNacimiento) {
        this._fechaNacimiento = _fechaNacimiento;
    }
    /**
     * @param _hombre the _hombre to set
     */
    public void setHombre(Boolean _hombre) {
        this._hombre = _hombre;
    }
    /**
     * @param _telefono the _telefono to set
     */
    public void setTelefono(String _telefono) {
        this._telefono = _telefono;
    }
    /**
     * @param _fechaVencimientoLicencia the _fechaVencimientoLicencia to set
     */
    public void setFechaVencimientoLicencia(String _fechaVencimientoLicencia) {
        this._fechaVencimientoLicencia = _fechaVencimientoLicencia;
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
     * @param _fechaNacimiento the _fechaNacimiento to set as seconds from January 1, 1970, 00:00:00 GMT
     */
    public void setFechaNacimiento(long _timestamp) {
        Date d;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        d = new Date((long)_timestamp*1000);

        this._fechaNacimiento = formatter.format(d);
;
    }
    /**
     * @param _fechaVencimientoLicencia the _fechaVencimientoLicencia to set as seconds from January 1, 1970, 00:00:00 GMT
     */
    public void setFechaVencimientoLicencia(long _timestamp) {
        Date d;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        d = new Date((long)_timestamp*1000);

        this._fechaVencimientoLicencia = formatter.format(d);
;
    }
    /**
     * @param _fechaNacimiento the _fechaNacimiento to set as java.util.Date
     */
    public void setFechaNacimiento(Date _fecha) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        this._fechaNacimiento = formatter.format(_fecha);
;
    }
    /**
     * @param _fechaVencimientoLicencia the _fechaVencimientoLicencia to set as java.util.Date
     */
    public void setFechaVencimientoLicencia(Date _fecha) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        this._fechaVencimientoLicencia = formatter.format(_fecha);
;
    }

    public static Usuario fromRS(ResultSet p_rs) throws SQLException {
        Usuario ret = new Usuario();

        ret.setId(p_rs.getLong("id"));
        ret.setIdComuna(p_rs.getLong("id_comuna"));
        ret.setNombre(p_rs.getString("nombre"));
        ret.setCorreo(p_rs.getString("correo"));
        ret.setFechaNacimiento(p_rs.getString("fecha_nacimiento"));
        ret.setHombre(p_rs.getString("hombre") != null ? p_rs.getString("hombre").equals("true") : null);
        ret.setTelefono(p_rs.getString("telefono"));
        ret.setFechaVencimientoLicencia(p_rs.getString("fecha_vencimiento_licencia"));
        ret.setFechaModificacion(p_rs.getString("fecha_modificacion"));
        ret.setBorrado(p_rs.getString("borrado") != null ? p_rs.getString("borrado").equals("true") : null);

        return ret;
    }

    public static Usuario getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        Usuario ret = null;
        
        String str_sql = _str_sql +
            "  WHERE us." + p_key + " = " + p_value +
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

    public static Usuario getById(Connection p_conn, String p_id) throws SQLException {
        return getByParameter(p_conn, "id_usuario", p_id);
    }
    
    public static ArrayList<Usuario> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws UnsupportedParameterException, SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<Usuario> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<Usuario>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_usuario")) {
                    array_clauses.add("us.id_usuario = " + p.getValue());
                }
                else if (p.getKey().equals("id_comuna")) {
                    array_clauses.add("us.id_comuna = " + p.getValue());
                }
                else if (p.getKey().equals("id_red_social")) {
                	str_sql +=
                		"    JOIN autenticacion a ON a.id_usuario = us.id_usuario";
                    array_clauses.add("a.id_red_social = " + p.getValue());
                }
                else if (p.getKey().equals("token")) {
                    array_clauses.add("a.token = '" + p.getValue() + "'");
                }
                else if (p.getKey().equals("mas reciente")) {
                    array_clauses.add("us.fecha_modificacion > datetime('" + p.getValue() + "')");
                }
                else if (p.getKey().equals("no borrado")) {
                    array_clauses.add("us.borrado = 'false'");
                }
                else if (p.getKey().equals("borrado")) {
                    array_clauses.add("us.borrado = 'true'");
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
            "  SELECT COALESCE(MAX(id_usuario), 0) + 1 AS next_id FROM usuario";
        
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
            "    UPDATE usuario" +
            "    SET" +
            "    nombre = " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
            "    correo = " + (_correo != null ? "'" + _correo + "'" : "null") + "," +
            "    fecha_nacimiento = " + (_fechaNacimiento != null ? "date('" + _fechaNacimiento + "')" : "null") + "," +
            "    hombre = " + (_hombre != null ? "'" + _hombre + "'" : "null") + "," +
            "    telefono = " + (_telefono != null ? "'" + _telefono + "'" : "null") + "," +
            "    fecha_vencimiento_licencia = " + (_fechaVencimientoLicencia != null ? "date('" + _fechaVencimientoLicencia + "')" : "null") + "," +
            "    fecha_modificacion = " + (_fechaModificacion != null ? "datetime('" + _fechaModificacion + "')" : "datetime('now', 'localtime')") + "," +
            "    borrado = " + (_borrado != null ? "'" + _borrado + "'" : "'false'") +
            "    WHERE" +
            "    id_usuario = " + Long.toString(this._id);

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
            "    INSERT INTO usuario" +
            "    (" +
            "    id_usuario, " +
            "    id_comuna, " +
            "    nombre, " +
            "    correo, " +
            "    fecha_nacimiento, " +
            "    hombre, " +
            "    telefono, " +
            "    fecha_vencimiento_licencia, " +
            "    fecha_modificacion, " +
            "    borrado)" +
            "    VALUES" +
            "    (" +
            "    " + (_id != null ? "'" + _id + "'" : "null") + "," +
            "    " + (_idComuna != null ? "'" + _idComuna + "'" : "null") + "," +
            "    " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
            "    " + (_correo != null ? "'" + _correo + "'" : "null") + "," +
            "    " + (_fechaNacimiento != null ? "date('" + _fechaNacimiento + "')" : "null") + "," +
            "    " + (_hombre != null ? "'" + _hombre + "'" : "null") + "," +
            "    " + (_telefono != null ? "'" + _telefono + "'" : "null") + "," +
            "    " + (_fechaVencimientoLicencia != null ? "date('" + _fechaVencimientoLicencia + "')" : "null") + "," +
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
            "    DELETE FROM usuario" +
            "    WHERE" +
            "    id_usuario = " + Long.toString(this._id);

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
        Usuario obj = null;
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_usuario = " + Long.toString(this._id) +
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

                _idComuna = obj.getIdComuna();
                _nombre = obj.getNombre();
                _correo = obj.getCorreo();
                _fechaNacimiento = obj.getFechaNacimiento();
                _hombre = obj.getHombre();
                _telefono = obj.getTelefono();
                _fechaVencimientoLicencia = obj.getFechaVencimientoLicencia();
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
            "    id_usuario = " + Long.toString(this._id) +
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
        return "Usuario [" +
	           "    _id = " + (_id != null ? _id : "null") + "," +
	           "    _idComuna = " + (_idComuna != null ? _idComuna : "null") + "," +
	           "    _nombre = " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
	           "    _correo = " + (_correo != null ? "'" + _correo + "'" : "null") + "," +
	           "    _fechaNacimiento = " + (_fechaNacimiento != null ? "'" + _fechaNacimiento + "'" : "null") + "," +
	           "    _hombre = " + (_hombre != null ? _hombre : "null") + "," +
	           "    _telefono = " + (_telefono != null ? "'" + _telefono + "'" : "null") + "," +
	           "    _fechaVencimientoLicencia = " + (_fechaVencimientoLicencia != null ? "'" + _fechaVencimientoLicencia + "'" : "null") + "," +
	           "    _fechaModificacion = " + (_fechaModificacion != null ? "'" + _fechaModificacion + "'" : "null") + "," +
	           "    _borrado = " + (_borrado != null ? _borrado : "null") +
			   "]";
    }


/*
    public static Usuario fromXMLNode(Node xmlNode) {
        Usuario ret = new Usuario();

        Element element = (Element) xmlNode;

        ret.setId(Long.decode(element.getElementsByTagName("id_usuario").item(0).getTextContent()));
        ret.setIdComuna(Long.decode(element.getElementsByTagName("id_comuna").item(0).getTextContent()));
        ret.setNombre(element.getElementsByTagName("nombre").item(0).getTextContent());
        ret.setCorreo(element.getElementsByTagName("correo").item(0).getTextContent());
        ret.setFechaNacimiento(element.getElementsByTagName("fecha_nacimiento").item(0).getTextContent());
        ret.setHombre(element.getElementsByTagName("hombre").item(0).getTextContent());
        ret.setTelefono(element.getElementsByTagName("telefono").item(0).getTextContent());
        ret.setFechaVencimientoLicencia(element.getElementsByTagName("fecha_vencimiento_licencia").item(0).getTextContent());
        ret.setFechaModificacion(element.getElementsByTagName("fecha_modificacion").item(0).getTextContent());
        ret.setBorrado(element.getElementsByTagName("borrado").item(0).getTextContent());

        return ret;
    }
    */
}
