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

	private ComprasDelMes agosto;
	private ComprasDelMes enero;

	@Before
	public void inicializar() throws RepeatedMonthException {

		miLibreria = new Libreria("La Libreria de Pepe");

		juan = new Cliente("Juan Olmos", "15.263.998", "Asamble 2314");
		maria = new Cliente("Maria Rosales", "32.654.789", "Mosconi 1445");
		mario = new Cliente("Mario Rosales", "33.644.571", "Rauch 4568");

		elHobbit = new Libro("El Hobbit", 50.0);
		lapicera = new ArticuloDeLibreria("Lapicera", 5.0);
		elGrafico = new RevistayPeriodico("El grafico", 30.0, 4);
		barcelona = new RevistayPeriodico("Barcelona", 20.0, 2);
		pagina12 = new RevistayPeriodico("Pagina12", 12.0, 30);

		suscripcionesMaria = new Suscripcion("Suscripciones Maria Rosales", 0);
		suscripcionesMaria.AgregarRevistaOPeriodico(barcelona);	

		suscripcionesJuan = new Suscripcion("Suscripciones Juan Olmos", 0);
		suscripcionesJuan.AgregarRevistaOPeriodico(elGrafico);
		suscripcionesJuan.AgregarRevistaOPeriodico(barcelona);		

		agosto = new ComprasDelMes("Compras de agosto", Month.AUGUST);
		enero = new ComprasDelMes("Compras de enero", Month.JANUARY);
		
		juan.agregarComprasDelMes(agosto);		
		juan.agregarComprasDelMes(enero);
		maria.agregarComprasDelMes(enero);		

		miLibreria.agregarCliente(juan);
		miLibreria.agregarCliente(maria);
	}

	@Test
	public void cobrarleAJuanMesDeAgosto() {
		
		miLibreria.comprar(juan, elHobbit, Month.AUGUST);
		miLibreria.comprar(juan, lapicera, Month.AUGUST);
		miLibreria.comprar(juan, lapicera, Month.AUGUST);
		miLibreria.comprar(juan, elGrafico, Month.AUGUST);

		Assert.assertEquals(92.1, miLibreria.calcularMontoACobrar(Month.AUGUST, juan), 0.1);
	}

	@Test
	public void cobrarleAMariaMesDeEnero() {
		
		miLibreria.comprar(maria, suscripcionesMaria, Month.JANUARY);
		miLibreria.comprar(maria, pagina12, Month.JANUARY);
		
		Assert.assertEquals(44.0, miLibreria.calcularMontoACobrar(Month.JANUARY, maria), 0.1);
	}

	@Test
	public void nombreDelaLibreriaEsCorrecto() {
		Assert.assertEquals("La Libreria de Pepe", miLibreria.getNombre());
	}

	@Test
	public void cobrarleAJuanMesDeEnero() {
		miLibreria.comprar(juan, elHobbit, Month.JANUARY);
		miLibreria.comprar(juan, lapicera, Month.JANUARY);
		miLibreria.comprar(juan, lapicera, Month.JANUARY);
		miLibreria.comprar(juan, suscripcionesJuan, Month.JANUARY);

		Assert.assertEquals(190.1, miLibreria.calcularMontoACobrar(Month.JANUARY, juan), 0.1);
	}
	
	@Test(expected = Error.class)
	public void ElClienteNoExiste() {
		miLibreria.comprar(mario, pagina12, Month.JANUARY);
	}

}
