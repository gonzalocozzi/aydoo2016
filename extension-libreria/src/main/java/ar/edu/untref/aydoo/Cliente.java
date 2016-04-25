package ar.edu.untref.aydoo;

import java.time.Month;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import ar.edu.untref.aydoo.UnregisteredClientException;
import ar.edu.untref.aydoo.RepeatedMonthException;

public class Cliente {

	private String nombre;
	private String dni;
	private String direccion;
	private List<ComprasDelMes> compras;

	public Cliente(String nombre, String DNI, String direccion) {
		this.nombre = nombre;
		this.dni = DNI;
		this.direccion = direccion;
		this.compras = new LinkedList<ComprasDelMes>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getDNI() {
		return this.dni;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void agregarCompraDelMes(ComprasDelMes compra) throws RepeatedMonthException {

		if(mesIngresado(compra.getMes())){
			throw new RepeatedMonthException();
		}

		this.compras.add(compra);
	}

	public void comprar(Libreria libreria, Month mes, Producto unProducto) throws UnregisteredClientException, InexistentMonthException {
		
		if(!libreria.esClienteRegistrado(this)){			
			throw new UnregisteredClientException();
		}

		Iterator<ComprasDelMes> iteradorMeses = compras.iterator();
		boolean mesEncontrado = false;

		while (iteradorMeses.hasNext() && !mesEncontrado) {

			ComprasDelMes compraActual = iteradorMeses.next();

			if(!mesIngresado(mes)){
				throw new InexistentMonthException();
			}

			if (compraActual.getMes().equals(mes)) {
				compraActual.agregarCompra(unProducto);
				mesEncontrado = true;
			}
		}
	}

	public double calcularGastoDelMes(Month mes) {

		if(!mesIngresado(mes)){
			throw new Error("Mes no ingresado");
		}

		double total = 0;
		Iterator<ComprasDelMes> iteradorMeses = compras.iterator();
		boolean mesEncontrado = false;

		while (iteradorMeses.hasNext() && !mesEncontrado) {			ComprasDelMes compraActual = iteradorMeses.next();
			
			if (compraActual.getMes().equals(mes)) {
				total += compraActual.calcularGastoDelMes();
				mesEncontrado = true;
			}
		}

		return total;
	}

	private boolean mesIngresado(Month mes){

		boolean mesIngresado = false;
		Iterator<ComprasDelMes> iteradorMeses = compras.iterator();

		while (iteradorMeses.hasNext()) {

			ComprasDelMes compraActual = iteradorMeses.next();

			if(compraActual.getMes().equals(mes)){
				mesIngresado = true;
			}
		}

		return mesIngresado;
	}

}
