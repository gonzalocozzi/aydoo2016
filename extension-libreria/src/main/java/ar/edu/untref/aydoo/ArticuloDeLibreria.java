package ar.edu.untref.aydoo;

public class ArticuloDeLibreria extends Producto {

	public ArticuloDeLibreria(String nombre, double precio) throws NegativePriceException {		
		super(nombre, precio * 1.21);
	}

}
