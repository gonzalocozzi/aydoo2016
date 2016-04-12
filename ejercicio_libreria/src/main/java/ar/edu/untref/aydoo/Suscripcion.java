package ar.edu.untref.aydoo;

public class Suscripcion extends Compra {

	private Boolean esAnual;

	public Suscripcion(Mes mes) {

		super(mes);
		this.esAnual = false;
	}

	public void agregarProducto(Producto producto) throws Exception {

		if(producto instanceof Libro || producto instanceof ArticuloDeLibreria){

			throw new Exception("No puede suscribirse a un libro o articulo de libreria");
		}

		super.agregarProducto(producto);
	}

	public Double getPrecioDeLaCompra() {

		Double precio = 0.0;

		precio = calcularPrecio(precio);

		if(this.esAnual()){

			precio *= 0.8;
		}

		return precio;	
	}

	private Double calcularPrecio(Double precio) {

		for(Producto c : this.listaDeProductos){

			if (c instanceof Revista){

				precio += c.getPrecio()* ((Revista) c).getPeriodicidad();

			} else {

				precio += c.getPrecio()* ((Periodico) c).getPeriodicidad();	
			}
		}

		return precio;
	}

	public void hacerAnual() {

		this.esAnual = true;
	}

	public boolean esAnual() {

		return this.esAnual;
	}	

}
