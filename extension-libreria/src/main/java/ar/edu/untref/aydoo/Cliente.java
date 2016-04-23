package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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

	public void agregarComprasDelMes(ComprasDelMes unMes) {
		this.compras.add(unMes);
	}

	public void comprar(ComprasDelMes unMes, Producto unProducto) {
		if(!compras.contains(unMes)){
			throw new Error("Mes no ingresado");
		}
		Iterator<ComprasDelMes> iteradorMeses = compras.iterator();
		while (iteradorMeses.hasNext()) {
			ComprasDelMes mesActual = iteradorMeses.next();
			if (mesActual.getNombre().equals(unMes.getNombre())) {
				mesActual.AgregarCompra(unProducto);
			}
		}
	}

	public double calcularGastoDelMes(ComprasDelMes unMes) {
		if(!compras.contains(unMes)){
			throw new Error("Mes no ingresado");
		}
		double total = 0;
		Iterator<ComprasDelMes> iteradorMeses = compras.iterator();
		while (iteradorMeses.hasNext()) {
			ComprasDelMes mesActual = iteradorMeses.next();
			if (mesActual.getNombre().equals(unMes.getNombre())) {
				total += mesActual.calcularGastoDelMes();
			}
		}
		return total;
	}

}
