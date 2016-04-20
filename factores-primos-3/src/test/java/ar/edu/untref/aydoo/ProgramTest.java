package ar.edu.untref.aydoo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProgramTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();	

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
	
	@Test
	public void programDevuelveFactorizacionDeUnNumeroSinArgumentosAparteDelNumero() throws IOException{
		
		String[] args = {"82"};
		Program.main(args);
		
		Assert.assertEquals("Factores primos 82: 2 41 \n", outContent.toString());
	}
	
	@Test
	public void programDevuelveFactorizacionDeUnNumeroConArgumentoFormatQuiet() throws IOException{
		
		String[] args = {"150", "--format=quiet"};
		Program.main(args);
		
		Assert.assertEquals("Factores primos 150: \n2\n3\n5\n5\n", outContent.toString());
	}
	
	@Test
	public void programDevuelveFactorizacionDeUnNumeroConArgumentoFormatPretty() throws IOException{
		
		String[] args = {"150", "--format=pretty"};
		Program.main(args);
		
		Assert.assertEquals("Factores primos 150: 2 3 5 5 \n", outContent.toString());
	}
	
	@Test
	public void programIndicaIngresoDeArgumentoFormatErroneo() throws IOException{
		
		String[] args = {"150", "--format=invalido"};
		Program.main(args);
		
		Assert.assertEquals("Formato no aceptado. Las opciones posibles son: pretty o quiet.\n", outContent.toString());
	}
	
	@Test
	public void programDevuelveFactorizacionDeUnNumeroConArgumentoSortDes() throws IOException{
		
		String[] args = {"150", "--sort:des"};
		Program.main(args);
		
		Assert.assertEquals("Factores primos 150: 5 5 3 2 \n", outContent.toString());
	}
	
	@Test
	public void programDevuelveFactorizacionDeUnNumeroConArgumentoSortAsc() throws IOException{
		
		String[] args = {"150", "--sort:asc"};
		Program.main(args);
		
		Assert.assertEquals("Factores primos 150: 2 3 5 5 \n", outContent.toString());
	}
	
	@Test
	public void programIndicaEscrituraEnArchivoConArgumentoOutputFile() throws IOException{
		
		String[] args = {"150", "--output-file=salida.txt"};
		Program.main(args);
		
		Assert.assertTrue(outContent.toString().contains("La factorización del numero 150 fue almacenada en "));
	}
	
	@Test
	public void programIndicaEscrituraEnArchivoConArgumentosSortDesYFormatPrettyEnOrdenInvertido() throws IOException{
		
		String[] args = {"150", "--sort:des", "--format=pretty"};
		Program.main(args);
		
		Assert.assertEquals("Factores primos 150: 5 5 3 2 \n", outContent.toString());
	}

}
