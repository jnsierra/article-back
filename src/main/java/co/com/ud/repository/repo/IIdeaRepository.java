package co.com.ud.repository.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.ud.repository.entity.IdeaEntity;
import co.com.ud.repository.entity.enumeracion.ESTADO_IDEA;

@Repository
public interface IIdeaRepository extends CrudRepository<IdeaEntity, Long>, JpaRepository<IdeaEntity, Long> {
	/**
	 * Metodo con el cual se busca las ideas de un usuario
	 * 
	 * @param idUsuario
	 * @return
	 */
	List<IdeaEntity> buscarIdeasPorUsuario(@Param("idUsuario") Long idUsuario);

	/**
	 * Metodo con el cual se buscan las ideas que tiene por revisar un profesor por
	 * medio de su estado
	 * 
	 * @param idProfesor
	 * @param estado
	 * @return
	 */
	List<IdeaEntity> buscarIdeaByProfesorAndEstado(@Param("idProfesor")Long idProfesor,@Param("estado") ESTADO_IDEA estado);
	/**
	 * Metodo con el cual se buscan las ideas que tiene por revisar un profesor por
	 * medio de su estado
	 * 
	 * @param idProfesor
	 * @param estado
	 * @return
	 */
	List<IdeaEntity> buscarIdeaByProfesor(@Param("idProfesor")Long idProfesor);
}
