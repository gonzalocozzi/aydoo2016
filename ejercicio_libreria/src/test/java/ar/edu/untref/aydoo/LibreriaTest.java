package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class LibreriaTest {

	@Test
	public void seAgregaNombreALaLibreria() {

		Libreria libreria = new Libreria(null, null);

		libreria.setNombre("el papiro");

		Assert.assertEquals("el papiro", libreria.getNombre());
	}

	@Test
	public void seAgregaDirecccionALaLibreria() {

		Libreria libreria = new Libreria(null, null);

		libreria.setDireccion("Gelly y Obes 2740, CABA");

		Assert.assertEquals("Gelly y Obes 2740, CABA", libreria.getDireccion());
	}
	
	@Test
	public void seAgregaNombreALaLibreriaAlSerCreada() {

		Libreria libreria = new Libreria("el papiro", null);

		Assert.assertEquals("el papiro", libreria.getNombre());
	}
	
	@Test
	public void seAgregaDirecccionALaLibreriaAlSerCreada() {

		Libreria libreria = new Libreria(null, "Gelly y Obes 2740, CABA");

		Assert.assertEquals("Gelly y Obes 2740, CABA", libreria.getDireccion());
	}
	
	@Test
	public void libreriaAgregaClienteASuListaDeClientesRegistrados() {
		
		Libreria libreria = new Libreria("el papiro", "Gelly y Obes 2740, CABA");
		Cliente cliente = new Cliente("juan perez", "Montes de Oca 4720, CABA");
		
		libreria.agregarCliente(cliente);
		
		Assert.assertTrue(libreria.esClienteRegistrado(cliente));
	}
	
	@Test
	public void libreriaIndicaElMontoACobrarAUnClienteSinSuscripcionesEnUnMesDeterminado() throws Exception{
		
		Libreria libreria = new Libreria("el papiro", "Gelly y Obes 2740, CABA");
		Cliente cliente = new Cliente("juan perez", "Montes de Oca 4720, CABA");
		libreria.agregarCliente(cliente);
		Compra compra = new Compra(Mes.AGOSTO);
		cliente.agregarCompra(compra);
		Producto elhobbit = new Libro("el hobbit", 50.0);
		Producto lapicera1 = new ArticuloDeLibreria("bic", 5.0);
		Producto lapicera2 = new ArticuloDeLibreria("bic", 5.0);
		Producto elgrafico = new Revista("el grafico", 30.0, 1);
		compra.agregarProducto(elhobbit);
		compra.agregarProducto(lapicera1);
		compra.agregarProducto(lapicera2);
		compra.agregarProducto(elgrafico);
		
		Assert.assertEquals(92.1, libreria.calcularMontoACobrar(cliente,  Mes.AGOSTO), 0.0);
	}
	
	@Test
	public void libreriaIndicaElMontoACobrarAUnClienteConSuscripcionAnualEnUnMesDeterminado() throws Exception{
		
		Libreria libreria = new Libreria("el papiro", "Gelly y Obes 2740, CABA");
		Cliente cliente = new Cliente("maria gutierrez", "Nueva York 1572, CABA");
		libreria.agregarCliente(cliente);
		Compra compra = new Compra(Mes.ENERO);
		Compra suscripcion = new Suscripcion(Mes.ENERO);
		((Suscripcion) suscripcion).hacerAnual();
		cliente.agregarCompra(compra);
		cliente.agregarCompra(suscripcion);
		Producto barcelona = new Revista("barcelona", 20.0, 2);
		Producto pagina12 = new Periodico("pagina 12", 12.0, 30);
		suscripcion.agregarProducto(barcelona);
		compra.agregarProducto(pagina12);
		
		Assert.assertEquals(44.0, libreria.calcularMontoACobrar(cliente,  Mes.ENERO), 0.0);
	}

}
