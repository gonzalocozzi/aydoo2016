package ar.edu.untref.aydoo;

import java.time.Month;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlquilerMensualTest {
	
	private Libreria miLibreria;
	private Cliente maria;
	private Libro elHobbit;
	ComprasDelMes comprasDeDiciembre;

	@Before
	public void inicializar() throws RepeatedMonthException {

		miLibreria = new Libreria("La Libreria de Pepe");
		maria = new Cliente("Maria Rosales", "32.654.789", "Mosconi 1445");
		elHobbit = new Libro("El Hobbit", 50.0);
		comprasDeDiciembre = new ComprasDelMes("Compras del mes de diciembre", Month.DECEMBER);	
		maria.agregarCompraDelMes(comprasDeDiciembre);
		miLibreria.registrarCliente(maria);
	}
	
	@Test
	public void alquilerMensualRegistraLibroAlquilado(){
		
		AlquilerMensual alquilerDelHobbit = new AlquilerMensual("Alquiler de El Hobbit", 0, 0);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);
		
		Assert.assertEquals("El Hobbit", alquilerDelHobbit.getLibroAlquilado().getNombre());
	}
	
	@Test
	public void alquilerMensualRegistraMesesDelAlquiler() throws InvalidRentalException{
		
		AlquilerMensual alquilerDelHobbit = new AlquilerMensual("Alquiler por un mes de El Hobbit", 0, 0);
		alquilerDelHobbit.setMesesDelAlquiler(1);
		
		Assert.assertEquals(1, alquilerDelHobbit.getPeriodoDelAlquiler());
	}
	
	@Test
	public void clienteAlquilaUnEjemplarDelHobbitPorUnMes() throws UnregisteredClientException, RepeatedMonthException, InvalidRentalException{		

		AlquilerMensual alquilerDelHobbit = new AlquilerMensual("Alquiler por un mes de El Hobbit", 0, 200);
		alquilerDelHobbit.setMesesDelAlquiler(1);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);
		
		maria.comprar(miLibreria, Month.DECEMBER, alquilerDelHobbit);

		Assert.assertEquals(200.0, miLibreria.calcularMontoACobrar(Month.DECEMBER, maria), 0.1);
	}
	
	@Test
	public void clienteAlquilaUnEjemplarDelHobbitPorTresMeses() throws UnregisteredClientException, RepeatedMonthException, InvalidRentalException{		

		AlquilerMensual alquilerDelHobbit = new AlquilerMensual("Alquiler por 3 meses de El Hobbit", 0, 200);
		alquilerDelHobbit.setMesesDelAlquiler(3);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);
		
		maria.comprar(miLibreria, Month.DECEMBER, alquilerDelHobbit);

		Assert.assertEquals(600.0, miLibreria.calcularMontoACobrar(Month.DECEMBER, maria), 0.1);
	}
	
	@Test(expected=InvalidRentalException.class)
	public void clienteNoPuedeAlquilarUnLibroPorMenosDeUnMes() throws InvalidRentalException{

		AlquilerMensual alquilerDelHobbit = new AlquilerMensual("Alquiler de El Hobbit", 0, 0);
		alquilerDelHobbit.setMesesDelAlquiler(0);
	}
	
	@Test(expected=InvalidRentalException.class)
	public void clienteNoPuedeAlquilarUnLibroPorMasDe3Meses() throws InvalidRentalException{

		AlquilerMensual alquilerDelHobbit = new AlquilerMensual("Alquiler de El Hobbit", 0, 0);
		alquilerDelHobbit.setMesesDelAlquiler(4);
	}

}
