package cl.dsoft.car.server.model;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import cl.dsoft.car.server.db.CambioRevision;

@XmlType(name = "CambioRevisions", propOrder = {
	    "cambioRevisions"
})
public class CambioRevisions {

	@XmlElement(name = "cambioRevision")
    protected ArrayList<CambioRevision> cambioRevisions;

    public CambioRevisions() {
		cambioRevisions = null;
	}

    public CambioRevisions(java.sql.Connection conn, Long idBase, String fechaModificacion) {
		seek(conn, idBase, fechaModificacion);
	}

    public List<CambioRevision> getCambioRevisions() {
		if (cambioRevisions == null) {
			cambioRevisions = new ArrayList<CambioRevision>();
		}
		return cambioRevisions;
	}

    private void seek(java.sql.Connection conn, Long idBase, String fechaModificacion) {
    	
    	ArrayList<AbstractMap.SimpleEntry<String, String>> listParameters;
    	
    	try {
			listParameters = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
			
			//listParameters.add(new AbstractMap.SimpleEntry<String, String>("id_usuario", String.valueOf(idBase)));
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("mas reciente", fechaModificacion));
			
			this.cambioRevisions = CambioRevision.seek(conn, listParameters, null, null, 0, 10000);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}