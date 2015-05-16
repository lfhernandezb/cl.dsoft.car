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
public class VwCampaniaUsuario {
    protected String _detalle;
    protected Short _numeroImpresiones;
    protected Long _id;
    protected String _fechaModificacion;
    protected String _fechaFin;
    protected Long _idUsuario;
    protected Short _periodicidad;
    protected String _fechaInicio;

    private final static String _str_sql = 
        "    SELECT" +
        "    vw.detalle AS detalle," +
        "    vw.numero_impresiones AS numero_impresiones," +
        "    vw.id AS id," +
        "    DATE_FORMAT(vw.fecha_modificacion, '%Y-%m-%d %H:%i:%s') AS fecha_modificacion," +
        "    DATE_FORMAT(vw.fecha_fin, '%Y-%m-%d %H:%i:%s') AS fecha_fin," +
        "    vw.id_usuario AS id_usuario," +
        "    vw.periodicidad AS periodicidad," +
        "    DATE_FORMAT(vw.fecha_inicio, '%Y-%m-%d %H:%i:%s') AS fecha_inicio" +
        "    FROM vw_campania_usuario vw";

    public VwCampaniaUsuario() {
        _detalle = null;
        _numeroImpresiones = null;
        _id = null;
        _fechaModificacion = null;
        _fechaFin = null;
        _idUsuario = null;
        _periodicidad = null;
        _fechaInicio = null;

    }
    /**
     * @return the _detalle
     */
    public String getDetalle() {
        return _detalle;
    }
    /**
     * @return the _numeroImpresiones
     */
    public Short getNumeroImpresiones() {
        return _numeroImpresiones;
    }
    /**
     * @return the _id
     */
    public Long getId() {
        return _id;
    }
    /**
     * @return the _fechaModificacion
     */
    public String getFechaModificacion() {
        return _fechaModificacion;
    }
    /**
     * @return the _fechaFin
     */
    public String getFechaFin() {
        return _fechaFin;
    }
    /**
     * @return the _idUsuario
     */
    public Long getIdUsuario() {
        return _idUsuario;
    }
    /**
     * @return the _periodicidad
     */
    public Short getPeriodicidad() {
        return _periodicidad;
    }
    /**
     * @return the _fechaInicio
     */
    public String getFechaInicio() {
        return _fechaInicio;
    }
    /**
     * @param _detalle the _detalle to set
     */
    public void setDetalle(String _detalle) {
        this._detalle = _detalle;
    }
    /**
     * @param _numeroImpresiones the _numeroImpresiones to set
     */
    public void setNumeroImpresiones(Short _numeroImpresiones) {
        this._numeroImpresiones = _numeroImpresiones;
    }
    /**
     * @param _id the _id to set
     */
    public void setId(Long _id) {
        this._id = _id;
    }
    /**
     * @param _fechaModificacion the _fechaModificacion to set
     */
    public void setFechaModificacion(String _fechaModificacion) {
        this._fechaModificacion = _fechaModificacion;
    }
    /**
     * @param _fechaFin the _fechaFin to set
     */
    public void setFechaFin(String _fechaFin) {
        this._fechaFin = _fechaFin;
    }
    /**
     * @param _idUsuario the _idUsuario to set
     */
    public void setIdUsuario(Long _idUsuario) {
        this._idUsuario = _idUsuario;
    }
    /**
     * @param _periodicidad the _periodicidad to set
     */
    public void setPeriodicidad(Short _periodicidad) {
        this._periodicidad = _periodicidad;
    }
    /**
     * @param _fechaInicio the _fechaInicio to set
     */
    public void setFechaInicio(String _fechaInicio) {
        this._fechaInicio = _fechaInicio;
    }

    public static VwCampaniaUsuario fromRS(ResultSet p_rs) throws SQLException {
        VwCampaniaUsuario ret = new VwCampaniaUsuario();

        ret.setDetalle(p_rs.getString("detalle"));
        ret.setNumeroImpresiones(p_rs.getShort("numero_impresiones"));
        ret.setId(p_rs.getLong("id"));
        ret.setFechaModificacion(p_rs.getString("fecha_modificacion"));
        ret.setFechaFin(p_rs.getString("fecha_fin"));
        ret.setIdUsuario(p_rs.getLong("id_usuario"));
        ret.setPeriodicidad(p_rs.getShort("periodicidad"));
        ret.setFechaInicio(p_rs.getString("fecha_inicio"));

        return ret;
    }

