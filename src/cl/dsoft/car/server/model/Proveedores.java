package cl.dsoft.car.server.model;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import cl.dsoft.car.misc.CarUtil;
import cl.dsoft.car.misc.MyCarException;
import cl.dsoft.car.server.db.Comuna;
import cl.dsoft.car.server.db.ConsultaProveedor;
import cl.dsoft.car.server.db.Proveedor;
import cl.dsoft.car.server.db.ProveedorMantencionBase;

@XmlType(name = "Proveedores", propOrder = {
	    "proveedores"
})
public class Proveedores {

	@XmlElement(name = "proveedor")
    protected ArrayList<Proveedor> proveedores;

	public Proveedores() {
		// TODO Auto-generated constructor stub
	}

    public Proveedores(java.sql.Connection conn, ConsultaProveedor consultaProveedor) {
		seek(conn, consultaProveedor);
	}

    /**
	 * @return the respuestaProveedores
	 */
	public List<Proveedor> getProveedores() {
		if (proveedores == null) {
			proveedores = new ArrayList<Proveedor>();
		}
		return proveedores;
	}

	/**
	 * @param respuestaProveedores the respuestaProveedores to set
	 */
	public void setProveedores(
			ArrayList<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
	
	private void seek(java.sql.Connection conn, ConsultaProveedor consultaProveedor) {
    	
    	ArrayList<AbstractMap.SimpleEntry<String, String>> listParameters;
    	TreeMap<Double, Proveedor> treeMap;
    	ArrayList<ProveedorMantencionBase> lst_pmb;
    	Properties prop = new Properties();
    	InputStream input = null;
    	
    	try {
			listParameters = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
			treeMap = new TreeMap<Double, Proveedor>();
			this.proveedores = new ArrayList<Proveedor>();
			
    		String filename = "config.properties";
    		input = Proveedores.class.getClassLoader().getResourceAsStream(filename);
    		if(input==null){
    	        throw new MyCarException("Archivo " + filename + " no encontrado");
    		}
 
    		//load a properties file from class path, inside static method
    		prop.load(input);
    		
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("id_mantencion_base", String.valueOf(consultaProveedor.getIdMantencionBase())));
			//listParameters.add(new AbstractMap.SimpleEntry<String, String>("mas reciente", fechaModificacion));
			
			lst_pmb = ProveedorMantencionBase.seek(conn, listParameters, null, null, 0, 10000);
			
			for (ProveedorMantencionBase pmb : lst_pmb) {
				Proveedor p = Proveedor.getById(conn, String.valueOf(pmb.getIdProveedor()));
				// calculo la distancia entre el proveedor y el usuario
				double distance = CarUtil.distFrom(consultaProveedor.getLatitud(), consultaProveedor.getLongitud(), p.getLatitud(), p.getLongitud());
				// agrego el par ditancia, proveedor a un arreglo ordenado
				treeMap.put(distance, p);
			}
			
			for(Map.Entry<Double,Proveedor> tm : treeMap.entrySet()) {
				Double key = tm.getKey();
				Proveedor p = tm.getValue();

				System.out.println(key + " => " + p);
				
				this.proveedores.add(p);
				
				if (this.proveedores.size() == Integer.valueOf(prop.getProperty("max_proveedores_retornados"))) {
					break;
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }


}
