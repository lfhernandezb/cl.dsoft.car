package cl.dsoft.car.server.model;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import cl.dsoft.car.server.db.Vehiculo;

@XmlType(name = "Vehiculos", propOrder = {
	    "vehiculos"
})
public class Vehiculos {

	@XmlElement(name = "vehiculo")
    protected ArrayList<Vehiculo> vehiculos;

    public Vehiculos() {
		vehiculos = null;
	}

    public Vehiculos(java.sql.Connection conn, Long idUsuario, String fechaModificacion) {
		seek(conn, idUsuario, fechaModificacion);
	}

    public List<Vehiculo> getVehiculos() {
		if (vehiculos == null) {
			vehiculos = new ArrayList<Vehiculo>();
		}
		return vehiculos;
	}

    private void seek(java.sql.Connection conn, Long idUsuario, String fechaModificacion) {
    	
    	ArrayList<AbstractMap.SimpleEntry<String, String>> listParameters;
    	
    	try {
			listParameters = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
			
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("id_usuario", String.valueOf(idUsuario)));
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("mas reciente", fechaModificacion));
			
			this.vehiculos = Vehiculo.seek(conn, listParameters, null, null, 0, 10000);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
