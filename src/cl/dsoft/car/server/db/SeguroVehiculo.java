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
public class SeguroVehiculo {
    protected Integer _idCiaSeguros;
    protected String _fechaModificacion;
    protected String _poliza;
    protected Long _idUsuario;
    protected String _fechaVencimiento;
    protected Long _idSeguroVehiculo;
    protected Long _idVehiculo;
    protected Boolean _borrado;
    protected String _observaciones;
    protected Integer _idTipoSeguro;

    private final static String _str_sql = 
        "    SELECT" +
        "    se.id_cia_seguros AS id_cia_seguros," +
        "    DATE_FORMAT(se.fecha_modificacion, '%Y-%m-%d %H:%i:%s') AS fecha_modificacion," +
        "    se.poliza AS poliza," +
        "    se.id_usuario AS id_usuario," +
        "    DATE_FORMAT(se.fecha_vencimiento, '%Y-%m-%d %H:%i:%s') AS fecha_vencimiento," +
        "    se.id_seguro_vehiculo AS id_seguro_vehiculo," +
        "    se.id_vehiculo AS id_vehiculo," +
        "    0+se.borrado AS borrado," +
        "    se.observaciones AS observaciones," +
        "    se.id_tipo_seguro AS id_tipo_seguro" +
        "    FROM seguro_vehiculo se";

