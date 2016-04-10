package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private String nombre;
	private String direccion;
	private List<Compra> listaDeCompras;

	public Cliente(String nombre, String direccion) {

		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.listaDeCompras = new ArrayList<Compra>();
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

	public void agregarCompra(Compra compra) {
		
		this.listaDeCompras.add(compra);
	}

	public boolean haComprado(Compra compra) {
		
		return this.listaDeCompras.contains(compra);
	}

	public void eliminarCompra(Compra compra) {
		
		int posicionDeLaCompraEnLaLista = this.listaDeCompras.indexOf(compra);
		this.listaDeCompras.remove(posicionDeLaCompraEnLaLista);
	}

}
