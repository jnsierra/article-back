package co.com.ud.repository.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.ud.repository.entity.ArticuloEntity;

@Repository
public interface IArticuloRepository extends CrudRepository<ArticuloEntity, Long>, JpaRepository<ArticuloEntity, Long> {
	/**
	 * Metodo con el cual cuento las notificaciones que tiene cada profesor
	 * @param idProf
	 * @return
	 */
	Integer getCountNotificationProf(@Param("idProf") Long idProf);
	/**
	 * Metodo con el cual obtengo las ideas que tiene asignado un profesor
	 * @param idProf
	 * @return
	 */
	List<ArticuloEntity> getIdeasNotifiByProf(@Param("idProf")Long idProf);
	/**
	 * Metodo con el cual actualizo el estado de un articulo
	 * @param id
	 * @param estado
	 * @return
	 */
	@Modifying
	@Transactional
	Integer updateEstado(@Param("id") Long id, @Param("estado") String estado);
}