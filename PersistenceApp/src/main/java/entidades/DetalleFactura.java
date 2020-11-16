package entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

//import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detallefactura")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Audited
public class DetalleFactura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "cantidad")
	private int cantidad;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	

	@ManyToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name="fk_articulos")
	private Articulos articulos;
	
	@ManyToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name="fk_factura")
	private Factura factura;

	@Column(name = "subtotal")
	private int subtotal;

}
