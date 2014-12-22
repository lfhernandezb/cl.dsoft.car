package cl.dsoft.car.server.model;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import cl.dsoft.car.server.db.MantencionUsuarioHecha;

@XmlType(name = "MantencionUsuarioHechas", propOrder = {
	    "mantencionUsuarioHechas"
})
public class MantencionUsuarioHechas {

	@XmlElement(name = "mantencionUsuarioHecha")
    protected ArrayList<MantencionUsuarioHecha> mantencionUsuarioHechas;

    public MantencionUsuarioHechas() {
		mantencionUsuarioHechas = null;
	}

    public MantencionUsuarioHechas(java.sql.Connection conn, Long idUsuario, String fechaModificacion) {
		seek(conn, idUsuario, fechaModificacion);
	}

    public List<MantencionUsuarioHecha> getMantencionUsuarioHechas() {
		if (mantencionUsuarioHechas == null) {
			mantencionUsuarioHechas = new ArrayList<MantencionUsuarioHecha>();
		}
		return mantencionUsuarioHechas;
	}

    private void seek(java.sql.Connection conn, Long idUsuario, String fechaModificacion) {
    	
    	ArrayList<AbstractMap.SimpleEntry<String, String>> listParameters;
    	
    	try {
			listParameters = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
			
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("id_usuario", String.valueOf(idUsuario)));
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("mas reciente", fechaModificacion));
			
			this.mantencionUsuarioHechas = MantencionUsuarioHecha.seek(conn, listParameters, null, null, 0, 10000);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
