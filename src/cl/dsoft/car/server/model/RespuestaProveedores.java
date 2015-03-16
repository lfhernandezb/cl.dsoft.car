package cl.dsoft.car.server.model;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import cl.dsoft.car.server.db.ConsultaProveedor;
import cl.dsoft.car.server.db.Proveedor;
import cl.dsoft.car.server.db.RespuestaProveedor;

@XmlType(name = "RespuestaProveedores", propOrder = {
	    "respuestaProveedores"
})
public class RespuestaProveedores {

	@XmlElement(name = "respuestaProveedor")
    protected ArrayList<RespuestaProveedor> respuestaProveedores;

	public RespuestaProveedores() {
		// TODO Auto-generated constructor stub
	}

    public RespuestaProveedores(java.sql.Connection conn, ConsultaProveedor consultaProveedor) {
		seek(conn, consultaProveedor);
	}

    /**
	 * @return the respuestaProveedores
	 */
	public List<RespuestaProveedor> getRespuestaProveedores() {
		if (respuestaProveedores == null) {
			respuestaProveedores = new ArrayList<RespuestaProveedor>();
		}
		return respuestaProveedores;
	}

	/**
	 * @param respuestaProveedores the respuestaProveedores to set
	 */
	public void setRespuestaProveedores(
			ArrayList<RespuestaProveedor> respuestaProveedores) {
		this.respuestaProveedores = respuestaProveedores;
	}
	
	private void seek(java.sql.Connection conn, ConsultaProveedor consultaProveedor) {
    	
    	ArrayList<AbstractMap.SimpleEntry<String, String>> listParameters;
    	
    	try {
			listParameters = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
			
			//listParameters.add(new AbstractMap.SimpleEntry<String, String>("id_usuario", String.valueOf(idUsuario)));
			//listParameters.add(new AbstractMap.SimpleEntry<String, String>("mas reciente", fechaModificacion));
			
			this.respuestaProveedores = RespuestaProveedor.seek(conn, listParameters, null, null, 0, 10000);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }


}
