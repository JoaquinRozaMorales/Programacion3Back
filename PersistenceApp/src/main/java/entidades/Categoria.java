package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

//import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "categoria")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Audited
public class Categoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "denominacion")
	private String denominacion;
	

	public Categoria(String denominacion) {
		super();
		this.denominacion = denominacion;
	}


	
	@ManyToMany(mappedBy="categoria")
	@Default
	private List<Articulos> articulos= new ArrayList<Articulos>();

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	
	
	
}
