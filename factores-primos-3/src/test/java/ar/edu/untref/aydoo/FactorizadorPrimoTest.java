package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class FactorizadorPrimoTest{		

	@Test
	public void factorizadorIngresaNumeroAFactorizarAlComienzo(){

		FactorizadorPrimo factorizador = new FactorizadorPrimo(1);

		Assert.assertEquals(1, factorizador.getNumeroAFactorizar(), 0.0);
	}

	@Test
	public void factorizadorIndicaQueNumeroUnoEsPrimo(){

		FactorizadorPrimo factorizador = new FactorizadorPrimo(1);	
		factorizador.calcularFactoresPrimos();

		String factorizacion = factorizador.getFactorizacion();

		Assert.assertEquals("1", factorizacion);
	}

	@Test
	public void factorizadorIndicaQueNumeroCincoEsPrimo(){

		FactorizadorPrimo factorizador = new FactorizadorPrimo(5);		
		factorizador.calcularFactoresPrimos();

		String factorizacion = factorizador.getFactorizacion();

		Assert.assertEquals("5", factorizacion);
	}

	@Test
	public void factorizadorIndicaQueNumeroDiecisieteEsPrimo(){

		FactorizadorPrimo factorizador = new FactorizadorPrimo(17);	
		factorizador.calcularFactoresPrimos();

		String factorizacion = factorizador.getFactorizacion();

		Assert.assertEquals("17", factorizacion);
	}

	@Test
	public void factorizadorIndicaQueNumeroNoventaYSieteEsPrimo(){

		FactorizadorPrimo factorizador = new FactorizadorPrimo(97);
		factorizador.calcularFactoresPrimos();

		String factorizacion = factorizador.getFactorizacion();

		Assert.assertEquals("97", factorizacion);
	}

	@Test
	public void factorizadorIndicaQueNumeroSetecientosDiecinueveEsPrimo(){

		FactorizadorPrimo factorizador = new FactorizadorPrimo(719);
		factorizador.calcularFactoresPrimos();

		String factorizacion = factorizador.getFactorizacion();

		Assert.assertEquals("719", factorizacion);
	}
	@Test
	public void factorizacionCorrectaDelNumeroNoventa(){

		FactorizadorPrimo factorizador = new FactorizadorPrimo(90);
		factorizador.calcularFactoresPrimos();

		String factorizacion = factorizador.getFactorizacion();

		Assert.assertEquals("2 3 3 5 ", factorizacion);
	}

	@Test
	public void factorizacionCorrectaDelNumeroTrescientosSesenta(){

		FactorizadorPrimo factorizador = new FactorizadorPrimo(360);
		factorizador.calcularFactoresPrimos();

		String factorizacion = factorizador.getFactorizacion();

		Assert.assertEquals("2 2 2 3 3 5 ", factorizacion);
	}

}
