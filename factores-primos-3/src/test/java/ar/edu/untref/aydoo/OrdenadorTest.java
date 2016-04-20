package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class OrdenadorTest {
	
	@Test
	public void ordenadorSeCreaConUnStringVacio(){
		
		Ordenador ordenador = new Ordenador();
		
		Assert.assertEquals("", ordenador.getFactorizacionInvertida());
	}
	
	@Test
	public void ordenadorInvierteString(){
		
		
	}

}
