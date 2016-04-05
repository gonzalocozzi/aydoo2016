package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class CandidatoTest {
	
	@Test
	public void testCandidatoSeCreaConNombreCorrecto(){
		
		Partido socialismo = new Partido("partido socialista");		
		Candidato stolbizer = new Candidato("stolbizer", socialismo);
		
		Assert.assertEquals("stolbizer", stolbizer.getNombre());
	}
	
	@Test
	public void testCandidatoSeCreaConPartidoCorrecto(){
		
		Partido socialismo = new Partido("partido socialista");		
		Candidato stolbizer = new Candidato("stolbizer", socialismo);
		
		Assert.assertEquals(socialismo, stolbizer.getPartido());
	}

}
