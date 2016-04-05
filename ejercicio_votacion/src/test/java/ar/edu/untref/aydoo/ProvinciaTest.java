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

}
