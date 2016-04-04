package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class VotoTest {
	
	@Test
	public void testSeCreaVotoConProvinciaCorrecta(){
		
		Provincia chubut = new Provincia("chubut");
		Partido fpv = new Partido("frente para la victoria");
		Candidato scioli = new Candidato("daniel scioli", fpv);
		chubut.agregarPartido(fpv);
		
		Voto voto = new Voto(scioli, chubut);
		
		Assert.assertEquals(chubut, voto.getProvincia());
	}

}
