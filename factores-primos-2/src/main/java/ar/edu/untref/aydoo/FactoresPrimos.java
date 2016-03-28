package ar.edu.untref.aydoo;

/**
 * Clase que devuelve un string con la factorizacion
 * en numeros primos de un valor indicado
 * @author gonzalo cozzi
 *
 */
public class FactoresPrimos {

	private Integer numero_a_factorizar;	
	private String factorizacion = "";

	/**
	 * @post se indica si el numero es primo
	 * @param numero a saber si es primo
	 * @return si es primo (true o false)
	 */
	public boolean es_primo(int numero){

		boolean es_primo = true;

		for(int i = 2; i < numero_a_factorizar; i++){
			
			if(numero_a_factorizar % i == 0){	
				
				es_primo = false;
			}
		}

		return es_primo;
	}

	/**
	 * @post se calculan los factores primos del numero ingresado
	 */
	public void calcular_factores_primos(){

		int numero_factorizado = this.getNumero_a_factorizar();

		if(es_primo(numero_a_factorizar)){	
			
			this.factorizacion = "el numero " + numero_a_factorizar + " es primo.";
		} else {
			
			for(Integer i = 2; i < numero_a_factorizar; i++){
				
				while(numero_factorizado%i == 0){
					
					numero_factorizado = numero_factorizado/i;					
					this.factorizacion += i.toString();
					this.factorizacion += " ";					
				}
			}
		}

	}	

	public Integer getNumero_a_factorizar() {
		
		return numero_a_factorizar;
	}

	public void setNumero_a_factorizar(Integer numero_ingresado) {
		
		this.numero_a_factorizar = numero_ingresado;
	}

	public String getFactorizacion() {
		
		return factorizacion;
	}

	public void setFactorizacion(String factorizacion) {
		
		this.factorizacion = factorizacion;
	}

}
