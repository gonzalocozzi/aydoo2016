package ar.edu.untref.aydoo;

import java.time.Month;

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
	private ComprasDelMes enero2;
	@SuppressWarnings("unused")
	private ComprasDelMes febrero;
	
	Libreria miLibreria;

	@Before
	public void inicializar() throws RepeatedMonthException, NegativePriceException {

		juan = new Cliente("Juan Olmos", "15.263.998", "Asamble 2314");
		maria = new Cliente("Maria Rosales", "32.654.789", "Mosconi 1445");

		elHobbit = new Libro("El Hobbit", 50.0);
		lapicera = new ArticuloDeLibreria("Lapicera", 5.0);;
		elGrafico = new RevistayPeriodico("El grafico", 30.0, 4);
		barcelona = new RevistayPeriodico("Barcelona", 20.0, 2);
		pagina12 = new RevistayPeriodico("Pagina12", 12.0, 30);
		pagina12.setFrecuenciaMensual(30);

		SuscripcionesMaria = new SuscripcionAnual("Suscripcion anual revista Barcelona", 0);
		SuscripcionesMaria.agregarRevistaOPeriodico(barcelona);

		agosto = new ComprasDelMes("Compras del mes de agosto", Month.AUGUST);
		enero = new ComprasDelMes("Enero", Month.JANUARY);
		enero2 = new ComprasDelMes("Compras del mes de agosto", Month.JANUARY);
		febrero = new ComprasDelMes("Febrero", Month.FEBRUARY);

		juan.agregarCompraDelMes(agosto);
		maria.agregarCompraDelMes(enero);
		
		miLibreria = new Libreria("Libreria de prueba");
		miLibreria.registrarCliente(juan);
		miLibreria.registrarCliente(maria);
	}
	
	@Test
	public void nombreDelClienteEsCorrecto() {
		
		String nombreDelCliente = juan.getNombre();
		
		Assert.assertEquals("Juan Olmos", nombreDelCliente);
	}
	
	@Test
	public void DNIDelClienteEsCorrecto() {
		
		String dniDelCliente = juan.getDNI();
		
		Assert.assertEquals("15.263.998", dniDelCliente);
	}
	
	@Test
	public void direccionDelClienteEsCorrecto() {
		
		String direccionDelCliente = juan.getDireccion();
		
		Assert.assertEquals("Asamble 2314", direccionDelCliente);
	}

	@Test
	public void cobrarleAJuanMesDeAgosto() throws UnregisteredClientException, InexistentMonthException {
		
		juan.comprar(miLibreria, Month.AUGUST, elHobbit);
		juan.comprar(miLibreria, Month.AUGUST, lapicera);
		juan.comprar(miLibreria, Month.AUGUST, lapicera);
		juan.comprar(miLibreria, Month.AUGUST, elGrafico);
		
		double gastoDelMes = juan.calcularGastoDelMes(Month.AUGUST);

		Assert.assertEquals(92.1, gastoDelMes, 0.0);
	}

	@Test
	public void cobrarleAMariaMesDeEnero() throws UnregisteredClientException, InexistentMonthException {
		
		maria.comprar(miLibreria, Month.JANUARY, SuscripcionesMaria);
		maria.comprar(miLibreria, Month.JANUARY, pagina12);
		
		double gastoDelMes = maria.calcularGastoDelMes(Month.JANUARY);
		
		Assert.assertEquals(44.0, gastoDelMes, 0.0);
	}
	
	@Test(expected = InexistentMonthException.class)
	public void cobrarleAMariaMesDeFebrero() throws InexistentMonthException{
		
		maria.calcularGastoDelMes(Month.FEBRUARY);
	}
	
	@Test(expected = InexistentMonthException.class)
	public void mesNoIngresado() throws UnregisteredClientException, InexistentMonthException {
		
		maria.comprar(miLibreria, Month.FEBRUARY, SuscripcionesMaria);
	}
	
	
	@Test(expected = RepeatedMonthException.class)
	public void mesYaIngresado() throws RepeatedMonthException {
		
		maria.agregarCompraDelMes(enero2);
	}

}
