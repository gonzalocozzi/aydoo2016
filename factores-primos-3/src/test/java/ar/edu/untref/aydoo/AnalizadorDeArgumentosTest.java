package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AnalizadorDeArgumentosTest {

	@Test
	public void analizadorDeArgumentosSeCreaYAlmacenaElNumeroAFactorizar(){

		String[] args = {"500", "--sort:des"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args, null);

		Integer numeroAFactorizar = analizador.getNumeroAFactorizar();

		Assert.assertEquals(500, numeroAFactorizar, 0.0);		
	}

	@Test
	public void analizadorDeArgumentosSeCreaYAlmacenaLaListaDeArgumentos1(){

		String[] args = {"500", "--sort:des"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args, null);

		List<String> listaDeArgumentos = analizador.getListaDeArgumentos();

		Assert.assertTrue(listaDeArgumentos.contains("500"));
	}

	@Test
	public void analizadorDeArgumentosSeCreaYAlmacenaLaListaDeArgumentos2(){

		String[] args = {"500", "--sort:des"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args, null);

		List<String> listaDeArgumentos = analizador.getListaDeArgumentos();

		Assert.assertTrue(listaDeArgumentos.contains("--sort:des"));
	}

	@Test
	public void analizadorDeArgumentosSeCreaYCreaUnFormateadorAlCualLePasaElNumeroAFormatear(){

		String[] args = {"90"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args, null);		
		Formateador formateadorCreadoPorElAnalizador = analizador.getFormateador();

		Integer numeroAFactorizar = formateadorCreadoPorElAnalizador.getNumeroAFactorizar();

		Assert.assertEquals(90, numeroAFactorizar, 0.0);
	}

	@Test
	public void analizadorDeArgumentosRecibeUnUnicoArgumentoYLlamaAlFormateador() throws IOException{

		String[] args = {"90"};
		String factorizacion = "2 3 3 5 ";		
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args, factorizacion);

		String salidaConfigurada = analizador.getSalidaConfigurada();

		Assert.assertEquals("Factores primos 90: 2 3 3 5 ", salidaConfigurada);
	}

	@Test
	public void analizadorDeArgumentosEncuentraUnArgumentoSortYLlamaAlOrdenador() throws IOException{

		String[] args = {"90", "--sort:des"};
		String factorizacion = "2 3 3 5 ";		
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args, factorizacion);

		String salidaConfigurada = analizador.getSalidaConfigurada();

		Assert.assertEquals("Factores primos 90: 5 3 3 2 ", salidaConfigurada);
	}

	@Test
	public void analizadorDeArgumentosAlertaQueRecibeMasDeCuatroParametros() throws IOException{

		String[] args = {"90", "--sort:des", "--format=pretty", "--output-file=salida.txt", "ARGUMENTO DE MAS"};
		String factorizacion = "2 3 3 5 ";		
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args, factorizacion);

		String salidaConfigurada = analizador.getSalidaConfigurada();

		Assert.assertEquals("Ha ingresado al menos un parametro de mas", salidaConfigurada);
	}

	@Test
	public void analizadorDeArgumentosEncuentraParametroFormatPretty() throws IOException{

		String[] args = {"90", "--format=pretty"};
		String factorizacion = "2 3 3 5 ";		
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args, factorizacion);

		String salidaConfigurada = analizador.getSalidaConfigurada();

		Assert.assertEquals("Factores primos 90: 2 3 3 5 ", salidaConfigurada);
	}

	@Test
	public void analizadorDeArgumentosEncuentraParametroFormatQuiet() throws IOException{

		String[] args = {"90", "--format=quiet"};
		String factorizacion = "2 3 3 5 ";		
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args, factorizacion);

		String salidaConfigurada = analizador.getSalidaConfigurada();

		Assert.assertEquals("Factores primos 90: \n2\n3\n3\n5", salidaConfigurada);
	}

	@Test
	public void analizadorDeArgumentosEncuentraParametroFormatIncorrecto() throws IOException{

		String[] args = {"90", "--format="};
		String factorizacion = "2 3 3 5 ";		
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args, factorizacion);

		String salidaConfigurada = analizador.getSalidaConfigurada();

		Assert.assertEquals("Formato no aceptado. Las opciones posibles son: pretty o quiet.", salidaConfigurada);
	}
	
	@Test
	public void analizadorDeArgumentosEncuentraParametroOutputFileYLlamaAlEscritorDeArchivo() throws IOException{
		
		String[] args = {"90", "--output-file=salida.txt"};
		String factorizacion = "2 3 3 5 ";		
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args, factorizacion);
		
		String direccionDelArchivoDondeSeGuardoLaFactorizacion = analizador.getSalidaConfigurada();
		
		Assert.assertTrue(direccionDelArchivoDondeSeGuardoLaFactorizacion.contains("salida.txt"));
	}

}
