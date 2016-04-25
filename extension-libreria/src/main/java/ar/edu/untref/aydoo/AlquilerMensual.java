package ar.edu.untref.aydoo;

public class AlquilerMensual extends Alquiler {

	public AlquilerMensual(String nombre, double precio, int precioMensual) throws NegativePriceException {		
		super(nombre, precio);
		super.setPrecioPorPeriodo(precioMensual);
	}

	public void setMesesDelAlquiler(int numeroDeMeses) throws InvalidRentalException, NegativePriceException {
		
		if(numeroDeMeses < 1 || numeroDeMeses > 3){			
			throw new InvalidRentalException();
		}
		
		super.setPeriodoDelAlquiler(numeroDeMeses);
		super.setPrecio(super.getPeriodoDelAlquiler() * super.getPrecioPorPeriodo());
	}

}
