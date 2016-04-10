package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class LibreriaTest {

	@Test
	public void seAgregaNombreALaLibreria() {

		Libreria elpapiro = new Libreria(null, null);

		elpapiro.setNombre("el papiro");

		Assert.assertEquals("el papiro", elpapiro.getNombre());
	}

	@Test
	public void seAgregaDirecccionALaLibreria() {

		Libreria elpapiro = new Libreria(null, null);

		elpapiro.setDireccion("Gelly y Obes 2740, CABA");

		Assert.assertEquals("Gelly y Obes 2740, CABA", elpapiro.getDireccion());
	}
	
	@Test
	public void seAgregaNombreALaLibreriaAlSerCreada() {

		Libreria elpapiro = new Libreria("el papiro", null);

		Assert.assertEquals("el papiro", elpapiro.getNombre());
	}
	
	@Test
	public void seAgregaDirecccionALaLibreriaAlSerCreada() {

		Libreria elpapiro = new Libreria(null, "Gelly y Obes 2740, CABA");

		Assert.assertEquals("Gelly y Obes 2740, CABA", elpapiro.getDireccion());
	}

}
