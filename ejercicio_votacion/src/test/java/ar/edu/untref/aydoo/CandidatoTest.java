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
	
	@Test
	public void testCandidatoAlmacenaVotoRecibidoCorrectamente(){
		
		Partido fpv = new Partido("frente para la victoria");		
		Candidato scioli = new Candidato("scioli", fpv);
		Provincia sanjuan = new Provincia("san juan");
		Voto voto = new Voto(scioli, sanjuan);
		
		scioli.agregarVoto(voto);
		
		Assert.assertTrue(scioli.getColeccionDeVotosRecibidos().contains(voto));
	}
	
	@Test
	public void testCandidatoIndicaCorrectamenteElNumeroDeVotosQueRecibio(){
		
		Partido fpv = new Partido("frente para la victoria");		
		Candidato scioli = new Candidato("scioli", fpv);
		Provincia sanjuan = new Provincia("san juan");
		Voto voto1 = new Voto(scioli, sanjuan);
		Voto voto2 = new Voto(scioli, sanjuan);
		Voto voto3 = new Voto(scioli, sanjuan);
		
		scioli.agregarVoto(voto1);
		scioli.agregarVoto(voto2);
		scioli.agregarVoto(voto3);
		
		Assert.assertEquals(3, scioli.getNumeroDeVotosRecibidos());
	}
	
	@Test
	public void testCandidatoSeAgregaASuPartido(){
		
		Partido fpv = new Partido("frente para la victoria");		
		Candidato scioli = new Candidato("scioli", fpv);
		
		Partido partidoDelCandidato = scioli.getPartido();
		
		Assert.assertTrue(partidoDelCandidato.getColeccionDeCandidatos().contains(scioli));
	}

}
