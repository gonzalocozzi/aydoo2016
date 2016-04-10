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
	
	@Test
	public void suscripcionEliminaProductoDeSuListaDeProductos() throws Exception {
		
		Suscripcion suscripcion = new Suscripcion(null);
		Producto quijote = new Libro("el quijote de la mancha", 175.0);
		
		suscripcion.agregarProducto(quijote);
		suscripcion.eliminarProducto(quijote);
		
		Assert.assertFalse(suscripcion.contiene(quijote));
	}
	
	@Test(expected=Exception.class)
	public void suscripcionNoEliminaProductoDeSuListaDeProductosSiNoLoPosee() throws Exception {
		
		Suscripcion suscripcion = new Suscripcion(null);
		Producto quijote = new Libro("el quijote de la mancha", 175.0);
		
		suscripcion.eliminarProducto(quijote);
	}
	
	@Test
	public void suscripcionNoAnualInformaSuPrecioConUnaRevistaQuincenal() throws Exception {
		
		Suscripcion suscripcion = new Suscripcion(null);
		Producto barcelona = new Revista("barcelona", 20.0, 2);
		
		suscripcion.agregarProducto(barcelona);	
		
		Assert.assertEquals(40.0, suscripcion.getPrecio(), 0.0);
	}

}
