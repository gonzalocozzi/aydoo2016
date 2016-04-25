package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArticuloDeLibreriaTest {

	private ArticuloDeLibreria miArticuloDeLibreria;

	@Before
	public void inicializar() throws NegativePriceException {
		miArticuloDeLibreria = new ArticuloDeLibreria("Lapicera", 10.0);
	}

	@Test
	public void ElPrecioEsCorrectoConIvaIncluido() {
		Assert.assertEquals(12.1, miArticuloDeLibreria.getPrecio(), 0.1);
	}

	@Test
	public void ElNombreEsCorrecto() {
		Assert.assertEquals("Lapicera", miArticuloDeLibreria.getNombre());
	}

	@Test(expected = NegativePriceException.class)
	public void elPrecioEsIncorrecto() throws NegativePriceException {
		Producto unArticuloDeLibreria = new ArticuloDeLibreria("Lapicera", 10.0);
		unArticuloDeLibreria.setPrecio(-10.0);
	}

	@Test
	public void ElCambioDeNombreEsCorrecto() {
		miArticuloDeLibreria.setNombre("Tijera");
		Assert.assertEquals("Tijera", miArticuloDeLibreria.getNombre());
	}

}
