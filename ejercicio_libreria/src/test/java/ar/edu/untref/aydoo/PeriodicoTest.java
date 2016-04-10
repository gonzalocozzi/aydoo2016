package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class PeriodicoTest {
	
	@Test
	public void seAgregaPeriodicidadAlPeriodico() throws Exception {
		
		Periodico pagina12 = new Periodico(null, null, 2);
		pagina12.setPeriodicidad(2);
		
		Assert.assertEquals(2, pagina12.getPeriodicidad(), 0.0);
	}
	
	@Test
	public void seAgregaPeriodicidadAlPeriodicoAlSerCreado() throws Exception {
		
		Periodico pagina12 = new Periodico(null, null, 2);
		
		Assert.assertEquals(2, pagina12.getPeriodicidad(), 0.0);
	}
	
	@Test
	public void seAgregaNombreAlPeriodicoAlSerCreado() throws Exception {
		
		Periodico pagina12 = new Periodico("pagina 12", null, 2);
		
		Assert.assertEquals("pagina 12", pagina12.getNombre());
	}
	
	@Test
	public void seAgregaPrecioAlPeriodicoAlSerCreado() throws Exception {
		
		Periodico pagina12 = new Periodico(null, 20.0, 2);
		
		Assert.assertEquals(20.0, pagina12.getPrecio(), 0.0);
	}
	
	@Test (expected=Exception.class)
	public void seImpideAgregarPeriodicidadNulaAlPeriodico() throws Exception {
		
		@SuppressWarnings("unused")
		Periodico pagina12 = new Periodico(null, null, 0);
	}
	
	@Test (expected=Exception.class)
	public void seImpideAgregarPeriodicidadNegativaAlPeriodico() throws Exception {
		
		@SuppressWarnings("unused")
		Periodico pagina12 = new Periodico(null, null, -1);
	}

}
