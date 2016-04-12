package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SuscripcionTest {

	@Test
	public void suscripcionAgregaMesEnElCualFueComprada() {

		Suscripcion suscripcion = new Suscripcion(null);
		suscripcion.setMes(Mes.ENERO);

		Assert.assertEquals(Mes.ENERO, suscripcion.getMes());
	}	

	@Test
	public void suscripcionAgregaProductoASuListaDeProductos() throws Exception {

		Suscripcion suscripcion = new Suscripcion(null);
		Producto barcelona = new Revista("barcelona", 20.0, 2);

		suscripcion.agregarProducto(barcelona);

		Assert.assertTrue(suscripcion.contiene(barcelona));
	}

	@Test
	public void suscripcionEliminaProductoDeSuListaDeProductos() throws Exception {

		Suscripcion suscripcion = new Suscripcion(null);
		Producto barcelona = new Revista("barcelona", 20.0, 2);

		suscripcion.agregarProducto(barcelona);
		suscripcion.eliminarProducto(barcelona);

		Assert.assertFalse(suscripcion.contiene(barcelona));
	}

	@Test(expected=Exception.class)
	public void suscripcionNoEliminaProductoDeSuListaDeProductosSiNoLoPosee() throws Exception {

		Suscripcion suscripcion = new Suscripcion(null);
		Producto quijote = new Libro("el quijote de la mancha", 175.0);

		suscripcion.eliminarProducto(quijote);
	}

	@Test
	public void suscripcionAgregaMesEnElCualFueCompradaAlSerCreada() {

		Suscripcion suscripcion = new Suscripcion(Mes.ENERO);

		Assert.assertEquals(Mes.ENERO, suscripcion.getMes());
	}

	@Test
	public void suscripcionNoAnualInformaSuPrecioConUnaRevistaQuincenal() throws Exception {

		Suscripcion suscripcion = new Suscripcion(Mes.ENERO);
		Producto barcelona = new Revista("barcelona", 20.0, 2);

		suscripcion.agregarProducto(barcelona);	

		Assert.assertEquals(40.0, suscripcion.getPrecioDeLaCompra(), 0.0);
	}

	@Test
	public void suscripcionNoAnualInformaSuPrecioConUnDiario() throws Exception {

		Suscripcion suscripcion = new Suscripcion(Mes.ENERO);
		Producto pagina12 = new Periodico("pagina 12", 12.0, 30);

		suscripcion.agregarProducto(pagina12);	

		Assert.assertEquals(360.0, suscripcion.getPrecioDeLaCompra(), 0.0);
	}

	@Test
	public void suscripcionNoAnualInformaSuPrecioConVariosProductos() throws Exception {

		Suscripcion suscripcion = new Suscripcion(Mes.ENERO);
		Producto pagina12 = new Periodico("pagina 12", 12.0, 30);
		Producto barcelona = new Revista("barcelona", 20.0, 2);
		Producto elgrafico = new Revista("el grafico", 30.0, 1);

		suscripcion.agregarProducto(pagina12);	
		suscripcion.agregarProducto(barcelona);
		suscripcion.agregarProducto(elgrafico);

		Assert.assertEquals(430.0, suscripcion.getPrecioDeLaCompra(), 0.0);
	}

	@Test
	public void seCreaSuscripcionAnual(){

		Suscripcion suscripcion = new Suscripcion(Mes.ENERO);
		suscripcion.hacerAnual();

		Assert.assertTrue(suscripcion.esAnual());
	}

	@Test
	public void suscripcionAnualInformaSuPrecioConUnaRevistaQuincenal() throws Exception {

		Suscripcion suscripcion = new Suscripcion(Mes.ENERO);
		suscripcion.hacerAnual();
		Producto barcelona = new Revista("barcelona", 20.0, 2);

		suscripcion.agregarProducto(barcelona);	

		Assert.assertEquals(32.0, suscripcion.getPrecioDeLaCompra(), 0.0);
	}

	@Test
	public void suscripcionAnualInformaSuPrecioConUnDiario() throws Exception {

		Suscripcion suscripcion = new Suscripcion(Mes.ENERO);
		suscripcion.hacerAnual();
		Producto pagina12 = new Periodico("pagina 12", 12.0, 30);

		suscripcion.agregarProducto(pagina12);	

		Assert.assertEquals(288.0, suscripcion.getPrecioDeLaCompra(), 0.0);
	}

	@Test
	public void suscripcionAnualInformaSuPrecioConVariosProductos() throws Exception {

		Suscripcion suscripcion = new Suscripcion(Mes.ENERO);
		suscripcion.hacerAnual();
		Producto pagina12 = new Periodico("pagina 12", 12.0, 30);
		Producto barcelona = new Revista("barcelona", 20.0, 2);
		Producto elgrafico = new Revista("el grafico", 30.0, 1);

		suscripcion.agregarProducto(pagina12);	
		suscripcion.agregarProducto(barcelona);
		suscripcion.agregarProducto(elgrafico);

		Assert.assertEquals(344.0, suscripcion.getPrecioDeLaCompra(), 0.0);
	}

	@Test (expected=Exception.class)
	public void suscripcionNoDejaAgregarLibrosALaListaDeProductos() throws Exception {

		Suscripcion suscripcion = new Suscripcion(Mes.ENERO);
		Producto elquijote = new Libro("el quijote de la mancha", 175.0);

		suscripcion.agregarProducto(elquijote);
	}

	@Test (expected=Exception.class)
	public void suscripcionNoDejaAgregarArticulosDeLibreriaALaListaDeProductos() throws Exception {

		Suscripcion suscripcion = new Suscripcion(Mes.ENERO);
		Producto lapicera = new ArticuloDeLibreria("bic", 5.0);

		suscripcion.agregarProducto(lapicera);
	}

}
