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
	public void testJuntaElectoralAgregaProvinciaHabilitadaParaELComicio(){

		JuntaElectoral juntaElectoral = new JuntaElectoral();

		Provincia chubut = new Provincia("chubut");		
		juntaElectoral.agregarProvincia(chubut);

		Assert.assertTrue(juntaElectoral.tieneProvincia(chubut));
	}

	@Test
	public void testJuntaElectoralAgregaVariasProvinciasHabilitadasParaElComicio(){

		JuntaElectoral juntaElectoral = new JuntaElectoral();

		Provincia chubut = new Provincia("chubut");		
		juntaElectoral.agregarProvincia(chubut);

		Provincia mendoza = new Provincia("mendoza");
		juntaElectoral.agregarProvincia(mendoza);

		Provincia corrientes = new Provincia("corrientes");
		juntaElectoral.agregarProvincia(corrientes);

		Assert.assertTrue(juntaElectoral.tieneProvincia(corrientes));
	}

	@Test
	public void testJuntaElectoralInformaElNumeroDeProvinciasHabilitadasParaElComicio(){

		JuntaElectoral juntaElectoral = new JuntaElectoral();

		Provincia chubut = new Provincia("chubut");		
		juntaElectoral.agregarProvincia(chubut);

		Provincia mendoza = new Provincia("mendoza");
		juntaElectoral.agregarProvincia(mendoza);

		Assert.assertEquals(2, juntaElectoral.getNumeroDeProvincias());
	}

}
