package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumns;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

//import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "articulos")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Audited
public class Articulos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "denominacion")
	@NonNull private String denominacion;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;

	@Column(name = "precio")
	private int precio;
	
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name= "articulo_categoria", 
			joinColumns= @JoinColumn(name = "articulo_id"),
			inverseJoinColumns= @JoinColumn(name = "categoria_id"))
	@Default
	private List<Categoria> categoria= new ArrayList<Categoria>();
	
	@OneToMany(mappedBy= "articulos", cascade = CascadeType.PERSIST)
	@Default
	private List<DetalleFactura> detalle = new ArrayList<DetalleFactura>();

	
}
