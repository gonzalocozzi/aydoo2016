package ar.edu.untref.aydoo;

import java.time.Month;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlquilerDiarioTest {

	private Libreria miLibreria;
	private Cliente juan;
	private Libro elHobbit;
	ComprasDelMes comprasDeOctubre;

	@Before
	public void inicializar() throws RepeatedMonthException {

		miLibreria = new Libreria("La Libreria de Pepe");
		juan = new Cliente("Juan Olmos", "15.263.998", "Asamblea 2314");
		elHobbit = new Libro("El Hobbit", 50.0);
		comprasDeOctubre = new ComprasDelMes("Compras del mes de octubre", Month.OCTOBER);	
		juan.agregarCompraDelMes(comprasDeOctubre);
		miLibreria.registrarCliente(juan);
	}
	
	@Test
	public void alquilerDiarioRegistraLibroAlquilado() throws InvalidRentalException{
		
		AlquilerDiario alquilerDelHobbit = new AlquilerDiario("Alquiler por 7 dias de El Hobbit", 0);
		alquilerDelHobbit.setDiasDelAlquiler(7);
		
		Assert.assertEquals(7, alquilerDelHobbit.getDiasDelAlquiler(), 0);
	}
	
	@Test
	public void alquilerDiarioRegistraDiasDelAlquiler(){
		
		AlquilerDiario alquilerDelHobbit = new AlquilerDiario("Alquiler por 3 dias de El Hobbit", 0);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);
		
		Assert.assertEquals("El Hobbit", alquilerDelHobbit.getLibroAlquilado().getNombre());
	}

	@Test
	public void clienteAlquilaUnEjemplarDelHobbitPor3Dias() throws UnregisteredClientException, RepeatedMonthException, InvalidRentalException{		

		AlquilerDiario alquilerDelHobbit = new AlquilerDiario("Alquiler por 3 dias de El Hobbit", 0);
		alquilerDelHobbit.setDiasDelAlquiler(3);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);

		juan.comprar(miLibreria, Month.OCTOBER, alquilerDelHobbit);

		Assert.assertEquals(30.0, miLibreria.calcularMontoACobrar(Month.OCTOBER, juan), 0.1);
	}

	@Test
	public void clienteAlquilaUnEjemplarDelHobbitPor25Dias() throws UnregisteredClientException, RepeatedMonthException, InvalidRentalException{		

		AlquilerDiario alquilerDelHobbit = new AlquilerDiario("Alquiler por 25 dias de El Hobbit", 0);
		alquilerDelHobbit.setDiasDelAlquiler(25);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);

		juan.comprar(miLibreria, Month.OCTOBER, alquilerDelHobbit);

		Assert.assertEquals(250.0, miLibreria.calcularMontoACobrar(Month.OCTOBER, juan), 0.1);
	}

	@Test(expected=InvalidRentalException.class)
	public void clienteNoPuedeAlquilarUnLibroPorMenosDe3Dias() throws InvalidRentalException{

		AlquilerDiario alquilerDelHobbit = new AlquilerDiario("Alquiler por 2 dias de El Hobbit", 0);
		alquilerDelHobbit.setDiasDelAlquiler(2);
	}
	
	@Test(expected=InvalidRentalException.class)
	public void clienteNoPuedeAlquilarUnLibroPorMasDe25Dias() throws InvalidRentalException{

		AlquilerDiario alquilerDelHobbit = new AlquilerDiario("Alquiler por 26 dias de El Hobbit", 0);
		alquilerDelHobbit.setDiasDelAlquiler(26);
	}
}
