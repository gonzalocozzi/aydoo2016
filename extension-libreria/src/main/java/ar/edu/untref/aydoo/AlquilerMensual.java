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

	public void setMesesDelAlquiler(int meses) throws InvalidRentalException {
		
		if(meses < 1){			
			throw new InvalidRentalException();
		}
		
		this.mesesDelAlquiler = meses;
		super.setPrecio(200 * meses);
	}

	public int getMesesDelAlquiler() {
		return this.mesesDelAlquiler;
	}


}
