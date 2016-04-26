package ar.edu.untref.aydoo;

import java.time.Month;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlquilerCuatrimestralTest {
	
	private Libreria miLibreria;
	private Cliente maria;
	private Libro elHobbit;
	ComprasDelMes comprasDeDiciembre;

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
	public void alquilerCuatrimestralRegistraLibroAlquilado() throws NegativePriceException{
		
		AlquilerCuatrimestral alquilerDelHobbit = new AlquilerCuatrimestral("Alquiler de El Hobbit", 0, 0);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);
		
		String nombreDelLibroAlquilado = alquilerDelHobbit.getLibroAlquilado().getNombre();
		
		Assert.assertEquals("El Hobbit", nombreDelLibroAlquilado);
	}
	
	@Test
	public void alquilerMensualRegistraCuatrimestresDelAlquiler() throws InvalidRentalException, NegativePriceException{
		
		AlquilerCuatrimestral alquilerDelHobbit = new AlquilerCuatrimestral("Alquiler por dos meses de El Hobbit", 0, 0);
		alquilerDelHobbit.setCuatrimestresDelAlquiler(2);
		
		int numeroDeCuatrimestres = alquilerDelHobbit.getCuatrimestresDelAlquiler();
		
		Assert.assertEquals(2, numeroDeCuatrimestres);
	}
	
	@Test
	public void clienteAlquilaUnEjemplarDelHobbitPorUnCuatrimestre() throws UnregisteredClientException, RepeatedMonthException, InvalidRentalException, NegativePriceException, InexistentMonthException{		

		AlquilerCuatrimestral alquilerDelHobbit = new AlquilerCuatrimestral("Alquiler por un cuatrimestre de El Hobbit", 0, 200);
		alquilerDelHobbit.setCuatrimestresDelAlquiler(1);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);
		
		maria.comprar(miLibreria, Month.DECEMBER, alquilerDelHobbit);
		
		double montoACobrar = miLibreria.calcularMontoACobrar(Month.DECEMBER, maria);

		Assert.assertEquals(720.0, montoACobrar, 0.0);
	}
	
	@Test
	public void clienteAlquilaUnEjemplarDelHobbitPorDosCuatrimestres() throws UnregisteredClientException, RepeatedMonthException, InvalidRentalException, NegativePriceException, InexistentMonthException{		

		AlquilerCuatrimestral alquilerDelHobbit = new AlquilerCuatrimestral("Alquiler por un cuatrimestre de El Hobbit", 0, 200);
		alquilerDelHobbit.setCuatrimestresDelAlquiler(2);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);
		
		maria.comprar(miLibreria, Month.DECEMBER, alquilerDelHobbit);
		
		double montoACobrar = miLibreria.calcularMontoACobrar(Month.DECEMBER, maria);

		Assert.assertEquals(1440.0, montoACobrar, 0.0);
	}
	
	@Test(expected=InvalidRentalException.class)
	public void clienteNoPuedeAlquilarUnLibroPorMenosDeUnCuatrimestre() throws InvalidRentalException, NegativePriceException{

		AlquilerCuatrimestral alquilerDelHobbit = new AlquilerCuatrimestral("Alquiler por un cuatrimestre de El Hobbit", 0, 0);
		alquilerDelHobbit.setCuatrimestresDelAlquiler(0);
	}
	
	@Test(expected=InvalidRentalException.class)
	public void clienteNoPuedeAlquilarUnLibroPorMasDe2Cuatrimestre() throws InvalidRentalException, NegativePriceException{

		AlquilerCuatrimestral alquilerDelHobbit = new AlquilerCuatrimestral("Alquiler por un cuatrimestre de El Hobbit", 0, 0);
		alquilerDelHobbit.setCuatrimestresDelAlquiler(3);
	}

}
