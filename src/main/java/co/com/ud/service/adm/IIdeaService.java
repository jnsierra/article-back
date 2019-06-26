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
}
