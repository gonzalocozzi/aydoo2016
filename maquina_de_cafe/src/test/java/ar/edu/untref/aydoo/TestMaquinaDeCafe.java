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
	
	@Test
	public void testHacedorDeTeAgregaTeALVaso(){
		
		HacedorDeTe hacedorDeTe = new HacedorDeTe();
		Vaso vaso = new Vaso();
		hacedorDeTe.prepararEnEsteVaso(vaso);
		
		Assert.assertTrue("El hacedor de te no agrego te al vaso", vaso.getTe());
	}
	
	@Test
	public void testHacedorDeTeChinoAgregaTeChinoAlVaso(){
		
		HacedorDeTeChino hacedorDeTeChino = new HacedorDeTeChino();
		Vaso vaso = new Vaso();
		hacedorDeTeChino.prepararEnEsteVaso(vaso);
		
		Assert.assertTrue("El hacedor de te chino no agrego te chino al vaso", vaso.getTeChino());
	}
	
	@Test
	public void testLecheroAgregaLecheAlVaso(){
		
		Lechero lechero = new Lechero();
		Vaso vaso = new Vaso();
		lechero.prepararEnEsteVaso(vaso);
		
		Assert.assertTrue("El lechero no agrego leche al vaso", vaso.getLeche());
	}
	
	@Test
	public void testMaquinaExpendedoraPreparaTeConLecheConNDeAzucar(){
		
		MaquinaExpendedoraDeBebidas maquina = new MaquinaExpendedoraDeBebidas();		
		Vaso vaso = maquina.hacerTeConLecheConNDeAzucar(2);
		
		Assert.assertEquals("El azucarero no agrego azucar al vaso", 2, vaso.getAzucar());
		Assert.assertTrue("El hacedor de te no agrego te al vaso", vaso.getTe());
		Assert.assertTrue("El lechero no agrego leche al vaso", vaso.getLeche());
		Assert.assertFalse("El cafetero agrego cafe al vaso", vaso.getCafe());
	}
	
	@Test
	public void testMaquinaExpendedoraPreparaCafeConLecheConNDeAzucar(){
		
		MaquinaExpendedoraDeBebidas maquina = new MaquinaExpendedoraDeBebidas();
		Vaso vaso = maquina.hacerCafeConLecheConNDeAzucar(3);
		
		Assert.assertEquals("El azucarero no agrego azucar al vaso", 3, vaso.getAzucar());
		Assert.assertTrue("El cafetero no agrego cafe al vaso", vaso.getCafe());
		Assert.assertTrue("El lechero no agrego leche al vaso", vaso.getLeche());
		Assert.assertFalse("El hacedor de te agrego te al vaso", vaso.getTe());
	}
	
}
