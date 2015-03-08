package cl.dsoft.car.server.model;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import cl.dsoft.car.server.db.Parametro;

@XmlType(name = "Parametros", propOrder = {
	    "parametros"
})
public class Parametros {

	@XmlElement(name = "parametro")
    protected ArrayList<Parametro> parametros;

    public Parametros() {
		parametros = null;
	}

    public Parametros(java.sql.Connection conn, Long idBase, String fechaModificacion) {
		seek(conn, idBase, fechaModificacion);
	}

    public List<Parametro> getParametros() {
		if (parametros == null) {
			parametros = new ArrayList<Parametro>();
		}
		return parametros;
	}

    private void seek(java.sql.Connection conn, Long idBase, String fechaModificacion) {
    	
    	ArrayList<AbstractMap.SimpleEntry<String, String>> listParameters;
    	
    	try {
			listParameters = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
			
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("id_usuario", String.valueOf(idBase)));
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("mas reciente", fechaModificacion));
			
			this.parametros = Parametro.seek(conn, listParameters, null, null, 0, 10000);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
