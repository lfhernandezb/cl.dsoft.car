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
public class Vehiculo {
    @Element(name = "idVehiculo")
    private Long _idVehiculo;
    @Element(name = "idUsuario")
    private Long _idUsuario;
    @Element(name = "idModelo")
    private Long _idModelo;
    @Element(name = "idTipoTransmision")
    private Byte _idTipoTransmision;
    @Element(name = "idCombustible")
    private Byte _idCombustible;
    @Element(name = "idTraccion")
    private Byte _idTraccion;
    @Element(name = "alias")
    private String _alias;
    @Element(name = "kmAnuales", required = false)
    private Integer _kmAnuales;
    @Element(name = "fechaUltimoKm", required = false)
    private String _fechaUltimoKm;
    @Element(name = "kmCalibrados", required = false)
    private Integer _kmCalibrados;
    @Element(name = "fechaUltimaCalibracion", required = false)
    private String _fechaUltimaCalibracion;
    @Element(name = "patente", required = false)
    private String _patente;
    @Element(name = "anio", required = false)
    private Integer _anio;
    @Element(name = "km", required = false)
    private Integer _km;
    @Element(name = "aireAcondicionado", required = false)
    private Boolean _aireAcondicionado;
    @Element(name = "alzaVidrios", required = false)
    private Boolean _alzaVidrios;
    @Element(name = "fechaModificacion")
    private String _fechaModificacion;
    @Element(name = "borrado")
    private Boolean _borrado;

    private final static String _str_sql = 
        "    SELECT" +
        "    ve.id_vehiculo AS id_vehiculo," +
        "    ve.id_usuario AS id_usuario," +
        "    ve.id_modelo AS id_modelo," +
        "    ve.id_tipo_transmision AS id_tipo_transmision," +
        "    ve.id_combustible AS id_combustible," +
        "    ve.id_traccion AS id_traccion," +
        "    ve.alias AS alias," +
        "    ve.km_anuales AS km_anuales," +
        "    strftime('%Y-%m-%d', ve.fecha_ultimo_km) AS fecha_ultimo_km," +
        "    ve.km_calibrados AS km_calibrados," +
        "    strftime('%Y-%m-%d', ve.fecha_ultima_calibracion) AS fecha_ultima_calibracion," +
        "    ve.patente AS patente," +
        "    ve.anio AS anio," +
        "    ve.km AS km," +
        "    ve.aire_acondicionado AS aire_acondicionado," +
        "    ve.alza_vidrios AS alza_vidrios," +
        "    strftime('%Y-%m-%d %H:%M:%S', ve.fecha_modificacion) AS fecha_modificacion," +
        "    ve.borrado AS borrado" +
        "    FROM vehiculo ve";

