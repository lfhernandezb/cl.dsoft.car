/**
 * 
 */
package cl.dsoft.car.mobile.model;

import java.sql.Connection;
import java.sql.SQLException;

import cl.dsoft.car.mobile.db.CambioRevision;


/**
 * @author lfhernandez
 *
 */
public class CambioRevisionModelo extends CambioRevision {

	/**
	 * 
	 */
	public CambioRevisionModelo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    public static CambioRevision getByIdCambio(Connection p_conn, String p_id_cambio) throws SQLException {
        return getByParameter(p_conn, "id_cambio", p_id_cambio);
    }
	

}
