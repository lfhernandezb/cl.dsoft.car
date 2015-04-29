package cl.dsoft.car.server.model;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import cl.dsoft.car.server.db.VwCampaniaUsuario;

@XmlType(name = "VwCampaniaUsuarios", propOrder = {
	    "vwCampaniaUsuarios"
})
public class VwCampaniaUsuarios {

	@XmlElement(name = "vwCampaniaUsuario")
    protected ArrayList<VwCampaniaUsuario> vwCampaniaUsuarios;

    public VwCampaniaUsuarios() {
    	vwCampaniaUsuarios = null;
	}

    public VwCampaniaUsuarios(java.sql.Connection conn, Long idBase, String fechaModificacion) {
		seek(conn, idBase, fechaModificacion);
	}

    /**
	 * @return the vCampaniaUsuarios
	 */
	public ArrayList<VwCampaniaUsuario> getVwCampaniaUsuarios() {
		if (vwCampaniaUsuarios == null) {
			vwCampaniaUsuarios = new ArrayList<VwCampaniaUsuario>();
		}
		return vwCampaniaUsuarios;
	}

    private void seek(java.sql.Connection conn, Long idBase, String fechaModificacion) {
    	
    	ArrayList<AbstractMap.SimpleEntry<String, String>> listParameters;
    	
    	try {
			listParameters = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
			
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("id_usuario", String.valueOf(idBase)));
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("mas reciente", fechaModificacion));
			
			this.vwCampaniaUsuarios = VwCampaniaUsuario.seek(conn, listParameters, null, null, 0, 10000);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
