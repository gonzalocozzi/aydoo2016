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
	public void testProvinciaEliminaCandidato() throws Exception{
		
		Partido justicialista = new Partido("justicialista");
		Candidato filmus = new Candidato("daniel filmus", justicialista);

		justicialista.eliminarCandidato(filmus);

		Assert.assertFalse(justicialista.tieneCandidato(filmus));	
	}
	
	@Test(expected=Exception.class)
	public void testPartidoNoEliminaCandidatoQueNoPosee() throws Exception{
		
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
	
	@Test
	public void testPartidoIndicaQueRecibioVariosVotosDeVariosCandidatos(){
		
		Partido pro = new Partido("pro");
		Candidato macri = new Candidato("mauricio macri", pro);
		Candidato michetti = new Candidato("gabriela michetti", pro);
		Provincia mendoza = new Provincia("mendoza");		
		Voto voto1 = new Voto(macri, mendoza);
		Voto voto2 = new Voto(macri, mendoza);
		Voto voto3 = new Voto(michetti, mendoza);
		Voto voto4 = new Voto(macri, mendoza);
		Voto voto5 = new Voto(macri, mendoza);
		Voto voto6 = new Voto(michetti, mendoza);
		
		pro.agregarVoto(voto1);
		pro.agregarVoto(voto2);
		pro.agregarVoto(voto3);
		pro.agregarVoto(voto4);
		pro.agregarVoto(voto5);
		pro.agregarVoto(voto6);
		
		Assert.assertEquals(6, pro.getNumeroDeVotosRecibidos());
	}

}
