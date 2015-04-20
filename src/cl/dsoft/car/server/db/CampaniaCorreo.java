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
public class CampaniaCorreo {
    protected String _textoCorreo;
    protected String _fechaModificacion;
    protected String _inicio;
    protected String _condicionSql;
    protected Integer _id;
    protected Boolean _borrado;
    protected String _descripcion;
    protected Boolean _activa;
    protected Boolean _porSql;
    protected Short _periodicidadDias;

    private final static String _str_sql = 
        "    SELECT" +
        "    ca.texto_correo AS texto_correo," +
        "    DATE_FORMAT(ca.fecha_modificacion, '%Y-%m-%d %H:%i:%s') AS fecha_modificacion," +
        "    DATE_FORMAT(ca.inicio, '%Y-%m-%d %H:%i:%s') AS inicio," +
        "    ca.condicion_sql AS condicion_sql," +
        "    ca.id_campania AS id," +
        "    0+ca.borrado AS borrado," +
        "    ca.descripcion AS descripcion," +
        "    0+ca.activa AS activa," +
        "    0+ca.por_sql AS por_sql," +
        "    ca.periodicidad_dias AS periodicidad_dias" +
        "    FROM campania ca";

    public CampaniaCorreo() {
        _textoCorreo = null;
        _fechaModificacion = null;
        _inicio = null;
        _condicionSql = null;
        _id = null;
        _borrado = null;
        _descripcion = null;
        _activa = null;
        _porSql = null;
        _periodicidadDias = null;

    }
    /**
     * @return the _textoCorreo
     */
    public String getTextoCorreo() {
        return _textoCorreo;
    }
    /**
     * @return the _fechaModificacion
     */
    public String getFechaModificacion() {
        return _fechaModificacion;
    }
    /**
     * @return the _inicio
     */
    public String getInicio() {
        return _inicio;
    }
    /**
     * @return the _condicionSql
     */
    public String getCondicionSql() {
        return _condicionSql;
    }
    /**
     * @return the _id
     */
    public Integer getId() {
        return _id;
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
     * @return the _activa
     */
    public Boolean getActiva() {
        return _activa;
    }
    /**
     * @return the _porSql
     */
    public Boolean getPorSql() {
        return _porSql;
    }
    /**
     * @return the _periodicidadDias
     */
    public Short getPeriodicidadDias() {
        return _periodicidadDias;
    }
    /**
     * @param _textoCorreo the _textoCorreo to set
     */
    public void setTextoCorreo(String _textoCorreo) {
        this._textoCorreo = _textoCorreo;
    }
    /**
     * @param _fechaModificacion the _fechaModificacion to set
     */
    public void setFechaModificacion(String _fechaModificacion) {
        this._fechaModificacion = _fechaModificacion;
    }
    /**
     * @param _inicio the _inicio to set
     */
    public void setInicio(String _inicio) {
        this._inicio = _inicio;
    }
    /**
     * @param _condicionSql the _condicionSql to set
     */
    public void setCondicionSql(String _condicionSql) {
        this._condicionSql = _condicionSql;
    }
    /**
     * @param _id the _id to set
     */
    public void setId(Integer _id) {
        this._id = _id;
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
     * @param _activa the _activa to set
     */
    public void setActiva(Boolean _activa) {
        this._activa = _activa;
    }
    /**
     * @param _porSql the _porSql to set
     */
    public void setPorSql(Boolean _porSql) {
        this._porSql = _porSql;
    }
    /**
     * @param _periodicidadDias the _periodicidadDias to set
     */
    public void setPeriodicidadDias(Short _periodicidadDias) {
        this._periodicidadDias = _periodicidadDias;
    }

    public static CampaniaCorreo fromRS(ResultSet p_rs) throws SQLException {
        CampaniaCorreo ret = new CampaniaCorreo();

        ret.setTextoCorreo(p_rs.getString("texto_correo"));
        ret.setFechaModificacion(p_rs.getString("fecha_modificacion"));
        ret.setInicio(p_rs.getString("inicio"));
        ret.setCondicionSql(p_rs.getString("condicion_sql"));
        ret.setId(p_rs.getInt("id"));
        ret.setBorrado(p_rs.getBoolean("borrado"));
        ret.setDescripcion(p_rs.getString("descripcion"));
        ret.setActiva(p_rs.getBoolean("activa"));
        ret.setPorSql(p_rs.getBoolean("por_sql"));
        ret.setPeriodicidadDias(p_rs.getShort("periodicidad_dias"));

        return ret;
    }

    public static CampaniaCorreo getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        CampaniaCorreo ret = null;
        
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

    public static CampaniaCorreo getById(Connection p_conn, String p_id) throws SQLException {
        return getByParameter(p_conn, "id_campania", p_id);
    }
    
    public static ArrayList<CampaniaCorreo> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws UnsupportedParameterException, SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<CampaniaCorreo> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<CampaniaCorreo>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_campania")) {
                    array_clauses.add("ca.id_campania = " + p.getValue());
                }
                else if (p.getKey().equals("mas reciente")) {
                    array_clauses.add("ca.fecha_modificacion > STR_TO_DATE('" + p.getValue() + "', '%Y-%m-%d %H:%i:%s')");
                }
                else if (p.getKey().equals("no borrado")) {
                    array_clauses.add("ca.borrado = 0");
                }
                else if (p.getKey().equals("borrado")) {
                    array_clauses.add("ca.borrado = 1");
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
            "    UPDATE campania" +
            "    SET" +
            "    texto_correo = " + (_textoCorreo != null ? "'" + _textoCorreo + "'" : "null") + "," +
            "    fecha_modificacion = " + (_fechaModificacion != null ? "STR_TO_DATE('" + _fechaModificacion + "', '%Y-%m-%d %H:%i:%s')" : "null") + "," +
            "    inicio = " + (_inicio != null ? "STR_TO_DATE('" + _inicio + "', '%Y-%m-%d %H:%i:%s')" : "null") + "," +
            "    condicion_sql = " + (_condicionSql != null ? "'" + _condicionSql + "'" : "null") + "," +
            "    borrado = " + (_borrado != null ? "b'" + (_borrado ? 1 : 0) + "'" : "null") + "," +
            "    descripcion = " + (_descripcion != null ? "'" + _descripcion + "'" : "null") + "," +
            "    activa = " + (_activa != null ? "b'" + (_activa ? 1 : 0) + "'" : "null") + "," +
            "    por_sql = " + (_porSql != null ? "b'" + (_porSql ? 1 : 0) + "'" : "null") + "," +
            "    periodicidad_dias = " + (_periodicidadDias != null ? _periodicidadDias : "null") +
            "    WHERE" +
            "    id_campania = " + Integer.toString(this._id);

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
            "    INSERT INTO campania" +
            "    (" +
            "    texto_correo, " +
            "    inicio, " +
            "    condicion_sql, " +
            "    descripcion, " +
            "    periodicidad_dias)" +
            "    VALUES" +
            "    (" +
            "    " + (_textoCorreo != null ? "'" + _textoCorreo + "'" : "null") + "," +
            "    " + (_inicio != null ? "STR_TO_DATE('" + _inicio + "', '%Y-%m-%d %H:%i:%s')" : "null") + "," +
            "    " + (_condicionSql != null ? "'" + _condicionSql + "'" : "null") + "," +
            "    " + (_descripcion != null ? "'" + _descripcion + "'" : "null") + "," +
            "    " + (_periodicidadDias != null ? "'" + _periodicidadDias + "'" : "null") +
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
            "    DELETE FROM campania" +
            "    WHERE" +
            "    id_campania = " + Integer.toString(this._id);

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
        CampaniaCorreo obj = null;
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_campania = " + Integer.toString(this._id) +
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

                _textoCorreo = obj.getTextoCorreo();
                _fechaModificacion = obj.getFechaModificacion();
                _inicio = obj.getInicio();
                _condicionSql = obj.getCondicionSql();
                _borrado = obj.getBorrado();
                _descripcion = obj.getDescripcion();
                _activa = obj.getActiva();
                _porSql = obj.getPorSql();
                _periodicidadDias = obj.getPeriodicidadDias();
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
            "    id_campania = " + Integer.toString(this._id) +
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
        return "CampaniaCorreo [" +
	           "    _texto_correo = " + (_textoCorreo != null ? "'" + _textoCorreo + "'" : "null") + "," +
	           "    _fecha_modificacion = " + (_fechaModificacion != null ? "STR_TO_DATE(" + _fechaModificacion + ", '%Y-%m-%d %H:%i:%s')" : "null") + "," +
	           "    _inicio = " + (_inicio != null ? "STR_TO_DATE(" + _inicio + ", '%Y-%m-%d %H:%i:%s')" : "null") + "," +
	           "    _condicion_sql = " + (_condicionSql != null ? "'" + _condicionSql + "'" : "null") + "," +
	           "    _id = " + (_id != null ? _id : "null") + "," +
	           "    _borrado = " + (_borrado != null ? "b'" + _borrado : "null") + "," +
	           "    _descripcion = " + (_descripcion != null ? "'" + _descripcion + "'" : "null") + "," +
	           "    _activa = " + (_activa != null ? "b'" + _activa : "null") + "," +
	           "    _por_sql = " + (_porSql != null ? "b'" + _porSql : "null") + "," +
	           "    _periodicidadDias = " + (_periodicidadDias != null ? _periodicidadDias : "null") +
			   "]";
    }


    public String toJSON() {
        return "CampaniaCorreo : {" +
	           "    \"_texto_correo\" : " + (_textoCorreo != null ? "\"" + _textoCorreo + "\"" : "null") + "," +
	           "    \"_fecha_modificacion\" : " + (_fechaModificacion != null ? "\"" + _fechaModificacion + "\"" : "null") + "," +
	           "    \"_inicio\" : " + (_inicio != null ? "\"" + _inicio + "\"" : "null") + "," +
	           "    \"_condicion_sql\" : " + (_condicionSql != null ? "\"" + _condicionSql + "\"" : "null") + "," +
	           "    \"_id\" : " + (_id != null ? _id : "null") + "," +
	           "    \"_borrado\" : " + (_borrado != null ? "b'" + _borrado : "null") + "," +
	           "    \"_descripcion\" : " + (_descripcion != null ? "\"" + _descripcion + "\"" : "null") + "," +
	           "    \"_activa\" : " + (_activa != null ? "b'" + _activa : "null") + "," +
	           "    \"_por_sql\" : " + (_porSql != null ? "b'" + _porSql : "null") + "," +
	           "    \"_periodicidadDias\" : " + (_periodicidadDias != null ? _periodicidadDias : "null") +
			   "}";
    }


    public String toXML() {
        return "<CampaniaCorreo>" +
	           "    <textoCorreo" + (_textoCorreo != null ? ">" + _textoCorreo + "</textoCorreo>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <fechaModificacion" + (_fechaModificacion != null ? ">" + _fechaModificacion + "</fechaModificacion>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <inicio" + (_inicio != null ? ">" + _inicio + "</inicio>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <condicionSql" + (_condicionSql != null ? ">" + _condicionSql + "</condicionSql>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <id" + (_id != null ? ">" + _id + "</id>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <borrado" + (_borrado != null ? ">" + _borrado + "</borrado>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <descripcion" + (_descripcion != null ? ">" + _descripcion + "</descripcion>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <activa" + (_activa != null ? ">" + _activa + "</activa>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <porSql" + (_porSql != null ? ">" + _porSql + "</porSql>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <periodicidadDias" + (_periodicidadDias != null ? ">" + _periodicidadDias + "</periodicidadDias>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
			   "</CampaniaCorreo>";
    }


    public static CampaniaCorreo fromXMLNode(Node xmlNode) {
        CampaniaCorreo ret = new CampaniaCorreo();

        Element element = (Element) xmlNode;

        ret.setTextoCorreo(element.getElementsByTagName("texto_correo").item(0).getTextContent());
        ret.setFechaModificacion(element.getElementsByTagName("fecha_modificacion").item(0).getTextContent());
        ret.setInicio(element.getElementsByTagName("inicio").item(0).getTextContent());
        ret.setCondicionSql(element.getElementsByTagName("condicion_sql").item(0).getTextContent());
        ret.setId(Integer.decode(element.getElementsByTagName("id_campania").item(0).getTextContent()));
        ret.setBorrado(Boolean.valueOf(element.getElementsByTagName("borrado").item(0).getTextContent()));
        ret.setDescripcion(element.getElementsByTagName("descripcion").item(0).getTextContent());
        ret.setActiva(Boolean.valueOf(element.getElementsByTagName("activa").item(0).getTextContent()));
        ret.setPorSql(Boolean.valueOf(element.getElementsByTagName("por_sql").item(0).getTextContent()));
        ret.setPeriodicidadDias(Short.decode(element.getElementsByTagName("periodicidad_dias").item(0).getTextContent()));

        return ret;
    }
}
