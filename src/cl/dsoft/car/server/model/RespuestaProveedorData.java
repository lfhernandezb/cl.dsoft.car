package cl.dsoft.car.server.model;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import cl.dsoft.car.server.db.ConsultaProveedor;

@XmlRootElement(name = "RespuestaProveedorData")
//If you want you can define the order in which the fields are written
//Optional
@XmlType(propOrder = { "proveedores" })
public class RespuestaProveedorData {

	//@XmlElement(nillable=true, required=false)
	protected Proveedores proveedores;

	public RespuestaProveedorData() {
		// TODO Auto-generated constructor stub
		proveedores = null;
	}

	/*
	 * se generan los datos que iran desde el Servidor a la App Movil en la consulta por idUsuario
	 */
	public RespuestaProveedorData(java.sql.Connection conn, ConsultaProveedor consultaProveedor) {

		this.proveedores = new Proveedores(conn, consultaProveedor);
	}

	/**
	 * @return the proveedores
	 */
	public Proveedores getProveedores() {
		return proveedores;
	}

	/**
	 * @param proveedores the proveedores to set
	 */
	public void setProveedores(Proveedores proveedores) {
		this.proveedores = proveedores;
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
			jc = JAXBContext.newInstance(String.class, RespuestaProveedorData.class);
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
