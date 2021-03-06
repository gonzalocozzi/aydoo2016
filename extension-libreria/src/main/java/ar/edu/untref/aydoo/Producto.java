package ar.edu.untref.aydoo;

public class Producto {

	private String nombre;
	private double precio;

	public Producto(String nombre, double precio) throws NegativePriceException {
		this.nombre = nombre;
		this.setPrecio(precio);
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nuevoNombre) {
		this.nombre = nuevoNombre;
	}
	
	public double getPrecio() {		
		return this.precio;
	}

	public void setPrecio(double precio) throws NegativePriceException {		
		if (precio < 0) {			
			throw new NegativePriceException();
		}		
		this.precio = precio;
	}
}
