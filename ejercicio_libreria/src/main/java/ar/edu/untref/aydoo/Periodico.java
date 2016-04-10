package ar.edu.untref.aydoo;

public class Periodico extends Producto {

	private Integer periodicidad;
	
	public Periodico(String nombre, Double precio, Integer periodicidad) {
		
		super(nombre, precio);
		this.setPeriodicidad(periodicidad);
	}

	public void setPeriodicidad(Integer periodicidad) {
		
		this.periodicidad = periodicidad;
	}

	public Integer getPeriodicidad() {
		
		return this.periodicidad;
	}	

}
