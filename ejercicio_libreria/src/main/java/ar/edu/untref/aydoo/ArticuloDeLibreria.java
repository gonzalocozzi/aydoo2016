package ar.edu.untref.aydoo;

public class ArticuloDeLibreria extends Producto {

	private Double IVA = null;

	public ArticuloDeLibreria(String nombre, Double precio) throws Exception {

		super(nombre, precio);
		this.setIVA();
	}

	private void setIVA(){

		this.IVA = super.getPrecio() * 0.21;
	}

	public Double getIVA() {

		return this.IVA;
	}	

	public Double getPrecio(){

		return super.getPrecio() + this.getIVA();
	}

}
