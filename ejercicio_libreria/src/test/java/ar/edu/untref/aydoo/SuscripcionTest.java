package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SuscripcionTest {
	
	@Test
	public void suscripcionAgregaMesEnElCualFueHecha() {
		
		Suscripcion suscripcion = new Suscripcion(null);
		suscripcion.setMes(Mes.ENERO);
		
		Assert.assertEquals(Mes.ENERO, suscripcion.getMes());
	}

}
