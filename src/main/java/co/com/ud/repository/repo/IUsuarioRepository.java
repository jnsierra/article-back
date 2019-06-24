package co.com.ud.repository.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.ud.repository.entity.UsuarioEntity;

@Repository
public interface IUsuarioRepository extends CrudRepository<UsuarioEntity, Long>, JpaRepository<UsuarioEntity, Long> {
	/**
	 * Metodo con el cual busco un usuario por medio de su usario y contrasena
	 * 
	 * @param correo
	 * @param contrasena
	 * @return
	 */
	Optional<UsuarioEntity> findByCorreoAndContrasenaAllIgnoreCase(String correo, String contrasena);
	/**
	 * Metodo con el cual obtengo un usuario por medio de su correo
	 * @param correo
	 * @return
	 */
	Optional<UsuarioEntity> findByCorreoAllIgnoreCase(String correo);

}
