package ar.edu.untref.aydoo;

public class Libreria {
	
	private String nombre;
	private String direccion;

	public Libreria(String nombre) {
		
		this.setNombre(nombre);
	}

	public void setNombre(String nombre) {
		
		this.nombre = nombre;
	}

	public String getNombre() {
		
		return this.nombre;
	}

	public void setDireccion(String direccion) {
		
		this.direccion = direccion;
	}

	public String getDireccion() {
		
		return this.direccion;
	}

}
