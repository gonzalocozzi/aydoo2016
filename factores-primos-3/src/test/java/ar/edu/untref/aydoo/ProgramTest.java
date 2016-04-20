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

}
