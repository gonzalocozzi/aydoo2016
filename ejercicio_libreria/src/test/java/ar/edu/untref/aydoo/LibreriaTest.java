package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class LibreriaTest {
	
	@Test
	public void seAgregaNombreALaLibreria() {
		
		Libreria elpapiro = new Libreria();
		
		elpapiro.setNombre("el papiro");
		
		Assert.assertEquals("el papiro", elpapiro.getNombre());
	}

}
