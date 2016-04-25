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

	public void agregarCliente(Cliente unCliente) {

		this.clientes.add(unCliente);
	}

	public double calcularMontoACobrar(Month mes, Cliente unCliente) {

		if(!clientes.contains(unCliente)){
			throw new Error("El cliente no existe");
		}

		double total = 0;
		Iterator<Cliente> iteradorClientes = clientes.iterator();

		while (iteradorClientes.hasNext()) {

			Cliente clienteActual = iteradorClientes.next();

			if (unCliente.getDNI().equals(clienteActual.getDNI())) {

				total = clienteActual.calcularGastoDelMes(mes);
			}
		}

		return total;
	}

	public void comprar(Cliente unCliente, Producto unProducto, Month mes) {

		if(!clientes.contains(unCliente)){

			throw new Error("El cliente no existe");
		}

		Iterator<Cliente> iteradorClientes = clientes.iterator();

		while (iteradorClientes.hasNext()) {

			Cliente clienteActual = iteradorClientes.next();

			if (unCliente.getDNI().equals(clienteActual.getDNI())) {

				clienteActual.comprar(mes, unProducto);
			}
		}
	}

}
