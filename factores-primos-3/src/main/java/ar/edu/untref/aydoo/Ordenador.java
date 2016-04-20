package ar.edu.untref.aydoo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author gonzalo alejandro cozzi
 *
 */
public class Ordenador {
	
	private String factorizacionInvertida;
	
	public Ordenador(){
		
		this.factorizacionInvertida = "";
	}

	public String invertirFactorizacion(String factorizacion) {

		//Se invierte la factorizacion convirtiendola en una lista de strings.
		String[] arregloDeLaFactorizacion = factorizacion.split(" ");
		List<String> listaDeLaFactorizacion = Arrays.asList(arregloDeLaFactorizacion);
		Collections.reverse(listaDeLaFactorizacion);
		String[] arregloInvertidoDeLafactorizacion = (String[]) listaDeLaFactorizacion.toArray();	
		
		//Se convierte la lista de strings en un string nuevamente
		for(int i = 0; i < arregloInvertidoDeLafactorizacion.length; i++){

			this.factorizacionInvertida += arregloInvertidoDeLafactorizacion[i];
			this.factorizacionInvertida += " ";
		}
		
		return this.getFactorizacionInvertida();
	}
	
	public String getFactorizacionInvertida(){
		
		return this.factorizacionInvertida;
	}

}
