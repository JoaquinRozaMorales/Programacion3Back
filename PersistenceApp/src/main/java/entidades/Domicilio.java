package entidades;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

//import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "domicilio")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Audited
public class Domicilio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombreCalle")
	private String nombreCalle;
	
	@Column(name = "numero")
	private int numero;
	
	@Exclude
	@OneToOne(mappedBy="domicilio")
	private Cliente cliente;

}