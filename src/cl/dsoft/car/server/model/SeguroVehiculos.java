package cl.dsoft.car.server.model;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import cl.dsoft.car.server.db.SeguroVehiculo;

@XmlType(name = "SeguroVehiculos", propOrder = {
	    "seguroVehiculos"
})
public class SeguroVehiculos {

	@XmlElement(name = "seguroVehiculo")
    protected ArrayList<SeguroVehiculo> seguroVehiculos;

    public SeguroVehiculos() {
    	seguroVehiculos = null;
	}

    public SeguroVehiculos(java.sql.Connection conn, Long idUsuario, String fechaModificacion) {
		seek(conn, idUsuario, fechaModificacion);
	}

    public List<SeguroVehiculo> getSeguroVehiculos() {
		if (seguroVehiculos == null) {
			seguroVehiculos = new ArrayList<SeguroVehiculo>();
		}
		return seguroVehiculos;
	}

    private void seek(java.sql.Connection conn, Long idUsuario, String fechaModificacion) {
    	
    	ArrayList<AbstractMap.SimpleEntry<String, String>> listParameters;
    	
    	try {
			listParameters = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
			
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("id_usuario", String.valueOf(idUsuario)));
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("mas reciente", fechaModificacion));
			
			this.seguroVehiculos = SeguroVehiculo.seek(conn, listParameters, null, null, 0, 10000);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
