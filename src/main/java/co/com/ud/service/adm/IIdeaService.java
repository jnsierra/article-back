package co.com.ud.service.adm;

import java.util.List;

import co.com.ud.repository.entity.IdeaEntity;

public interface IIdeaService {
	/**
	 * Metodo con el cual guardo una idea en el sistema para un usuario
	 * 
	 * @param idea
	 * @return
	 */
	IdeaEntity guardarIdea(IdeaEntity idea);

	/**
	 * Metodo con el cual obtengo la idea por medio del id del usuario
	 * 
	 * @param id
	 * @return
	 */
	List<IdeaEntity> getIdeaByUsuario(Long id);
	/**
	 * Metodo con el cual obtengo todas las ideas que debe reviar un profesor
	 * @param estado
	 * @param idProfesor
	 * @return
	 */
	List<IdeaEntity> getIdeaByProfesorAndEstado(String estado, Long idProfesor);
	/**
	 * Metodo con el cual se cambia el estado de una idea
	 * @param idIdea
	 * @param estado
	 * @return
	 */
	Boolean updateEstadoIdea(Long idIdea, String estado, Long idProfAut);
}
