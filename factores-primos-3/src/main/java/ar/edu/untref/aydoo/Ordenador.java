package ar.edu.untref.aydoo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ordenador {
	
	private String factorizacionInvertida;
	
	public Ordenador(){
		
		this.factorizacionInvertida = "";
	}

	public String invertirSalida(String salida) {

		String[] arregloDeLaSalida = salida.split(" ");
		List<String> list = Arrays.asList(arregloDeLaSalida);
		Collections.reverse(list);
		String[] arregloInvertidoDeLaSalida = (String[]) list.toArray();		

		this.factorizacionInvertida = "";

		for(int i = 0; i < arregloInvertidoDeLaSalida.length; i++){

			this.factorizacionInvertida += arregloInvertidoDeLaSalida[i];
			this.factorizacionInvertida += " ";
		}
		
		return this.factorizacionInvertida;
	}

}
