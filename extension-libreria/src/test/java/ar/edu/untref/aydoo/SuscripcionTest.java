package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SuscripcionTest {
	
	Suscripcion suscripcionDePrueba;
	RevistayPeriodico brando;
	RevistayPeriodico viva;
	
	@Before
	public void inicializar() throws NegativePriceException{
		
		suscripcionDePrueba = new Suscripcion("Suscripcion de prueba", 0);
		brando = new RevistayPeriodico("Brando", 25.0, 2);
		viva = new RevistayPeriodico("Viva", 20.0, 4);
	}
	
	@Test
	public void suscripcionAgregaUnProducto() throws NegativePriceException{
		
		suscripcionDePrueba.agregarRevistaOPeriodico(brando);
		
		boolean contieneLaRevista = suscripcionDePrueba.contiene(brando);
		
		Assert.assertTrue(contieneLaRevista);
	}
	
	@Test
	public void suscripcionInformaSuPrecioConteniendoUnProducto() throws NegativePriceException{
		
		suscripcionDePrueba.agregarRevistaOPeriodico(viva);
		
		double precioDeLaSuscripcion = suscripcionDePrueba.getPrecio();
		
		Assert.assertEquals(80.0, precioDeLaSuscripcion, 0.0);
	}
	
	@Test
	public void suscripcionInformaSuPrecioConteniendoVariosProducto() throws NegativePriceException{
		
		suscripcionDePrueba.agregarRevistaOPeriodico(brando);
		suscripcionDePrueba.agregarRevistaOPeriodico(viva);
		
		double precioDeLaSuscripcion = suscripcionDePrueba.getPrecio();
		
		Assert.assertEquals(130.0, precioDeLaSuscripcion, 0.0);
	}

}
