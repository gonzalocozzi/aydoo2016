package ar.edu.untref.aydoo;

import java.util.List;

/**
 * @author gonzalo alejandro cozzi
 */
public class Formateador {

	private Integer numeroAFactorizar;
	private String factorizacion;
	private String factorizacionFormateada;

	public Formateador(Integer numeroAFactorizar){

		this.setNumeroAFactorizar(numeroAFactorizar);
		this.factorizacionFormateada = "Factores primos " + this.numeroAFactorizar + ": ";
	}	

	public String formatearFactorizacion(List<String> listaDeArgumentos, String factorizacion){	

		this.setFactorizacion(factorizacion);

		if(listaDeArgumentos.size() == 1 || listaDeArgumentos.contains("--format=pretty")){

			this.formatoPretty();

		} else if(listaDeArgumentos.contains("--format=quiet")) {

			this.formatoQuiet();

		} else {			

			this.formatoPretty();
		}

		return this.factorizacionFormateada;
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

	public void setNumeroAFactorizar(Integer numeroAFactorizar) {

		this.numeroAFactorizar = numeroAFactorizar;
	}

	public void setFactorizacion(String factorizacion) {

		this.factorizacion = factorizacion;
	}

}
