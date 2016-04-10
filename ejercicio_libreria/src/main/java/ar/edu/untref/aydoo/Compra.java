package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Compra {

	private Mes mes;
	private List<Producto> listaDeProductos;
	
	public Compra() {
		
		this.listaDeProductos = new ArrayList<Producto>();
	}

	public void setMes(Mes mes) {
		
		this.mes = mes;
	}

	public Mes getMes() {
		
		return this.mes;
	}

	public void agregarProducto(Producto quijote) {
		
		this.listaDeProductos.add(quijote);
	}

	public boolean contiene(Producto producto) {
		
		return this.listaDeProductos.contains(producto);
	}

	public Double getPrecio() {
		
		Double precio = 0.0;
		
		for(Producto c : this.listaDeProductos){
			
			precio += c.getPrecio();
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
