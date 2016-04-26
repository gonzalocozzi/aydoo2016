package ar.edu.untref.aydoo;

import java.time.Month;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Libreria {

	private String nombre;
	private List<Cliente> clientes;

	public Libreria(String nombre) {
		this.nombre = nombre;
		this.clientes = new LinkedList<Cliente>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void registrarCliente(Cliente unCliente) {
		this.clientes.add(unCliente);
	}
	
	public boolean esClienteRegistrado(Cliente unCliente){		
		return this.clientes.contains(unCliente);
	}

	public double calcularMontoACobrar(Month mes, Cliente unCliente) throws UnregisteredClientException, InexistentMonthException {		
		
		if(!esClienteRegistrado(unCliente)){
			throw new UnregisteredClientException();
		}
		
		double total = 0;
		Iterator<Cliente> iteradorClientes = clientes.iterator();
		boolean clienteEncontrado = false;	
		
		while (iteradorClientes.hasNext() && !clienteEncontrado) {
			Cliente clienteActual = iteradorClientes.next();
			
			if (unCliente.getDNI().equals(clienteActual.getDNI())) {
				total = clienteActual.calcularGastoDelMes(mes);
				clienteEncontrado = true;
			}
		}
		return total;
	}

}
