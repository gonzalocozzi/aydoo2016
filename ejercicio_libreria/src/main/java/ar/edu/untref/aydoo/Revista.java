package ar.edu.untref.aydoo;

public class Revista extends Producto {
	
	private Integer periodicidad;

	public Revista(String nombre, Double precio) {
		
		super(nombre, precio);
	}

	public void setPeriodicidad(Integer periodicidad) {
		
		this.periodicidad = periodicidad;		
	}

	public Integer getPeriodicidad() {
		
		return this.periodicidad;
	}

}
