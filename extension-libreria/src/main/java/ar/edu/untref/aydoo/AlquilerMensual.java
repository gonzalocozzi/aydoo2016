package ar.edu.untref.aydoo;

public class AlquilerMensual extends Producto {
	
	private Libro libroAlquilado;
	private int mesesDelAlquiler;

	public AlquilerMensual(String nombre, double precio) {		
		super(nombre, precio);
	}
	
	public Libro getLibroAlquilado() {
		return this.libroAlquilado;
	}

	public void setLibroAlquilado(Libro libroAlquilado) {
		this.libroAlquilado = libroAlquilado;
	}

	public void setMesesDelAlquiler(int numeroDeMeses) throws InvalidRentalException {
		
		if(numeroDeMeses < 1 || numeroDeMeses > 3){			
			throw new InvalidRentalException();
		}
		
		this.mesesDelAlquiler = numeroDeMeses;
		super.setPrecio(200 * numeroDeMeses);
	}

	public int getMesesDelAlquiler() {
		return this.mesesDelAlquiler;
	}


}
