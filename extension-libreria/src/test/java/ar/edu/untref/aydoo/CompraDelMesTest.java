package ar.edu.untref.aydoo;

import java.time.Month;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CompraDelMesTest {

	private ComprasDelMes agosto;

	private Libro elHobbit;
	private ArticuloDeLibreria lapicera;
	private RevistayPeriodico elGrafico;

	@Before
	public void inicializar() throws NegativePriceException {
		
		agosto = new ComprasDelMes("Compras de agosto", Month.AUGUST);

		elHobbit = new Libro("El Hobbit", 50.0);
		lapicera = new ArticuloDeLibreria("Lapicera", 5.0);
		elGrafico = new RevistayPeriodico("El Grafico", 30.0, 4);

		agosto.agregarCompra(elHobbit);
		agosto.agregarCompra(lapicera);
		agosto.agregarCompra(elGrafico);
	}

	@Test
	public void NombreDeCompraDelMesEsCorrecto() {
		
		String nombreDeLaCompra = agosto.getNombre();
		
		Assert.assertEquals("Compras de agosto", nombreDeLaCompra);
	}

	@Test
	public void TotalAPagarDeCompraDelMesEsCorrecto() {
		
		double gastoDeLaCompra = agosto.calcularGastoDelMes();
		
		Assert.assertEquals(86.05, gastoDeLaCompra, 0.0);
	}

}
