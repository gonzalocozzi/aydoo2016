package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class OrdenadorTest {
	
	@Test
	public void ordenadorSeCreaConUnStringVacio(){
		
		Ordenador ordenador = new Ordenador();
		
		Assert.assertEquals("", ordenador.getStringInvertido());
	}
	
	@Test
	public void ordenadorInvierteUnString(){
		
		Ordenador ordenador = new Ordenador();
		
		String invertido = ordenador.invertirString("a b c d e f");
		
		Assert.assertEquals("f e d c b a ", invertido);
	}

}
