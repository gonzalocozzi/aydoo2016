package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RevistaTest {

	private RevistayPeriodico miRevista;

	@Before
	public void inicializar() {
		miRevista = new RevistayPeriodico("Ole", 25.0, 4);
	}

	@Test
	public void ElPrecioEsCorrecto() {
		Assert.assertEquals(25.0, miRevista.getPrecio(), 0.1);
	}

	@Test
	public void ElNombreEsCorrecto() {
		Assert.assertEquals("Ole", miRevista.getNombre());
	}

	@Test(expected = Error.class)
	public void elPrecioEsIncorrecto() {
		Producto unaRevista = new RevistayPeriodico("NBA", 23.0, 4);
		unaRevista.setPrecio(-10.0);
	}

	@Test
	public void ElCambioDeNombreEsCorrecto() {
		miRevista.setNombre("Para Teens");
		Assert.assertEquals("Para Teens", miRevista.getNombre());
	}

	@Test
	public void precioDeLaSuscripcionMensualEsCorrecta() {
		miRevista.setFrecuenciaMensual(4);
		Assert.assertEquals(100.0, miRevista.getPrecioSuscripcionMensual(), 0.1);
	}

	@Test
	public void precioDeLaSuscripcionAnualEsCorrecta() {
		miRevista.setFrecuenciaMensual(4);
		Assert.assertEquals(960.0, miRevista.getPrecioSuscripcionAnual(), 0.1);
	}

	@Test
	public void montoAcobrarMensualConSuscripcionAnual() {
		miRevista.setFrecuenciaMensual(4);
		Assert.assertEquals(80.0, miRevista.getPrecioMensualConSuscripcionAnual(), 0.1);
	}

}
