package ar.edu.untref.aydoo;

import java.io.IOException;

public class Program 
{
	//Numero a factorizar
	private Integer numero;

	/**
	 * @post se ingresa un numero a factorizar en sus primos
	 * @param numero_ingresado es el valor a factorizar en sus primos
	 */
	public Program(Integer numero_ingresado){
		this.numero = numero_ingresado;
	}

	/**
	 * @post se calculan los factores primos del numero ingresado
	 * @param numero_factorizado es el valor a factorizar en sus primos
	 */
	public void calcular_factores(Integer numero_factorizado){
		
		for(int i = 2; i < numero_factorizado; i++){			
			while(numero%i == 0){				
				this.numero = numero/i;
				System.out.print(i + "  ");
			}
		}

	}	

	/**
	 * Clase principal de ejecucion del programa
	 * @param arg
	 * @throws IOException
	 */
	public static void main(String[]arg)throws IOException{
		
		Integer num = Integer.parseInt(arg[0]);
		if(num <= 3){
			System.out.println("El numero " + num + " no tiene factores primos.");
		} else {
			Program factores_primos = new Program(num);
			System.out.print("Factores primos " + num + ": ");
			factores_primos.calcular_factores(num);	
			System.out.print("\n");
		}		
	}   
	
}
