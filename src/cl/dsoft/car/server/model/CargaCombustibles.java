package cl.dsoft.car.server.model;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import cl.dsoft.car.server.db.CargaCombustible;

@XmlType(name = "CargaCombustibles", propOrder = {
	    "cargaCombustibles"
})
public class CargaCombustibles {

	@XmlElement(name = "cargaCombustible")
    protected ArrayList<CargaCombustible> cargaCombustibles;

    public CargaCombustibles() {
    	cargaCombustibles = null;
	}

    public CargaCombustibles(java.sql.Connection conn, Long idUsuario, String fechaModificacion) {
		seek(conn, idUsuario, fechaModificacion);
	}

    public List<CargaCombustible> getCargaCombustibles() {
		if (cargaCombustibles == null) {
			cargaCombustibles = new ArrayList<CargaCombustible>();
		}
		return cargaCombustibles;
	}

    private void seek(java.sql.Connection conn, Long idUsuario, String fechaModificacion) {
    	
    	ArrayList<AbstractMap.SimpleEntry<String, String>> listParameters;
    	
    	try {
			listParameters = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
			
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("id_usuario", String.valueOf(idUsuario)));
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("mas reciente", fechaModificacion));
			
			this.cargaCombustibles = CargaCombustible.seek(conn, listParameters, null, null, 0, 10000);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
