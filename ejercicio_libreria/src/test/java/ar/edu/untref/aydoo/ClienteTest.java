package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {

	@Test
	public void seAgregaNombreAlCliente() {

		Cliente cliente = new Cliente(null, null);

		cliente.setNombre("juan perez");

		Assert.assertEquals("juan perez", cliente.getNombre());
	}

	@Test
	public void seAgregaDireccionAlCliente(){

		Cliente cliente = new Cliente(null, null);

		cliente.setDireccion("Montes de Oca 4720, CABA");

		Assert.assertEquals("Montes de Oca 4720, CABA", cliente.getDireccion());
	}

	@Test
	public void seAgregaNombreAlClienteCuandoEsCreado(){

		Cliente cliente = new Cliente("juan perez", null);

		Assert.assertEquals("juan perez", cliente.getNombre());
	}
	
	@Test
	public void seAgregaDireccionAlClienteCuandoEsCreado(){

		Cliente cliente = new Cliente(null, "Montes de Oca 4720, CABA");

		Assert.assertEquals("Montes de Oca 4720, CABA", cliente.getDireccion());
	}
	
	@Test
	public void clienteAgregaCompraASuListaDeCompras() throws Exception{
		
		Cliente cliente = new Cliente("juan perez", "Montes de Oca 4720, CABA");
		Compra compra = new Compra(Mes.AGOSTO);
		
		cliente.agregarCompra(compra);
		
		Assert.assertTrue(cliente.haComprado(compra));
	}

}
