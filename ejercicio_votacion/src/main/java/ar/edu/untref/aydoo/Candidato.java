package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Candidato {

	private String nombre;
	private Partido partido;
	private List<Voto> coleccionDeVotosRecibidos = new LinkedList<Voto>();

	public Candidato(String string, Partido partido) {
		this.setNombre(string);
		this.setPartido(partido);
		this.partido.agregarCandidato(this);
	}

	public void agregarVoto(Voto voto) {
		this.coleccionDeVotosRecibidos.add(voto);
	}	
	
	public int getNumeroDeVotosRecibidos() {
		return this.coleccionDeVotosRecibidos.size();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;		
	}

	public List<Voto> getColeccionDeVotosRecibidos() {
		return coleccionDeVotosRecibidos;
	}

	public void setColeccionDeVotosRecibidos(List<Voto> coleccionDeVotosRecibidos) {
		this.coleccionDeVotosRecibidos = coleccionDeVotosRecibidos;
	}

}
