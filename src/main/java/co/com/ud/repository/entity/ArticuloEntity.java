package co.com.ud.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "id_articulo")
@NamedQueries({
	@NamedQuery(name = "ArticuloEntity.getCountNotificationProf", query = "SELECT count(*) FROM ArticuloEntity art inner join art.idea as ide WHERE art.estado = 'ENVIADO_POR_CORRECCIONES' AND ide.idProfesor = :idProf  "),
	@NamedQuery(name = "ArticuloEntity.getIdeasNotifiByProf", query = "SELECT art FROM ArticuloEntity art inner join fetch art.idea as ide WHERE art.estado = 'ENVIADO_POR_CORRECCIONES' AND ide.idProfesor = :idProf"),
	@NamedQuery(name = "ArticuloEntity.updateEstado", query = "update ArticuloEntity art set art.estado = :estado WHERE id = :id")
})
@Getter @Setter
public class ArticuloEntity extends Auditable<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "articulo_generator")
	@SequenceGenerator(name = "articulo_generator", sequenceName = "articulo_seq", allocationSize = 1)
	private Long id;
	@Column(name = "resumen_ingles")
	private String resumenIngles;
	@Column(name = "resumen_espanol")
	private String resumenEspanol;
	@Column(name = "contenido")
	private String contenido;
	@Column(name = "estado")
	private String estado;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idea_id")
	private IdeaEntity idea;

}
