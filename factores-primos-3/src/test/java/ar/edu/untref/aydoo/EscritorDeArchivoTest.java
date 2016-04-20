package ar.edu.untref.aydoo;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class EscritorDeArchivoTest {
	
	@Test
	public void escritorDeArchivoAlmacenaElNombreDelArchivo() throws IOException{
		
		EscritorDeArchivo escritor = new EscritorDeArchivo();
		Integer numeroAFactorizar = 90;
		String argumentoDeEscrituraEnArchivo = "--output-file=salida.txt";
		String factorizacion = "2 3 3 5 ";		
		escritor.escribirArchivo(numeroAFactorizar, argumentoDeEscrituraEnArchivo, factorizacion);
		
		String nombreDelArchivo = escritor.getNombreDelArchivo();
		
		Assert.assertEquals("salida.txt", nombreDelArchivo);
	}
	
	@Test
	public void escritorDeArchivoSeCreaYAveriguaDireccionRelativaDelJAR(){
		
		EscritorDeArchivo escritor = new EscritorDeArchivo();
		File archivo = new File(System.getProperty("java.class.path"));
		File direccion = archivo.getAbsoluteFile().getParentFile();		
		String direccionRelativaDelJAR = direccion.toString();
		
		String direccionDelJAR = escritor.getDireccionDelJAR();
		
		Assert.assertEquals(direccionRelativaDelJAR, direccionDelJAR);
	}	

}
