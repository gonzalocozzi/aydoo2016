package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class JuntaElectoralTest {

	@Test
	public void testJuntaElectoralAlmacenaCandidatoHabilitadoParaElComicio(){

		JuntaElectoral juntaElectoral = new JuntaElectoral();		

		Partido renovador = new Partido("frente renovador");
		Candidato massa = new Candidato("sergio massa", renovador);		
		juntaElectoral.agregarCandidato(massa);

		Assert.assertTrue(juntaElectoral.tieneCandidato(massa));
	}

	@Test
	public void testJuntaElectoralAlmacenaVariosCandidatosHabilitadosParaeLcOmicio(){

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
	public void testJuntaElectoralInformaNumeroDeCandidatosHabilitadosParaElComicio(){

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
	public void testJuntaElectoralAgregaProvinciaHabilitadasParaElComicio(){

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

	@Test
	public void testJuntaElectoralRecibeVotoYLoEnviaAlCandidatoCorrespondiente() throws Exception{

		JuntaElectoral juntaElectoral = new JuntaElectoral();

		Partido renovador = new Partido("frente renovador");
		Candidato massa = new Candidato("sergio massa", renovador);
		juntaElectoral.agregarCandidato(massa);
		Provincia chubut = new Provincia("chubut");		
		chubut.agregarPartido(renovador);
		juntaElectoral.agregarProvincia(chubut);
		Voto voto = new Voto(massa, chubut);

		juntaElectoral.emitirVoto(voto);

		Assert.assertEquals(1, massa.getNumeroDeVotosRecibidos());
	}

	@Test
	public void testJuntaElectoralRecibeVotoYLoEnviaALaProvinciaCorrespondiente() throws Exception{

		JuntaElectoral juntaElectoral = new JuntaElectoral();

		Partido renovador = new Partido("frente renovador");
		Candidato massa = new Candidato("sergio massa", renovador);
		juntaElectoral.agregarCandidato(massa);
		Provincia chubut = new Provincia("chubut");		
		chubut.agregarPartido(renovador);
		juntaElectoral.agregarProvincia(chubut);
		Voto voto = new Voto(massa, chubut);

		juntaElectoral.emitirVoto(voto);

		Assert.assertEquals(1, chubut.getPartido(renovador).getNumeroDeVotosRecibidos());
	}

	@Test
	public void testJuntaElectoralRecibeVariosVotosParaUnCandidatoEnUnaProvinciaYLosCuenta() throws Exception{

		JuntaElectoral juntaElectoral = new JuntaElectoral();
		//Definicion del candidato
		Partido renovador = new Partido("frente renovador");
		Candidato massa = new Candidato("sergio massa", renovador);
		juntaElectoral.agregarCandidato(massa);
		//Definicion de la provincia
		Provincia mendoza = new Provincia("mendoza");		
		mendoza.agregarPartido(renovador);
		juntaElectoral.agregarProvincia(mendoza);
		//Creacion de los votos
		Voto voto1 = new Voto(massa, mendoza);
		Voto voto2 = new Voto(massa, mendoza);
		Voto voto3 = new Voto(massa, mendoza);
		Voto voto4 = new Voto(massa, mendoza);
		Voto voto5 = new Voto(massa, mendoza);

		juntaElectoral.emitirVoto(voto1);
		juntaElectoral.emitirVoto(voto2);
		juntaElectoral.emitirVoto(voto3);
		juntaElectoral.emitirVoto(voto4);
		juntaElectoral.emitirVoto(voto5);

		Assert.assertEquals(5, massa.getNumeroDeVotosRecibidos());
	}

	@Test
	public void testJuntaElectoralRecibeVariosVotosParaUnCandidatoEnVariasProvinciasYLosCuenta() throws Exception{

		JuntaElectoral juntaElectoral = new JuntaElectoral();
		//Definicion del candidato
		Partido pro = new Partido("pro");
		Candidato macri = new Candidato("mauricio macri", pro);
		juntaElectoral.agregarCandidato(macri);
		//Definicion de las provincias
		Provincia mendoza = new Provincia("mendoza");	
		Provincia buenosaires = new Provincia("buenos aires");
		Provincia rionegro = new Provincia("rio negro");
		Provincia entrerios = new Provincia("entre rios");
		mendoza.agregarPartido(pro);
		buenosaires.agregarPartido(pro);
		rionegro.agregarPartido(pro);
		entrerios.agregarPartido(pro);
		juntaElectoral.agregarProvincia(mendoza);
		juntaElectoral.agregarProvincia(buenosaires);
		juntaElectoral.agregarProvincia(rionegro);
		juntaElectoral.agregarProvincia(entrerios);
		//Creacion de los votos
		Voto voto1 = new Voto(macri, mendoza);
		Voto voto2 = new Voto(macri, mendoza);
		Voto voto3 = new Voto(macri, mendoza);
		Voto voto4 = new Voto(macri, buenosaires);
		Voto voto5 = new Voto(macri, buenosaires);
		Voto voto6 = new Voto(macri, rionegro);
		Voto voto7 = new Voto(macri, entrerios);
		Voto voto8 = new Voto(macri, entrerios);
		Voto voto9 = new Voto(macri, entrerios);

		juntaElectoral.emitirVoto(voto1);
		juntaElectoral.emitirVoto(voto2);
		juntaElectoral.emitirVoto(voto3);
		juntaElectoral.emitirVoto(voto4);
		juntaElectoral.emitirVoto(voto5);
		juntaElectoral.emitirVoto(voto6);
		juntaElectoral.emitirVoto(voto7);
		juntaElectoral.emitirVoto(voto8);
		juntaElectoral.emitirVoto(voto9);

		Assert.assertEquals(9, macri.getNumeroDeVotosRecibidos());
	}

	@Test
	public void testJuntaElectoralIndicaCandidatoMasVotadoEnElPais() throws Exception{

		JuntaElectoral juntaElectoral = new JuntaElectoral();
		//Definicion de los candidatos y partidos
		Partido pro = new Partido("pro");
		Candidato macri = new Candidato("mauricio macri", pro);
		juntaElectoral.agregarCandidato(macri);		
		Partido renovador = new Partido("frente renovador");
		Candidato massa = new Candidato("sergio massa", renovador);
		juntaElectoral.agregarCandidato(massa);		
		Partido fpv = new Partido("frente para la victoria");
		Candidato scioli = new Candidato("daniel scioli", fpv);
		juntaElectoral.agregarCandidato(scioli);
		//Definicion de las provincias		
		Provincia mendoza = new Provincia("mendoza");	
		Provincia buenosaires = new Provincia("buenos aires");
		Provincia rionegro = new Provincia("rio negro");
		Provincia entrerios = new Provincia("entre rios");
		mendoza.agregarPartido(pro);
		buenosaires.agregarPartido(pro);
		rionegro.agregarPartido(pro);
		entrerios.agregarPartido(pro);
		mendoza.agregarPartido(renovador);
		buenosaires.agregarPartido(renovador);
		rionegro.agregarPartido(renovador);
		entrerios.agregarPartido(renovador);
		mendoza.agregarPartido(fpv);
		buenosaires.agregarPartido(fpv);
		rionegro.agregarPartido(fpv);
		entrerios.agregarPartido(fpv);
		juntaElectoral.agregarProvincia(mendoza);
		juntaElectoral.agregarProvincia(buenosaires);
		juntaElectoral.agregarProvincia(rionegro);
		juntaElectoral.agregarProvincia(entrerios);
		//Creacion de los votos
		Voto voto1 = new Voto(macri, mendoza);
		Voto voto2 = new Voto(macri, mendoza);
		Voto voto3 = new Voto(massa, mendoza);
		Voto voto4 = new Voto(scioli, buenosaires);
		Voto voto5 = new Voto(massa, buenosaires);
		Voto voto6 = new Voto(massa, rionegro);
		Voto voto7 = new Voto(macri, entrerios);
		Voto voto8 = new Voto(scioli, entrerios);
		Voto voto9 = new Voto(massa, entrerios);

		juntaElectoral.emitirVoto(voto1);
		juntaElectoral.emitirVoto(voto2);
		juntaElectoral.emitirVoto(voto3);
		juntaElectoral.emitirVoto(voto4);
		juntaElectoral.emitirVoto(voto5);
		juntaElectoral.emitirVoto(voto6);
		juntaElectoral.emitirVoto(voto7);
		juntaElectoral.emitirVoto(voto8);
		juntaElectoral.emitirVoto(voto9);

		Assert.assertEquals(massa, juntaElectoral.getCandidatoMasVotado());
	}

}
