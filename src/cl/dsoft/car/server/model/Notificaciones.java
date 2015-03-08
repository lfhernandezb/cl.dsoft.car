package cl.dsoft.car.server.model;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import cl.dsoft.car.server.db.Notificacion;

@XmlType(name = "Notificaciones", propOrder = {
	    "notificaciones"
})
public class Notificaciones {

	@XmlElement(name = "notificacion")
    protected ArrayList<Notificacion> notificaciones;

    public Notificaciones() {
		notificaciones = null;
	}

    public Notificaciones(java.sql.Connection conn, Long idBase, String fechaModificacion) {
		seek(conn, idBase, fechaModificacion);
	}

    public List<Notificacion> getNotificaciones() {
		if (notificaciones == null) {
			notificaciones = new ArrayList<Notificacion>();
		}
		return notificaciones;
	}

    private void seek(java.sql.Connection conn, Long idBase, String fechaModificacion) {
    	
    	ArrayList<AbstractMap.SimpleEntry<String, String>> listParameters;
    	
    	try {
			listParameters = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
			
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("id_usuario", String.valueOf(idBase)));
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("mas reciente", fechaModificacion));
			
			this.notificaciones = Notificacion.seek(conn, listParameters, null, null, 0, 10000);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
