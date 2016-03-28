package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

public class TestMaquinaDeCafe {
	
	@Test
	public void testAzucareroAgregaNCucharadasDeAzucarAlVaso(){
		
		Azucarero azucarero = new Azucarero();
		Vaso vaso = new Vaso();
		azucarero.ponerNEnEsteVaso(2, vaso);
		
		Assert.assertEquals("El azucarero no agrego azucar al vaso", 2, vaso.getAzucar());
	}
	
	@Test
	public void testCafeteroAgregaCafeAlVaso(){
		
		Cafetero cafetero = new Cafetero();
		Vaso vaso = new Vaso();
		cafetero.prepararEnEsteVaso(vaso);
		
		Assert.assertTrue("El cafetero no agrego cafe al vaso", vaso.getCafe());
	}

}
