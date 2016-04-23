package ar.edu.untref.aydoo;

public class RevistayPeriodico extends Producto {

	private int frecuenciaMensual;

	public RevistayPeriodico(String nombre, double precio, int frecuencia) {
		super(nombre, precio);
		this.frecuenciaMensual = frecuencia;
	}

	public int getFrecuenciaMensual() {
		return this.frecuenciaMensual;
	}

	public void setFrecuenciaMensual(int nuevaFrecuencia) {
		this.frecuenciaMensual = nuevaFrecuencia;
	}

	public double getPrecioSuscripcionMensual() {
		return (this.getPrecio() * this.frecuenciaMensual);
	}

	public double getPrecioSuscripcionAnual() {
		double aux = ((this.getPrecio() * this.frecuenciaMensual) * 12);
		double descuento = ((aux * 20) / 100);

		return aux - descuento;
	}

	public double getPrecioMensualConSuscripcionAnual() {
		return (this.getPrecioSuscripcionAnual() / 12);
	}

}
