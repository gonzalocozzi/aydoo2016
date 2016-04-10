package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {
	
	@Test
	public void seAgregaNombreACliente() {
		
		Cliente cliente = new Cliente();
		
		cliente.setNombre("juan perez");
		
		Assert.assertEquals("juan perez", cliente.getNombre());
	}

}
