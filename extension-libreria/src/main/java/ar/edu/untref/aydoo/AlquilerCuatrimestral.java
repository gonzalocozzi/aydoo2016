package ar.edu.untref.aydoo;

public class AlquilerCuatrimestral extends Producto {
	
	private Libro libroAlquilado;
	private int cuatrimestresDelAlquiler;

	public AlquilerCuatrimestral(String nombre, double precio) {
		super(nombre, precio);
	}

	public void setLibroAlquilado(Libro libroAlquilado) {
		this.libroAlquilado = libroAlquilado;
	}

	public Libro getLibroAlquilado() {
		return this.libroAlquilado;
	}

	public void setCuatrimestresDelAlquiler(int numeroDeCuatrimestres) {
		this.cuatrimestresDelAlquiler = numeroDeCuatrimestres;
	}

	public int getCuatrimestresDelAlquiler() {
		return this.cuatrimestresDelAlquiler;
	}
	
	

}
