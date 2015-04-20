package cl.dsoft.car.mobile.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "ImageData")
public class ImageData {

	@Element(required = true)
	Integer id;
	@Element
	Vigencia vigencia;
	@Element(required = true)
	String data;
	
	public ImageData() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the vigencia
	 */
	public Vigencia getVigencia() {
		return vigencia;
	}

	/**
	 * @param vigencia the vigencia to set
	 */
	public void setVigencia(Vigencia vigencia) {
		this.vigencia = vigencia;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

}
