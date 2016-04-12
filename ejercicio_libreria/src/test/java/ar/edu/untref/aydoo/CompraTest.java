package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CompraTest {

	@Test
	public void compraAgregaMesEnElCualFueHecha() {

		Compra compra = new Compra(null);
		compra.setMes(Mes.AGOSTO);

		Assert.assertEquals(Mes.AGOSTO, compra.getMes());
	}

	@Test
	public void compraAgregaProductoASuListaDeProductos() throws Exception {

		Compra compra = new Compra(null);
		Producto quijote = new Libro("el quijote de la mancha", 175.0);

		compra.agregarProducto(quijote);

		Assert.assertTrue(compra.contiene(quijote));
	}

	@Test
	public void compraEliminaProductoDeSuListaDeProductos() throws Exception {

		Compra compra = new Compra(null);
		Producto quijote = new Libro("el quijote de la mancha", 175.0);

		compra.agregarProducto(quijote);
		compra.eliminarProducto(quijote);

		Assert.assertFalse(compra.contiene(quijote));
	}

	@Test(expected=Exception.class)
	public void compraNoEliminaProductoDeSuListaDeProductosSiNoLoPosee() throws Exception {

		Compra compra = new Compra(null);
		Producto quijote = new Libro("el quijote de la mancha", 175.0);

		compra.eliminarProducto(quijote);
	}

	@Test
	public void compraInformaSuPrecioConVariosProductos() throws Exception {

		Compra compra = new Compra(null);
		Producto elhobbit = new Libro("el hobbit", 50.0);
		Producto lapicera = new ArticuloDeLibreria("bic", 5.0);
		Producto elgrafico = new Revista("el grafico", 30.0, 1);

		compra.agregarProducto(elhobbit);
		compra.agregarProducto(lapicera);
		compra.agregarProducto(lapicera);
		compra.agregarProducto(elgrafico);		

		Assert.assertEquals(92.1, compra.getPrecioDeLaCompra(), 0.0);
	}

	@Test
	public void compraAgregaMesEnElCualFueHechaAlSerCreada(){

		Compra compra = new Compra(Mes.AGOSTO);

		Assert.assertEquals(Mes.AGOSTO, compra.getMes());
	}

}
