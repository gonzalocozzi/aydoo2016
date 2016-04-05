package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class PartidoTest {

	@Test
	public void testPartidoSeCreaConNombreCorrecto(){

		Partido ucr = new Partido("union civica radical");

		Assert.assertEquals("union civica radical", ucr.getNombre());
	}

}
