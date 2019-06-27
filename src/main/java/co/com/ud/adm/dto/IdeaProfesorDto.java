package co.com.ud.adm.dto;

import co.com.ud.repository.entity.enumeracion.ESTADO_IDEA;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class IdeaProfesorDto {
	
	private Long id;
	private String titulo;
	private String contenido;
	private Long idProfesor;
	private ESTADO_IDEA estado;
	private UsuarioDto alumno;

}
