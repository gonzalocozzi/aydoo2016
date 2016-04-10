package ar.edu.untref.aydoo;

public class Producto {	
	
	private String nombre;
	private Double precio;

	public void setNombre(String string) {	
		
		this.nombre = string;
	}

	public String getNombre() {		
		
		return this.nombre;
	}

	public void setPrecio(Double d) {
		
		this.precio = d;
	}

	public Double getPrecio() {
		
		return this.precio;
	}

}
