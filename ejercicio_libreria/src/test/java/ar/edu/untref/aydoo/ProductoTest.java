package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ProductoTest {

	@Test
	public void seAgregaNombreAlProducto() throws Exception {	

		Producto productoDePrueba = new Producto(null, 0.0);

		productoDePrueba.setNombre("nombre_de_producto");

		Assert.assertEquals("nombre_de_producto", productoDePrueba.getNombre());
	}

	@Test
	public void seAgregaPrecioAlProducto() throws Exception {		

		Producto productoDePrueba = new Producto(null, 0.0);

		productoDePrueba.setPrecio(5.70);

		Assert.assertEquals(5.70, productoDePrueba.getPrecio(), 0.0);
	}

	@Test
	public void seAgregaNombreAlProductoAlSerCreado() throws Exception {

		Producto productoDePrueba = new Producto("nombre_de_producto", 0.0);

		Assert.assertEquals("nombre_de_producto", productoDePrueba.getNombre());
	}

	@Test
	public void seAgregaPrecioAlProductoAlSerCreado() throws Exception {

		Producto productoDePrueba = new Producto(null, 12.0);

		Assert.assertEquals(12.0, productoDePrueba.getPrecio(), 0.0);
	}

	@Test(expected=Exception.class)
	public void productoNoPermiteAgregrarUnPrecioNegativo() throws Exception{

		Producto productoDePrueba = new Producto(null, 0.0);

		productoDePrueba.setPrecio(-1.0);
	}

}
