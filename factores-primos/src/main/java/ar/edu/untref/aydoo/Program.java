package ar.edu.untref.aydoo;

import java.io.IOException;

public class Program {

	/**
	 * Clase principal de ejecucion del programa
	 * Intermedia entre la clase de factores primos y la terminal
	 * @param arg
	 * @throws IOException
	 */
	public static void main(String[]arg)throws IOException{

		Integer numero_a_factorizar = Integer.parseInt(arg[0]);
		
		FactoresPrimos factores_primos = new FactoresPrimos();
		factores_primos.setNumero_a_factorizar(numero_a_factorizar);
		factores_primos.calcular_factores_primos();
		
		System.out.print("Factores primos " + numero_a_factorizar + ": ");
		System.out.print(factores_primos.getFactorizacion());
		System.out.print("\n");
	}		
}   

