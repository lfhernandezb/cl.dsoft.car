package cl.dsoft.car.mobile.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

public class Vigencia {

	@Attribute(required = true)
	String inicio;
	@Attribute(required = true)
	String fin;
	
	public Vigencia() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the inicio
	 */
	public String getInicio() {
		return inicio;
	}

	/**
	 * @param inicio the inicio to set
	 */
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	/**
	 * @return the fin
	 */
	public String getFin() {
		return fin;
	}

	/**
	 * @param fin the fin to set
	 */
	public void setFin(String fin) {
		this.fin = fin;
	}

}
