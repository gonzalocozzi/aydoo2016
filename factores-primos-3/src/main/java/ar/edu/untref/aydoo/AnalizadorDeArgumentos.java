package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase dedicada a configurar la salida de la factorizacion
 * considerando los argumentos o parametros ingresados por el usuario
 * @author gonzalo alejandro cozzi
 */
public class AnalizadorDeArgumentos {

	private Integer numeroAFactorizar;
	private String factorizacion;
	private List<String> listaDeArgumentos;	
	private Formateador formateador;
	private Ordenador ordenador;
	private EscritorDeArchivo escritor;

	public AnalizadorDeArgumentos(String[] args, String factorizacion){

		this.numeroAFactorizar = Integer.parseInt(args[0]);
		this.factorizacion = factorizacion;		
		this.listaDeArgumentos =  new ArrayList<String>();

		for(int i = 0; i < args.length; i++){

			listaDeArgumentos.add(i, args[i].toLowerCase());
		}

		this.formateador = new Formateador(this.listaDeArgumentos);		
	}

	public String getSalidaConfigurada() throws IOException{	

		if(listaDeArgumentos.size() < 2){

			this.factorizacion = this.formateador.formatearFactorizacion(this.getFactorizacion());

		} else if(listaDeArgumentos.size() < 5){

			this.analisisDeArgumentos();

		} else {

			this.factorizacion = "Ha ingresado al menos un parametro de mas";
		}

		return this.getFactorizacion();
	}

	private void analisisDeArgumentos() throws IOException {

		this.busquedaDeArgumentoSort();

		this.busquedaDeArgumentoFormat();

		this.busquedaDeArgumentoOutputFile();
	}	

	/**
	 * @post busca el argumento "--sort" en los argumentos
	 * y si lo encuentra envia la factorizacion al ordenador
	 */
	private void busquedaDeArgumentoSort() {

		if(this.listaDeArgumentos.contains("--sort:des")){

			this.ordenador = new Ordenador();
			this.factorizacion = this.ordenador.invertirString(this.factorizacion);
		}
	}

	/**
	 * @post envia la factorizacion al formateador
	 */
	private void busquedaDeArgumentoFormat() {

		if(this.listaDeArgumentos.contains("--format=pretty") || this.listaDeArgumentos.contains("--format=quiet")){

			this.factorizacion = this.formateador.formatearFactorizacion(this.getFactorizacion());

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

				this.factorizacion = this.formateador.formatearFactorizacion(this.getFactorizacion());
			}

		}
	}

	/**
	 * @post busca el argumento "--output-file" en los argumentos
	 * y si lo encuentra envia la factorizacion al escritor de archivo
	 */
	private void busquedaDeArgumentoOutputFile() throws IOException {

		//Se busca si entre los argumentos se incluye "--output-file="
		Boolean contieneDireccionDeArchivo = false;
		Integer posicionDeLaDireccionDelArchivo = 0;

		for(int i = 0; i < this.listaDeArgumentos.size(); i++){

			if(listaDeArgumentos.get(i).contains("--output-file=")){

				contieneDireccionDeArchivo = true;
				posicionDeLaDireccionDelArchivo = i;
			}
		}

		//Si entre los argumentos se incluye "--output-file=" se procede a escribir en archivo
		if(contieneDireccionDeArchivo){			

			this.escritor = new EscritorDeArchivo();
			String parametroDeEscrituraEnArchivo = this.listaDeArgumentos.get(posicionDeLaDireccionDelArchivo);

			this.factorizacion = escritor.escribirArchivo(this.numeroAFactorizar, parametroDeEscrituraEnArchivo, this.factorizacion);
		}
	}

	public Integer getNumeroAFactorizar() {

		return this.numeroAFactorizar;
	}	

	public String getFactorizacion() {
		return this.factorizacion;
	}

	public List<String> getListaDeArgumentos() {

		return this.listaDeArgumentos;
	}

	public Formateador getFormateador() {

		return this.formateador;
	}

}
