package ar.edu.untref.aydoo;

import java.util.Iterator;

public class SuscripcionAnual extends Suscripcion {

	public SuscripcionAnual(String nombre, double precio) {
		
		super(nombre, precio);
	}
	
	public void agregarRevistaOPeriodico(RevistayPeriodico unaRevistaOPeriodico) {
		
		super.getProductos().add(unaRevistaOPeriodico);
		this.setPrecio();		
	}	
	
	public void setPrecio(){
		
		double total = 0;
		Iterator<RevistayPeriodico> iteradorProductos = super.getProductos().iterator();
		
		while (iteradorProductos.hasNext()) {
			
			RevistayPeriodico revistaOPeriodicoActual = iteradorProductos.next();
			total += revistaOPeriodicoActual.getPrecio() * revistaOPeriodicoActual.getFrecuenciaMensual();
		}
		
		super.setPrecio(total * 0.8);
	}

	public double getPrecioTotal() {
		
		return this.getPrecio()* 12;
	}

}
