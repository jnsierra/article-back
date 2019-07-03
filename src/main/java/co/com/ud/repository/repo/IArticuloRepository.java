package co.com.ud.repository.repo;

import org.springframework.data.jpa.repository.JpaRepository;
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
}