    public static VwCampaniaUsuario getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        VwCampaniaUsuario ret = null;
        
        String str_sql = _str_sql +
            "  WHERE vw." + p_key + " = " + p_value +
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

    
    public static ArrayList<VwCampaniaUsuario> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws UnsupportedParameterException, SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<VwCampaniaUsuario> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<VwCampaniaUsuario>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("mas reciente")) {
                    array_clauses.add("vw.fecha_modificacion > STR_TO_DATE('" + p.getValue() + "', '%Y-%m-%d %H:%i:%s')");
                }
                else if (p.getKey().equals("id_usuario")) {
                    array_clauses.add("vw.id_usuario = " + p.getValue());
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
    // es una vista... no hay UPDATE, INSERT, DELETE, load
    /*
    public int update(Connection p_conn) throws SQLException {

        int ret = -1;
        Statement stmt = null;

        String str_sql =
            "    UPDATE vw_campania_usuario" +
            "    SET" +
            "    detalle = " + (_detalle != null ? "'" + _detalle + "'" : "null") + "," +
            "    numero_impresiones = " + (_numeroImpresiones != null ? _numeroImpresiones : "null") + "," +
            "    id = " + (_id != null ? _id : "null") + "," +
            "    fecha_modificacion = " + (_fechaModificacion != null ? "STR_TO_DATE('" + _fechaModificacion + "', '%Y-%m-%d %H:%i:%s')" : "null") + "," +
            "    fecha_fin = " + (_fechaFin != null ? "STR_TO_DATE('" + _fechaFin + "', '%Y-%m-%d %H:%i:%s')" : "null") + "," +
            "    id_usuario = " + (_idUsuario != null ? _idUsuario : "null") + "," +
            "    periodicidad = " + (_periodicidad != null ? _periodicidad : "null") + "," +
            "    fecha_inicio = " + (_fechaInicio != null ? "STR_TO_DATE('" + _fechaInicio + "', '%Y-%m-%d %H:%i:%s')" : "null") +
            "    WHERE" +
;

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
    
    public int insert(Connection p_conn) throws SQLException {
        
        int ret = -1;
        Statement stmt = null;
        ResultSet rs = null;

        String str_sql =
            "    INSERT INTO vw_campania_usuario" +
            "    (" +
            "    detalle, " +
            "    numero_impresiones, " +
            "    fecha_fin, " +
            "    id_usuario, " +
            "    periodicidad, " +
            "    fecha_inicio)" +
            "    VALUES" +
            "    (" +
            "    " + (_detalle != null ? "'" + _detalle + "'" : "null") + "," +
            "    " + (_numeroImpresiones != null ? "'" + _numeroImpresiones + "'" : "null") + "," +
            "    " + (_fechaFin != null ? "STR_TO_DATE('" + _fechaFin + "', '%Y-%m-%d %H:%i:%s')" : "null") + "," +
            "    " + (_idUsuario != null ? "'" + _idUsuario + "'" : "null") + "," +
            "    " + (_periodicidad != null ? "'" + _periodicidad + "'" : "null") + "," +
            "    " + (_fechaInicio != null ? "STR_TO_DATE('" + _fechaInicio + "', '%Y-%m-%d %H:%i:%s')" : "null") +
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
            "    DELETE FROM vw_campania_usuario" +
            "    WHERE" +
;

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
        VCampaniaUsuario obj = null;
        
        String str_sql = _str_sql +
            "    WHERE" +
 +
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

                _detalle = obj.getDetalle();
                _numeroImpresiones = obj.getNumeroImpresiones();
                _id = obj.getId();
                _fechaModificacion = obj.getFechaModificacion();
                _fechaFin = obj.getFechaFin();
                _idUsuario = obj.getIdUsuario();
                _periodicidad = obj.getPeriodicidad();
                _fechaInicio = obj.getFechaInicio();
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
 +
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
    */
    @Override
    public String toString() {
        return "VCampaniaUsuario [" +
	           "    _detalle = " + (_detalle != null ? "'" + _detalle + "'" : "null") + "," +
	           "    _numeroImpresiones = " + (_numeroImpresiones != null ? _numeroImpresiones : "null") + "," +
	           "    _id = " + (_id != null ? _id : "null") + "," +
	           "    _fecha_modificacion = " + (_fechaModificacion != null ? "STR_TO_DATE(" + _fechaModificacion + ", '%Y-%m-%d %H:%i:%s')" : "null") + "," +
	           "    _fecha_fin = " + (_fechaFin != null ? "STR_TO_DATE(" + _fechaFin + ", '%Y-%m-%d %H:%i:%s')" : "null") + "," +
	           "    _idUsuario = " + (_idUsuario != null ? _idUsuario : "null") + "," +
	           "    _periodicidad = " + (_periodicidad != null ? _periodicidad : "null") + "," +
	           "    _fecha_inicio = " + (_fechaInicio != null ? "STR_TO_DATE(" + _fechaInicio + ", '%Y-%m-%d %H:%i:%s')" : "null") +
			   "]";
    }


    public String toJSON() {
        return "VCampaniaUsuario : {" +
	           "    \"_detalle\" : " + (_detalle != null ? "\"" + _detalle + "\"" : "null") + "," +
	           "    \"_numeroImpresiones\" : " + (_numeroImpresiones != null ? _numeroImpresiones : "null") + "," +
	           "    \"_id\" : " + (_id != null ? _id : "null") + "," +
	           "    \"_fecha_modificacion\" : " + (_fechaModificacion != null ? "\"" + _fechaModificacion + "\"" : "null") + "," +
	           "    \"_fecha_fin\" : " + (_fechaFin != null ? "\"" + _fechaFin + "\"" : "null") + "," +
	           "    \"_idUsuario\" : " + (_idUsuario != null ? _idUsuario : "null") + "," +
	           "    \"_periodicidad\" : " + (_periodicidad != null ? _periodicidad : "null") + "," +
	           "    \"_fecha_inicio\" : " + (_fechaInicio != null ? "\"" + _fechaInicio + "\"" : "null") +
			   "}";
    }


    public String toXML() {
        return "<VCampaniaUsuario>" +
	           "    <detalle" + (_detalle != null ? ">" + _detalle + "</detalle>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <numeroImpresiones" + (_numeroImpresiones != null ? ">" + _numeroImpresiones + "</numeroImpresiones>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <id" + (_id != null ? ">" + _id + "</id>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <fechaModificacion" + (_fechaModificacion != null ? ">" + _fechaModificacion + "</fechaModificacion>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <fechaFin" + (_fechaFin != null ? ">" + _fechaFin + "</fechaFin>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <idUsuario" + (_idUsuario != null ? ">" + _idUsuario + "</idUsuario>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <periodicidad" + (_periodicidad != null ? ">" + _periodicidad + "</periodicidad>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <fechaInicio" + (_fechaInicio != null ? ">" + _fechaInicio + "</fechaInicio>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
			   "</VCampaniaUsuario>";
    }


    public static VwCampaniaUsuario fromXMLNode(Node xmlNode) {
        VwCampaniaUsuario ret = new VwCampaniaUsuario();

        Element element = (Element) xmlNode;

        ret.setDetalle(element.getElementsByTagName("detalle").item(0).getTextContent());
        ret.setNumeroImpresiones(Short.decode(element.getElementsByTagName("numero_impresiones").item(0).getTextContent()));
        ret.setId(Long.decode(element.getElementsByTagName("id").item(0).getTextContent()));
        ret.setFechaModificacion(element.getElementsByTagName("fecha_modificacion").item(0).getTextContent());
        ret.setFechaFin(element.getElementsByTagName("fecha_fin").item(0).getTextContent());
        ret.setIdUsuario(Long.decode(element.getElementsByTagName("id_usuario").item(0).getTextContent()));
        ret.setPeriodicidad(Short.decode(element.getElementsByTagName("periodicidad").item(0).getTextContent()));
        ret.setFechaInicio(element.getElementsByTagName("fecha_inicio").item(0).getTextContent());

        return ret;
    }
}
