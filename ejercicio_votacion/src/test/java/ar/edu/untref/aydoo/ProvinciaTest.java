package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ProvinciaTest {

	@Test
	public void testProvinciaSeCreaConElNombreCorrecto(){

		Provincia buenosaires = new Provincia("buenos aires");

		Assert.assertEquals("buenos aires", buenosaires.getNombre());
	}

	@Test
	public void testProvinciaIncorporaPartido(){

		Provincia santiagodelestero = new Provincia("santiago del estero");
		Partido ucr = new Partido("union civica radical");

		santiagodelestero.agregarPartido(ucr);

		Assert.assertTrue(santiagodelestero.tienePartido(ucr));
	}
	
}
