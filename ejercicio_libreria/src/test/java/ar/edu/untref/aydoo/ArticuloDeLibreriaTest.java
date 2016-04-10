package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ArticuloDeLibreriaTest {
	
	@Test
	public void articuloDeLibreriaCalculaSuIVA() {
		
		ArticuloDeLibreria lapicera = new ArticuloDeLibreria(null, 5.0);
		
		Assert.assertEquals(1.05, lapicera.getIVA(), 0.0);
	}

}
