	package ar.edu.untref.aydoo;

import java.io.IOException;

/**
 * 
 * @author gonzalo alejandro cozzi
 *
 */
public class Program {

	public static void main(String[] args)throws IOException{
		
		if(args.length == 0){
			
			System.out.println("Por favor, ingrese el numero que desea factorizar.");
			
		} else {
			
			Integer numeroAFactorizar = Integer.parseInt(args[0]);	
			
			FactorizadorPrimo factorizadorPrimo = new FactorizadorPrimo(numeroAFactorizar);
			String factorizacion = factorizadorPrimo.calcularFactoresPrimos();
			
			Formateador formateador = new Formateador(numeroAFactorizar, factorizacion, args);
			formateador.setFactorizacionFormateada();
			
			System.out.println(formateador.getFactorizacionFormateada());
		}
	}		
}   

