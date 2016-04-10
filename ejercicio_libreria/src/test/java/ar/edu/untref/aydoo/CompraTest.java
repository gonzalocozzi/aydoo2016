package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CompraTest {
	
	@Test
	public void compraAgregaMesEnElCualFueHecha() {
		
		Compra compra = new Compra();
		compra.setMes(Mes.AGOSTO);
		
		Assert.assertEquals(Mes.AGOSTO, compra.getMes());
	}

}
