package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ComprasDelMes {

	private String nombre;
	private List<Producto> compras;

	public ComprasDelMes(String nombre) {
		this.nombre = nombre;
		this.compras = new LinkedList<Producto>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void AgregarCompra(Producto unProducto) {
		this.compras.add(unProducto);
	}

	public double calcularGastoDelMes() {
		double total = 0;
		Iterator<Producto> iteradorDeProductos = compras.iterator();
		while (iteradorDeProductos.hasNext()) {
			Producto productoActual = iteradorDeProductos.next();
			total += productoActual.getPrecio();
		}
		return total;
	}

}
