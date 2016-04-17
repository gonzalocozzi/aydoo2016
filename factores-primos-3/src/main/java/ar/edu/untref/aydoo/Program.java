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
			Formateador formateador = new Formateador(args);			
			factorizadorPrimo.setFormateador(formateador);
			String factorizacion = factorizadorPrimo.getFactorizacionFormateada();
			
			System.out.println(factorizacion);
		}
	}		
}   

