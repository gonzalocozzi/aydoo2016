package ar.edu.untref.aydoo;

public class AlquilerCuatrimestral extends AlquilerMensual {
	
	private Libro libroAlquilado;
	private int cuatrimestresDelAlquiler;

	public AlquilerCuatrimestral(String nombre, double precio, int precioMensual) {
		super(nombre, precio, precioMensual);
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

	public void setCuatrimestresDelAlquiler(int numeroDeCuatrimestres) throws InvalidRentalException {

		if(numeroDeCuatrimestres < 1 || numeroDeCuatrimestres > 2){			
			throw new InvalidRentalException();
		}
		
		this.cuatrimestresDelAlquiler = numeroDeCuatrimestres;
		super.setPrecio(super.getPrecioMensual() * this.cuatrimestresDelAlquiler * 4 * 0.9);
	}

}
