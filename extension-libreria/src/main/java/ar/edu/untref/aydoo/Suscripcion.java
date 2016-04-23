package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Suscripcion extends Producto {

	private List<RevistayPeriodico> productos;

	public Suscripcion(String nombre, double precio) {
		super(nombre, precio);
		this.productos = new LinkedList<RevistayPeriodico>();
	}

	public void AgregarRevistaOPeriodico(RevistayPeriodico unaRevistaOPeriodico) {
		this.productos.add(unaRevistaOPeriodico);
	}

	public double getMontoACobrarSuscripciones() {
		double total = 0;
		Iterator<RevistayPeriodico> iteradorProductos = productos.iterator();
		while (iteradorProductos.hasNext()) {
			RevistayPeriodico revistaOPeriodicoActual = iteradorProductos.next();
			total += revistaOPeriodicoActual.getPrecioMensualConSuscripcionAnual();
		}
		return total;
	}

}
