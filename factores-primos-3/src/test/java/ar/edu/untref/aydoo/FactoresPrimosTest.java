package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class FactoresPrimosTest{
	
	FactoresPrimos factorizador = new FactoresPrimos();
	
	@Test
	public void factorizadorIndicaQueNumeroUnoEsPrimo(){
		
		factorizador.setNumeroAFactorizar(1);
		factorizador.calcularFactoresPrimos();
		Assert.assertEquals("La prueba es exitosa", "1", factorizador.getFactorizacion());
	}
	
	@Test
	public void factorizadorIndicaQueNumeroCincoEsPrimo(){
		
		factorizador.setNumeroAFactorizar(5);
		factorizador.calcularFactoresPrimos();
		Assert.assertEquals("La prueba es exitosa", "5", factorizador.getFactorizacion());
	}
	
	@Test
	public void factorizadorIndicaQueNumeroDiecisieteEsPrimo(){
		
		factorizador.setNumeroAFactorizar(17);
		factorizador.calcularFactoresPrimos();
		Assert.assertEquals("La prueba es exitosa", "17", factorizador.getFactorizacion());
	}
	
	@Test
	public void factorizadorIndicaQueNumeroNoventaYSieteEsPrimo(){
		
		factorizador.setNumeroAFactorizar(97);
		factorizador.calcularFactoresPrimos();
		Assert.assertEquals("La prueba es exitosa", "97", factorizador.getFactorizacion());
	}
	
	@Test
	public void factorizadorIndicaQueNumeroSetecientosDiecinueveEsPrimo(){
		
		factorizador.setNumeroAFactorizar(719);
		factorizador.calcularFactoresPrimos();
		Assert.assertEquals("La prueba es exitosa", "719", factorizador.getFactorizacion());
	}
	@Test
	public void factorizacionCorrectaDelNumeroNoventa(){
		
		factorizador.setNumeroAFactorizar(90);
		factorizador.calcularFactoresPrimos();
		Assert.assertEquals("La prueba es exitosa", "2 3 3 5 ", factorizador.getFactorizacion());
	}
	
	@Test
	public void factorizacionCorrectaDelNumeroTrescientosSesenta(){
		
		factorizador.setNumeroAFactorizar(360);
		factorizador.calcularFactoresPrimos();
		Assert.assertEquals("La prueba es exitosa", "2 2 2 3 3 5 ", factorizador.getFactorizacion());
	}
	
}
