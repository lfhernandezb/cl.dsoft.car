/**
 * 
 */
package cl.dsoft.car.server.model;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.simpleframework.xml.Order;

/**
 * @author lfhernandez
 *
 */
@XmlRootElement(name = "ImageData")
@XmlType(propOrder = { "id", "vigencia", "data"})
public class ImageData {

	/**
	 * 
	 */
	Integer id;
	Vigencia vigencia;
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
	@XmlElement
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
        JAXBContext jc;
        StringWriter stringWriter = new StringWriter();
        
		try {
			jc = JAXBContext.newInstance(String.class, CarData.class);
	        Marshaller marshaller = jc.createMarshaller();

	        marshaller.marshal(this, stringWriter);
	        
	        
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return stringWriter.toString();
		}
        
        

	}

}
