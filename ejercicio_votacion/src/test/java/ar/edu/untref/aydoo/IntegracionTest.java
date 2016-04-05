package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegracionTest {	

	JuntaElectoral centroDeComputos = new JuntaElectoral();		

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
		centroDeComputos.agregarCandidato(macri);		
		centroDeComputos.agregarCandidato(massa);		
		centroDeComputos.agregarCandidato(scioli);

		//Incorporacion de las provincias habilitadas al centro de computos
		centroDeComputos.agregarProvincia(mendoza);
		centroDeComputos.agregarProvincia(buenosaires);
		centroDeComputos.agregarProvincia(rionegro);
		centroDeComputos.agregarProvincia(entrerios);
	}	

	@Test
	public void testSeEmiteVotoYCandidatoLoRecibeCorrectamente() throws Exception{

		Voto voto = new Voto(macri, buenosaires);
		centroDeComputos.emitirVoto(voto);

		Assert.assertEquals(1, macri.getNumeroDeVotosRecibidos());
	}

}
