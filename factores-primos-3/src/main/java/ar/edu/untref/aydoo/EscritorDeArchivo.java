package ar.edu.untref.aydoo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author gonzalo alejandro cozzi
 */
public class EscritorDeArchivo {	

	private String nombreDelArchivo;
	private String direccionDelJAR;
	private String factorizacion;	

	public EscritorDeArchivo(){

		File archivo = new File(System.getProperty("java.class.path"));
		File direccion = archivo.getAbsoluteFile().getParentFile();		
		this.direccionDelJAR = direccion.toString();
	}

	public String escribirArchivo(Integer numeroAFactorizar, String argumentoDeEscrituraEnArchivo, String factorizacion) throws IOException{

		this.nombreDelArchivo = argumentoDeEscrituraEnArchivo.substring(14);
		File archivoConLaFactorizacion = new File(nombreDelArchivo);
		FileWriter escritor = new FileWriter(archivoConLaFactorizacion);
		escritor.write(factorizacion);
		escritor.close();

		String mensajeDeEscrituraEnConsola = "La factorización del numero " + numeroAFactorizar + 
				" fue almacenada en " + this.getDireccionDelJAR() + "/" + this.getNombreDelArchivo();

		this.factorizacion = mensajeDeEscrituraEnConsola;

		return this.getFactorizacion();
	}	

	public String getNombreDelArchivo(){

		return this.nombreDelArchivo;
	}


	public String getFactorizacion() {

		return this.factorizacion;
	}

	public String getDireccionDelJAR(){

		return this.direccionDelJAR;
	}

}
