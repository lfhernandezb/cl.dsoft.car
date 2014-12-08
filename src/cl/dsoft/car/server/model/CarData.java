package cl.dsoft.car.server.model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.simpleframework.xml.ElementList;

import cl.dsoft.car.server.db.CiaSeguros;
import cl.dsoft.car.server.db.SeguroVehiculo;
import cl.dsoft.car.server.db.Log;
import cl.dsoft.car.server.db.MantencionBaseHecha;
import cl.dsoft.car.server.db.MantencionUsuario;
import cl.dsoft.car.server.db.MantencionUsuarioHecha;
import cl.dsoft.car.server.db.Recordatorio;
import cl.dsoft.car.server.db.CargaCombustible;
import cl.dsoft.car.server.db.Reparacion;
import cl.dsoft.car.server.db.Usuario;
import cl.dsoft.car.server.db.Autenticacion;
import cl.dsoft.car.server.db.Vehiculo;

@XmlRootElement(name = "CarData")
//If you want you can define the order in which the fields are written
//Optional
@XmlType(propOrder = { "paises", "regiones", "comunas", "usuarios", "autenticaciones", "vehiculos", "mantencionBaseHechas", "mantencionUsuarios", "mantencionUsuarioHechas", "recordatorios", "cargaCombustibles", "reparaciones", "ciaSeguross", "seguroVehiculos", "logs" })
public class CarData {

	//@XmlElement(nillable=true, required=false)
	protected Paises paises;
	//@XmlElement(nillable=true, required=false)
	protected Regiones regiones;
	//@XmlElement(nillable=true, required=false)
	protected Comunas comunas;
	//@XmlElement(nillable=true, required=false)
	protected Usuarios usuarios;
	//@XmlElement(nillable=true, required=false)
	protected Autenticaciones autenticaciones;
	//@XmlElement(nillable=true, required=false)
	protected Vehiculos vehiculos;
	//@XmlElement(nillable=true, required=false)
	protected MantencionBaseHechas mantencionBaseHechas;
	//@XmlElement(nillable=true, required=false)
	protected MantencionUsuarios mantencionUsuarios;
	//@XmlElement(nillable=true, required=false)
	protected MantencionUsuarioHechas mantencionUsuarioHechas;
	//@XmlElement(nillable=true, required=false)
	protected Recordatorios recordatorios;
	//@XmlElement(nillable=true, required=false)
	protected CargaCombustibles cargaCombustibles;
	//@XmlElement(nillable=true, required=false)
	protected Reparaciones reparaciones;
	//@XmlElement(nillable=true, required=false)
	protected CiaSeguross ciaSeguross;
	//@XmlElement(nillable=true, required=false)
	protected SeguroVehiculos seguroVehiculos;
	//@XmlElement(nillable=true, required=false)
	protected Logs logs;
	
	public CarData() {

		this.paises = null;
		this.regiones = null;
		this.comunas = null;
		this.usuarios = null;
		this.autenticaciones = null;
		this.vehiculos = null;
		this.mantencionBaseHechas = null;
		this.mantencionUsuarios = null;
		this.mantencionUsuarioHechas = null;
		this.recordatorios = null;
		this.cargaCombustibles = null;
		this.reparaciones = null;
		this.ciaSeguross = null;
		this.seguroVehiculos = null;
		this.logs = null;
	}

	public CarData(java.sql.Connection conn, Long idUsuario, String fechaModificacion) {

		this.paises = new Paises(conn, idUsuario, fechaModificacion);
		this.regiones = new Regiones(conn, idUsuario, fechaModificacion);
		this.comunas = new Comunas(conn, idUsuario, fechaModificacion);
		this.usuarios = new Usuarios(conn, idUsuario, fechaModificacion);
		this.autenticaciones = new Autenticaciones(conn, idUsuario, fechaModificacion);
		this.vehiculos = new Vehiculos(conn, idUsuario, fechaModificacion);
		this.mantencionBaseHechas = new MantencionBaseHechas(conn, idUsuario, fechaModificacion);
		this.mantencionUsuarios = new MantencionUsuarios(conn, idUsuario, fechaModificacion);
		this.mantencionUsuarioHechas = new MantencionUsuarioHechas(conn, idUsuario, fechaModificacion);
		this.recordatorios = new Recordatorios(conn, idUsuario, fechaModificacion);
		this.cargaCombustibles = new CargaCombustibles(conn, idUsuario, fechaModificacion);
		this.reparaciones = new Reparaciones(conn, idUsuario, fechaModificacion);
		this.ciaSeguross = new CiaSeguross(conn, idUsuario, fechaModificacion);
		this.seguroVehiculos = new SeguroVehiculos(conn, idUsuario, fechaModificacion);
		this.logs = new Logs(conn, idUsuario, fechaModificacion);
	}

