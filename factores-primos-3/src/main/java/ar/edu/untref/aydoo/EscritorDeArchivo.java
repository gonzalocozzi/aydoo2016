package ar.edu.untref.aydoo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscritorDeArchivo {
	
	private File archivo = new File(System.getProperty("java.class.path"));
	private File direccion = archivo.getAbsoluteFile().getParentFile();
	private String direccionDelJAR = direccion.toString() + "/";
	private String factorizacion;
	
	public String escribirArchivo(Integer numeroAFactorizar, String parametroDeEscrituraEnArchivo, String factorizacion) throws IOException{
		
		String nombreDelArchivo = parametroDeEscrituraEnArchivo.substring(14);
		File archivoConLaFactorizacion = new File(nombreDelArchivo);
		FileWriter escritor = new FileWriter(archivoConLaFactorizacion);
		escritor.write(factorizacion);
		escritor.close();
		
		this.factorizacion = "La factorización del numero " + numeroAFactorizar + " fue almacenada en " + direccionDelJAR + nombreDelArchivo ;
		
		return this.factorizacion;
	}

}
