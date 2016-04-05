package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class JuntaElectoralTest {

	@Test
	public void testJuntaElectoralAlmacenaCandidato(){

		JuntaElectoral juntaElectoral = new JuntaElectoral();		

		Partido renovador = new Partido("frente renovador");
		Candidato massa = new Candidato("sergio massa", renovador);		
		juntaElectoral.agregarCandidato(massa);

		Assert.assertTrue(juntaElectoral.tieneCandidato(massa));
	}

	@Test
	public void testJuntaElectoralAlmacenaVariosCandidatos(){

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

	@Test
	public void testJuntaElectoralInformaNumeroDeCandidatos(){

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

		Assert.assertEquals(3, juntaElectoral.getNumeroDeCandidatos());
	}

	@Test
	public void testJuntaElectoralAgregaProvincia(){

		JuntaElectoral juntaElectoral = new JuntaElectoral();

		Provincia chubut = new Provincia("chubut");		
		juntaElectoral.agregarProvincia(chubut);

		Assert.assertTrue(juntaElectoral.tieneProvincia(chubut));
	}

}
