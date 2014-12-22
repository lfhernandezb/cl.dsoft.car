package cl.dsoft.car.server.model;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import cl.dsoft.car.server.db.Recordatorio;

@XmlType(name = "Recordatorios", propOrder = {
	    "recordatorios"
})
public class Recordatorios {

	@XmlElement(name = "recordatorio")
    protected ArrayList<Recordatorio> recordatorios;

    public Recordatorios() {
		recordatorios = null;
	}

    public Recordatorios(java.sql.Connection conn, Long idUsuario, String fechaModificacion) {
		seek(conn, idUsuario, fechaModificacion);
	}

    public List<Recordatorio> getRecordatorios() {
		if (recordatorios == null) {
			recordatorios = new ArrayList<Recordatorio>();
		}
		return recordatorios;
	}

    private void seek(java.sql.Connection conn, Long idUsuario, String fechaModificacion) {
    	
    	ArrayList<AbstractMap.SimpleEntry<String, String>> listParameters;
    	
    	try {
			listParameters = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
			
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("id_usuario", String.valueOf(idUsuario)));
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("mas reciente", fechaModificacion));
			
			this.recordatorios = Recordatorio.seek(conn, listParameters, null, null, 0, 10000);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
