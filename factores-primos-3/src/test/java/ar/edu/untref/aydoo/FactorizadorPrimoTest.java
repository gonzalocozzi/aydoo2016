package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class FactorizadorPrimoTest{	
	
		
	@Test
	public void factorizadorIngresaNumeroAFactorizar(){
		
		FactorizadorPrimo factorizador = new FactorizadorPrimo();
		factorizador.setNumeroAFactorizar(1);
		
		Assert.assertEquals(1, factorizador.getNumeroAFactorizar(), 0.0);
	}
	
	@Test
	public void factorizadorIndicaQueNumeroUnoEsPrimo(){
		
		FactorizadorPrimo factorizador = new FactorizadorPrimo();
		factorizador.setNumeroAFactorizar(1);
		factorizador.calcularFactoresPrimos();
		Assert.assertEquals("La prueba es exitosa", "1", factorizador.getFactorizacion());
	}
	
	@Test
	public void factorizadorIndicaQueNumeroCincoEsPrimo(){
		
		FactorizadorPrimo factorizador = new FactorizadorPrimo();
		factorizador.setNumeroAFactorizar(5);
		factorizador.calcularFactoresPrimos();
		Assert.assertEquals("La prueba es exitosa", "5", factorizador.getFactorizacion());
	}
	
	@Test
	public void factorizadorIndicaQueNumeroDiecisieteEsPrimo(){
		
		FactorizadorPrimo factorizador = new FactorizadorPrimo();
		factorizador.setNumeroAFactorizar(17);
		factorizador.calcularFactoresPrimos();
		Assert.assertEquals("La prueba es exitosa", "17", factorizador.getFactorizacion());
	}
	
	@Test
	public void factorizadorIndicaQueNumeroNoventaYSieteEsPrimo(){
		
		FactorizadorPrimo factorizador = new FactorizadorPrimo();
		factorizador.setNumeroAFactorizar(97);
		factorizador.calcularFactoresPrimos();
		Assert.assertEquals("La prueba es exitosa", "97", factorizador.getFactorizacion());
	}
	
	@Test
	public void factorizadorIndicaQueNumeroSetecientosDiecinueveEsPrimo(){
		
		FactorizadorPrimo factorizador = new FactorizadorPrimo();
		factorizador.setNumeroAFactorizar(719);
		factorizador.calcularFactoresPrimos();
		Assert.assertEquals("La prueba es exitosa", "719", factorizador.getFactorizacion());
	}
	@Test
	public void factorizacionCorrectaDelNumeroNoventa(){
		
		FactorizadorPrimo factorizador = new FactorizadorPrimo();
		factorizador.setNumeroAFactorizar(90);
		factorizador.calcularFactoresPrimos();
		Assert.assertEquals("La prueba es exitosa", "2 3 3 5 ", factorizador.getFactorizacion());
	}
	
	@Test
	public void factorizacionCorrectaDelNumeroTrescientosSesenta(){
		
		FactorizadorPrimo factorizador = new FactorizadorPrimo();
		factorizador.setNumeroAFactorizar(360);
		factorizador.calcularFactoresPrimos();
		Assert.assertEquals("La prueba es exitosa", "2 2 2 3 3 5 ", factorizador.getFactorizacion());
	}
	
}