    public Vehiculo() {
        _idVehiculo = null;
        _idUsuario = null;
        _idModelo = null;
        _idTipoTransmision = null;
        _idCombustible = null;
        _idTraccion = null;
        _alias = null;
        _kmAnuales = null;
        _fechaUltimoKm = null;
        _kmCalibrados = null;
        _fechaUltimaCalibracion = null;
        _patente = null;
        _anio = null;
        _km = null;
        _aireAcondicionado = null;
        _alzaVidrios = null;
        _fechaModificacion = null;
        _borrado = null;

    }
    /**
     * @return the _idVehiculo
     */
    public Long getIdVehiculo() {
        return _idVehiculo;
    }
    /**
     * @return the _idUsuario
     */
    public Long getIdUsuario() {
        return _idUsuario;
    }
    /**
     * @return the _idModelo
     */
    public Long getIdModelo() {
        return _idModelo;
    }
    /**
     * @return the _idTipoTransmision
     */
    public Byte getIdTipoTransmision() {
        return _idTipoTransmision;
    }
    /**
     * @return the _idCombustible
     */
    public Byte getIdCombustible() {
        return _idCombustible;
    }
    /**
     * @return the _idTraccion
     */
    public Byte getIdTraccion() {
        return _idTraccion;
    }
    /**
     * @return the _alias
     */
    public String getAlias() {
        return _alias;
    }
    /**
     * @return the _kmAnuales
     */
    public Integer getKmAnuales() {
        return _kmAnuales;
    }
    /**
     * @return the _fechaUltimoKm
     */
    public String getFechaUltimoKm() {
        return _fechaUltimoKm;
    }
    /**
     * @return the _kmCalibrados
     */
    public Integer getKmCalibrados() {
        return _kmCalibrados;
    }
    /**
     * @return the _fechaUltimaCalibracion
     */
    public String getFechaUltimaCalibracion() {
        return _fechaUltimaCalibracion;
    }
    /**
     * @return the _patente
     */
    public String getPatente() {
        return _patente;
    }
    /**
     * @return the _anio
     */
    public Integer getAnio() {
        return _anio;
    }
    /**
     * @return the _km
     */
    public Integer getKm() {
        return _km;
    }
    /**
     * @return the _aireAcondicionado
     */
    public Boolean getAireAcondicionado() {
        return _aireAcondicionado;
    }
    /**
     * @return the _alzaVidrios
     */
    public Boolean getAlzaVidrios() {
        return _alzaVidrios;
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
     * @return the _fechaUltimoKm as seconds from January 1, 1970, 00:00:00 GMT
     */
    public long getFechaUltimoKmAsLong() throws ParseException {
        Date d;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        d = formatter.parse(_fechaUltimoKm);

        return (long)d.getTime() / 1000L;
    }
    /**
     * @return the _fechaUltimaCalibracion as seconds from January 1, 1970, 00:00:00 GMT
     */
    public long getFechaUltimaCalibracionAsLong() throws ParseException {
        Date d;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        d = formatter.parse(_fechaUltimaCalibracion);

        return (long)d.getTime() / 1000L;
    }
    /**
     * @return the _fechaUltimoKm as Date
     */
    public Date getFechaUltimoKmAsDate() throws ParseException {
        Date d;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        d = formatter.parse(_fechaUltimoKm);

        return d;
    }
    /**
     * @return the _fechaUltimaCalibracion as Date
     */
    public Date getFechaUltimaCalibracionAsDate() throws ParseException {
        Date d;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        d = formatter.parse(_fechaUltimaCalibracion);

        return d;
    }
    /**
     * @param _idVehiculo the _idVehiculo to set
     */
    public void setIdVehiculo(Long _idVehiculo) {
        this._idVehiculo = _idVehiculo;
    }
    /**
     * @param _idUsuario the _idUsuario to set
     */
    public void setIdUsuario(Long _idUsuario) {
        this._idUsuario = _idUsuario;
    }
    /**
     * @param _idModelo the _idModelo to set
     */
    public void setIdModelo(Long _idModelo) {
        this._idModelo = _idModelo;
    }
    /**
     * @param _idTipoTransmision the _idTipoTransmision to set
     */
    public void setIdTipoTransmision(Byte _idTipoTransmision) {
        this._idTipoTransmision = _idTipoTransmision;
    }
    /**
     * @param _idCombustible the _idCombustible to set
     */
    public void setIdCombustible(Byte _idCombustible) {
        this._idCombustible = _idCombustible;
    }
    /**
     * @param _idTraccion the _idTraccion to set
     */
    public void setIdTraccion(Byte _idTraccion) {
        this._idTraccion = _idTraccion;
    }
    /**
     * @param _alias the _alias to set
     */
    public void setAlias(String _alias) {
        this._alias = _alias;
    }
    /**
     * @param _kmAnuales the _kmAnuales to set
     */
    public void setKmAnuales(Integer _kmAnuales) {
        this._kmAnuales = _kmAnuales;
    }
    /**
     * @param _fechaUltimoKm the _fechaUltimoKm to set
     */
    public void setFechaUltimoKm(String _fechaUltimoKm) {
        this._fechaUltimoKm = _fechaUltimoKm;
    }
    /**
     * @param _kmCalibrados the _kmCalibrados to set
     */
    public void setKmCalibrados(Integer _kmCalibrados) {
        this._kmCalibrados = _kmCalibrados;
    }
    /**
     * @param _fechaUltimaCalibracion the _fechaUltimaCalibracion to set
     */
    public void setFechaUltimaCalibracion(String _fechaUltimaCalibracion) {
        this._fechaUltimaCalibracion = _fechaUltimaCalibracion;
    }
    /**
     * @param _patente the _patente to set
     */
    public void setPatente(String _patente) {
        this._patente = _patente;
    }
    /**
     * @param _anio the _anio to set
     */
    public void setAnio(Integer _anio) {
        this._anio = _anio;
    }
    /**
     * @param _km the _km to set
     */
    public void setKm(Integer _km) {
        this._km = _km;
    }
    /**
     * @param _aireAcondicionado the _aireAcondicionado to set
     */
    public void setAireAcondicionado(Boolean _aireAcondicionado) {
        this._aireAcondicionado = _aireAcondicionado;
    }
    /**
     * @param _alzaVidrios the _alzaVidrios to set
     */
    public void setAlzaVidrios(Boolean _alzaVidrios) {
        this._alzaVidrios = _alzaVidrios;
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
     * @param _fechaUltimoKm the _fechaUltimoKm to set as seconds from January 1, 1970, 00:00:00 GMT
     */
    public void setFechaUltimoKm(long _timestamp) {
        Date d;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        d = new Date((long)_timestamp*1000);

        this._fechaUltimoKm = formatter.format(d);
;
    }
    /**
     * @param _fechaUltimaCalibracion the _fechaUltimaCalibracion to set as seconds from January 1, 1970, 00:00:00 GMT
     */
    public void setFechaUltimaCalibracion(long _timestamp) {
        Date d;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        d = new Date((long)_timestamp*1000);

        this._fechaUltimaCalibracion = formatter.format(d);
;
    }
    /**
     * @param _fechaUltimoKm the _fechaUltimoKm to set as java.util.Date
     */
    public void setFechaUltimoKm(Date _fecha) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        this._fechaUltimoKm = formatter.format(_fecha);
;
    }
    /**
     * @param _fechaUltimaCalibracion the _fechaUltimaCalibracion to set as java.util.Date
     */
    public void setFechaUltimaCalibracion(Date _fecha) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        this._fechaUltimaCalibracion = formatter.format(_fecha);
;
    }

