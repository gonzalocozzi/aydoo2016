package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LibroTest {

	private Libro miLibro;

	@Before
	public void inicializar() throws NegativePriceException {
		
		miLibro = new Libro("El Hobbit", 75.50);
	}

	@Test
	public void elPrecioEsCorrecto() {
		
		double precioDelLibro = miLibro.getPrecio();
		
		Assert.assertEquals(75.50, precioDelLibro, 0.0);
	}

	@Test
	public void elNombreEsCorrecto() {
		
		String nombreDelLibro = miLibro.getNombre();
		
		Assert.assertEquals("El Hobbit", nombreDelLibro);
	}

	@Test(expected = NegativePriceException.class)
	public void elPrecioEsIncorrecto() throws NegativePriceException {
		
		Producto unLibro = new Libro("La Cupula", 90.0);
		unLibro.setPrecio(-80.0);
	}

	@Test
	public void elCambioDeNombreEsCorrecto() {
		
		miLibro.setNombre("El señor de los Anillos: las dos Torres");
		
		String nombreDelLibro = miLibro.getNombre();
		
		Assert.assertEquals("El señor de los Anillos: las dos Torres", nombreDelLibro);
	}

}
