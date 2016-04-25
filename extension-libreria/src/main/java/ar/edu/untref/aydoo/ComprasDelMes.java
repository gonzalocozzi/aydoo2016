package ar.edu.untref.aydoo;

import java.time.Month;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ComprasDelMes {

	private String nombre;
	private Month mes;
	private List<Producto> compras;

	public ComprasDelMes(String nombre, Month mes) {		
		this.nombre = nombre;
		this.mes = mes;
		this.compras = new LinkedList<Producto>();
	}

	public Month getMes() {		
		return mes;
	}

	public String getNombre() {		
		return this.nombre;
	}

	public void agregarCompra(Producto unProducto) {		
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
