package ar.edu.untref.aydoo;

import java.io.IOException;

/**
 * @author gonzalo alejandro cozzi
 */
public class FactorizadorPrimo {

	private Integer numeroAFactorizar;	
	private String[] argumentos;
	private String factorizacion;
	private AnalizadorDeArgumentos analizadorDeArgumentos;

	/**
	 * @post se almacena en la clase el valor absoluto del numero a factorizar
	 * @param numeroAFactorizar
	 */
	public FactorizadorPrimo(String[] args) {

		this.setNumeroAFactorizar(Math.abs(Integer.parseInt(args[0])));
		this.factorizacion = new String("");
		this.setArgumentos(args);
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

	public String[] getArgumentos() {
		
		return this.argumentos;
	}

	private void setArgumentos(String[] argumentos) {
		
		this.argumentos = argumentos;
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
	 * @param argumentos son los argumentos ingresados por el usuario
	 * para configurar la salida de la factorizacion
	 * @return la factorizacion del numero a factorizar formateada en base a 
	 * la configuracion indicada por el usuario con los argumentos
	 * @throws IOException
	 */
	public String getFactorizacionFormateada() throws IOException{
		
		this.analizadorDeArgumentos = new AnalizadorDeArgumentos(this.getArgumentos(), this.factorizacion);
		this.factorizacion = this.analizadorDeArgumentos.getSalidaConfigurada();
		
		return this.factorizacion;
	}

}