    public static Vehiculo fromRS(ResultSet p_rs) throws SQLException {
        Vehiculo ret = new Vehiculo();

        ret.setIdVehiculo(p_rs.getLong("id_vehiculo"));
        ret.setIdUsuario(p_rs.getLong("id_usuario"));
        ret.setIdModelo(p_rs.getLong("id_modelo"));
        ret.setIdTipoTransmision(p_rs.getByte("id_tipo_transmision"));
        ret.setIdCombustible(p_rs.getByte("id_combustible"));
        ret.setIdTraccion(p_rs.getByte("id_traccion"));
        ret.setAlias(p_rs.getString("alias"));
        ret.setKmAnuales(p_rs.getInt("km_anuales"));
        ret.setFechaUltimoKm(p_rs.getString("fecha_ultimo_km"));
        ret.setKmCalibrados(p_rs.getInt("km_calibrados"));
        ret.setFechaUltimaCalibracion(p_rs.getString("fecha_ultima_calibracion"));
        ret.setPatente(p_rs.getString("patente"));
        ret.setAnio(p_rs.getInt("anio"));
        ret.setKm(p_rs.getInt("km"));
        ret.setAireAcondicionado(p_rs.getString("aire_acondicionado") != null ? p_rs.getString("aire_acondicionado").equals("true") : null);
        ret.setAlzaVidrios(p_rs.getString("alza_vidrios") != null ? p_rs.getString("alza_vidrios").equals("true") : null);
        ret.setFechaModificacion(p_rs.getString("fecha_modificacion"));
        ret.setBorrado(p_rs.getString("borrado") != null ? p_rs.getString("borrado").equals("true") : null);

        return ret;
    }

