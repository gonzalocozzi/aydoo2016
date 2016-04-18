package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class AdministradorDeArgumentos {

	private Formateador formateador;
	private Ordenador ordenador;
	private String factorizacion;
	private List<String> listaDeArgumentos;

	public AdministradorDeArgumentos(Integer numeroAFactorizar, String[] args, String factorizacion){

		this.formateador = new Formateador(numeroAFactorizar);
		this.ordenador = new Ordenador();
		this.factorizacion = factorizacion;		
		this.listaDeArgumentos =  new ArrayList<String>();

		for(Integer i = 0; i < args.length; i++){

			listaDeArgumentos.add(i, args[i].toLowerCase());
		}
	}

	public String getSalidaConfigurada(){	

		if(listaDeArgumentos.size() < 2){

			this.factorizacion = this.formateador.formatearFactorizacion(this.listaDeArgumentos, this.factorizacion);

		} else if(listaDeArgumentos.size() < 5){

			this.analisisDeArgumentos();

		} else {

			this.factorizacion = "Ha ingresado al menos un parámetro de más";
		}

		return this.factorizacion;
	}

	private void analisisDeArgumentos() {

		//Argumento SORT
		if(this.listaDeArgumentos.contains("--sort:des")){

			this.factorizacion = this.ordenador.invertirSalida(this.factorizacion);
		}

		//Argumento FORMAT
		if(this.listaDeArgumentos.contains("--format=pretty") || this.listaDeArgumentos.contains("--format=quiet")){

			this.factorizacion = this.formateador.formatearFactorizacion(this.listaDeArgumentos, this.factorizacion);
			
		} else {

			Boolean noContieneFormat = false;

			for(String argumento : listaDeArgumentos){

				if(argumento.contains("--format=")){

					noContieneFormat = true;
				}
			}
			
			//Caso de FORMAT erroneo
			if(noContieneFormat){

				this.factorizacion = "Formato no aceptado. Las opciones posibles son: pretty o quiet.";	

			//Caso de FORMAT no especificado
			} else {

				this.factorizacion = this.formateador.formatearFactorizacion(this.listaDeArgumentos, this.factorizacion);
			}
		}
	}

}
