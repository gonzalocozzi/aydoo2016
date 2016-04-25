package ar.edu.untref.aydoo;

public class AlquilerDiario extends Producto {

	private Libro libroAlquilado;
	private int diasDelAlquiler;

	public AlquilerDiario(String nombre, double precio) {
		super(nombre, precio);
		this.diasDelAlquiler = 0;
	}

	public Libro getLibroAlquilado() {
		return libroAlquilado;
	}

	public void setLibroAlquilado(Libro libroAlquilado) {
		this.libroAlquilado = libroAlquilado;
	}

	public void setDiasDelAlquiler(int dias) throws InvalidRentalException {
		// TODO Auto-generated method stub
		
		if(dias < 3 || dias > 25){
			
			throw new InvalidRentalException();
		}
		
		this.diasDelAlquiler = dias;
		super.setPrecio(diasDelAlquiler * 10);
	}

}
