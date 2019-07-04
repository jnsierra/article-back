package co.com.ud.adm.dto.profesor;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NotificacionProfDto {
	
	private Long idArticulo;
	private String tituloIdea;
	
	public static NotificacionProfDto of(Long id, String tituloIdea) {
		NotificacionProfDto notificacion = new NotificacionProfDto();
		notificacion.setIdArticulo(id);
		notificacion.setTituloIdea(tituloIdea);
		return notificacion;
	}

}
