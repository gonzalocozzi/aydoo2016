package ar.edu.untref.aydoo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AnalizadorDeArgumentosTest {
	
	@Test
	public void analizadorDeArgumentosSeCreaYAlmacenaElNumeroAFactorizar(){
		
		String[] args = {"500", "--sort:des"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args, null);
		
		Integer numeroAFactorizar = analizador.getNumeroAFactorizar();
		
		Assert.assertEquals(500, numeroAFactorizar, 0.0);		
	}
	
	@Test
	public void analizadorDeArgumentosSeCreaYAlmacenaLaListaDeArgumentos1(){
		
		String[] args = {"500", "--sort:des"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args, null);
		
		List<String> listaDeArgumentos = analizador.getListaDeArgumentos();
		
		Assert.assertTrue(listaDeArgumentos.contains("500"));
	}
	
	@Test
	public void analizadorDeArgumentosSeCreaYAlmacenaLaListaDeArgumentos2(){
		
		String[] args = {"500", "--sort:des"};
		AnalizadorDeArgumentos analizador = new AnalizadorDeArgumentos(args, null);
		
		List<String> listaDeArgumentos = analizador.getListaDeArgumentos();
		
		Assert.assertTrue(listaDeArgumentos.contains("--sort:des"));
	}

}
