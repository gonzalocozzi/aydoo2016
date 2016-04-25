package ar.edu.untref.aydoo;

public class AlquilerMensual extends Producto {
	
	private Libro libroAlquilado;
	private int mesesDelAlquiler;
	private int precioMensual;

	public AlquilerMensual(String nombre, double precio, int precioMensual) {		
		super(nombre, precio);
		this.setPrecioMensual(precioMensual);
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
		super.setPrecio(this.precioMensual * numeroDeMeses);
	}

	public int getMesesDelAlquiler() {
		return this.mesesDelAlquiler;
	}

	public int getPrecioMensual() {
		return this.precioMensual;
	}

	public void setPrecioMensual(int precioMensual) {
		this.precioMensual = precioMensual;
	}

}
