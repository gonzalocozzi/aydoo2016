package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class LibroTest {

	@Test
	public void seAgregaNombreAlLibro() throws Exception{

		Libro quijote = new Libro(null, 0.0);
		quijote.setNombre("el quijote de la mancha");

		Assert.assertEquals("el quijote de la mancha", quijote.getNombre());
	}

	@Test
	public void seAgregaPrecioAlLibro() throws Exception{

		Libro quijote = new Libro(null, 0.0);
		quijote.setPrecio(125.0);

		Assert.assertEquals(125.0, quijote.getPrecio(), 0.0);
	}

	@Test
	public void seAgregaNombreAlLibroAlSerCreado() throws Exception {

		Libro quijote = new Libro("el quijote de la mancha", 0.0);

		Assert.assertEquals("el quijote de la mancha", quijote.getNombre());
	}

	@Test
	public void seAgregaPrecioAlLibroAlSerCreado() throws Exception {

		Libro quijote = new Libro(null, 125.0);

		Assert.assertEquals(125.0, quijote.getPrecio(), 0.0);
	}

}