    public SeguroVehiculo() {
        _idCiaSeguros = null;
        _fechaModificacion = null;
        _poliza = null;
        _idUsuario = null;
        _fechaVencimiento = null;
        _idSeguroVehiculo = null;
        _idVehiculo = null;
        _borrado = null;
        _observaciones = null;
        _idTipoSeguro = null;

    }
    /**
     * @return the _idCiaSeguros
     */
    public Integer getIdCiaSeguros() {
        return _idCiaSeguros;
    }
    /**
     * @return the _fechaModificacion
     */
    public String getFechaModificacion() {
        return _fechaModificacion;
    }
    /**
     * @return the _poliza
     */
    public String getPoliza() {
        return _poliza;
    }
    /**
     * @return the _idUsuario
     */
    public Long getIdUsuario() {
        return _idUsuario;
    }
    /**
     * @return the _fechaVencimiento
     */
    public String getFechaVencimiento() {
        return _fechaVencimiento;
    }
    /**
     * @return the _idSeguroVehiculo
     */
    public Long getIdSeguroVehiculo() {
        return _idSeguroVehiculo;
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
     * @return the _observaciones
     */
    public String getObservaciones() {
        return _observaciones;
    }
    /**
     * @return the _idTipoSeguro
     */
    public Integer getIdTipoSeguro() {
        return _idTipoSeguro;
    }
    /**
     * @param _idCiaSeguros the _idCiaSeguros to set
     */
    public void setIdCiaSeguros(Integer _idCiaSeguros) {
        this._idCiaSeguros = _idCiaSeguros;
    }
    /**
     * @param _fechaModificacion the _fechaModificacion to set
     */
    public void setFechaModificacion(String _fechaModificacion) {
        this._fechaModificacion = _fechaModificacion;
    }
    /**
     * @param _poliza the _poliza to set
     */
    public void setPoliza(String _poliza) {
        this._poliza = _poliza;
    }
    /**
     * @param _idUsuario the _idUsuario to set
     */
    public void setIdUsuario(Long _idUsuario) {
        this._idUsuario = _idUsuario;
    }
    /**
     * @param _fechaVencimiento the _fechaVencimiento to set
     */
    public void setFechaVencimiento(String _fechaVencimiento) {
        this._fechaVencimiento = _fechaVencimiento;
    }
    /**
     * @param _idSeguroVehiculo the _idSeguroVehiculo to set
     */
    public void setIdSeguroVehiculo(Long _idSeguroVehiculo) {
        this._idSeguroVehiculo = _idSeguroVehiculo;
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
     * @param _observaciones the _observaciones to set
     */
    public void setObservaciones(String _observaciones) {
        this._observaciones = _observaciones;
    }
    /**
     * @param _idTipoSeguro the _idTipoSeguro to set
     */
    public void setIdTipoSeguro(Integer _idTipoSeguro) {
        this._idTipoSeguro = _idTipoSeguro;
    }

    public static SeguroVehiculo fromRS(ResultSet p_rs) throws SQLException {
        SeguroVehiculo ret = new SeguroVehiculo();

        ret.setIdCiaSeguros(p_rs.getInt("id_cia_seguros"));
        ret.setFechaModificacion(p_rs.getString("fecha_modificacion"));
        ret.setPoliza(p_rs.getString("poliza"));
        ret.setIdUsuario(p_rs.getLong("id_usuario"));
        ret.setFechaVencimiento(p_rs.getString("fecha_vencimiento"));
        ret.setIdSeguroVehiculo(p_rs.getLong("id_seguro_vehiculo"));
        ret.setIdVehiculo(p_rs.getLong("id_vehiculo"));
        ret.setBorrado(p_rs.getBoolean("borrado"));
        ret.setObservaciones(p_rs.getString("observaciones"));
        ret.setIdTipoSeguro(p_rs.getInt("id_tipo_seguro"));

        return ret;
    }

    public static SeguroVehiculo getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        SeguroVehiculo ret = null;
        
        String str_sql = _str_sql +
            "  WHERE se." + p_key + " = " + p_value +
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

    
    public static ArrayList<SeguroVehiculo> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws UnsupportedParameterException, SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<SeguroVehiculo> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<SeguroVehiculo>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_usuario")) {
                    array_clauses.add("se.id_usuario = " + p.getValue());
                }
                else if (p.getKey().equals("id_seguro_vehiculo")) {
                    array_clauses.add("se.id_seguro_vehiculo = " + p.getValue());
                }
                else if (p.getKey().equals("id_cia_seguros")) {
                    array_clauses.add("se.id_cia_seguros = " + p.getValue());
                }
                else if (p.getKey().equals("id_usuario")) {
                    array_clauses.add("se.id_usuario = " + p.getValue());
                }
                else if (p.getKey().equals("id_vehiculo")) {
                    array_clauses.add("se.id_vehiculo = " + p.getValue());
                }
                else if (p.getKey().equals("id_tipo_seguro")) {
                    array_clauses.add("se.id_tipo_seguro = " + p.getValue());
                }
                else if (p.getKey().equals("mas reciente")) {
                    array_clauses.add("se.fecha_modificacion > STR_TO_DATE('" + p.getValue() + "', '%Y-%m-%d %H:%i:%s')");
                }
                else if (p.getKey().equals("no borrado")) {
                    array_clauses.add("se.borrado = 0");
                }
                else if (p.getKey().equals("borrado")) {
                    array_clauses.add("se.borrado = 1");
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
            "    UPDATE seguro_vehiculo" +
            "    SET" +
            "    fecha_modificacion = " + (_fechaModificacion != null ? "STR_TO_DATE('" + _fechaModificacion + "', '%Y-%m-%d %H:%i:%s')" : "null") + "," +
            "    poliza = " + (_poliza != null ? "'" + _poliza + "'" : "null") + "," +
            "    fecha_vencimiento = " + (_fechaVencimiento != null ? "STR_TO_DATE('" + _fechaVencimiento + "', '%Y-%m-%d %H:%i:%s')" : "null") + "," +
            "    borrado = " + (_borrado != null ? "b'" + (_borrado ? 1 : 0) + "'" : "null") + "," +
            "    observaciones = " + (_observaciones != null ? "'" + _observaciones + "'" : "null") +
            "    WHERE" +
            "    id_usuario = " + Long.toString(this._idUsuario) + " AND" +
            "    id_seguro_vehiculo = " + Long.toString(this._idSeguroVehiculo);

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
            "    INSERT INTO seguro_vehiculo" +
            "    (" +
            "    id_cia_seguros, " +
            "    poliza, " +
            "    id_usuario, " +
            "    fecha_vencimiento, " +
            "    id_seguro_vehiculo, " +
            "    id_vehiculo, " +
            "    observaciones, " +
            "    id_tipo_seguro)" +
            "    VALUES" +
            "    (" +
            "    " + (_idCiaSeguros != null ? "'" + _idCiaSeguros + "'" : "null") + "," +
            "    " + (_poliza != null ? "'" + _poliza + "'" : "null") + "," +
            "    " + (_idUsuario != null ? "'" + _idUsuario + "'" : "null") + "," +
            "    " + (_fechaVencimiento != null ? "STR_TO_DATE('" + _fechaVencimiento + "', '%Y-%m-%d %H:%i:%s')" : "null") + "," +
            "    " + (_idSeguroVehiculo != null ? "'" + _idSeguroVehiculo + "'" : "null") + "," +
            "    " + (_idVehiculo != null ? "'" + _idVehiculo + "'" : "null") + "," +
            "    " + (_observaciones != null ? "'" + _observaciones + "'" : "null") + "," +
            "    " + (_idTipoSeguro != null ? "'" + _idTipoSeguro + "'" : "null") +
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
            "    DELETE FROM seguro_vehiculo" +
            "    WHERE" +
            "    id_usuario = " + Long.toString(this._idUsuario) + " AND" +
            "    id_seguro_vehiculo = " + Long.toString(this._idSeguroVehiculo);

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
        SeguroVehiculo obj = null;
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_usuario = " + Long.toString(this._idUsuario) + " AND" +
            "    id_seguro_vehiculo = " + Long.toString(this._idSeguroVehiculo) +
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

                _idCiaSeguros = obj.getIdCiaSeguros();
                _fechaModificacion = obj.getFechaModificacion();
                _poliza = obj.getPoliza();
                _fechaVencimiento = obj.getFechaVencimiento();
                _idVehiculo = obj.getIdVehiculo();
                _borrado = obj.getBorrado();
                _observaciones = obj.getObservaciones();
                _idTipoSeguro = obj.getIdTipoSeguro();
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
            "    id_seguro_vehiculo = " + Long.toString(this._idSeguroVehiculo) +
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
        return "SeguroVehiculo [" +
	           "    _idCiaSeguros = " + (_idCiaSeguros != null ? _idCiaSeguros : "null") + "," +
	           "    _fecha_modificacion = " + (_fechaModificacion != null ? "STR_TO_DATE(" + _fechaModificacion + ", '%Y-%m-%d %H:%i:%s')" : "null") + "," +
	           "    _poliza = " + (_poliza != null ? "'" + _poliza + "'" : "null") + "," +
	           "    _idUsuario = " + (_idUsuario != null ? _idUsuario : "null") + "," +
	           "    _fecha_vencimiento = " + (_fechaVencimiento != null ? "STR_TO_DATE(" + _fechaVencimiento + ", '%Y-%m-%d %H:%i:%s')" : "null") + "," +
	           "    _idSeguroVehiculo = " + (_idSeguroVehiculo != null ? _idSeguroVehiculo : "null") + "," +
	           "    _idVehiculo = " + (_idVehiculo != null ? _idVehiculo : "null") + "," +
	           "    _borrado = " + (_borrado != null ? "b'" + _borrado : "null") + "," +
	           "    _observaciones = " + (_observaciones != null ? "'" + _observaciones + "'" : "null") + "," +
	           "    _idTipoSeguro = " + (_idTipoSeguro != null ? _idTipoSeguro : "null") +
			   "]";
    }


    public String toJSON() {
        return "SeguroVehiculo : {" +
	           "    \"_idCiaSeguros\" : " + (_idCiaSeguros != null ? _idCiaSeguros : "null") + "," +
	           "    \"_fecha_modificacion\" : " + (_fechaModificacion != null ? "\"" + _fechaModificacion + "\"" : "null") + "," +
	           "    \"_poliza\" : " + (_poliza != null ? "\"" + _poliza + "\"" : "null") + "," +
	           "    \"_idUsuario\" : " + (_idUsuario != null ? _idUsuario : "null") + "," +
	           "    \"_fecha_vencimiento\" : " + (_fechaVencimiento != null ? "\"" + _fechaVencimiento + "\"" : "null") + "," +
	           "    \"_idSeguroVehiculo\" : " + (_idSeguroVehiculo != null ? _idSeguroVehiculo : "null") + "," +
	           "    \"_idVehiculo\" : " + (_idVehiculo != null ? _idVehiculo : "null") + "," +
	           "    \"_borrado\" : " + (_borrado != null ? "b'" + _borrado : "null") + "," +
	           "    \"_observaciones\" : " + (_observaciones != null ? "\"" + _observaciones + "\"" : "null") + "," +
	           "    \"_idTipoSeguro\" : " + (_idTipoSeguro != null ? _idTipoSeguro : "null") +
			   "}";
    }


    public String toXML() {
        return "<SeguroVehiculo>" +
	           "    <idCiaSeguros" + (_idCiaSeguros != null ? ">" + _idCiaSeguros + "</idCiaSeguros>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <fechaModificacion" + (_fechaModificacion != null ? ">" + _fechaModificacion + "</fechaModificacion>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <poliza" + (_poliza != null ? ">" + _poliza + "</poliza>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <idUsuario" + (_idUsuario != null ? ">" + _idUsuario + "</idUsuario>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <fechaVencimiento" + (_fechaVencimiento != null ? ">" + _fechaVencimiento + "</fechaVencimiento>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <idSeguroVehiculo" + (_idSeguroVehiculo != null ? ">" + _idSeguroVehiculo + "</idSeguroVehiculo>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <idVehiculo" + (_idVehiculo != null ? ">" + _idVehiculo + "</idVehiculo>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <borrado" + (_borrado != null ? ">" + _borrado + "</borrado>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <observaciones" + (_observaciones != null ? ">" + _observaciones + "</observaciones>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <idTipoSeguro" + (_idTipoSeguro != null ? ">" + _idTipoSeguro + "</idTipoSeguro>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
			   "</SeguroVehiculo>";
    }


    public static SeguroVehiculo fromXMLNode(Node xmlNode) {
        SeguroVehiculo ret = new SeguroVehiculo();

        Element element = (Element) xmlNode;

        ret.setIdCiaSeguros(Integer.decode(element.getElementsByTagName("id_cia_seguros").item(0).getTextContent()));
        ret.setFechaModificacion(element.getElementsByTagName("fecha_modificacion").item(0).getTextContent());
        ret.setPoliza(element.getElementsByTagName("poliza").item(0).getTextContent());
        ret.setIdUsuario(Long.decode(element.getElementsByTagName("id_usuario").item(0).getTextContent()));
        ret.setFechaVencimiento(element.getElementsByTagName("fecha_vencimiento").item(0).getTextContent());
        ret.setIdSeguroVehiculo(Long.decode(element.getElementsByTagName("id_seguro_vehiculo").item(0).getTextContent()));
        ret.setIdVehiculo(Long.decode(element.getElementsByTagName("id_vehiculo").item(0).getTextContent()));
        ret.setBorrado(Boolean.valueOf(element.getElementsByTagName("borrado").item(0).getTextContent()));
        ret.setObservaciones(element.getElementsByTagName("observaciones").item(0).getTextContent());
        ret.setIdTipoSeguro(Integer.decode(element.getElementsByTagName("id_tipo_seguro").item(0).getTextContent()));

        return ret;
    }
}
