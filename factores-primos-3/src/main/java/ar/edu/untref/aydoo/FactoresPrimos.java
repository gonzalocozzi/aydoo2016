package ar.edu.untref.aydoo;

/**
 * 
 * @author gonzalo alejandro cozzi
 *
 */
public class FactoresPrimos {

	private Integer numeroAFactorizar;	
	private String factorizacion = "";

	
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
		
		return numeroAFactorizar;
	}

	public void setNumeroAFactorizar(Integer numeroIngresado) {
		
		this.numeroAFactorizar = numeroIngresado;
	}

	public String getFactorizacion() {
		
		return factorizacion;
	}

	public void setFactorizacion(String factorizacion) {
		
		this.factorizacion = factorizacion;
	}

}
