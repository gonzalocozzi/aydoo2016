package ar.edu.untref.aydoo;

import java.time.Month;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LibreriaTest {

	private Libreria miLibreria;

	private Cliente juan;
	private Cliente maria;
	private Cliente mario;

	private Libro elHobbit;
	private ArticuloDeLibreria lapicera;
	private RevistayPeriodico elGrafico;
	private RevistayPeriodico barcelona;
	private RevistayPeriodico pagina12;
	private Suscripcion suscripcionesMaria;
	private Suscripcion suscripcionesJuan;

	private ComprasDelMes comprasDeAgosto;
	private ComprasDelMes comprasDeEnero;

	@Before
	public void inicializar() throws RepeatedMonthException {

		miLibreria = new Libreria("La Libreria de Pepe");

		juan = new Cliente("Juan Olmos", "15.263.998", "Asamblea 2314");
		maria = new Cliente("Maria Rosales", "32.654.789", "Mosconi 1445");
		mario = new Cliente("Mario Rosales", "33.644.571", "Rauch 4568");

		elHobbit = new Libro("El Hobbit", 50.0);
		lapicera = new ArticuloDeLibreria("Lapicera", 5.0);
		elGrafico = new RevistayPeriodico("El grafico", 30.0, 4);
		barcelona = new RevistayPeriodico("Barcelona", 20.0, 2);
		pagina12 = new RevistayPeriodico("Pagina12", 12.0, 30);

		suscripcionesMaria = new SuscripcionAnual("Suscripciones Maria Rosales", 0);
		suscripcionesMaria.AgregarRevistaOPeriodico(barcelona);	

		suscripcionesJuan = new SuscripcionAnual("Suscripciones Juan Olmos", 0);
		suscripcionesJuan.AgregarRevistaOPeriodico(elGrafico);
		suscripcionesJuan.AgregarRevistaOPeriodico(barcelona);		

		comprasDeAgosto = new ComprasDelMes("Compras de agosto", Month.AUGUST);
		comprasDeEnero = new ComprasDelMes("Compras de enero", Month.JANUARY);
		
		juan.agregarCompraDelMes(comprasDeAgosto);		
		juan.agregarCompraDelMes(comprasDeEnero);
		maria.agregarCompraDelMes(comprasDeEnero);		

		miLibreria.registrarCliente(juan);
		miLibreria.registrarCliente(maria);
	}

	@Test
	public void cobrarleAJuanMesDeAgosto() throws UnregisteredClientException {
		
		juan.comprar(miLibreria, Month.AUGUST, elHobbit);
		juan.comprar(miLibreria, Month.AUGUST, lapicera);
		juan.comprar(miLibreria, Month.AUGUST, lapicera);
		juan.comprar(miLibreria, Month.AUGUST, elGrafico);

		Assert.assertEquals(92.1, miLibreria.calcularMontoACobrar(Month.AUGUST, juan), 0.1);
	}

	@Test
	public void cobrarleAMariaMesDeEnero() throws UnregisteredClientException {
		
		maria.comprar(miLibreria, Month.JANUARY, suscripcionesMaria);
		maria.comprar(miLibreria, Month.JANUARY, pagina12);
		
		Assert.assertEquals(44.0, miLibreria.calcularMontoACobrar(Month.JANUARY, maria), 0.1);
	}

	@Test
	public void nombreDelaLibreriaEsCorrecto() {
		
		Assert.assertEquals("La Libreria de Pepe", miLibreria.getNombre());
	}

	@Test
	public void cobrarleAJuanMesDeEnero() throws UnregisteredClientException {

		juan.comprar(miLibreria, Month.JANUARY, elHobbit);
		juan.comprar(miLibreria, Month.JANUARY, lapicera);
		juan.comprar(miLibreria, Month.JANUARY, lapicera);
		juan.comprar(miLibreria, Month.JANUARY, suscripcionesJuan);
		
		Assert.assertEquals(190.1, miLibreria.calcularMontoACobrar(Month.JANUARY, juan), 0.1);
	}
	
	@Test(expected = UnregisteredClientException.class)
	public void ElClienteNoExiste() throws UnregisteredClientException {
		mario.comprar(miLibreria, Month.JANUARY, pagina12);
	}

}
