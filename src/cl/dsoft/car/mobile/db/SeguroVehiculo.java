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
public class SeguroVehiculo {
    @Element(name = "idSeguroVehiculo")
    private Long _idSeguroVehiculo;
    @Element(name = "idUsuario")
    private Long _idUsuario;
    @Element(name = "idCiaSeguros")
    private Integer _idCiaSeguros;
    @Element(name = "idVehiculo")
    private Long _idVehiculo;
    @Element(name = "idTipoSeguro")
    private Integer _idTipoSeguro;
    @Element(name = "poliza", required = false)
    private String _poliza;
    @Element(name = "observaciones", required = false)
    private String _observaciones;
    @Element(name = "fechaVencimiento", required = false)
    private String _fechaVencimiento;
    @Element(name = "fechaModificacion")
    private String _fechaModificacion;
    @Element(name = "borrado")
    private Boolean _borrado;

    private final static String _str_sql = 
        "    SELECT" +
        "    se.id_seguro_vehiculo AS id_seguro_vehiculo," +
        "    se.id_usuario AS id_usuario," +
        "    se.id_cia_seguros AS id_cia_seguros," +
        "    se.id_vehiculo AS id_vehiculo," +
        "    se.id_tipo_seguro AS id_tipo_seguro," +
        "    se.poliza AS poliza," +
        "    se.observaciones AS observaciones," +
        "    strftime('%Y-%m-%d', se.fecha_vencimiento) AS fecha_vencimiento," +
        "    strftime('%Y-%m-%d %H:%M:%S', se.fecha_modificacion) AS fecha_modificacion," +
        "    se.borrado AS borrado" +
        "    FROM seguro_vehiculo se";

