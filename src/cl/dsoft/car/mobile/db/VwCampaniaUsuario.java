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
public class VwCampaniaUsuario {
    @Element(name = "id", required = false)
    private Long _id;
    @Element(name = "idUsuario", required = false)
    private Long _idUsuario;
    @Element(name = "fechaInicio", required = false)
    private String _fechaInicio;
    @Element(name = "fechaFin", required = false)
    private String _fechaFin;
    @Element(name = "periodicidad", required = false)
    private Short _periodicidad;
    @Element(name = "numeroImpresiones", required = false)
    private Short _numeroImpresiones;
    @Element(name = "detalle", required = false)
    private String _detalle;
    @Element(name = "fechaModificacion", required = false)
    private String _fechaModificacion;

    private final static String _str_sql = 
        "    SELECT" +
        "    vw.id AS id," +
        "    vw.id_usuario AS id_usuario," +
        "    strftime('%Y-%m-%d', vw.fecha_inicio) AS fecha_inicio," +
        "    strftime('%Y-%m-%d', vw.fecha_fin) AS fecha_fin," +
        "    vw.periodicidad AS periodicidad," +
        "    vw.numero_impresiones AS numero_impresiones," +
        "    vw.detalle AS detalle," +
        "    strftime('%Y-%m-%d %H:%M:%S', vw.fecha_modificacion) AS fecha_modificacion" +
        "    FROM vw_campania_usuario vw";

    public VwCampaniaUsuario() {
        _id = null;
        _idUsuario = null;
        _fechaInicio = null;
        _fechaFin = null;
        _periodicidad = null;
        _numeroImpresiones = null;
        _detalle = null;
        _fechaModificacion = null;

    }
    /**
     * @return the _id
     */
    public Long getId() {
        return _id;
    }
    /**
     * @return the _idUsuario
     */
    public Long getIdUsuario() {
        return _idUsuario;
    }
    /**
     * @return the _fechaInicio
     */
    public String getFechaInicio() {
        return _fechaInicio;
    }
    /**
     * @return the _fechaFin
     */
    public String getFechaFin() {
        return _fechaFin;
    }
    /**
     * @return the _periodicidad
     */
    public Short getPeriodicidad() {
        return _periodicidad;
    }
    /**
     * @return the _numeroImpresiones
     */
    public Short getNumeroImpresiones() {
        return _numeroImpresiones;
    }
    /**
     * @return the _detalle
     */
    public String getDetalle() {
        return _detalle;
    }
    /**
     * @return the _fechaModificacion
     */
    public String getFechaModificacion() {
        return _fechaModificacion;
    }
    /**
     * @return the _fechaInicio as seconds from January 1, 1970, 00:00:00 GMT
     */
    public long getFechaInicioAsLong() throws ParseException {
        Date d;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        d = formatter.parse(_fechaInicio);

        return (long)d.getTime() / 1000L;
    }
    /**
     * @return the _fechaFin as seconds from January 1, 1970, 00:00:00 GMT
     */
    public long getFechaFinAsLong() throws ParseException {
        Date d;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        d = formatter.parse(_fechaFin);

        return (long)d.getTime() / 1000L;
    }
    /**
     * @return the _fechaInicio as Date
     */
    public Date getFechaInicioAsDate() throws ParseException {
        Date d;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        d = formatter.parse(_fechaInicio);

        return d;
    }
    /**
     * @return the _fechaFin as Date
     */
    public Date getFechaFinAsDate() throws ParseException {
        Date d;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        d = formatter.parse(_fechaFin);

        return d;
    }
    /**
     * @param _id the _id to set
     */
    public void setId(Long _id) {
        this._id = _id;
    }
    /**
     * @param _idUsuario the _idUsuario to set
     */
    public void setIdUsuario(Long _idUsuario) {
        this._idUsuario = _idUsuario;
    }
    /**
     * @param _fechaInicio the _fechaInicio to set
     */
    public void setFechaInicio(String _fechaInicio) {
        this._fechaInicio = _fechaInicio;
    }
    /**
     * @param _fechaFin the _fechaFin to set
     */
    public void setFechaFin(String _fechaFin) {
        this._fechaFin = _fechaFin;
    }
    /**
     * @param _periodicidad the _periodicidad to set
     */
    public void setPeriodicidad(Short _periodicidad) {
        this._periodicidad = _periodicidad;
    }
    /**
     * @param _numeroImpresiones the _numeroImpresiones to set
     */
    public void setNumeroImpresiones(Short _numeroImpresiones) {
        this._numeroImpresiones = _numeroImpresiones;
    }
    /**
     * @param _detalle the _detalle to set
     */
    public void setDetalle(String _detalle) {
        this._detalle = _detalle;
    }
    /**
     * @param _fechaModificacion the _fechaModificacion to set
     */
    public void setFechaModificacion(String _fechaModificacion) {
        this._fechaModificacion = _fechaModificacion;
    }
    /**
     * @param _fechaInicio the _fechaInicio to set as seconds from January 1, 1970, 00:00:00 GMT
     */
    public void setFechaInicio(long _timestamp) {
        Date d;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        d = new Date((long)_timestamp*1000);

        this._fechaInicio = formatter.format(d);
;
    }
    /**
     * @param _fechaFin the _fechaFin to set as seconds from January 1, 1970, 00:00:00 GMT
     */
    public void setFechaFin(long _timestamp) {
        Date d;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        d = new Date((long)_timestamp*1000);

        this._fechaFin = formatter.format(d);
;
    }
    /**
     * @param _fechaInicio the _fechaInicio to set as java.util.Date
     */
    public void setFechaInicio(Date _fecha) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        this._fechaInicio = formatter.format(_fecha);
;
    }
    /**
     * @param _fechaFin the _fechaFin to set as java.util.Date
     */
    public void setFechaFin(Date _fecha) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        this._fechaFin = formatter.format(_fecha);
