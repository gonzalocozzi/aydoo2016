package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDeArgumentos {

	private Integer numeroAFactorizar;
	private String factorizacion;
	private List<String> listaDeArgumentos;
	private Formateador formateador;
	private Ordenador ordenador;
	private EscritorDeArchivo escritor;

	public AdministradorDeArgumentos(Integer numeroAFactorizar, String[] args, String factorizacion){

		this.numeroAFactorizar = numeroAFactorizar;
		this.factorizacion = factorizacion;		
		this.listaDeArgumentos =  new ArrayList<String>();
		this.formateador = new Formateador(this.numeroAFactorizar);		

		for(int i = 0; i < args.length; i++){

			listaDeArgumentos.add(i, args[i].toLowerCase());
		}
	}

	public String getSalidaConfigurada() throws IOException{	

		if(listaDeArgumentos.size() < 2){

			this.factorizacion = this.formateador.formatearFactorizacion(this.listaDeArgumentos, this.factorizacion);

		} else if(listaDeArgumentos.size() < 5){

			this.analisisDeArgumentos();

		} else {

			this.factorizacion = "Ha ingresado al menos un parámetro de más";
		}

		return this.factorizacion;
	}

	private void analisisDeArgumentos() throws IOException {

		//Argumento SORT
		if(this.listaDeArgumentos.contains("--sort:des")){

			this.ordenador = new Ordenador();
			this.factorizacion = this.ordenador.invertirSalida(this.factorizacion);
		}

		//Argumento FORMAT
		if(this.listaDeArgumentos.contains("--format=pretty") || this.listaDeArgumentos.contains("--format=quiet")){

			this.factorizacion = this.formateador.formatearFactorizacion(this.listaDeArgumentos, this.factorizacion);

		} else {

			Boolean contieneFormatErroneo = false;

			for(String argumento : listaDeArgumentos){

				if(argumento.contains("--format=")){

					contieneFormatErroneo = true;
				}
			}

			//Caso de FORMAT erroneo
			if(contieneFormatErroneo){

				this.factorizacion = "Formato no aceptado. Las opciones posibles son: pretty o quiet.";	

				//Caso de FORMAT no especificado
			} else {

				this.factorizacion = this.formateador.formatearFactorizacion(this.listaDeArgumentos, this.factorizacion);
			}

		}

		//Argumento OUTPUT FILE			
		Boolean contieneDireccionDeArchivo = false;
		Integer posicionDeLaDireccionDelArchivo = 0;

		for(int i = 0; i < this.listaDeArgumentos.size(); i++){

			if(listaDeArgumentos.get(i).contains("--output-file=")){

				contieneDireccionDeArchivo = true;
				posicionDeLaDireccionDelArchivo = i;
			}

		}

		if(contieneDireccionDeArchivo){			

			this.escritor = new EscritorDeArchivo();
			String parametroDeEscrituraEnArchivo = this.listaDeArgumentos.get(posicionDeLaDireccionDelArchivo);
			this.factorizacion = escritor.escribirArchivo(this.numeroAFactorizar, parametroDeEscrituraEnArchivo, this.factorizacion);
		}
	}

}
