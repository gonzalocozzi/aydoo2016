package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class TestFactoresPrimos{
	
	private FactoresPrimos factorizador = new FactoresPrimos();
	
	@Test
	public void test_se_indica_que_numero_uno_es_primo(){
		
		factorizador.setNumero_a_factorizar(1);
		factorizador.calcular_factores_primos();
		Assert.assertEquals("La prueba es exitosa", "1", factorizador.getFactorizacion());
	}
	
	@Test
	public void test_se_indica_que_numero_cinco_es_primo(){
		
		factorizador.setNumero_a_factorizar(5);
		factorizador.calcular_factores_primos();
		Assert.assertEquals("La prueba es exitosa", "5", factorizador.getFactorizacion());
	}
	
	@Test
	public void test_se_indica_que_numero_diecisiete_es_primo(){
		
		factorizador.setNumero_a_factorizar(17);
		factorizador.calcular_factores_primos();
		Assert.assertEquals("La prueba es exitosa", "17", factorizador.getFactorizacion());
	}
	
	@Test
	public void test_se_indica_que_numero_noventa_y_siete_es_primo(){
		
		factorizador.setNumero_a_factorizar(97);
		factorizador.calcular_factores_primos();
		Assert.assertEquals("La prueba es exitosa", "97", factorizador.getFactorizacion());
	}
	
	@Test
	public void test_se_indica_que_numero_setecientos_diecinueve_es_primo(){
		
		factorizador.setNumero_a_factorizar(719);
		factorizador.calcular_factores_primos();
		Assert.assertEquals("La prueba es exitosa", "719", factorizador.getFactorizacion());
	}
	@Test
	public void test_factorizacion_correcta_del_numero_90(){
		
		factorizador.setNumero_a_factorizar(90);
		factorizador.calcular_factores_primos();
		Assert.assertEquals("La prueba es exitosa", "2 3 3 5 ", factorizador.getFactorizacion());
	}
	
	@Test
	public void test_factorizacion_correcta_del_numero_360(){
		
		factorizador.setNumero_a_factorizar(360);
		factorizador.calcular_factores_primos();
		Assert.assertEquals("La prueba es exitosa", "2 2 2 3 3 5 ", factorizador.getFactorizacion());
	}
	
}
