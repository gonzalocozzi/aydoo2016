package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Suscripcion extends Producto {

	private List<RevistayPeriodico> productos;

	public Suscripcion(String nombre, double precio) throws NegativePriceException {		
		super(nombre, precio);
		this.productos = new LinkedList<RevistayPeriodico>();
	}

	public void agregarRevistaOPeriodico(RevistayPeriodico unaRevistaOPeriodico) throws NegativePriceException {		
		this.productos.add(unaRevistaOPeriodico);
		this.setPrecio();		
	}	

	private void setPrecio() throws NegativePriceException{				
		double total = 0;
		Iterator<RevistayPeriodico> iteradorProductos = productos.iterator();

		while (iteradorProductos.hasNext()) {			
			RevistayPeriodico revistaOPeriodicoActual = iteradorProductos.next();
			total += revistaOPeriodicoActual.getPrecio() * revistaOPeriodicoActual.getFrecuenciaMensual();
		}		
		super.setPrecio(total);
	}

	public List<RevistayPeriodico> getProductos() {		
		return productos;
	}

	public boolean contiene(RevistayPeriodico revista) {		
		return this.productos.contains(revista);
	}
}
