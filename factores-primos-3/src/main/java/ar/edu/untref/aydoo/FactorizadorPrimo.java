package ar.edu.untref.aydoo;

/**
 * 
 * @author gonzalo alejandro cozzi
 *
 */
public class FactorizadorPrimo {

	private Integer numeroAFactorizar;	
	private String factorizacion = "";
	
	public FactorizadorPrimo(Integer numeroAFactorizar) {
		
		this.numeroAFactorizar = numeroAFactorizar;
		
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
	
	public String calcularFactoresPrimos(){

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
		
		return this.factorizacion;

	}	

	public Integer getNumeroAFactorizar() {
		
		return this.numeroAFactorizar;
	}

	public void setNumeroAFactorizar(Integer numeroIngresado) {
		
		this.numeroAFactorizar = numeroIngresado;
	}

}
