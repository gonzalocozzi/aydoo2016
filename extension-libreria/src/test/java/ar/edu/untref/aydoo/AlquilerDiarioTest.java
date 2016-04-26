package ar.edu.untref.aydoo;

import java.time.Month;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlquilerDiarioTest {

	private Libreria miLibreria;
	private Cliente juan;
	private Libro elHobbit;
	private ComprasDelMes comprasDeOctubre;

	@Before
	public void inicializar() throws RepeatedMonthException, NegativePriceException {

		miLibreria = new Libreria("La Libreria de Pepe");
		juan = new Cliente("Juan Olmos", "15.263.998", "Asamblea 2314");
		elHobbit = new Libro("El Hobbit", 50.0);
		comprasDeOctubre = new ComprasDelMes("Compras del mes de octubre", Month.OCTOBER);	
		juan.agregarCompraDelMes(comprasDeOctubre);
		miLibreria.registrarCliente(juan);
	}
	
	@Test
	public void alquilerDiarioRegistraLibroAlquilado() throws InvalidRentalException, NegativePriceException{
		
		AlquilerDiario alquilerDelHobbit = new AlquilerDiario("Alquiler por 7 dias de El Hobbit", 0, 0);
		alquilerDelHobbit.setDiasDelAlquiler(7);
		
		int numeroDeDias = alquilerDelHobbit.getPeriodoDelAlquiler();
		
		Assert.assertEquals(7, numeroDeDias, 0);
	}
	
	@Test
	public void alquilerDiarioRegistraDiasDelAlquiler() throws NegativePriceException{
		
		AlquilerDiario alquilerDelHobbit = new AlquilerDiario("Alquiler por 3 dias de El Hobbit", 0, 0);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);
		
		String nombreDelLibroAlquilado = alquilerDelHobbit.getLibroAlquilado().getNombre();
		
		Assert.assertEquals("El Hobbit", nombreDelLibroAlquilado);
	}

	@Test
	public void clienteAlquilaUnEjemplarDelHobbitPor3Dias() throws UnregisteredClientException, RepeatedMonthException, InvalidRentalException, NegativePriceException, InexistentMonthException{		

		AlquilerDiario alquilerDelHobbit = new AlquilerDiario("Alquiler por 3 dias de El Hobbit", 0, 10);
		alquilerDelHobbit.setDiasDelAlquiler(3);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);
		juan.comprar(miLibreria, Month.OCTOBER, alquilerDelHobbit);
		
		double montoACobrar = miLibreria.calcularMontoACobrar(Month.OCTOBER, juan);

		Assert.assertEquals(30.0, montoACobrar, 0.0);
	}

	@Test
	public void clienteAlquilaUnEjemplarDelHobbitPor25Dias() throws UnregisteredClientException, RepeatedMonthException, InvalidRentalException, NegativePriceException, InexistentMonthException{		

		AlquilerDiario alquilerDelHobbit = new AlquilerDiario("Alquiler por 25 dias de El Hobbit", 0, 10);
		alquilerDelHobbit.setDiasDelAlquiler(25);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);
		juan.comprar(miLibreria, Month.OCTOBER, alquilerDelHobbit);
		
		double montoACobrar = miLibreria.calcularMontoACobrar(Month.OCTOBER, juan);

		Assert.assertEquals(250.0, montoACobrar, 0.0);
	}

	@Test(expected=InvalidRentalException.class)
	public void clienteNoPuedeAlquilarUnLibroPorMenosDe3Dias() throws InvalidRentalException, NegativePriceException{

		AlquilerDiario alquilerDelHobbit = new AlquilerDiario("Alquiler por 2 dias de El Hobbit", 0, 0);
		alquilerDelHobbit.setDiasDelAlquiler(2);
	}
	
	@Test(expected=InvalidRentalException.class)
	public void clienteNoPuedeAlquilarUnLibroPorMasDe25Dias() throws InvalidRentalException, NegativePriceException{

		AlquilerDiario alquilerDelHobbit = new AlquilerDiario("Alquiler por 26 dias de El Hobbit", 0, 0);
		alquilerDelHobbit.setDiasDelAlquiler(26);
	}
}
