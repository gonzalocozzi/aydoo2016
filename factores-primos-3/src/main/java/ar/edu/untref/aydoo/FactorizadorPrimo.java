package ar.edu.untref.aydoo;

import java.io.IOException;

/**
 * @author gonzalo alejandro cozzi
 */
public class FactorizadorPrimo {

	private Integer numeroAFactorizar;	
	private String factorizacion;
	private AnalizadorDeArgumentos configuradorDeFactorizacion;

	/**
	 * @post se almacena en la clase el valor absoluto del numero a factorizar
	 * @param numeroAFactorizar
	 */
	public FactorizadorPrimo(Integer numeroAFactorizar) {

		this.setNumeroAFactorizar(Math.abs(numeroAFactorizar));
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

	/**
	 * @pre el numero a factorizar es negativo
	 * @post calcula la factorizacion en primos del numero a factorizar
	 */
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
	
	/**
	 * @param args son los argumentos ingresados por el usuario
	 * para configurar la salida de la factorizacion
	 * @return la factorizacion del numero a factorizar formateada en base a 
	 * la configuracion indicada por el usuario con los argumentos
	 * @throws IOException
	 */
	public String getFactorizacionFormateada(String[] args) throws IOException{
		
		this.configuradorDeFactorizacion = new AnalizadorDeArgumentos(this.numeroAFactorizar, args, this.factorizacion);
		this.factorizacion = this.configuradorDeFactorizacion.getSalidaConfigurada();
		
		return this.factorizacion;
	}

}
