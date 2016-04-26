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
	public void elPrecioEsCorrectoConIvaIncluido() {
		
		double precioDelArticulo = miArticuloDeLibreria.getPrecio();
		
		Assert.assertEquals(12.1, precioDelArticulo, 0.0);
	}

	@Test
	public void elNombreEsCorrecto() {
		
		String nombreDelArticulo = miArticuloDeLibreria.getNombre();
		
		Assert.assertEquals("Lapicera", nombreDelArticulo);
	}

	@Test(expected = NegativePriceException.class)
	public void elPrecioEsIncorrecto() throws NegativePriceException {
		
		Producto unArticuloDeLibreria = new ArticuloDeLibreria("Lapicera", 10.0);
		unArticuloDeLibreria.setPrecio(-10.0);
	}

	@Test
	public void elCambioDeNombreEsCorrecto() {
		
		miArticuloDeLibreria.setNombre("Tijera");
		
		String nombreDelArticulo = miArticuloDeLibreria.getNombre();
		
		Assert.assertEquals("Tijera", nombreDelArticulo);
	}

}
