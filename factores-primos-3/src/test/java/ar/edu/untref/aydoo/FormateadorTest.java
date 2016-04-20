package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class FormateadorTest {
	
	@Test
	public void formateadorSeCreaYAlmacenaNumeroAFactorizar(){
		
		Formateador formateador = new Formateador(10);
		
		Integer numeroAFactorizarAlmacenado = formateador.getNumeroAFactorizar();
		
		Assert.assertEquals(10, numeroAFactorizarAlmacenado, 0.0);		
	}
	
	@Test
	public void formateadorSeCreaYAgregaElEncabezadoALaFactorizacionFormateada(){
		
		Formateador formateador = new Formateador(10);
		
		String factorizacionFormateada = formateador.getFactorizacionFormateada();
		
		Assert.assertEquals("Factores primos 10: ", factorizacionFormateada);	
	}
}
