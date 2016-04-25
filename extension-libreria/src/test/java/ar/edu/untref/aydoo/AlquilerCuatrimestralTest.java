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
	public void inicializar() throws RepeatedMonthException {

		miLibreria = new Libreria("La Libreria de Pepe");
		maria = new Cliente("Maria Rosales", "32.654.789", "Mosconi 1445");
		elHobbit = new Libro("El Hobbit", 50.0);
		comprasDeDiciembre = new ComprasDelMes("Compras del mes de diciembre", Month.DECEMBER);	
		maria.agregarCompraDelMes(comprasDeDiciembre);
		miLibreria.registrarCliente(maria);
	}
	
	@Test
	public void alquilerCuatrimestralRegistraLibroAlquilado(){
		
		AlquilerCuatrimestral alquilerDelHobbit = new AlquilerCuatrimestral("Alquiler de El Hobbit", 0);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);
		
		Assert.assertEquals("El Hobbit", alquilerDelHobbit.getLibroAlquilado().getNombre());
	}
	
	@Test
	public void alquilerMensualRegistraCuatrimestresDelAlquiler() throws InvalidRentalException{
		
		AlquilerCuatrimestral alquilerDelHobbit = new AlquilerCuatrimestral("Alquiler por dos meses de El Hobbit", 0);
		alquilerDelHobbit.setMesesDelAlquiler(2);
		
		Assert.assertEquals(2, alquilerDelHobbit.getCuatrimestresDelAlquiler());
	}
	
	@Test
	public void clienteAlquilaUnEjemplarDelHobbitPorUnMes() throws UnregisteredClientException, RepeatedMonthException, InvalidRentalException{		

		AlquilerCuatrimestral alquilerDelHobbit = new AlquilerCuatrimestral("Alquiler por un cuatrimestre de El Hobbit", 0);
		alquilerDelHobbit.setMesesDelAlquiler(1);
		alquilerDelHobbit.setLibroAlquilado(elHobbit);
		
		maria.comprar(miLibreria, Month.DECEMBER, alquilerDelHobbit);

		Assert.assertEquals(720.0, miLibreria.calcularMontoACobrar(Month.DECEMBER, maria), 0.1);
	}

}
