package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ProductoTest {
	
	@Test
	public void seAgregaNombreAlProducto() {
		
		Producto productoDePrueba = new Producto();
		
		productoDePrueba.setNombre("nombre_de_producto");
		
		Assert.assertEquals("nombre_de_producto", productoDePrueba.getNombre());
	}

}
