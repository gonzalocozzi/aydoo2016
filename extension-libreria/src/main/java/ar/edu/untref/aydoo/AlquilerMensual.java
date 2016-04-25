package ar.edu.untref.aydoo;

public class AlquilerMensual extends Producto {
	
	private Libro libroAlquilado;

	public AlquilerMensual(String nombre, double precio) {		
		super(nombre, precio);
	}
	
	public Libro getLibroAlquilado() {
		return this.libroAlquilado;
	}

	public void setLibroAlquilado(Libro libroAlquilado) {
		this.libroAlquilado = libroAlquilado;
	}


}