    public static Vehiculo getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        Vehiculo ret = null;
        
        String str_sql = _str_sql +
            "  WHERE ve." + p_key + " = " + p_value +
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

    
    public static ArrayList<Vehiculo> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws UnsupportedParameterException, SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<Vehiculo> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<Vehiculo>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_usuario")) {
                    array_clauses.add("ve.id_usuario = " + p.getValue());
                }
                else if (p.getKey().equals("id_vehiculo")) {
                    array_clauses.add("ve.id_vehiculo = " + p.getValue());
                }
                else if (p.getKey().equals("id_traccion")) {
                    array_clauses.add("ve.id_traccion = " + p.getValue());
                }
                else if (p.getKey().equals("id_tipo_transmision")) {
                    array_clauses.add("ve.id_tipo_transmision = " + p.getValue());
                }
                else if (p.getKey().equals("id_modelo")) {
                    array_clauses.add("ve.id_modelo = " + p.getValue());
                }
                else if (p.getKey().equals("id_combustible")) {
                    array_clauses.add("ve.id_combustible = " + p.getValue());
                }
                else if (p.getKey().equals("mas reciente")) {
                    array_clauses.add("ve.fecha_modificacion > datetime('" + p.getValue() + "')");
                }
                else if (p.getKey().equals("no borrado")) {
                    array_clauses.add("ve.borrado = 'false'");
                }
                else if (p.getKey().equals("borrado")) {
                    array_clauses.add("ve.borrado = 'true'");
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
            "  SELECT COALESCE(MAX(id_vehiculo), 0) + 1 AS next_id FROM vehiculo";
        
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
            "    UPDATE vehiculo" +
            "    SET" +
            "    alias = " + (_alias != null ? "'" + _alias + "'" : "null") + "," +
            "    km_anuales = " + (_kmAnuales != null ? "'" + _kmAnuales + "'" : "null") + "," +
            "    fecha_ultimo_km = " + (_fechaUltimoKm != null ? "date('" + _fechaUltimoKm + "')" : "null") + "," +
            "    km_calibrados = " + (_kmCalibrados != null ? "'" + _kmCalibrados + "'" : "null") + "," +
            "    fecha_ultima_calibracion = " + (_fechaUltimaCalibracion != null ? "date('" + _fechaUltimaCalibracion + "')" : "null") + "," +
            "    patente = " + (_patente != null ? "'" + _patente + "'" : "null") + "," +
            "    anio = " + (_anio != null ? "'" + _anio + "'" : "null") + "," +
            "    km = " + (_km != null ? "'" + _km + "'" : "null") + "," +
            "    aire_acondicionado = " + (_aireAcondicionado != null ? "'" + _aireAcondicionado + "'" : "null") + "," +
            "    alza_vidrios = " + (_alzaVidrios != null ? "'" + _alzaVidrios + "'" : "null") + "," +
            "    fecha_modificacion = " + (_fechaModificacion != null ? "datetime('" + _fechaModificacion + "')" : "datetime('now', 'localtime')") + "," +
            "    borrado = " + (_borrado != null ? "'" + _borrado + "'" : "'false'") +
            "    WHERE" +
            "    id_usuario = " + Long.toString(this._idUsuario) + " AND" +
            "    id_vehiculo = " + Long.toString(this._idVehiculo);

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

        if (_idVehiculo == null) {
            _idVehiculo = getNextId(p_conn);
        }

        String str_sql =
            "    INSERT INTO vehiculo" +
            "    (" +
            "    id_vehiculo, " +
            "    id_usuario, " +
            "    id_modelo, " +
            "    id_tipo_transmision, " +
            "    id_combustible, " +
            "    id_traccion, " +
            "    alias, " +
            "    km_anuales, " +
            "    fecha_ultimo_km, " +
            "    km_calibrados, " +
            "    fecha_ultima_calibracion, " +
            "    patente, " +
            "    anio, " +
            "    km, " +
            "    aire_acondicionado, " +
            "    alza_vidrios, " +
            "    fecha_modificacion, " +
            "    borrado)" +
            "    VALUES" +
            "    (" +
            "    " + (_idVehiculo != null ? "'" + _idVehiculo + "'" : "null") + "," +
            "    " + (_idUsuario != null ? "'" + _idUsuario + "'" : "null") + "," +
            "    " + (_idModelo != null ? "'" + _idModelo + "'" : "null") + "," +
            "    " + (_idTipoTransmision != null ? "'" + _idTipoTransmision + "'" : "null") + "," +
            "    " + (_idCombustible != null ? "'" + _idCombustible + "'" : "null") + "," +
            "    " + (_idTraccion != null ? "'" + _idTraccion + "'" : "null") + "," +
            "    " + (_alias != null ? "'" + _alias + "'" : "null") + "," +
            "    " + (_kmAnuales != null ? "'" + _kmAnuales + "'" : "null") + "," +
            "    " + (_fechaUltimoKm != null ? "date('" + _fechaUltimoKm + "')" : "null") + "," +
            "    " + (_kmCalibrados != null ? "'" + _kmCalibrados + "'" : "null") + "," +
            "    " + (_fechaUltimaCalibracion != null ? "date('" + _fechaUltimaCalibracion + "')" : "null") + "," +
            "    " + (_patente != null ? "'" + _patente + "'" : "null") + "," +
            "    " + (_anio != null ? "'" + _anio + "'" : "null") + "," +
            "    " + (_km != null ? "'" + _km + "'" : "null") + "," +
            "    " + (_aireAcondicionado != null ? "'" + _aireAcondicionado + "'" : "null") + "," +
            "    " + (_alzaVidrios != null ? "'" + _alzaVidrios + "'" : "null") + "," +
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
            "    DELETE FROM vehiculo" +
            "    WHERE" +
            "    id_usuario = " + Long.toString(this._idUsuario) + " AND" +
            "    id_vehiculo = " + Long.toString(this._idVehiculo);

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
        Vehiculo obj = null;
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_usuario = " + Long.toString(this._idUsuario) + " AND" +
            "    id_vehiculo = " + Long.toString(this._idVehiculo) +
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

                _idModelo = obj.getIdModelo();
                _idTipoTransmision = obj.getIdTipoTransmision();
                _idCombustible = obj.getIdCombustible();
                _idTraccion = obj.getIdTraccion();
                _alias = obj.getAlias();
                _kmAnuales = obj.getKmAnuales();
                _fechaUltimoKm = obj.getFechaUltimoKm();
                _kmCalibrados = obj.getKmCalibrados();
                _fechaUltimaCalibracion = obj.getFechaUltimaCalibracion();
                _patente = obj.getPatente();
                _anio = obj.getAnio();
                _km = obj.getKm();
                _aireAcondicionado = obj.getAireAcondicionado();
                _alzaVidrios = obj.getAlzaVidrios();
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
            "    id_usuario = " + Long.toString(this._idUsuario) + " AND" +
            "    id_vehiculo = " + Long.toString(this._idVehiculo) +
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
        return "Vehiculo [" +
	           "    _idVehiculo = " + (_idVehiculo != null ? _idVehiculo : "null") + "," +
	           "    _idUsuario = " + (_idUsuario != null ? _idUsuario : "null") + "," +
	           "    _idModelo = " + (_idModelo != null ? _idModelo : "null") + "," +
	           "    _idTipoTransmision = " + (_idTipoTransmision != null ? _idTipoTransmision : "null") + "," +
	           "    _idCombustible = " + (_idCombustible != null ? _idCombustible : "null") + "," +
	           "    _idTraccion = " + (_idTraccion != null ? _idTraccion : "null") + "," +
	           "    _alias = " + (_alias != null ? "'" + _alias + "'" : "null") + "," +
	           "    _kmAnuales = " + (_kmAnuales != null ? _kmAnuales : "null") + "," +
	           "    _fechaUltimoKm = " + (_fechaUltimoKm != null ? "'" + _fechaUltimoKm + "'" : "null") + "," +
	           "    _kmCalibrados = " + (_kmCalibrados != null ? _kmCalibrados : "null") + "," +
	           "    _fechaUltimaCalibracion = " + (_fechaUltimaCalibracion != null ? "'" + _fechaUltimaCalibracion + "'" : "null") + "," +
	           "    _patente = " + (_patente != null ? "'" + _patente + "'" : "null") + "," +
	           "    _anio = " + (_anio != null ? _anio : "null") + "," +
	           "    _km = " + (_km != null ? _km : "null") + "," +
	           "    _aireAcondicionado = " + (_aireAcondicionado != null ? _aireAcondicionado : "null") + "," +
	           "    _alzaVidrios = " + (_alzaVidrios != null ? _alzaVidrios : "null") + "," +
	           "    _fechaModificacion = " + (_fechaModificacion != null ? "'" + _fechaModificacion + "'" : "null") + "," +
	           "    _borrado = " + (_borrado != null ? _borrado : "null") +
			   "]";
    }


