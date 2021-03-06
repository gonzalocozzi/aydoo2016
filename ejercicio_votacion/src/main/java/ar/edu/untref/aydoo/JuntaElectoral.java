package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class JuntaElectoral {

	private List<Candidato> coleccionDeCandidatos;
	private List<Provincia> coleccionDeProvincias;
	
	public JuntaElectoral(){
		
		this.coleccionDeCandidatos = new LinkedList<Candidato>();
		this.coleccionDeProvincias = new LinkedList<Provincia>();
	}

	public void agregarCandidato(Candidato candidato) {
		
		this.coleccionDeCandidatos.add(candidato);
	}

	public boolean tieneCandidato(Candidato candidato) {
		
		return this.coleccionDeCandidatos.contains(candidato);
	}

	public int getNumeroDeCandidatos() {
		
		return this.coleccionDeCandidatos.size();
	}

	public void agregarProvincia(Provincia provincia) {
		
		this.coleccionDeProvincias.add(provincia);
	}

	public boolean tieneProvincia(Provincia provincia) {
		
		return this.coleccionDeProvincias.contains(provincia);
	}

	public int getNumeroDeProvincias() {
		
		return this.coleccionDeProvincias.size();
	}

	public void emitirVoto(Voto voto) throws Exception {
		
		Partido partidoDelCandidatoDelVoto = voto.getCandidato().getPartido();
		Candidato candidatoDelVoto = voto.getCandidato();
		Provincia provinciaDelVoto = voto.getProvincia();

		if(this.tieneCandidato(candidatoDelVoto) && this.tieneProvincia(provinciaDelVoto)){

			int posicionDelCandidatoEnLaColeccion = this.coleccionDeCandidatos.indexOf(candidatoDelVoto);
			this.coleccionDeCandidatos.get(posicionDelCandidatoEnLaColeccion).agregarVoto(voto);

			int posicionDeLaProvinciaEnLaColeccion = this.coleccionDeProvincias.indexOf(provinciaDelVoto);
			this.coleccionDeProvincias.get(posicionDeLaProvinciaEnLaColeccion).agregarVotoAlPartido(partidoDelCandidatoDelVoto, voto);

		} else {

			throw new Exception("La provincia o candidato indicado no ha sido habilitado");			
		}
	}

	public Candidato getCandidatoMasVotado() {

		ListIterator<Candidato> iteradorDeCandidatos = this.coleccionDeCandidatos.listIterator();
		Candidato candidatoMasVotado = null;
		int votos = 0;

		while(iteradorDeCandidatos.hasNext()){			

			Candidato candidatoActual = iteradorDeCandidatos.next();

			if(candidatoActual.getNumeroDeVotosRecibidos() > votos){

				candidatoMasVotado = candidatoActual;
				votos = candidatoActual.getNumeroDeVotosRecibidos();
			}
		}

		return candidatoMasVotado;
	}

	public Partido getPartidoMasVotadoEn(Provincia provincia) {
		
		int posicionDeLaProvinciaEnLaColeccion = this.coleccionDeProvincias.indexOf(provincia);

		return this.coleccionDeProvincias.get(posicionDeLaProvinciaEnLaColeccion).getPartidoMasVotado();
	}

}
