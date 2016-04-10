package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class LibroTest {
	
	@Test
	public void seAgregaNombreAlLibroAlSerCreado() {
		
		Libro quijote = new Libro("el quijote de la mancha", null);
		
		Assert.assertEquals("el quijote de la mancha", quijote.getNombre());
	}

}
