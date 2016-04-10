package ar.edu.untref.aydoo;

public class Suscripcion extends Compra {

	private Boolean esAnual;

	public Suscripcion(Mes mes) {

		super(mes);
		this.esAnual = false;
	}
	
	public void agregarProducto(Producto producto) throws Exception {
		
		if(producto instanceof Libro){
			
			throw new Exception("No puede suscribirse a un libro");
		}
		
		super.agregarProducto(producto);
	}

	public Double getPrecio() {

		Double precio = 0.0;

		precio = calcularPrecio(precio);

		if(this.esAnual()){

			precio *= 0.8;

		}

		return precio;	
	}

	private Double calcularPrecio(Double precio) {
		
		for(Producto c : this.listaDeProductos){

			if(c instanceof Revista){

				precio += c.getPrecio()* ((Revista) c).getPeriodicidad();

			} else if (c instanceof Periodico){

				precio += c.getPrecio()* ((Periodico) c).getPeriodicidad();			

			} else {

				precio += c.getPrecio();

			}
		}
		
		return precio;
	}

	public void setAnual() {

		this.esAnual = true;
	}

	public boolean esAnual() {

		return this.esAnual;
	}	

}
