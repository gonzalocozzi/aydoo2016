package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegracionTest {	

	JuntaElectoral juntaElectoral = new JuntaElectoral();		

	//Definicion de los candidatos y sus partidos		
	Partido pro = new Partido("pro");
	Candidato macri = new Candidato("mauricio macri", pro);
	Partido renovador = new Partido("frente renovador");
	Candidato massa = new Candidato("sergio massa", renovador);
	Partido fpv = new Partido("frente para la victoria");
	Candidato scioli = new Candidato("daniel scioli", fpv);		

	//Definicion de las provincias	
	Provincia mendoza = new Provincia("mendoza");	
	Provincia buenosaires = new Provincia("buenos aires");
	Provincia rionegro = new Provincia("rio negro");
	Provincia entrerios = new Provincia("entre rios");

	@Before
	public void incoporacionDeCandidatosYProvinciasHabilitadasALaJuntaElectoral(){	

		//Incorporacion de los partidos a las provincias
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

		//Incorporacion de los candidatos habilitados al centro de computos
		juntaElectoral.agregarCandidato(macri);		
		juntaElectoral.agregarCandidato(massa);		
		juntaElectoral.agregarCandidato(scioli);

		//Incorporacion de las provincias habilitadas al centro de computos
		juntaElectoral.agregarProvincia(mendoza);
		juntaElectoral.agregarProvincia(buenosaires);
		juntaElectoral.agregarProvincia(rionegro);
		juntaElectoral.agregarProvincia(entrerios);
	}	

	@Test
	public void testSeEmiteVotoYCandidatoLoRecibe() throws Exception{

		Voto voto = new Voto(macri, buenosaires);
		juntaElectoral.emitirVoto(voto);

		Assert.assertEquals(1, macri.getNumeroDeVotosRecibidos());
	}

	@Test
	public void testSeEmitenVariosVotosAlMismoCandidatoYEsteLosCuenta() throws Exception{

		Voto voto1 = new Voto(massa, mendoza);
		Voto voto2 = new Voto(massa, mendoza);
		Voto voto3 = new Voto(massa, entrerios);
		Voto voto4 = new Voto(massa, entrerios);
		Voto voto5 = new Voto(massa, buenosaires);
		Voto voto6 = new Voto(massa, buenosaires);
		Voto voto7 = new Voto(massa, buenosaires);
		Voto voto8 = new Voto(massa, buenosaires);
		Voto voto9 = new Voto(massa, rionegro);

		juntaElectoral.emitirVoto(voto1);		
		juntaElectoral.emitirVoto(voto2);	
		juntaElectoral.emitirVoto(voto3);	
		juntaElectoral.emitirVoto(voto4);	
		juntaElectoral.emitirVoto(voto5);	
		juntaElectoral.emitirVoto(voto6);	
		juntaElectoral.emitirVoto(voto7);	
		juntaElectoral.emitirVoto(voto8);	
		juntaElectoral.emitirVoto(voto9);

		Assert.assertEquals(9, massa.getNumeroDeVotosRecibidos());
	}

	@Test
	public void testSeEmitenVariosVotosADiferentesCandidatosEnLaMismaProvinciaYLaJuntaElectoralIndicaCualEsElPartidoMasVotadoEnElla() throws Exception{

		Voto voto1 = new Voto(macri, rionegro);
		Voto voto2 = new Voto(macri, rionegro);
		Voto voto3 = new Voto(scioli, rionegro);
		Voto voto4 = new Voto(massa, rionegro);
		Voto voto5 = new Voto(massa, rionegro);
		Voto voto6 = new Voto(scioli, rionegro);
		Voto voto7 = new Voto(massa, rionegro);
		Voto voto8 = new Voto(macri, rionegro);
		Voto voto9 = new Voto(massa, rionegro);

		juntaElectoral.emitirVoto(voto1);		
		juntaElectoral.emitirVoto(voto2);	
		juntaElectoral.emitirVoto(voto3);	
		juntaElectoral.emitirVoto(voto4);	
		juntaElectoral.emitirVoto(voto5);	
		juntaElectoral.emitirVoto(voto6);	
		juntaElectoral.emitirVoto(voto7);	
		juntaElectoral.emitirVoto(voto8);	
		juntaElectoral.emitirVoto(voto9);

		Assert.assertEquals(renovador, juntaElectoral.getPartidoMasVotadoEn(rionegro));
	}

	@Test
	public void testSeEmitenVotosADiferentesCandidatosEnVariasProvinciasYLaJuntaElectoralIndicaCualFueElMasVotadoEnElPais() throws Exception{

		Voto voto1 = new Voto(macri, mendoza);
		Voto voto2 = new Voto(macri, rionegro);
		Voto voto3 = new Voto(massa, buenosaires);
		Voto voto4 = new Voto(massa, buenosaires);
		Voto voto5 = new Voto(scioli, buenosaires);
		Voto voto6 = new Voto(massa, mendoza);
		Voto voto7 = new Voto(macri, entrerios);
		Voto voto8 = new Voto(massa, entrerios);
		Voto voto9 = new Voto(scioli, entrerios);
		Voto voto10 = new Voto(scioli, buenosaires);
		Voto voto11 = new Voto(macri, mendoza);
		Voto voto12 = new Voto(macri, mendoza);
		Voto voto13 = new Voto(scioli, rionegro);
		Voto voto14 = new Voto(macri, buenosaires);

		juntaElectoral.emitirVoto(voto1);		
		juntaElectoral.emitirVoto(voto2);	
		juntaElectoral.emitirVoto(voto3);	
		juntaElectoral.emitirVoto(voto4);	
		juntaElectoral.emitirVoto(voto5);	
		juntaElectoral.emitirVoto(voto6);	
		juntaElectoral.emitirVoto(voto7);	
		juntaElectoral.emitirVoto(voto8);	
		juntaElectoral.emitirVoto(voto9);
		juntaElectoral.emitirVoto(voto10);		
		juntaElectoral.emitirVoto(voto11);
		juntaElectoral.emitirVoto(voto12);
		juntaElectoral.emitirVoto(voto13);	
		juntaElectoral.emitirVoto(voto14);	

		Assert.assertEquals(macri, juntaElectoral.getCandidatoMasVotado());		
	}

	@Test(expected=Exception.class)
	public void testNoSePermiteVotarAUnCandidatoNoHabilitado() throws Exception{

		Partido socialista = new Partido("partido socialista");
		Candidato binner = new Candidato("hermes binner", socialista);
		mendoza.agregarPartido(socialista);

		Voto voto = new Voto(binner, mendoza);		

		juntaElectoral.emitirVoto(voto);	
	}

	@Test(expected=Exception.class)
	public void testNoSePermiteVotarEnUnaProvinciaNoHabilitada() throws Exception{

		Partido mpn = new Partido("movimiento popular neuquino");
		Candidato gutierrez = new Candidato("gutierrez", mpn);
		Provincia neuquen = new Provincia("neuquen");		
		juntaElectoral.agregarCandidato(gutierrez);

		Voto voto = new Voto(gutierrez, neuquen);

		juntaElectoral.emitirVoto(voto);
	}
	
}
