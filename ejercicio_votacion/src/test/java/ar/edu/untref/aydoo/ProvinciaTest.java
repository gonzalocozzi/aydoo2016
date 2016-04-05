package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ProvinciaTest {

	@Test
	public void testProvinciaSeCreaConElNombreCorrecto(){

		Provincia buenosaires = new Provincia("buenos aires");

		Assert.assertEquals("buenos aires", buenosaires.getNombre());
	}

	@Test
	public void testProvinciaIncorporaPartido(){

		Provincia santiagodelestero = new Provincia("santiago del estero");
		Partido ucr = new Partido("union civica radical");

		santiagodelestero.agregarPartido(ucr);

		Assert.assertTrue(santiagodelestero.tienePartido(ucr));
	}

	@Test
	public void testProvinciaEliminaPartidoIndicado() throws Exception{

		Provincia neuquen = new Provincia("neuquen");
		Partido ucr = new Partido("union civica radical");

		neuquen.agregarPartido(ucr);
		neuquen.eliminarPartido(ucr);

		Assert.assertFalse(neuquen.tienePartido(ucr));
	}

	@Test(expected=Exception.class)
	public void testProvinciaNoEliminaPartidoQueNoPosee() throws Exception{

		Provincia sanluis = new Provincia("san luis");
		Partido pj = new Partido("justicialista");

		sanluis.eliminarPartido(pj);
	}

	@Test
	public void testProvinciaIndicaQueTieneElPartidoIndicado(){

		Provincia cordoba = new Provincia("cordoba");
		Partido fpv = new Partido("frente para la victoria");		
		cordoba.agregarPartido(fpv);

		Assert.assertTrue(cordoba.tienePartido(fpv));
	}

	@Test
	public void testProvinciaIndicaQueNoTieneElPartidoIndicado(){

		Provincia misiones = new Provincia("misiones");
		Partido pro = new Partido("pro");

		Assert.assertFalse(misiones.tienePartido(pro));
	}

	@Test
	public void testProvinciaAgregaVotoAUnPartido() throws Exception{

		Provincia chubut = new Provincia("chubut");
		Partido renovador = new Partido("frente renovador");
		Candidato massa = new Candidato("sergio massa", renovador);
		chubut.agregarPartido(renovador);
		Voto voto = new Voto(massa, chubut);

		chubut.agregarVotoAlPartido(renovador, voto);

		Assert.assertEquals(1, chubut.getColeccionDePartidos().get(0).getNumeroDeVotosRecibidos());
	}

	@Test(expected=Exception.class)
	public void testProvinciaNoAgregaVotoAUnPartidoQueNoPosee() throws Exception{

		Provincia tierradelfuego = new Provincia("tierra del fuego");
		Partido fpv = new Partido("frente para la victoria");
		Candidato scioli = new Candidato("daniel scioli", fpv);

		Voto voto = new Voto(scioli, tierradelfuego);

		tierradelfuego.agregarVotoAlPartido(fpv, voto);
	}

	@Test
	public void testProvinciaIndicaCualEsElPartidoMasVotadoEnSuTerritorio() throws Exception{

		//Definicion de los candidatos y partidos
		Partido pro = new Partido("pro");
		Candidato macri = new Candidato("mauricio macri", pro);	
		Partido renovador = new Partido("frente renovador");
		Candidato massa = new Candidato("sergio massa", renovador);
		Partido fpv = new Partido("frente para la victoria");
		Candidato scioli = new Candidato("daniel scioli", fpv);
		//Definicion de la provincia	
		Provincia mendoza = new Provincia("mendoza");
		mendoza.agregarPartido(pro);
		mendoza.agregarPartido(renovador);
		mendoza.agregarPartido(fpv);
		//Creacion de los votos
		Voto voto1 = new Voto(macri, mendoza);
		Voto voto2 = new Voto(macri, mendoza);
		Voto voto3 = new Voto(massa, mendoza);
		Voto voto4 = new Voto(massa, mendoza);
		Voto voto5 = new Voto(scioli, mendoza);
		Voto voto6 = new Voto(massa, mendoza);
		Voto voto7 = new Voto(macri, mendoza);
		Voto voto8 = new Voto(massa, mendoza);
		Voto voto9 = new Voto(scioli, mendoza);
		Voto voto10 = new Voto(scioli, mendoza);
		Voto voto11 = new Voto(macri, mendoza);
		Voto voto12 = new Voto(macri, mendoza);
		
		mendoza.agregarVotoAlPartido(pro, voto1);
		mendoza.agregarVotoAlPartido(pro, voto2);
		mendoza.agregarVotoAlPartido(renovador, voto3);
		mendoza.agregarVotoAlPartido(renovador, voto4);		
		mendoza.agregarVotoAlPartido(fpv, voto5);
		mendoza.agregarVotoAlPartido(renovador, voto6);
		mendoza.agregarVotoAlPartido(pro, voto7);
		mendoza.agregarVotoAlPartido(renovador, voto8);		
		mendoza.agregarVotoAlPartido(fpv, voto9);
		mendoza.agregarVotoAlPartido(fpv, voto10);
		mendoza.agregarVotoAlPartido(pro, voto11);
		mendoza.agregarVotoAlPartido(pro, voto12);		
		
		Assert.assertEquals(pro, mendoza.getPartidoMasVotado());
	}

}
