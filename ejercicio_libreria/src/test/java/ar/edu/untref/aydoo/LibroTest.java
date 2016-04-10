package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class LibroTest {
	
	@Test
	public void seAgregaNombreAlLibro(){
		
		Libro quijote = new Libro(null, null);
		quijote.setNombre("el quijote de la mancha");
		
		Assert.assertEquals("el quijote de la mancha", quijote.getNombre());
	}
	
	@Test
	public void seAgregaNombreAlLibroAlSerCreado() {
		
		Libro quijote = new Libro("el quijote de la mancha", null);
		
		Assert.assertEquals("el quijote de la mancha", quijote.getNombre());
	}
	
	@Test
	public void seAgregaPrecioAlLibroAlSerCreado() {
		
		Libro quijote = new Libro(null, 125.0);
		
		Assert.assertEquals(125.0, quijote.getPrecio(), 0.0);
	}

}
