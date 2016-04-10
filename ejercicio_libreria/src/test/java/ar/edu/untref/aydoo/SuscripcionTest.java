package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SuscripcionTest {
	
	@Test
	public void suscripcionAgregaMesEnElCualFueHecha() {
		
		Suscripcion suscripcion = new Suscripcion(null);
		suscripcion.setMes(Mes.ENERO);
		
		Assert.assertEquals(Mes.ENERO, suscripcion.getMes());
	}
	
	@Test
	public void suscripcionAgregaProductoASuListaDeProductos() {
		
		Suscripcion suscripcion = new Suscripcion(null);
		Producto quijote = new Libro("el quijote de la mancha", 175.0);
		
		suscripcion.agregarProducto(quijote);
		
		Assert.assertTrue(suscripcion.contiene(quijote));
	}

}
