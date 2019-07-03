package co.com.ud.service.adm;

import co.com.ud.repository.entity.ArticuloEntity;

public interface IArticuloService {
	/**
	 * Metodo con el cual persisto la informacion de un articulo
	 * @param articulo
	 * @return
	 */
	ArticuloEntity guardarArticulo(ArticuloEntity articulo);
	/**
	 * Metodo con el cual cuento las notificaciones que tiene cada profesor
	 * @param idProf
	 * @return
	 */
	Integer getCountNotificationProf(Long idProf);

}
