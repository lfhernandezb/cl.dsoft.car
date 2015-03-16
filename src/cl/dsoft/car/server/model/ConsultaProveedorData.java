package cl.dsoft.car.server.model;

import java.io.StringWriter;
import java.sql.SQLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import cl.dsoft.car.server.db.ConsultaProveedor;
import cl.dsoft.car.server.db.Autenticacion;
import cl.dsoft.car.server.db.CargaCombustible;
import cl.dsoft.car.server.db.Log;
import cl.dsoft.car.server.db.MantencionBaseHecha;
import cl.dsoft.car.server.db.MantencionPospuesta;
import cl.dsoft.car.server.db.MantencionUsuario;
import cl.dsoft.car.server.db.MantencionUsuarioHecha;
import cl.dsoft.car.server.db.Recordatorio;
import cl.dsoft.car.server.db.Reparacion;
import cl.dsoft.car.server.db.SeguroVehiculo;
import cl.dsoft.car.server.db.Usuario;
import cl.dsoft.car.server.db.Vehiculo;

@XmlRootElement(name = "ConsultaProveedorData")
//If you want you can define the order in which the fields are written
//Optional
@XmlType(propOrder = { "consultaProveedores"})
public class ConsultaProveedorData {

	//@XmlElement(nillable=true, required=false)
	protected ConsultaProveedores consultaProveedores;

	public ConsultaProveedorData() {
		// TODO Auto-generated constructor stub
		consultaProveedores = null;
	}

	/**
	 * @return the consultaProveedores
	 */
	public ConsultaProveedores getConsultaProveedores() {
		return consultaProveedores;
	}

	/**
	 * @param consultaProveedores the consultaProveedores to set
	 */
	public void setConsultaProveedores(ConsultaProveedores consultaProveedores) {
		this.consultaProveedores = consultaProveedores;
	}

	/*
	 * se graban en la base de datos MySQL los datos recibidos desde la App Movil
	 */
	public void save(java.sql.Connection conn) throws SQLException {
		
		for (ConsultaProveedor consultaProveedor : this.consultaProveedores.getConsultaProveedores()) {
			
			consultaProveedor.save(conn);
		}

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
        JAXBContext jc;
        StringWriter stringWriter = new StringWriter();
        
		try {
			jc = JAXBContext.newInstance(String.class, CarData.class);
	        Marshaller marshaller = jc.createMarshaller();

	        marshaller.marshal(this, stringWriter);
	        
	        
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return stringWriter.toString();
		}
        
        

	}
	
}
