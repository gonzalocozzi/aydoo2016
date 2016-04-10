package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {
	
	@Test
	public void seAgregaNombreAlCliente() {
		
		Cliente cliente = new Cliente();
		
		cliente.setNombre("juan perez");
		
		Assert.assertEquals("juan perez", cliente.getNombre());
	}
	
	@Test
	public void seAgregaDireccionAlCliente(){
		
		Cliente cliente = new Cliente();
		
		cliente.setDireccion("Montes de Oca 4720, CABA");
		
		Assert.assertEquals("Montes de Oca 4720, CABA", cliente.getDireccion());
	}

}
