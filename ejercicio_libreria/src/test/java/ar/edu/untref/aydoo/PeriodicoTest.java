package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class PeriodicoTest {
	
	@Test
	public void seAgregaPeriodicidadAlPeriodico() {
		
		Periodico pagina12 = new Periodico(null, null);
		pagina12.setPeriodicidad(2);
		
		Assert.assertEquals(2, pagina12.getPeriodicidad(), 0.0);
	}

}
