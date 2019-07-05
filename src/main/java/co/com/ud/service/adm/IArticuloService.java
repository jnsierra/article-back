package co.com.ud.service.adm;

import java.util.List;
import java.util.Optional;

import co.com.ud.adm.dto.profesor.NotificacionProfDto;
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
	/**
	 * Metodo con el cual cuento las notificaciones que tiene cada estudiante 
	 * @param idAlumno
	 * @return
	 */
	Integer getCountNotificationAlum(Long idAlumno);
	/**
	 * Metodo con el cual por medio del id de profesor obtiene el id de las ideas
	 * @param idProf
	 * @return
	 */
	List<NotificacionProfDto> getTitulosNotifProf(Long idProf);
	/**
	 * Metodo con el cual por medio del id del alumno obtiene los titulos de las ideas
	 * @param idAlumno
	 * @return
	 */
	List<NotificacionProfDto> getTitulosNotifAlum(Long idAlumno);
	/**
	 * Metodo con el cual obtengo un articulo por medio de su id
	 * @param id
	 * @return
	 */
	Optional<ArticuloEntity> getById(Long id);
	/**
	 * Metodo con el cual actualizo el estado de un articulo
	 * @param id
	 * @param estado
	 * @return
	 */
	Boolean updateEstadoById(Long id, String estado);

}
