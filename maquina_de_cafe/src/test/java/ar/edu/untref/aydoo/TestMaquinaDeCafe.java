package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

public class TestMaquinaDeCafe {
	
	@Test
	public void testAzucareroAgregaNCucharadasDeAzucarAlVaso(){
		
		Azucarero azucarero = new Azucarero();
		Vaso vaso = new Vaso();
		azucarero.ponerNEnEsteVaso(2, vaso);
		
		Assert.assertEquals("EL azucarero agrego con exito azucar al vaso", 2, vaso.getAzucar());
	}

}
