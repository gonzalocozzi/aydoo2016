package ar.edu.untref.aydoo;

public class Alquiler extends Producto {
	
	private Libro libroAlquilado;
	private int precioPorPeriodo;
	private int periodoDelAlquiler;

	public Alquiler(String nombre, double precio) throws NegativePriceException {
		super(nombre, precio);
	}		
	
	public Libro getLibroAlquilado() {
		return this.libroAlquilado;
	}

	public void setLibroAlquilado(Libro libroAlquilado) {
		this.libroAlquilado = libroAlquilado;
	}

	public int getPrecioPorPeriodo() {		
		return precioPorPeriodo;
	}

	public void setPrecioPorPeriodo(int precioDiario) {		
		this.precioPorPeriodo = precioDiario;
	}
	
	public int getPeriodoDelAlquiler() {		
		return this.periodoDelAlquiler;
	}	

	public void setPeriodoDelAlquiler(int periodoDelAlquiler) {
		this.periodoDelAlquiler = periodoDelAlquiler;
	}

}
