package ar.edu.untref.aydoo;

import java.io.IOException;

/**
 * Clase principal de ejecucion del programa
 * Intermedia entre la clase de factores primos y la terminal 
 * @author gonzalo alejandro cozzi
 *
 */
public class Program {

	public static void main(String[] args)throws IOException{

		
		//SUGERENCIA: CONVERTIR CONDICIONES EN VARIABLES LOCALES
		//Exige el ingreso de un numero a factorizar
		if(args.length == 0){
			
			System.out.println("Por favor, ingrese el numero que desea factorizar.");
			
		} else {
			
			Integer numero_a_factorizar = Integer.parseInt(args[0]);
			
			FactoresPrimos factores_primos = new FactoresPrimos();
			factores_primos.setNumero_a_factorizar(numero_a_factorizar);
			factores_primos.calcular_factores_primos();
			
			//Caso sin formato o PRETTY
			if(args.length == 1 || args[1].equalsIgnoreCase("--format=pretty")){
				
				System.out.print("Factores primos " + numero_a_factorizar + ": ");
				System.out.print(factores_primos.getFactorizacion());
				System.out.print("\n");
				
			//Caso de formato QUIET
			} else if(args[1].equalsIgnoreCase("--format=quiet")){
				
				String[] arreglo_factorizacion = factores_primos.getFactorizacion().split(" ");
				
				for(int i = 0; i < arreglo_factorizacion.length; i++){
					
					System.out.println(arreglo_factorizacion[i]);
				}
				
			//Caso de formato no aceptado	
			} else {
				
				System.out.println("Formato no aceptado. Las opciones posibles son: pretty o quiet.");
			}			
			
		}
	}		
}   

