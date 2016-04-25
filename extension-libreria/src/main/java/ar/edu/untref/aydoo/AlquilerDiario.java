package ar.edu.untref.aydoo;

public class AlquilerDiario extends Producto {

	private Libro libroAlquilado;
	private int diasDelAlquiler;
	private int precioDiario = 0;

	public AlquilerDiario(String nombre, double precio, int precioDiario) {
		super(nombre, precio);
		this.diasDelAlquiler = 0;
		this.setPrecioDiario(precioDiario);
	}

	public Libro getLibroAlquilado() {
		return this.libroAlquilado;
	}

	public void setLibroAlquilado(Libro libroAlquilado) {
		this.libroAlquilado = libroAlquilado;
	}
	
	public int getDiasDelAlquiler() {		
		return this.diasDelAlquiler;
	}

	public void setDiasDelAlquiler(int numeroDeDias) throws InvalidRentalException {
		
		if(numeroDeDias < 3 || numeroDeDias > 25){			
			throw new InvalidRentalException();
		}
		
		this.diasDelAlquiler = numeroDeDias;
		super.setPrecio(diasDelAlquiler * this.precioDiario);
	}

	public int getPrecioDiario() {
		
		return precioDiario;
	}

	public void setPrecioDiario(int precioDiario) {
		
		this.precioDiario = precioDiario;
	}

}
