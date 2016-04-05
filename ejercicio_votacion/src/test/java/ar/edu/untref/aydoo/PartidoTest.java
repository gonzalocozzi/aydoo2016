package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class PartidoTest {

	@Test
	public void testPartidoSeCreaConNombreCorrecto(){

		Partido ucr = new Partido("union civica radical");

		Assert.assertEquals("union civica radical", ucr.getNombre());
	}

	@Test
	public void testPartidoIndicaQuePoseeCandidato(){

		Partido justicialista = new Partido("justicialista");
		Candidato filmus = new Candidato("daniel filmus", justicialista);	

		Assert.assertTrue(justicialista.tieneCandidato(filmus));		
	}

	@Test
	public void testProvinciaEliminaCandidato(){

		Partido justicialista = new Partido("justicialista");
		Candidato filmus = new Candidato("daniel filmus", justicialista);

		justicialista.eliminarCandidato(filmus);

		Assert.assertFalse(justicialista.tieneCandidato(filmus));	
	}
	
}
