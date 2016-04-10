package ar.edu.untref.aydoo;

public class Cliente {

	private String nombre;
	private String direccion;

	public Cliente(String nombre) {

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

	public Object getDireccion() {

		return this.direccion;
	}

}
