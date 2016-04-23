package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LibroTest {

	private Libro miLibro;

	@Before
	public void inicializar() {
		miLibro = new Libro("El Hobbit", 75.50);
	}

	@Test
	public void ElPrecioEsCorrecto() {
		Assert.assertEquals(75.50, miLibro.getPrecio(), 0.1);
	}

	@Test
	public void ElNombreEsCorrecto() {
		Assert.assertEquals("El Hobbit", miLibro.getNombre());
	}

	@Test(expected = Error.class)
	public void elPrecioEsIncorrecto() {
		Producto unLibro = new Libro("La Cupula", 90.0);
		unLibro.setPrecio(-80.0);
	}

	@Test
	public void ElCambioDeNombreEsCorrecto() {
		miLibro.setNombre("El señor de los Anillos: las dos Torres");
		Assert.assertEquals("El señor de los Anillos: las dos Torres", miLibro.getNombre());
	}

}
