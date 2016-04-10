package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Compra {

	private Mes mes;
	protected List<Producto> listaDeProductos;
	
	public Compra(Mes mes) {
		
		this.listaDeProductos = new ArrayList<Producto>();
		this.setMes(mes);
	}

	public void setMes(Mes mes) {
		
		this.mes = mes;
	}

	public Mes getMes() {
		
		return this.mes;
	}

	public void agregarProducto(Producto producto) throws Exception {
		
		this.listaDeProductos.add(producto);
	}

	public boolean contiene(Producto producto) {
		
		return this.listaDeProductos.contains(producto);
	}

	public Double getPrecio() {
		
		Double precio = 0.0;
		
		for(Producto p : this.listaDeProductos){
			
			precio += p.getPrecio();
		}
		
		return precio;
	}

	public void eliminarProducto(Producto producto) throws Exception {
		
		if(this.contiene(producto)){
			
			int posicionDelProductoEnLaLista = this.listaDeProductos.indexOf(producto);
			this.listaDeProductos.remove(posicionDelProductoEnLaLista);
			
		} else {
			
			throw new Exception("La compra no incluye el producto que desea eliminar");			
		}
		
	}

}
