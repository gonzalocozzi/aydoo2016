package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class RevistaTest {
	
	@Test
	public void seAgregaPeriodicidadALaRevista() throws Exception {
		
		Revista barcelona = new Revista(null, null, 2);
		barcelona.setPeriodicidad(2);
		
		Assert.assertEquals(2, barcelona.getPeriodicidad(), 0.0);
	}
	
	@Test
	public void seAgregaPeriodicidadALaRevistaAlSerCreada() throws Exception {
		
		Revista barcelona = new Revista(null, null, 2);
		
		Assert.assertEquals(2, barcelona.getPeriodicidad(), 0.0);
	}
	
	@Test
	public void seAgregaNombreALaRevistaAlSerCreada() throws Exception {
		
		Revista barcelona = new Revista("barcelona", null, 2);
		
		Assert.assertEquals("barcelona", barcelona.getNombre());
	}
	
	@Test
	public void seAgregaPrecioALaRevistaAlSerCreada() throws Exception {
		
		Revista barcelona = new Revista(null, 20.0, 2);
		
		Assert.assertEquals(20.0, barcelona.getPrecio(), 0.0);
	}
	
	@Test (expected=Exception.class)
	public void seImpideAgregarPeriodicidadNulaALaRevista() throws Exception {
		
		@SuppressWarnings("unused")
		Revista barcelona = new Revista(null, null, 0);
	}

}
