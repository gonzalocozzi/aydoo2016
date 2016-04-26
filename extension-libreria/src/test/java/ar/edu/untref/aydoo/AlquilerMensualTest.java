package ar.edu.untref.aydoo;

import java.time.Month;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlquilerMensualTest {
	
	private Libreria miLibreria;
	private Cliente maria;
	private Libro elHobbit;
	private ComprasDelMes comprasDeDiciembre;

	@Before
	public void inicializar() throws RepeatedMonthException, NegativePriceException {

		miLibreria = new Libreria("La Libreria de Pepe");
		maria = new Cliente("Maria Rosales", "32.654.789", "Mosconi 1445");
		elHobbit = new Libro("El Hobbit", 50.0);
		comprasDeDiciembre = new ComprasDelMes("Compras del mes de diciembre", Month.DECEMBER);	
		maria.agregarCompraDelMes(comprasDeDiciembre);
		miLibreria.registrarCliente(maria);
	}
	
	@Test
	public void alquilerMensualRegistraLibroAlquilado() throws NegativePriceException{
		
		AlquilerMensual alquilerDelHobbit = new AlquilerMensual("Alquiler de El Hobbit", 0, 0);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);
		
		String nombreDelLibroAlquilado = alquilerDelHobbit.getLibroAlquilado().getNombre();
		
		Assert.assertEquals("El Hobbit", nombreDelLibroAlquilado);
	}
	
	@Test
	public void alquilerMensualRegistraMesesDelAlquiler() throws InvalidRentalException, NegativePriceException{
		
		AlquilerMensual alquilerDelHobbit = new AlquilerMensual("Alquiler por un mes de El Hobbit", 0, 0);
		alquilerDelHobbit.setMesesDelAlquiler(1);
		
		int numeroDeMeses = alquilerDelHobbit.getPeriodoDelAlquiler();
		
		Assert.assertEquals(1, numeroDeMeses);
	}
	
	@Test
	public void clienteAlquilaUnEjemplarDelHobbitPorUnMes() throws UnregisteredClientException, RepeatedMonthException, InvalidRentalException, NegativePriceException, InexistentMonthException{		

		AlquilerMensual alquilerDelHobbit = new AlquilerMensual("Alquiler por un mes de El Hobbit", 0, 200);
		alquilerDelHobbit.setMesesDelAlquiler(1);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);		
		maria.comprar(miLibreria, Month.DECEMBER, alquilerDelHobbit);
		
		double montoACobrar = miLibreria.calcularMontoACobrar(Month.DECEMBER, maria);

		Assert.assertEquals(200.0, montoACobrar, 0.0);
	}
	
	@Test
	public void clienteAlquilaUnEjemplarDelHobbitPorTresMeses() throws UnregisteredClientException, RepeatedMonthException, InvalidRentalException, NegativePriceException, InexistentMonthException{		

		AlquilerMensual alquilerDelHobbit = new AlquilerMensual("Alquiler por 3 meses de El Hobbit", 0, 200);
		alquilerDelHobbit.setMesesDelAlquiler(3);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);		
		maria.comprar(miLibreria, Month.DECEMBER, alquilerDelHobbit);
		
		double montoACobrar = miLibreria.calcularMontoACobrar(Month.DECEMBER, maria);

		Assert.assertEquals(600.0, montoACobrar, 0.0);
	}
	
	@Test(expected=InvalidRentalException.class)
	public void clienteNoPuedeAlquilarUnLibroPorMenosDeUnMes() throws InvalidRentalException, NegativePriceException{

		AlquilerMensual alquilerDelHobbit = new AlquilerMensual("Alquiler de El Hobbit", 0, 0);
		alquilerDelHobbit.setMesesDelAlquiler(0);
	}
	
	@Test(expected=InvalidRentalException.class)
	public void clienteNoPuedeAlquilarUnLibroPorMasDe3Meses() throws InvalidRentalException, NegativePriceException{

		AlquilerMensual alquilerDelHobbit = new AlquilerMensual("Alquiler de El Hobbit", 0, 0);
		alquilerDelHobbit.setMesesDelAlquiler(4);
	}

}