    public SeguroVehiculo() {
        _idSeguroVehiculo = null;
        _idUsuario = null;
        _idCiaSeguros = null;
        _idVehiculo = null;
        _idTipoSeguro = null;
        _poliza = null;
        _observaciones = null;
        _fechaVencimiento = null;
        _fechaModificacion = null;
        _borrado = null;

    }
    /**
     * @return the _idSeguroVehiculo
     */
    public Long getIdSeguroVehiculo() {
        return _idSeguroVehiculo;
    }
    /**
     * @return the _idUsuario
     */
    public Long getIdUsuario() {
        return _idUsuario;
    }
    /**
     * @return the _idCiaSeguros
     */
    public Integer getIdCiaSeguros() {
        return _idCiaSeguros;
    }
    /**
     * @return the _idVehiculo
     */
    public Long getIdVehiculo() {
        return _idVehiculo;
    }
    /**
     * @return the _idTipoSeguro
     */
    public Integer getIdTipoSeguro() {
        return _idTipoSeguro;
    }
    /**
     * @return the _poliza
     */
    public String getPoliza() {
        return _poliza;
    }
    /**
     * @return the _observaciones
     */
    public String getObservaciones() {
        return _observaciones;
    }
    /**
     * @return the _fechaVencimiento
     */
    public String getFechaVencimiento() {
        return _fechaVencimiento;
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
     * @return the _fechaVencimiento as seconds from January 1, 1970, 00:00:00 GMT
     */
    public long getFechaVencimientoAsLong() throws ParseException {
        Date d;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        d = formatter.parse(_fechaVencimiento);

        return (long)d.getTime() / 1000L;
    }
    /**
     * @return the _fechaVencimiento as Date
     */
    public Date getFechaVencimientoAsDate() throws ParseException {
        Date d;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        d = formatter.parse(_fechaVencimiento);

        return d;
    }
    /**
     * @param _idSeguroVehiculo the _idSeguroVehiculo to set
     */
    public void setIdSeguroVehiculo(Long _idSeguroVehiculo) {
        this._idSeguroVehiculo = _idSeguroVehiculo;
    }
    /**
     * @param _idUsuario the _idUsuario to set
     */
    public void setIdUsuario(Long _idUsuario) {
        this._idUsuario = _idUsuario;
    }
    /**
     * @param _idCiaSeguros the _idCiaSeguros to set
     */
    public void setIdCiaSeguros(Integer _idCiaSeguros) {
        this._idCiaSeguros = _idCiaSeguros;
    }
    /**
     * @param _idVehiculo the _idVehiculo to set
     */
    public void setIdVehiculo(Long _idVehiculo) {
        this._idVehiculo = _idVehiculo;
    }
    /**
     * @param _idTipoSeguro the _idTipoSeguro to set
     */
    public void setIdTipoSeguro(Integer _idTipoSeguro) {
        this._idTipoSeguro = _idTipoSeguro;
    }
    /**
     * @param _poliza the _poliza to set
     */
    public void setPoliza(String _poliza) {
        this._poliza = _poliza;
    }
    /**
     * @param _observaciones the _observaciones to set
     */
    public void setObservaciones(String _observaciones) {
        this._observaciones = _observaciones;
    }
    /**
     * @param _fechaVencimiento the _fechaVencimiento to set
     */
    public void setFechaVencimiento(String _fechaVencimiento) {
        this._fechaVencimiento = _fechaVencimiento;
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
     * @param _fechaVencimiento the _fechaVencimiento to set as seconds from January 1, 1970, 00:00:00 GMT
     */
    public void setFechaVencimiento(long _timestamp) {
        Date d;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        d = new Date((long)_timestamp*1000);

        this._fechaVencimiento = formatter.format(d);
;
    }
    /**
     * @param _fechaVencimiento the _fechaVencimiento to set as java.util.Date
     */
    public void setFechaVencimiento(Date _fecha) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        this._fechaVencimiento = formatter.format(_fecha);
;
    }

    public static SeguroVehiculo fromRS(ResultSet p_rs) throws SQLException {
        SeguroVehiculo ret = new SeguroVehiculo();

        ret.setIdSeguroVehiculo(p_rs.getLong("id_seguro_vehiculo"));
        ret.setIdUsuario(p_rs.getLong("id_usuario"));
        ret.setIdCiaSeguros(p_rs.getInt("id_cia_seguros"));
        ret.setIdVehiculo(p_rs.getLong("id_vehiculo"));
        ret.setIdTipoSeguro(p_rs.getInt("id_tipo_seguro"));
        ret.setPoliza(p_rs.getString("poliza"));
        ret.setObservaciones(p_rs.getString("observaciones"));
        ret.setFechaVencimiento(p_rs.getString("fecha_vencimiento"));
        ret.setFechaModificacion(p_rs.getString("fecha_modificacion"));
        ret.setBorrado(p_rs.getString("borrado") != null ? p_rs.getString("borrado").equals("true") : null);

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
                if (p.getKey().equals("id_seguro_vehiculo")) {
                    array_clauses.add("se.id_seguro_vehiculo = " + p.getValue());
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
                else if (p.getKey().equals("id_cia_seguros")) {
                    array_clauses.add("se.id_cia_seguros = " + p.getValue());
                }
                else if (p.getKey().equals("mas reciente")) {
                    array_clauses.add("se.fecha_modificacion > datetime('" + p.getValue() + "')");
                }
                else if (p.getKey().equals("no borrado")) {
                    array_clauses.add("se.borrado = 'false'");
                }
                else if (p.getKey().equals("borrado")) {
                    array_clauses.add("se.borrado = 'true'");
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
            "  SELECT COALESCE(MAX(id_seguro_vehiculo), 0) + 1 AS next_id FROM seguro_vehiculo";
        
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
            "    UPDATE seguro_vehiculo" +
            "    SET" +
            "    poliza = " + (_poliza != null ? "'" + _poliza + "'" : "null") + "," +
            "    observaciones = " + (_observaciones != null ? "'" + _observaciones + "'" : "null") + "," +
            "    fecha_vencimiento = " + (_fechaVencimiento != null ? "date('" + _fechaVencimiento + "')" : "null") + "," +
            "    fecha_modificacion = " + (_fechaModificacion != null ? "datetime('" + _fechaModificacion + "')" : "datetime('now', 'localtime')") + "," +
            "    borrado = " + (_borrado != null ? "'" + _borrado + "'" : "'false'") +
            "    WHERE" +
            "    id_seguro_vehiculo = " + Long.toString(this._idSeguroVehiculo) + " AND" +
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

        if (_idSeguroVehiculo == null) {
            _idSeguroVehiculo = getNextId(p_conn);
        }

        String str_sql =
            "    INSERT INTO seguro_vehiculo" +
            "    (" +
            "    id_seguro_vehiculo, " +
            "    id_usuario, " +
            "    id_cia_seguros, " +
            "    id_vehiculo, " +
            "    id_tipo_seguro, " +
            "    poliza, " +
            "    observaciones, " +
            "    fecha_vencimiento, " +
            "    fecha_modificacion, " +
            "    borrado)" +
            "    VALUES" +
            "    (" +
            "    " + (_idSeguroVehiculo != null ? "'" + _idSeguroVehiculo + "'" : "null") + "," +
            "    " + (_idUsuario != null ? "'" + _idUsuario + "'" : "null") + "," +
            "    " + (_idCiaSeguros != null ? "'" + _idCiaSeguros + "'" : "null") + "," +
            "    " + (_idVehiculo != null ? "'" + _idVehiculo + "'" : "null") + "," +
            "    " + (_idTipoSeguro != null ? "'" + _idTipoSeguro + "'" : "null") + "," +
            "    " + (_poliza != null ? "'" + _poliza + "'" : "null") + "," +
            "    " + (_observaciones != null ? "'" + _observaciones + "'" : "null") + "," +
            "    " + (_fechaVencimiento != null ? "date('" + _fechaVencimiento + "')" : "null") + "," +
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
            "    DELETE FROM seguro_vehiculo" +
            "    WHERE" +
            "    id_seguro_vehiculo = " + Long.toString(this._idSeguroVehiculo) + " AND" +
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
        SeguroVehiculo obj = null;
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_seguro_vehiculo = " + Long.toString(this._idSeguroVehiculo) + " AND" +
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

                _idCiaSeguros = obj.getIdCiaSeguros();
                _idVehiculo = obj.getIdVehiculo();
                _idTipoSeguro = obj.getIdTipoSeguro();
                _poliza = obj.getPoliza();
                _observaciones = obj.getObservaciones();
                _fechaVencimiento = obj.getFechaVencimiento();
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
            "    id_seguro_vehiculo = " + Long.toString(this._idSeguroVehiculo) + " AND" +
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
        return "SeguroVehiculo [" +
	           "    _idSeguroVehiculo = " + (_idSeguroVehiculo != null ? _idSeguroVehiculo : "null") + "," +
	           "    _idUsuario = " + (_idUsuario != null ? _idUsuario : "null") + "," +
	           "    _idCiaSeguros = " + (_idCiaSeguros != null ? _idCiaSeguros : "null") + "," +
	           "    _idVehiculo = " + (_idVehiculo != null ? _idVehiculo : "null") + "," +
	           "    _idTipoSeguro = " + (_idTipoSeguro != null ? _idTipoSeguro : "null") + "," +
	           "    _poliza = " + (_poliza != null ? "'" + _poliza + "'" : "null") + "," +
	           "    _observaciones = " + (_observaciones != null ? "'" + _observaciones + "'" : "null") + "," +
	           "    _fechaVencimiento = " + (_fechaVencimiento != null ? "'" + _fechaVencimiento + "'" : "null") + "," +
	           "    _fechaModificacion = " + (_fechaModificacion != null ? "'" + _fechaModificacion + "'" : "null") + "," +
	           "    _borrado = " + (_borrado != null ? _borrado : "null") +
			   "]";
    }


/*
    public static SeguroVehiculo fromXMLNode(Node xmlNode) {
        SeguroVehiculo ret = new SeguroVehiculo();

        Element element = (Element) xmlNode;

        ret.setIdSeguroVehiculo(Long.decode(element.getElementsByTagName("id_seguro_vehiculo").item(0).getTextContent()));
        ret.setIdUsuario(Long.decode(element.getElementsByTagName("id_usuario").item(0).getTextContent()));
        ret.setIdCiaSeguros(Integer.decode(element.getElementsByTagName("id_cia_seguros").item(0).getTextContent()));
        ret.setIdVehiculo(Long.decode(element.getElementsByTagName("id_vehiculo").item(0).getTextContent()));
        ret.setIdTipoSeguro(Integer.decode(element.getElementsByTagName("id_tipo_seguro").item(0).getTextContent()));
        ret.setPoliza(element.getElementsByTagName("poliza").item(0).getTextContent());
        ret.setObservaciones(element.getElementsByTagName("observaciones").item(0).getTextContent());
        ret.setFechaVencimiento(element.getElementsByTagName("fecha_vencimiento").item(0).getTextContent());
        ret.setFechaModificacion(element.getElementsByTagName("fecha_modificacion").item(0).getTextContent());
        ret.setBorrado(element.getElementsByTagName("borrado").item(0).getTextContent());

        return ret;
    }
    */
}