/*
    public static Vehiculo fromXMLNode(Node xmlNode) {
        Vehiculo ret = new Vehiculo();

        Element element = (Element) xmlNode;

        ret.setIdVehiculo(Long.decode(element.getElementsByTagName("id_vehiculo").item(0).getTextContent()));
        ret.setIdUsuario(Long.decode(element.getElementsByTagName("id_usuario").item(0).getTextContent()));
        ret.setIdModelo(Long.decode(element.getElementsByTagName("id_modelo").item(0).getTextContent()));
        ret.setIdTipoTransmision(Byte.decode(element.getElementsByTagName("id_tipo_transmision").item(0).getTextContent()));
        ret.setIdCombustible(Byte.decode(element.getElementsByTagName("id_combustible").item(0).getTextContent()));
        ret.setIdTraccion(Byte.decode(element.getElementsByTagName("id_traccion").item(0).getTextContent()));
        ret.setAlias(element.getElementsByTagName("alias").item(0).getTextContent());
        ret.setKmAnuales(Integer.decode(element.getElementsByTagName("km_anuales").item(0).getTextContent()));
        ret.setFechaUltimoKm(element.getElementsByTagName("fecha_ultimo_km").item(0).getTextContent());
        ret.setKmCalibrados(Integer.decode(element.getElementsByTagName("km_calibrados").item(0).getTextContent()));
        ret.setFechaUltimaCalibracion(element.getElementsByTagName("fecha_ultima_calibracion").item(0).getTextContent());
        ret.setPatente(element.getElementsByTagName("patente").item(0).getTextContent());
        ret.setAnio(Integer.decode(element.getElementsByTagName("anio").item(0).getTextContent()));
        ret.setKm(Integer.decode(element.getElementsByTagName("km").item(0).getTextContent()));
        ret.setAireAcondicionado(element.getElementsByTagName("aire_acondicionado").item(0).getTextContent());
        ret.setAlzaVidrios(element.getElementsByTagName("alza_vidrios").item(0).getTextContent());
        ret.setFechaModificacion(element.getElementsByTagName("fecha_modificacion").item(0).getTextContent());
        ret.setBorrado(element.getElementsByTagName("borrado").item(0).getTextContent());

        return ret;
    }
    */
}
