package cl.dsoft.car.server.model;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import cl.dsoft.car.server.db.MantencionUsuario;

@XmlType(name = "MantencionUsuarios", propOrder = {
	    "mantencionUsuarios"
})
public class MantencionUsuarios {

	@XmlElement(name = "mantencionUsuario")
    protected ArrayList<MantencionUsuario> mantencionUsuarios;

    public MantencionUsuarios() {
		mantencionUsuarios = null;
	}

    public MantencionUsuarios(java.sql.Connection conn, Long idUsuario, String fechaModificacion) {
		seek(conn, idUsuario, fechaModificacion);
	}

    public List<MantencionUsuario> getMantencionUsuarios() {
		if (mantencionUsuarios == null) {
			mantencionUsuarios = new ArrayList<MantencionUsuario>();
		}
		return mantencionUsuarios;
	}

    private void seek(java.sql.Connection conn, Long idUsuario, String fechaModificacion) {
    	
    	ArrayList<AbstractMap.SimpleEntry<String, String>> listParameters;
    	
    	try {
			listParameters = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
			
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("id_usuario", String.valueOf(idUsuario)));
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("mas reciente", fechaModificacion));
			
			this.mantencionUsuarios = MantencionUsuario.seek(conn, listParameters, null, null, 0, 10000);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
