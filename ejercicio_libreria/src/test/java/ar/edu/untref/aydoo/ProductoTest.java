package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ProductoTest {
	
	@Test
	public void seAgregaNombreAlProducto() {	
		
		Producto productoDePrueba = new Producto(null);
		
		productoDePrueba.setNombre("nombre_de_producto");
		
		Assert.assertEquals("nombre_de_producto", productoDePrueba.getNombre());
	}
	
	@Test
	public void seAgregaPrecioAlProducto() {		
		
		Producto productoDePrueba = new Producto(null);
		
		productoDePrueba.setPrecio(5.70);
		
		Assert.assertEquals(5.70, productoDePrueba.getPrecio(), 0.0);
	}
	
	@Test
	public void seAgregaNombreAlProductoAlSerCreado() {
		
		Producto productoDePrueba = new Producto("nombre_de_producto");
		
		Assert.assertEquals("nombre_de_producto", productoDePrueba.getNombre());
	}

}
