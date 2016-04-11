package ar.edu.untref.aydoo;

public class Revista extends Producto {

	private Integer periodicidad;

	public Revista(String nombre, Double precio, Integer periodicidad) throws Exception {

		super(nombre, precio);

		if(periodicidad > 0){

			this.setPeriodicidad(periodicidad);	

		} else {

			throw new Exception("La periodicidad debe ser mayor o igual a 1");
		}
	}

	public void setPeriodicidad(Integer periodicidad) {

		this.periodicidad = periodicidad;		
	}

	public Integer getPeriodicidad() {

		return this.periodicidad;
	}

}
