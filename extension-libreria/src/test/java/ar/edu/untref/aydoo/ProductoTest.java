package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductoTest {

	private Producto miProducto;

	@Before
	public void inicializar() throws NegativePriceException {
		
		miProducto = new Producto("El Hobbit", 50.0);
	}

	@Test
	public void ElPrecioEsCorrecto() {
		
		double precioDelProducto = miProducto.getPrecio();
		
		Assert.assertEquals(50.0, precioDelProducto, 0.1);
	}

	@Test
	public void ElNombreEsCorrecto() {
		
		String nombreDelProducto = miProducto.getNombre();
		
		Assert.assertEquals("El Hobbit", nombreDelProducto);
	}

	@Test(expected = NegativePriceException.class)
	public void elPrecioEsIncorrecto() throws NegativePriceException {
		
		Producto unProducto = new Producto("Lapicera", 9.0);
		unProducto.setPrecio(-10.0);
	}

	@Test
	public void ElCambioDeNombreEsCorrecto() {
		
		miProducto.setNombre("El señor de los Anillos: la Comunidad del Anillo");
		
		String nombreDelProducto = miProducto.getNombre(); 
		
		Assert.assertEquals("El señor de los Anillos: la Comunidad del Anillo", nombreDelProducto);
	}
}
