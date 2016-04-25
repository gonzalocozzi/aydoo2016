package ar.edu.untref.aydoo;

public class AlquilerCuatrimestral extends Producto {
	
	private Libro libroAlquilado;
	private int cuatrimestresDelAlquiler;

	public AlquilerCuatrimestral(String nombre, double precio) {
		super(nombre, precio);
		this.cuatrimestresDelAlquiler = 0;
		
	}
	
	public Libro getLibroAlquilado() {
		return this.libroAlquilado;
	}
	
	public void setLibroAlquilado(Libro libroAlquilado) {
		this.libroAlquilado = libroAlquilado;
	}	

	public int getCuatrimestresDelAlquiler() {
		return this.cuatrimestresDelAlquiler;
	}

	public void setMesesDelAlquiler(int numeroDeCuatrimestres) throws InvalidRentalException {

		if(numeroDeCuatrimestres < 1 || numeroDeCuatrimestres > 2){			
			throw new InvalidRentalException();
		}
		
		this.cuatrimestresDelAlquiler = numeroDeCuatrimestres;
		super.setPrecio(200 * numeroDeCuatrimestres * 4 * 0.9);
	}

}
