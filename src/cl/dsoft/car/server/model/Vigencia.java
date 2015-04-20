package cl.dsoft.car.server.model;

import javax.xml.bind.annotation.XmlAttribute;

public class Vigencia {
	
	
	String inicio;
	
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
	@XmlAttribute
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
	@XmlAttribute
	public void setFin(String fin) {
		this.fin = fin;
	}

}
