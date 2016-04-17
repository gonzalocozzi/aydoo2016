package ar.edu.untref.aydoo;

/**
 * 
 * @author gonzalo alejandro cozzi
 *
 */
public class FactorizadorPrimo {

	private Integer numeroAFactorizar;	
	private String factorizacion;
	private Formateador formateador;

	public FactorizadorPrimo(Integer numeroAFactorizar) {

		this.setNumeroAFactorizar(numeroAFactorizar);
		this.factorizacion = new String("");
	}

	public boolean esPrimo(int numero){

		boolean esPrimo = true;

		for(int i = 2; i < numeroAFactorizar; i++){

			if(numeroAFactorizar % i == 0){	

				esPrimo = false;
			}
		}

		return esPrimo;
	}

	public void calcularFactoresPrimos(){

		Integer numeroFactorizado = this.getNumeroAFactorizar();

		if(esPrimo(numeroAFactorizar)){	

			this.factorizacion = numeroFactorizado.toString();

		} else {

			for(Integer i = 2; i < numeroAFactorizar; i++){

				while(numeroFactorizado%i == 0){

					numeroFactorizado = numeroFactorizado/i;					
					this.factorizacion += i.toString();
					this.factorizacion += " ";					
				}
			}
		}

	}	

	public Integer getNumeroAFactorizar() {

		return this.numeroAFactorizar;
	}

	public void setNumeroAFactorizar(Integer numeroIngresado) {

		this.numeroAFactorizar = numeroIngresado;
	}

	public String getFactorizacion(){

		return this.factorizacion;
	}

	public void setFormateador(Formateador formateador) {
		this.formateador = formateador;
		this.formateador.setNumeroAFactorizar(numeroAFactorizar);
	}

	public String getFactorizacionFormateada(){

		this.calcularFactoresPrimos();
		
		this.formateador.setFactorizacion(this.factorizacion);
		this.formateador.invertirFactorizacion();
		this.formateador.formatearFactorizacion();

		return this.formateador.getFactorizacionFormateada();
	}

}
