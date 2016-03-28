package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class TestFactoresPrimos{
	
	private FactoresPrimos factorizador = new FactoresPrimos();
	
	@Test
	public void test_se_indica_que_numero_uno_es_primo(){
		
		factorizador.setNumero_a_factorizar(1);
		factorizador.calcular_factores_primos();
		Assert.assertEquals("La prueba es exitosa", "el numero 1 es primo.", factorizador.getFactorizacion());
	}
	
}
