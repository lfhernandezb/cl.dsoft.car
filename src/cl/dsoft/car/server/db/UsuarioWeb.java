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
public class UsuarioWeb {
    protected String _nombre;
    protected String _nombreUsuario;
    protected String _email;
    protected String _apellidos;
    protected Boolean _borrado;
    protected String _contrasena;
    protected Integer _id;
    protected Boolean _activo;

    private final static String _str_sql = 
        "    SELECT" +
        "    us.nombre AS nombre," +
        "    us.nombre_usuario AS nombre_usuario," +
        "    us.email AS email," +
        "    us.apellidos AS apellidos," +
        "    0+us.borrado AS borrado," +
        "    us.contrasena AS contrasena," +
        "    us.id_usuario_web AS id," +
        "    0+us.activo AS activo" +
        "    FROM usuario_web us";

    public UsuarioWeb() {
        _nombre = null;
        _nombreUsuario = null;
        _email = null;
        _apellidos = null;
        _borrado = null;
        _contrasena = null;
        _id = null;
        _activo = null;

    }
    /**
     * @return the _nombre
     */
    public String getNombre() {
        return _nombre;
    }
    /**
     * @return the _nombreUsuario
     */
    public String getNombreUsuario() {
        return _nombreUsuario;
    }
    /**
     * @return the _email
     */
    public String getEmail() {
        return _email;
    }
    /**
     * @return the _apellidos
     */
    public String getApellidos() {
        return _apellidos;
    }
    /**
     * @return the _borrado
     */
    public Boolean getBorrado() {
        return _borrado;
    }
    /**
     * @return the _contrasena
     */
    public String getContrasena() {
        return _contrasena;
    }
    /**
     * @return the _id
     */
    public Integer getId() {
        return _id;
    }
    /**
     * @return the _activo
     */
    public Boolean getActivo() {
        return _activo;
    }
    /**
     * @param _nombre the _nombre to set
     */
    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }
    /**
     * @param _nombreUsuario the _nombreUsuario to set
     */
    public void setNombreUsuario(String _nombreUsuario) {
        this._nombreUsuario = _nombreUsuario;
    }
    /**
     * @param _email the _email to set
     */
    public void setEmail(String _email) {
        this._email = _email;
    }
    /**
     * @param _apellidos the _apellidos to set
     */
    public void setApellidos(String _apellidos) {
        this._apellidos = _apellidos;
    }
    /**
     * @param _borrado the _borrado to set
     */
    public void setBorrado(Boolean _borrado) {
        this._borrado = _borrado;
    }
    /**
     * @param _contrasena the _contrasena to set
     */
    public void setContrasena(String _contrasena) {
        this._contrasena = _contrasena;
    }
    /**
     * @param _id the _id to set
     */
    public void setId(Integer _id) {
        this._id = _id;
    }
    /**
     * @param _activo the _activo to set
     */
    public void setActivo(Boolean _activo) {
        this._activo = _activo;
    }

    public static UsuarioWeb fromRS(ResultSet p_rs) throws SQLException {
        UsuarioWeb ret = new UsuarioWeb();

        ret.setNombre(p_rs.getString("nombre"));
        ret.setNombreUsuario(p_rs.getString("nombre_usuario"));
        ret.setEmail(p_rs.getString("email"));
        ret.setApellidos(p_rs.getString("apellidos"));
        ret.setBorrado(p_rs.getBoolean("borrado"));
        ret.setContrasena(p_rs.getString("contrasena"));
        ret.setId(p_rs.getInt("id"));
        ret.setActivo(p_rs.getBoolean("activo"));

        return ret;
    }

    public static UsuarioWeb getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        UsuarioWeb ret = null;
        
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

    public static UsuarioWeb getById(Connection p_conn, String p_id) throws SQLException {
        return getByParameter(p_conn, "id_usuario_web", p_id);
    }
    
    public static ArrayList<UsuarioWeb> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws UnsupportedParameterException, SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<UsuarioWeb> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<UsuarioWeb>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_usuario_web")) {
                    array_clauses.add("us.id_usuario_web = " + p.getValue());
                }
                else if (p.getKey().equals("no borrado")) {
                    array_clauses.add("us.borrado = 0");
                }
                else if (p.getKey().equals("borrado")) {
                    array_clauses.add("us.borrado = 1");
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
            "    UPDATE usuario_web" +
            "    SET" +
            "    nombre = " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
            "    nombre_usuario = " + (_nombreUsuario != null ? "'" + _nombreUsuario + "'" : "null") + "," +
            "    email = " + (_email != null ? "'" + _email + "'" : "null") + "," +
            "    apellidos = " + (_apellidos != null ? "'" + _apellidos + "'" : "null") + "," +
            "    borrado = " + (_borrado != null ? "b'" + (_borrado ? 1 : 0) + "'" : "null") + "," +
            "    contrasena = " + (_contrasena != null ? "'" + _contrasena + "'" : "null") + "," +
            "    activo = " + (_activo != null ? "b'" + (_activo ? 1 : 0) + "'" : "null") +
            "    WHERE" +
            "    id_usuario_web = " + Integer.toString(this._id);

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
            "    INSERT INTO usuario_web" +
            "    (" +
            "    nombre, " +
            "    nombre_usuario, " +
            "    email, " +
            "    apellidos, " +
            "    contrasena)" +
            "    VALUES" +
            "    (" +
            "    " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
            "    " + (_nombreUsuario != null ? "'" + _nombreUsuario + "'" : "null") + "," +
            "    " + (_email != null ? "'" + _email + "'" : "null") + "," +
            "    " + (_apellidos != null ? "'" + _apellidos + "'" : "null") + "," +
            "    " + (_contrasena != null ? "'" + _contrasena + "'" : "null") +
            "    )";
        
        try {
            stmt = p_conn.createStatement();

            ret = stmt.executeUpdate(str_sql, Statement.RETURN_GENERATED_KEYS);

            rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                _id = rs.getInt(1);
            } else {
                // throw an exception from here
                // throw new Exception("Error al obtener id");
            }

            rs.close();
            rs = null;
            //System.out.println("Key returned from getGeneratedKeys():" + _id.toString());

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
            "    DELETE FROM usuario_web" +
            "    WHERE" +
            "    id_usuario_web = " + Integer.toString(this._id);

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
        UsuarioWeb obj = null;
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_usuario_web = " + Integer.toString(this._id) +
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
                _nombreUsuario = obj.getNombreUsuario();
                _email = obj.getEmail();
                _apellidos = obj.getApellidos();
                _borrado = obj.getBorrado();
                _contrasena = obj.getContrasena();
                _activo = obj.getActivo();
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
            "    id_usuario_web = " + Integer.toString(this._id) +
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
        return "UsuarioWeb [" +
	           "    _nombre = " + (_nombre != null ? "'" + _nombre + "'" : "null") + "," +
	           "    _nombre_usuario = " + (_nombreUsuario != null ? "'" + _nombreUsuario + "'" : "null") + "," +
	           "    _email = " + (_email != null ? "'" + _email + "'" : "null") + "," +
	           "    _apellidos = " + (_apellidos != null ? "'" + _apellidos + "'" : "null") + "," +
	           "    _borrado = " + (_borrado != null ? "b'" + _borrado : "null") + "," +
	           "    _contrasena = " + (_contrasena != null ? "'" + _contrasena + "'" : "null") + "," +
	           "    _id = " + (_id != null ? _id : "null") + "," +
	           "    _activo = " + (_activo != null ? "b'" + _activo : "null") +
			   "]";
    }


    public String toJSON() {
        return "UsuarioWeb : {" +
	           "    \"_nombre\" : " + (_nombre != null ? "\"" + _nombre + "\"" : "null") + "," +
	           "    \"_nombre_usuario\" : " + (_nombreUsuario != null ? "\"" + _nombreUsuario + "\"" : "null") + "," +
	           "    \"_email\" : " + (_email != null ? "\"" + _email + "\"" : "null") + "," +
	           "    \"_apellidos\" : " + (_apellidos != null ? "\"" + _apellidos + "\"" : "null") + "," +
	           "    \"_borrado\" : " + (_borrado != null ? "b'" + _borrado : "null") + "," +
	           "    \"_contrasena\" : " + (_contrasena != null ? "\"" + _contrasena + "\"" : "null") + "," +
	           "    \"_id\" : " + (_id != null ? _id : "null") + "," +
	           "    \"_activo\" : " + (_activo != null ? "b'" + _activo : "null") +
			   "}";
    }


    public String toXML() {
        return "<UsuarioWeb>" +
	           "    <nombre" + (_nombre != null ? ">" + _nombre + "</nombre>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <nombreUsuario" + (_nombreUsuario != null ? ">" + _nombreUsuario + "</nombreUsuario>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <email" + (_email != null ? ">" + _email + "</email>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <apellidos" + (_apellidos != null ? ">" + _apellidos + "</apellidos>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <borrado" + (_borrado != null ? ">" + _borrado + "</borrado>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <contrasena" + (_contrasena != null ? ">" + _contrasena + "</contrasena>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <id" + (_id != null ? ">" + _id + "</id>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <activo" + (_activo != null ? ">" + _activo + "</activo>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
			   "</UsuarioWeb>";
    }


    public static UsuarioWeb fromXMLNode(Node xmlNode) {
        UsuarioWeb ret = new UsuarioWeb();

        Element element = (Element) xmlNode;

        ret.setNombre(element.getElementsByTagName("nombre").item(0).getTextContent());
        ret.setNombreUsuario(element.getElementsByTagName("nombre_usuario").item(0).getTextContent());
        ret.setEmail(element.getElementsByTagName("email").item(0).getTextContent());
        ret.setApellidos(element.getElementsByTagName("apellidos").item(0).getTextContent());
        ret.setBorrado(Boolean.valueOf(element.getElementsByTagName("borrado").item(0).getTextContent()));
        ret.setContrasena(element.getElementsByTagName("contrasena").item(0).getTextContent());
        ret.setId(Integer.decode(element.getElementsByTagName("id_usuario_web").item(0).getTextContent()));
        ret.setActivo(Boolean.valueOf(element.getElementsByTagName("activo").item(0).getTextContent()));

        return ret;
    }
}
