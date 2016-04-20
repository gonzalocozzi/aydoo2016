package ar.edu.untref.aydoo;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class FactorizadorPrimoTest{		

	@Test
	public void factorizadorIngresaNumeroAFactorizarAlComienzo(){

		String[] args = {"1"}; 
		FactorizadorPrimo factorizador = new FactorizadorPrimo(args);

		Assert.assertEquals(1, factorizador.getNumeroAFactorizar(), 0.0);
	}

	@Test
	public void factorizadorIndicaQueNumeroUnoEsPrimo(){

		String[] args = {"1"};
		FactorizadorPrimo factorizador = new FactorizadorPrimo(args);	
		factorizador.calcularFactoresPrimos();

		String factorizacion = factorizador.getFactorizacion();

		Assert.assertEquals("1", factorizacion);
	}

	@Test
	public void factorizadorIndicaQueNumeroDiecisieteEsPrimo(){

		String[] args = {"17"};
		FactorizadorPrimo factorizador = new FactorizadorPrimo(args);	
		factorizador.calcularFactoresPrimos();

		String factorizacion = factorizador.getFactorizacion();

		Assert.assertEquals("17", factorizacion);
	}

	@Test
	public void factorizadorIndicaQueNumeroNoventaYSieteEsPrimo(){

		String[] args = {"97"};
		FactorizadorPrimo factorizador = new FactorizadorPrimo(args);
		factorizador.calcularFactoresPrimos();

		String factorizacion = factorizador.getFactorizacion();

		Assert.assertEquals("97", factorizacion);
	}

	@Test
	public void factorizadorIndicaQueNumeroSetecientosDiecinueveEsPrimo(){

		String[] args = {"719"};
		FactorizadorPrimo factorizador = new FactorizadorPrimo(args);
		factorizador.calcularFactoresPrimos();

		String factorizacion = factorizador.getFactorizacion();

		Assert.assertEquals("719", factorizacion);
	}
	@Test
	public void factorizacionCorrectaDelNumeroNoventa(){

		String[] args = {"90"};
		FactorizadorPrimo factorizador = new FactorizadorPrimo(args);
		factorizador.calcularFactoresPrimos();

		String factorizacion = factorizador.getFactorizacion();

		Assert.assertEquals("2 3 3 5 ", factorizacion);
	}

	@Test
	public void factorizacionCorrectaDelNumeroTrescientosSesenta(){

		String[] args = {"360"};
		FactorizadorPrimo factorizador = new FactorizadorPrimo(args);
		factorizador.calcularFactoresPrimos();

		String factorizacion = factorizador.getFactorizacion();

		Assert.assertEquals("2 2 2 3 3 5 ", factorizacion);
	}
	
	@Test
	public void factorizadorPrimoDevuelveFactorizacionFormateada() throws IOException{
		
		String[] args = {"360", "--sort:des", "--format=quiet"};
		FactorizadorPrimo factorizador = new FactorizadorPrimo(args);
		factorizador.calcularFactoresPrimos();

		String factorizacionFormateada = factorizador.getFactorizacionFormateada();
		
		Assert.assertEquals("Factores primos 360: \n5\n3\n3\n2\n2\n2", factorizacionFormateada);
	}
	
	@Test
	public void factorizadorPrimoDevuelveFactorizacionDelModuloDeUnNumeroNegativo(){
		
		String[] args = {"-90"};
		FactorizadorPrimo factorizador = new FactorizadorPrimo(args);
		factorizador.calcularFactoresPrimos();

		String factorizacion = factorizador.getFactorizacion();

		Assert.assertEquals("2 3 3 5 ", factorizacion);
	}

}
