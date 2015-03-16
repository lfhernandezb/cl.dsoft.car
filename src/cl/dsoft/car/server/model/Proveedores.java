package cl.dsoft.car.server.model;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import cl.dsoft.car.server.db.Comuna;
import cl.dsoft.car.server.db.ConsultaProveedor;
import cl.dsoft.car.server.db.Proveedor;

@XmlType(name = "Proveedores", propOrder = {
	    "proveedores"
})
public class Proveedores {

	@XmlElement(name = "proveedor")
    protected ArrayList<Proveedor> proveedores;

	public Proveedores() {
		// TODO Auto-generated constructor stub
	}

    public Proveedores(java.sql.Connection conn, ConsultaProveedor consultaProveedor) {
		seek(conn, consultaProveedor);
	}

    /**
	 * @return the respuestaProveedores
	 */
	public List<Proveedor> getProveedores() {
		if (proveedores == null) {
			proveedores = new ArrayList<Proveedor>();
		}
		return proveedores;
	}

	/**
	 * @param respuestaProveedores the respuestaProveedores to set
	 */
	public void setProveedores(
			ArrayList<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
	
	private void seek(java.sql.Connection conn, ConsultaProveedor consultaProveedor) {
    	
    	ArrayList<AbstractMap.SimpleEntry<String, String>> listParameters;
    	
    	try {
			listParameters = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
			
			//listParameters.add(new AbstractMap.SimpleEntry<String, String>("id_usuario", String.valueOf(idUsuario)));
			//listParameters.add(new AbstractMap.SimpleEntry<String, String>("mas reciente", fechaModificacion));
			
			this.proveedores = Proveedor.seek(conn, listParameters, null, null, 0, 10000);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }


}