package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class PeriodicoTest {
	
	@Test
	public void seAgregaPeriodicidadAlPeriodico() {
		
		Periodico pagina12 = new Periodico(null, null, null);
		pagina12.setPeriodicidad(2);
		
		Assert.assertEquals(2, pagina12.getPeriodicidad(), 0.0);
	}
	
	@Test
	public void seAgregaPeriodicidadAlPeriodicoAlSerCreado() {
		
		Periodico pagina12 = new Periodico(null, null, 2);
		
		Assert.assertEquals(2, pagina12.getPeriodicidad(), 0.0);
	}
	
	@Test
	public void seAgregaNombreAlPeriodicoAlSerCreado() {
		
		Periodico pagina12 = new Periodico("pagina 12", null, null);
		
		Assert.assertEquals("pagina 12", pagina12.getNombre());
	}

}
