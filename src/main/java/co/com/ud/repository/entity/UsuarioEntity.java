package co.com.ud.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import co.com.ud.repository.entity.enumeracion.TipoUsuario;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "us_usuario",uniqueConstraints = {
		@UniqueConstraint(columnNames = "email", name = "UK_USUARIO_EMAIL")
} )
@Getter @Setter @ToString
public class UsuarioEntity {
	
	@Id
	@Column(name = "id", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_generator")
	@SequenceGenerator(name = "usuario_generator", sequenceName = "usuario_seq", allocationSize = 1)
	private Long id;
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "email")
	private String correo;
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "password")
	private String contrasena;
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name = "name")
	private String nombre;
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(name = "cambioContra")
	private String cambioContra;
	@Enumerated(EnumType.STRING)
	@Column(name = "tipoUsuario")
	private TipoUsuario tipoUsuario;
}