	public CarData(java.sql.Connection conn, Long idRedSocial, String token, Boolean byIdRedSocial) {

		this.usuarios = new Usuarios(conn, idRedSocial, token, byIdRedSocial);
		
		if (!this.usuarios.getUsuarios().isEmpty()) {
			Usuario u = this.getUsuarios().getUsuarios().get(0);
			
			this.paises = new Paises(conn, u.getId(), "1900-01-01");
			this.autenticaciones = new Autenticaciones(conn, u.getId(), "1900-01-01");
			this.regiones = new Regiones(conn, u.getId(), "1900-01-01");
			this.comunas = new Comunas(conn, u.getId(), "1900-01-01");
			this.vehiculos = new Vehiculos(conn, u.getId(), "1900-01-01");
			this.mantencionBaseHechas = new MantencionBaseHechas(conn, u.getId(), "1900-01-01");
			this.mantencionUsuarios = new MantencionUsuarios(conn, u.getId(), "1900-01-01");
			this.mantencionUsuarioHechas = new MantencionUsuarioHechas(conn, u.getId(), "1900-01-01");
			this.recordatorios = new Recordatorios(conn, u.getId(), "1900-01-01");
			this.cargaCombustibles = new CargaCombustibles(conn, u.getId(), "1900-01-01");
			this.reparaciones = new Reparaciones(conn, u.getId(), "1900-01-01");
			this.ciaSeguross = new CiaSeguross(conn, u.getId(), "1900-01-01");
			this.seguroVehiculos = new SeguroVehiculos(conn, u.getId(), "1900-01-01");
			this.logs = new Logs(conn, u.getId(), "1900-01-01");
		}
		/*
		else {
			
			this.paises = new Paises();
			this.regiones = new Regiones();
			this.comunas = new Comunas();
			this.vehiculos = new Vehiculos();
			this.mantencionBaseHechas = new MantencionBaseHechas();
			this.mantencionUsuarios = new MantencionUsuarios();
			this.mantencionUsuarioHechas = new MantencionUsuarioHechas();
			this.recordatorios = new Recordatorios();
			this.cargaCombustibles = new CargaCombustibles();
			this.reparaciones = new Reparaciones();
		}
		*/
	}

	/**
	 * @return the paises
	 */
	public Paises getPaises() {
		return paises;
	}

	/**
	 * @return the autenticaciones
	 */
	public Autenticaciones getAutenticaciones() {
		return autenticaciones;
	}

	/**
	 * @param autenticaciones the autenticaciones to set
	 */
	public void setAutenticaciones(Autenticaciones autenticaciones) {
		this.autenticaciones = autenticaciones;
	}

	/**
	 * @param paises the paises to set
	 */
	public void setPaises(Paises paises) {
		this.paises = paises;
	}

	/**
	 * @return the regiones
	 */
	public Regiones getRegiones() {
		return regiones;
	}

	/**
	 * @param regiones the regiones to set
	 */
	public void setRegiones(Regiones regiones) {
		this.regiones = regiones;
	}

	/**
	 * @return the comunas
	 */
	public Comunas getComunas() {
		return comunas;
	}

	/**
	 * @param comunas the comunas to set
	 */
	public void setComunas(Comunas comunas) {
		this.comunas = comunas;
	}

	/**
	 * @return the usuarios
	 */
	public Usuarios getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * @return the vehiculos
	 */
	public Vehiculos getVehiculos() {
		return vehiculos;
	}

