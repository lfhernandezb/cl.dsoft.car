package cl.dsoft.car.server.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import cl.dsoft.car.server.db.ConsultaProveedor;

@XmlType(name = "ConsultaProveedores", propOrder = {
	    "consultaProveedores"
})
public class ConsultaProveedores {

	@XmlElement(name = "consultaProveedor")
    protected ArrayList<ConsultaProveedor> consultaProveedores;

	public ConsultaProveedores() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the consultaProveedores
	 */
	public ArrayList<ConsultaProveedor> getConsultaProveedores() {
		return consultaProveedores;
	}

	/**
	 * @param consultaProveedores the consultaProveedores to set
	 */
	public void setConsultaProveedores(
			ArrayList<ConsultaProveedor> consultaProveedores) {
		this.consultaProveedores = consultaProveedores;
	}

}
