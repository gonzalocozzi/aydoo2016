package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class RevistaTest {
	
	@Test
	public void seAgregaPeriodicidadALaRevista() {
		
		Revista barcelona = new Revista(null, null, null);
		barcelona.setPeriodicidad(2);
		
		Assert.assertEquals(2, barcelona.getPeriodicidad(), 0.0);
	}
	
	@Test
	public void seAgregaPeriodicidadALaRevistaAlSerCreada() {
		
		Revista barcelona = new Revista(null, null, 2);
		
		Assert.assertEquals(2, barcelona.getPeriodicidad(), 0.0);
	}
	
	@Test
	public void seAgregaNombreALaRevistaAlSerCreada() {
		
		Revista barcelona = new Revista("barcelona", null, null);
		
		Assert.assertEquals("barcelona", barcelona.getNombre());
	}

}
