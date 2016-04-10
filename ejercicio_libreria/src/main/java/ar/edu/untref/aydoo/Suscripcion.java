package ar.edu.untref.aydoo;

public class Suscripcion extends Compra {

	public Suscripcion(Mes mes) {

		super(mes);
	}

	public Double getPrecio() {

		Double precio = 0.0;

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

}
