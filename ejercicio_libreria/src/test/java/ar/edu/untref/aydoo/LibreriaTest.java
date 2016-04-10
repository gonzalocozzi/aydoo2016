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

}
