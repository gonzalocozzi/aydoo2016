package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class FactorizadorPrimoTest{	
	
		
	@Test
	public void factorizadorIngresaNumeroAFactorizar(){
		
		FactorizadorPrimo factorizador = new FactorizadorPrimo(null);
		
		factorizador.setNumeroAFactorizar(1);
		
		Assert.assertEquals(1, factorizador.getNumeroAFactorizar(), 0.0);
	}
	
	@Test
	public void factorizadorIngresaNumeroAFactorizarAlComienzo(){
		
		FactorizadorPrimo factorizador = new FactorizadorPrimo(1);
		
		Assert.assertEquals(1, factorizador.getNumeroAFactorizar(), 0.0);
	}
	
	@Test
	public void factorizadorIndicaQueNumeroUnoEsPrimo(){
		
		FactorizadorPrimo factorizador = new FactorizadorPrimo(1);		
		
		String factorizacion = factorizador.calcularFactoresPrimos();
		
		Assert.assertEquals("1", factorizacion);
	}
	
	@Test
	public void factorizadorIndicaQueNumeroCincoEsPrimo(){
		
		FactorizadorPrimo factorizador = new FactorizadorPrimo(5);		
		
		String factorizacion = factorizador.calcularFactoresPrimos();
		
		Assert.assertEquals("5", factorizacion);
	}
	
	@Test
	public void factorizadorIndicaQueNumeroDiecisieteEsPrimo(){
		
		FactorizadorPrimo factorizador = new FactorizadorPrimo(17);	
		
		String factorizacion = factorizador.calcularFactoresPrimos();
		
		Assert.assertEquals("17", factorizacion);
	}
	
	@Test
	public void factorizadorIndicaQueNumeroNoventaYSieteEsPrimo(){
		
		FactorizadorPrimo factorizador = new FactorizadorPrimo(97);
		
		String factorizacion = factorizador.calcularFactoresPrimos();
		
		Assert.assertEquals("97", factorizacion);
	}
	
	@Test
	public void factorizadorIndicaQueNumeroSetecientosDiecinueveEsPrimo(){
		
		FactorizadorPrimo factorizador = new FactorizadorPrimo(719);
		
		String factorizacion = factorizador.calcularFactoresPrimos();
		
		Assert.assertEquals("719", factorizacion);
	}
	@Test
	public void factorizacionCorrectaDelNumeroNoventa(){
		
		FactorizadorPrimo factorizador = new FactorizadorPrimo(90);
		
		String factorizacion = factorizador.calcularFactoresPrimos();
		
		Assert.assertEquals("2 3 3 5 ", factorizacion);
	}
	
	@Test
	public void factorizacionCorrectaDelNumeroTrescientosSesenta(){
		
		FactorizadorPrimo factorizador = new FactorizadorPrimo(360);
		
		String factorizacion = factorizador.calcularFactoresPrimos();
		
		Assert.assertEquals("2 2 2 3 3 5 ", factorizacion);
	}
	
}
