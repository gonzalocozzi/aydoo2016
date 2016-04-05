package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class JuntaElectoralTest {

	@Test
	public void testJuntaElectoralRecibeCandidato(){

		JuntaElectoral juntaElectoral = new JuntaElectoral();		

		Partido renovador = new Partido("frente renovador");
		Candidato massa = new Candidato("sergio massa", renovador);		
		juntaElectoral.agregarCandidato(massa);

		Assert.assertTrue(juntaElectoral.tieneCandidato(massa));
	}

	@Test
	public void testJuntaElectoralRecibeVariosCandidatos(){

		JuntaElectoral juntaElectoral = new JuntaElectoral();

		Partido renovador = new Partido("frente renovador");
		Candidato massa = new Candidato("sergio massa", renovador);
		juntaElectoral.agregarCandidato(massa);

		Partido fpv = new Partido("frente para la victoria");
		Candidato scioli = new Candidato("daniel scioli", fpv);
		juntaElectoral.agregarCandidato(scioli);

		Partido pro = new Partido("pro");
		Candidato macri = new Candidato("macri", pro);
		juntaElectoral.agregarCandidato(macri);

		Assert.assertTrue(juntaElectoral.tieneCandidato(scioli));		
	}

}
