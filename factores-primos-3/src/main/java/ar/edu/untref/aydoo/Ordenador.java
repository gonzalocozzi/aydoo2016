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
	
	private String stringInvertido;
	
	public Ordenador(){
		
		this.stringInvertido = "";
	}

	public String invertirString(String string) {

		//Se invierte el string convirtiendolo en una lista de strings.
		String[] arregloDelString = string.split(" ");
		List<String> listaDeStrings = Arrays.asList(arregloDelString);
		Collections.reverse(listaDeStrings);
		String[] arregloInvertidoDelString = (String[]) listaDeStrings.toArray();	
		
		//Se convierte la lista de strings en un string nuevamente
		for(int i = 0; i < arregloInvertidoDelString.length; i++){

			this.stringInvertido += arregloInvertidoDelString[i];
			this.stringInvertido += " ";
		}
		
		return this.getStringInvertido();
	}
	
	public String getStringInvertido(){
		
		return this.stringInvertido;
	}

}
