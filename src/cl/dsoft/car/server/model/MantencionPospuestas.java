package cl.dsoft.car.server.model;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import cl.dsoft.car.server.db.MantencionPospuesta;

@XmlType(name = "MantencionPospuestas", propOrder = {
	    "mantencionPospuestas"
})
public class MantencionPospuestas {

	@XmlElement(name = "mantencionPospuesta")
    protected ArrayList<MantencionPospuesta> mantencionPospuestas;

    public MantencionPospuestas() {
		mantencionPospuestas = null;
	}

    public MantencionPospuestas(java.sql.Connection conn, Long idBase, String fechaModificacion) {
		seek(conn, idBase, fechaModificacion);
	}

    public List<MantencionPospuesta> getMantencionPospuestas() {
		if (mantencionPospuestas == null) {
			mantencionPospuestas = new ArrayList<MantencionPospuesta>();
		}
		return mantencionPospuestas;
	}

    private void seek(java.sql.Connection conn, Long idBase, String fechaModificacion) {
    	
    	ArrayList<AbstractMap.SimpleEntry<String, String>> listParameters;
    	
    	try {
			listParameters = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
			
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("id_usuario", String.valueOf(idBase)));
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("mas reciente", fechaModificacion));
			
			this.mantencionPospuestas = MantencionPospuesta.seek(conn, listParameters, null, null, 0, 10000);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
