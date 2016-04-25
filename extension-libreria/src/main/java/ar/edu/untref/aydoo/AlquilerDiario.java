package ar.edu.untref.aydoo;

public class AlquilerDiario extends Alquiler {

	public AlquilerDiario(String nombre, double precio, int precioDiario) throws NegativePriceException {
		super(nombre, precio);
		super.setPeriodoDelAlquiler(0);
		super.setPrecioPorPeriodo(precioDiario);
	}	

	public void setDiasDelAlquiler(int numeroDeDias) throws InvalidRentalException, NegativePriceException {
		
		if(numeroDeDias < 3 || numeroDeDias > 25){			
			throw new InvalidRentalException();
		}
		
		super.setPeriodoDelAlquiler(numeroDeDias);
		super.setPrecio(super.getPeriodoDelAlquiler() * super.getPrecioPorPeriodo());
	}

}
