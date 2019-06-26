package co.com.ud.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "id_ideas")
@NamedQueries({
	@NamedQuery(name = "IdeaEntity.buscarIdeasPorUsuario", query = "select idea from IdeaEntity idea inner join fetch idea.usuario us where us.id = :idUsuario")
})
@Getter
@Setter
public class IdeaEntity extends Auditable<String>{
	@Id
	@Column(name = "id", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idea_generator")
	@SequenceGenerator(name = "idea_generator", sequenceName = "idea_seq", allocationSize = 1)
	private Long id;
	@Column(name = "titulo", length = 300)
	private String titulo;
	@Column(name = "contenido", length = 2500)
	private String contenido;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id",nullable = false)
	private UsuarioEntity usuario;
	@Column(name = "profesor_id", nullable = false)
	private Long idProfesor;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdeaEntity other = (IdeaEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}