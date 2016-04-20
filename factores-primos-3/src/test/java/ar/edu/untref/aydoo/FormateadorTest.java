package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FormateadorTest {
	
	@Test
	public void formateadorSeCreaYAlmacenaNumeroAFactorizar(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("10");
		Formateador formateador = new Formateador(listaDeArgumentos);
		
		Integer numeroAFactorizarAlmacenado = formateador.getNumeroAFactorizar();
		
		Assert.assertEquals(10, numeroAFactorizarAlmacenado, 0.0);		
	}
	
	@Test
	public void formateadorSeCreaYAgregaElEncabezadoALaFactorizacionFormateada(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("10");
		Formateador formateador = new Formateador(listaDeArgumentos);
		
		String factorizacionFormateada = formateador.getFactorizacionFormateada();
		
		Assert.assertEquals("Factores primos 10: ", factorizacionFormateada);	
	}
	
	@Test
	public void formateadorRecibeUnicamenteUnNumeroYFormateaPretty(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("360");
		Formateador formateador = new Formateador(listaDeArgumentos);
		formateador.formatearFactorizacion("2 2 2 3 3 5 ");
		String factorizacionFormateada = formateador.getFactorizacionFormateada();
		
		Assert.assertEquals("Factores primos 360: 2 2 2 3 3 5 ", factorizacionFormateada);	
	}
	
	@Test
	public void formateadorRecibeNoRecibeArgumentoFormatYFormateaPretty(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("360");
		listaDeArgumentos.add("--sort:des");
		Formateador formateador = new Formateador(listaDeArgumentos);
		formateador.formatearFactorizacion("2 2 2 3 3 5 ");
		String factorizacionFormateada = formateador.getFactorizacionFormateada();
		
		Assert.assertEquals("Factores primos 360: 2 2 2 3 3 5 ", factorizacionFormateada);	
	}
	
	@Test
	public void formateadorRecibeRecibeArgumentoFormatQuietYFormateaQuiet(){
		
		List<String> listaDeArgumentos = new ArrayList<String>();
		listaDeArgumentos.add("360");
		listaDeArgumentos.add("--format=quiet");
		Formateador formateador = new Formateador(listaDeArgumentos);
		formateador.formatearFactorizacion("2 2 2 3 3 5 ");
		String factorizacionFormateada = formateador.getFactorizacionFormateada();
		
		Assert.assertEquals("Factores primos 360: \n2\n2\n2\n3\n3\n5", factorizacionFormateada);	
	}
	
}
