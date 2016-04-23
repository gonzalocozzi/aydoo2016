package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

	private Cliente juan;
	private Cliente maria;

	private Libro elHobbit;
	private ArticuloDeLibreria lapicera;
	private RevistayPeriodico elGrafico;
	private RevistayPeriodico barcelona;
	private RevistayPeriodico pagina12;
	private Suscripcion SuscripcionesMaria;

	private ComprasDelMes agosto;
	private ComprasDelMes enero;
	private ComprasDelMes febrero;

	@Before
	public void inicializar() {

		juan = new Cliente("Juan Olmos", "15.263.998", "Asamble 2314");
		maria = new Cliente("Maria Rosales", "32.654.789", "Mosconi 1445");

		elHobbit = new Libro("El Hobbit", 50.0);
		lapicera = new ArticuloDeLibreria("Lapicera", 5.0);
		lapicera.aplicarIva();
		elGrafico = new RevistayPeriodico("El grafico", 30.0, 4);
		barcelona = new RevistayPeriodico("Barcelona", 20.0, 2);
		pagina12 = new RevistayPeriodico("Pagina12", 12.0, 30);
		pagina12.setFrecuenciaMensual(30);

		SuscripcionesMaria = new Suscripcion("Suscripcion anual revista Barcelona", 0);
		SuscripcionesMaria.AgregarRevistaOPeriodico(barcelona);
		SuscripcionesMaria.setPrecio(SuscripcionesMaria.getMontoACobrarSuscripciones());

		agosto = new ComprasDelMes("Agosto");
		enero = new ComprasDelMes("Enero");
		febrero = new ComprasDelMes("Febrero");

		juan.agregarComprasDelMes(agosto);
		maria.agregarComprasDelMes(enero);

	}

	@Test
	public void cobrarleAJuanMesDeAgosto() {
		juan.comprar(agosto, elHobbit);
		juan.comprar(agosto, lapicera);
		juan.comprar(agosto, lapicera);
		juan.comprar(agosto, elGrafico);

		Assert.assertEquals(92.1, juan.calcularGastoDelMes(agosto), 0.1);
	}

	@Test
	public void cobrarleAMariaMesDeEnero() {
		maria.comprar(enero, SuscripcionesMaria);
		maria.comprar(enero, pagina12);

		Assert.assertEquals(44.0, maria.calcularGastoDelMes(enero), 0.1);
	}

	@Test
	public void nombreDelClienteEsCorrecto() {
		Assert.assertEquals("Juan Olmos", juan.getNombre());
	}

	@Test
	public void DNIDelClienteEsCorrecto() {
		Assert.assertEquals("15.263.998", juan.getDNI());
	}

	@Test
	public void direccionDelClienteEsCorrecto() {
		Assert.assertEquals("Asamble 2314", juan.getDireccion());
	}
	
	@Test(expected = Error.class)
	public void MesNoIngresado() {
		maria.comprar(febrero, SuscripcionesMaria);
	}

}