;
    }

    public static VwCampaniaUsuario fromRS(ResultSet p_rs) throws SQLException {
        VwCampaniaUsuario ret = new VwCampaniaUsuario();

        ret.setId(p_rs.getLong("id"));
        ret.setIdUsuario(p_rs.getLong("id_usuario"));
        ret.setFechaInicio(p_rs.getString("fecha_inicio"));
        ret.setFechaFin(p_rs.getString("fecha_fin"));
        ret.setPeriodicidad(p_rs.getShort("periodicidad"));
        ret.setNumeroImpresiones(p_rs.getShort("numero_impresiones"));
        ret.setDetalle(p_rs.getString("detalle"));
        ret.setFechaModificacion(p_rs.getString("fecha_modificacion"));

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

    public static VwCampaniaUsuario getById(Connection p_conn, String p_id) throws SQLException {
        return getByParameter(p_conn, "id_vw_campania_usuario", p_id);
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
                if (p.getKey().equals("id")) {
                    array_clauses.add("vw.id = " + p.getValue());
                }
                else if (p.getKey().equals("id_usuario")) {
                    array_clauses.add("vw.id_usuario = " + p.getValue());
                }
                else if (p.getKey().equals("nuevas")) {
                    array_clauses.add("vw.numero_impresiones > 0");
                }
                else if (p.getKey().equals("viejas")) {
                    array_clauses.add("vw.numero_impresiones <= 0");
                }
                else if (p.getKey().equals("mas reciente")) {
                    array_clauses.add("vw.fecha_modificacion > datetime('" + p.getValue() + "')");
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
            "  SELECT COALESCE(MAX(id_vw_campania_usuario), 0) + 1 AS next_id FROM vw_campania_usuario";
        
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
            "    UPDATE vw_campania_usuario" +
            "    SET" +
            "    id_usuario = " + (_idUsuario != null ? "'" + _idUsuario + "'" : "null") + "," +
            "    fecha_inicio = " + (_fechaInicio != null ? "date('" + _fechaInicio + "')" : "null") + "," +
            "    fecha_fin = " + (_fechaFin != null ? "date('" + _fechaFin + "')" : "null") + "," +
            "    periodicidad = " + (_periodicidad != null ? "'" + _periodicidad + "'" : "null") + "," +
            "    numero_impresiones = " + (_numeroImpresiones != null ? "'" + _numeroImpresiones + "'" : "null") + "," +
            "    detalle = " + (_detalle != null ? "'" + _detalle + "'" : "null") + "," +
            "    fecha_modificacion = " + (_fechaModificacion != null ? "datetime('" + _fechaModificacion + "')" : "null") +
            "    WHERE" +
            "    id = " + Long.toString(this._id);

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
            "    INSERT INTO vw_campania_usuario" +
            "    (" +
            "    id, " +
            "    id_usuario, " +
            "    fecha_inicio, " +
            "    fecha_fin, " +
            "    periodicidad, " +
            "    numero_impresiones, " +
            "    detalle, " +
            "    fecha_modificacion)" +
            "    VALUES" +
            "    (" +
            "    " + (_id != null ? "'" + _id + "'" : "null") + "," +
            "    " + (_idUsuario != null ? "'" + _idUsuario + "'" : "null") + "," +
            "    " + (_fechaInicio != null ? "date('" + _fechaInicio + "')" : "null") + "," +
            "    " + (_fechaFin != null ? "date('" + _fechaFin + "')" : "null") + "," +
            "    " + (_periodicidad != null ? "'" + _periodicidad + "'" : "null") + "," +
            "    " + (_numeroImpresiones != null ? "'" + _numeroImpresiones + "'" : "null") + "," +
            "    " + (_detalle != null ? "'" + _detalle + "'" : "null") + "," +
            "    " + (_fechaModificacion != null ? "datetime('" + _fechaModificacion + "')" : "null") +
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
            "    id = " + Long.toString(this._id);

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
        VwCampaniaUsuario obj = null;
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id = " + Long.toString(this._id) +
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

                _idUsuario = obj.getIdUsuario();
                _fechaInicio = obj.getFechaInicio();
                _fechaFin = obj.getFechaFin();
                _periodicidad = obj.getPeriodicidad();
                _numeroImpresiones = obj.getNumeroImpresiones();
                _detalle = obj.getDetalle();
                _fechaModificacion = obj.getFechaModificacion();
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
            "    id = " + Long.toString(this._id) +
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
        return "VwCampaniaUsuario [" +
	           "    _id = " + (_id != null ? _id : "null") + "," +
	           "    _idUsuario = " + (_idUsuario != null ? _idUsuario : "null") + "," +
	           "    _fechaInicio = " + (_fechaInicio != null ? "'" + _fechaInicio + "'" : "null") + "," +
	           "    _fechaFin = " + (_fechaFin != null ? "'" + _fechaFin + "'" : "null") + "," +
	           "    _periodicidad = " + (_periodicidad != null ? _periodicidad : "null") + "," +
	           "    _numeroImpresiones = " + (_numeroImpresiones != null ? _numeroImpresiones : "null") + "," +
	           "    _detalle = " + (_detalle != null ? "'" + _detalle + "'" : "null") + "," +
	           "    _fechaModificacion = " + (_fechaModificacion != null ? "'" + _fechaModificacion + "'" : "null") +
			   "]";
    }


/*
    public static VwCampaniaUsuario fromXMLNode(Node xmlNode) {
        VwCampaniaUsuario ret = new VwCampaniaUsuario();

        Element element = (Element) xmlNode;

        ret.setId(Long.decode(element.getElementsByTagName("id").item(0).getTextContent()));
        ret.setIdUsuario(Long.decode(element.getElementsByTagName("id_usuario").item(0).getTextContent()));
        ret.setFechaInicio(element.getElementsByTagName("fecha_inicio").item(0).getTextContent());
        ret.setFechaFin(element.getElementsByTagName("fecha_fin").item(0).getTextContent());
        ret.setPeriodicidad(Short.decode(element.getElementsByTagName("periodicidad").item(0).getTextContent()));
        ret.setNumeroImpresiones(Short.decode(element.getElementsByTagName("numero_impresiones").item(0).getTextContent()));
        ret.setDetalle(element.getElementsByTagName("detalle").item(0).getTextContent());
        ret.setFechaModificacion(element.getElementsByTagName("fecha_modificacion").item(0).getTextContent());

        return ret;
    }
    */
}
