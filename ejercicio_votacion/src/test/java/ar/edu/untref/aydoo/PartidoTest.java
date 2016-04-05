package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PartidoTest {
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

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
	public void testProvinciaEliminaCandidato() throws Exception{
		
		Partido justicialista = new Partido("justicialista");
		Candidato filmus = new Candidato("daniel filmus", justicialista);

		justicialista.eliminarCandidato(filmus);

		Assert.assertFalse(justicialista.tieneCandidato(filmus));	
	}
	
	@Test(expected=Exception.class)
	public void testPartidoNoEliminaCandidatoQueNoPosee() throws Exception{
		
		expectedEx.expect(Exception.class);
		expectedEx.expectMessage("No puede eliminarse el candidato porque no se ha postulado en el partido");
		
		Partido pro = new Partido("pro");
		Partido justicialista = new Partido("justicialista");
		Candidato filmus = new Candidato("daniel filmus", justicialista);

		pro.eliminarCandidato(filmus);
	}
	
	@Test
	public void testPartidoIndicaQueRecibioUnVoto(){
		
		Partido pro = new Partido("pro");
		Candidato macri = new Candidato("mauricio macri", pro);
		Provincia mendoza = new Provincia("mendoza");		
		Voto voto = new Voto(macri, mendoza);
		
		pro.agregarVoto(voto);
		
		Assert.assertEquals(1, pro.getNumeroDeVotosRecibidos());
	}

}
