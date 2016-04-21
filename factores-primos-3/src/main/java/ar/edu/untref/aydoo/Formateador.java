package ar.edu.untref.aydoo;

import java.util.List;

/**
 * @author gonzalo alejandro cozzi
 */
public class Formateador {

	private Integer numeroAFactorizar;
	private List<String> listaDeArgumentos;
	private String factorizacion;
	private String factorizacionFormateada;

	public Formateador(List<String> listaDeArgumentos){

		this.listaDeArgumentos = listaDeArgumentos;
		this.numeroAFactorizar = Integer.parseInt(this.listaDeArgumentos.get(0));
		this.factorizacionFormateada = "Factores primos " + this.numeroAFactorizar + ": ";
	}	

	public String formatearFactorizacion(String factorizacion){	

		this.factorizacion = factorizacion;

		if(listaDeArgumentos.size() == 1 || listaDeArgumentos.contains("--format=pretty")){

			this.formatoPretty();

		} else if(listaDeArgumentos.contains("--format=quiet")) {

			this.formatoQuiet();

		} else {			

			this.formatoPretty();
		}

		return this.getFactorizacionFormateada();
	}

	private void formatoPretty() {

		this.factorizacionFormateada += this.factorizacion;	
	}

	private void formatoQuiet() {

		String[] arregloDeLaFactorizacion = this.factorizacion.split(" ");

		for(int i = 0; i < arregloDeLaFactorizacion.length; i++){

			this.factorizacionFormateada += "\n";
			this.factorizacionFormateada += arregloDeLaFactorizacion[i];
		}
	}

	public Integer getNumeroAFactorizar(){

		return this.numeroAFactorizar;
	}	

	public String getFactorizacionFormateada() {

		return this.factorizacionFormateada;
	}

}
