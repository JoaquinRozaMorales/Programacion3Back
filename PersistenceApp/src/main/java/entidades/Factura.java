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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

//import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "factura")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Audited
public class Factura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String fecha;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numero")
	private int numero;

	@Column(name = "total")
	private int total;

	
	@OneToMany(mappedBy="factura",cascade= CascadeType.ALL, orphanRemoval = true)
	@Default
	private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();

	
	@ManyToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name="fk_cliente")
	private Cliente cliente;


	
	
}
