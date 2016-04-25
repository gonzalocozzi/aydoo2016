package ar.edu.untref.aydoo;

public class AlquilerDiario extends Alquiler {

	public AlquilerDiario(String nombre, double precio, int precioDiario) {
		super(nombre, precio);
		super.setPeriodoDelAlquiler(0);
		super.setPrecioPorPeriodo(precioDiario);
	}	

	public void setDiasDelAlquiler(int numeroDeDias) throws InvalidRentalException {
		
		if(numeroDeDias < 3 || numeroDeDias > 25){			
			throw new InvalidRentalException();
		}
		
		super.setPeriodoDelAlquiler(numeroDeDias);
		super.setPrecio(super.getPeriodoDelAlquiler() * super.getPrecioPorPeriodo());
	}

}
