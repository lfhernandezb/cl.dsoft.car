package cl.dsoft.car.mobile.model;

import java.util.ArrayList;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import cl.dsoft.car.mobile.db.Proveedor;

@Root(name = "RespuestaProveedorData")
@Order(elements={"proveedores"})
public class RespuestaProveedorData {

	@ElementList(required=false)
	protected ArrayList<Proveedor> proveedores;

	public RespuestaProveedorData() {
		// TODO Auto-generated constructor stub
		
		this.proveedores = null;
	}

	/**
	 * @return the proveedores
	 */
	public ArrayList<Proveedor> getProveedores() {
		return proveedores;
	}

	/**
	 * @param proveedores the proveedores to set
	 */
	public void setProveedores(ArrayList<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

}
