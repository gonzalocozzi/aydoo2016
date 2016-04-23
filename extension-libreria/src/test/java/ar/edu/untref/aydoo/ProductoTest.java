package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductoTest {

	private Producto miProducto;

	@Before
	public void inicializar() {
		miProducto = new Producto("El Hobbit", 50.0);
	}

	@Test
	public void ElPrecioEsCorrecto() {
		Assert.assertEquals(50.0, miProducto.getPrecio(), 0.1);
	}

	@Test
	public void ElNombreEsCorrecto() {
		Assert.assertEquals("El Hobbit", miProducto.getNombre());
	}

	@Test(expected = Error.class)
	public void elPrecioEsIncorrecto() {
		Producto unProducto = new Producto("Lapicera", 9.0);
		unProducto.setPrecio(-10.0);
	}

	@Test
	public void ElCambioDeNombreEsCorrecto() {
		miProducto.setNombre("El señor de los Anillos: la Comunidad del Anillo");
		Assert.assertEquals("El señor de los Anillos: la Comunidad del Anillo", miProducto.getNombre());
	}
}
