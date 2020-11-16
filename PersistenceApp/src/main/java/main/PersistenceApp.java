package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Articulos;
import entidades.Categoria;
import entidades.Cliente;
import entidades.DetalleFactura;
import entidades.Domicilio;
import entidades.Factura;

public class PersistenceApp {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceAppPU");	
		EntityManager em = emf.createEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			/*Domicilio dom = Domicilio.builder().nombreCalle("luis marco").numero(1324).build();
			Factura factura1 = Factura.builder().numero(15).fecha("15/08/2001").build();
			Cliente cliente = Cliente.builder().nombre("Joaquin").apellido("Roza").dni(43152046).domicilio(dom).build();
			
			dom.setCliente(cliente);
			factura1.setCliente(cliente);
			
			Categoria perecederos = Categoria.builder().denominacion("Perecederos").build();
			Categoria lacteos = Categoria.builder().denominacion("Lacteos").build();
			Categoria limpieza = Categoria.builder().denominacion("Limpieza").build();
			
			Articulos art1 = Articulos.builder().cantidad(20).precio(200).denominacion("yogurt Ser").build();
			Articulos art2 = Articulos.builder().cantidad(80).precio(300).denominacion("detergente Magistral").build();
			System.out.println("bien");
			art1.getCategoria().add(perecederos);
			art1.getCategoria().add(lacteos);
			lacteos.getArticulos().add(art1);
			perecederos.getArticulos().add(art1);
			
			art2.getCategoria().add(limpieza);
			limpieza.getArticulos().add(art2);
			
			DetalleFactura det1 = DetalleFactura.builder().articulos(art1).cantidad(2).subtotal(40).build();
			DetalleFactura det2 = DetalleFactura.builder().articulos(art2).cantidad(1).subtotal(80).build();
			
			art1.getDetalle().add(det1);
			factura1.getDetalles().add(det1);
			det1.setFactura(factura1);
			
			art2.getDetalle().add(det2);
			factura1.getDetalles().add(det2);
			det2.setFactura(factura1);
			
			factura1.setTotal(120);*/
			
			Factura factura1 = em.find(Factura.class, 1L);
			//factura1.setNumero(21);
			
			
			System.out.println("exitoso creado");
			
			em.remove(factura1);
			
			em.flush();
			
			em.getTransaction().commit();
			
		}catch (Exception e) {
			System.out.println("no se creo");
			em.getTransaction().rollback();
		}
		
		em.close();
		emf.close();
	}
}