	/**
	 * @param vehiculos the vehiculos to set
	 */
	public void setVehiculos(Vehiculos vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	/**
	 * @return the mantencionBaseHechas
	 */
	public MantencionBaseHechas getMantencionBaseHechas() {
		return mantencionBaseHechas;
	}

	/**
	 * @param mantencionBaseHechas the mantencionBaseHechas to set
	 */
	public void setMantencionBaseHechas(
			MantencionBaseHechas mantencionBaseHechas) {
		this.mantencionBaseHechas = mantencionBaseHechas;
	}

	/**
	 * @return the mantencionUsuarios
	 */
	public MantencionUsuarios getMantencionUsuarios() {
		return mantencionUsuarios;
	}

	/**
	 * @param mantencionUsuarios the mantencionUsuarios to set
	 */
	public void setMantencionUsuarios(MantencionUsuarios mantencionUsuarios) {
		this.mantencionUsuarios = mantencionUsuarios;
	}

	/**
	 * @return the mantencionUsuarioHechas
	 */
	public MantencionUsuarioHechas getMantencionUsuarioHechas() {
		return mantencionUsuarioHechas;
	}

	/**
	 * @param mantencionUsuarioHechas the mantencionUsuarioHechas to set
	 */
	public void setMantencionUsuarioHechas(
			MantencionUsuarioHechas mantencionUsuarioHechas) {
		this.mantencionUsuarioHechas = mantencionUsuarioHechas;
	}

	/**
	 * @return the recordatorios
	 */
	public Recordatorios getRecordatorios() {
		return recordatorios;
	}

	/**
	 * @param recordatorios the recordatorios to set
	 */
	public void setRecordatorios(Recordatorios recordatorios) {
		this.recordatorios = recordatorios;
	}

	/**
	 * @return the rendimientos
	 */
	public CargaCombustibles getCargaCombustibles() {
		return cargaCombustibles;
	}

	/**
	 * @param rendimientos the rendimientos to set
	 */
	public void setCargaCombustibles(CargaCombustibles cargaCombustibles) {
		this.cargaCombustibles = cargaCombustibles;
	}

	/**
	 * @return the reparaciones
	 */
	public Reparaciones getReparaciones() {
		return reparaciones;
	}

	/**
	 * @param reparaciones the reparaciones to set
	 */
	public void setReparaciones(Reparaciones reparaciones) {
		this.reparaciones = reparaciones;
	}
	
	/**
	 * @return the logs
	 */
	public Logs getLogs() {
		return logs;
	}

	/**
	 * @return the ciaSeguross
	 */
	public CiaSeguross getCiaSeguross() {
		return ciaSeguross;
	}

	/**
	 * @param ciaSeguross the ciaSeguross to set
	 */
	public void setCiaSeguross(CiaSeguross ciaSeguross) {
		this.ciaSeguross = ciaSeguross;
	}

	/**
	 * @return the seguroVehiculos
	 */
	public SeguroVehiculos getSeguroVehiculos() {
		return seguroVehiculos;
	}

	/**
	 * @param seguroVehiculos the seguroVehiculos to set
	 */
	public void setSeguroVehiculos(SeguroVehiculos seguroVehiculos) {
		this.seguroVehiculos = seguroVehiculos;
	}

	/**
	 * @param logs the logs to set
	 */
	public void setLogs(Logs logs) {
		this.logs = logs;
	}

	public void save(java.sql.Connection conn) throws SQLException {
		
		for (Usuario usuario : this.usuarios.getUsuarios()) {
			
			usuario.save(conn);
		}

		for (Autenticacion autenticacion : this.autenticaciones.getAutenticaciones()) {
			
			autenticacion.save(conn);
		}

		for (Vehiculo vehiculo : this.vehiculos.getVehiculos()) {
			
			vehiculo.save(conn);
		}
	
		for (MantencionBaseHecha mantencionBaseHecha : this.mantencionBaseHechas.getMantencionBaseHechas()) {
			
			mantencionBaseHecha.save(conn);
		}

		for (MantencionUsuario mantencionUsuario : this.mantencionUsuarios.getMantencionUsuarios()) {
			
			mantencionUsuario.save(conn);
		}

		for (MantencionUsuarioHecha mantencionUsuarioHecha : this.mantencionUsuarioHechas.getMantencionUsuarioHechas()) {
			
			mantencionUsuarioHecha.save(conn);
		}

		for (Recordatorio recordatorio : this.recordatorios.getRecordatorios()) {
			
			recordatorio.save(conn);
		}

		for (CargaCombustible rendimiento : this.cargaCombustibles.getCargaCombustibles()) {
			
			rendimiento.save(conn);
		}

		for (Reparacion reparacion : this.reparaciones.getReparaciones()) {
			
			reparacion.save(conn);
		}
		
		for (SeguroVehiculo seguroVehiculo : this.seguroVehiculos.getSeguroVehiculos()) {
			
			seguroVehiculo.save(conn);
		}

		for (Log log : this.logs.getLogs()) {
			
			log.save(conn);
		}

	}

}
