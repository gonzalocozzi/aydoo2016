package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CompraTest {
	
	@Test
	public void compraAgregaMesEnElCualFueHecha() {
		
		Compra compra = new Compra();
		compra.setMes(Mes.AGOSTO);
		
		Assert.assertEquals(Mes.AGOSTO, compra.getMes());
	}
	
	@Test
	public void compraAgregaProductoASuListaDeProductos() {
		
		Compra compra = new Compra();
		Producto quijote = new Libro("el quijote de la mancha", 175.0);
		
		compra.agregarProducto(quijote);
		
		Assert.assertTrue(compra.contiene(quijote));
	}
	
	@Test
	public void compraEliminaProductoDeSuListaDeProductos() {
		
		Compra compra = new Compra();
		Producto quijote = new Libro("el quijote de la mancha", 175.0);
		
		compra.agregarProducto(quijote);
		compra.eliminarProducto(quijote);
		
		Assert.assertFalse(compra.contiene(quijote));
	}
	
	@Test
	public void compraInformaSuPrecioConVariosProductosSinSuscripcion() throws Exception {
		
		Compra compra = new Compra();
		Producto elhobbit = new Libro("el hobbit", 50.0);
		Producto lapicera = new ArticuloDeLibreria("bic", 5.0);
		Producto elgrafico = new Revista("el grafico", 30.0, 1);
		
		compra.agregarProducto(elhobbit);
		compra.agregarProducto(lapicera);
		compra.agregarProducto(lapicera);
		compra.agregarProducto(elgrafico);		
		
		Assert.assertEquals(92.1, compra.getPrecio(), 0.0);
	}

}
