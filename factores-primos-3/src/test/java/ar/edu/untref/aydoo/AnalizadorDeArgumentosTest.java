package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class AnalizadorDeArgumentosTest {
	
	@Test
	public void analizadorDeArgumentosSeCreaYAlmacenaElNumeroAFactorizar(){
		
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(500, null, null);
		
		Integer numeroAFactorizar = analizador.getNumeroAFactorizar();
		
		Assert.assertEquals(500, numeroAFactorizar, 0.0);		
	}

}
