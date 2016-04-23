package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CompraDelMesTest {

	private ComprasDelMes agosto;

	private Libro elHobbit;
	private ArticuloDeLibreria lapicera;
	private RevistayPeriodico elGrafico;

	@Before
	public void inicializar() {
		agosto = new ComprasDelMes("Agosto");

		elHobbit = new Libro("El Hobbit", 50.0);
		lapicera = new ArticuloDeLibreria("Lapicera", 5.0);
		lapicera.aplicarIva();
		elGrafico = new RevistayPeriodico("El Grafico", 30.0, 4);

		agosto.AgregarCompra(elHobbit);
		agosto.AgregarCompra(lapicera);
		agosto.AgregarCompra(elGrafico);
	}

	@Test
	public void NombreDeCompraDelMesEsCorrecto() {
		Assert.assertEquals("Agosto", agosto.getNombre());
	}

	@Test
	public void TotalAPagarDeCompraDelMesEsCorrecto() {
		Assert.assertEquals(86.05, agosto.calcularGastoDelMes(), 0.1);
	}

}
