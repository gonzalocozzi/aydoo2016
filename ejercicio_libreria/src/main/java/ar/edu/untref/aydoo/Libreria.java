package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Libreria {
	
	private String nombre;
	private String direccion;
	private List<Cliente> listaDeClientesRegistrados;

	public Libreria(String nombre, String direccion) {
		
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.listaDeClientesRegistrados = new ArrayList<Cliente>();
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

	public void agregarCliente(Cliente cliente) {
		
		this.listaDeClientesRegistrados.add(cliente);
	}

	public boolean esClienteRegistrado(Cliente cliente) {
		
		return this.listaDeClientesRegistrados.contains(cliente);
	}

}
