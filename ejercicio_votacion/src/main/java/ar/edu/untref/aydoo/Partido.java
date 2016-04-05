package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Partido {

	private String nombre;
	private List<Voto> coleccionDeVotos = new LinkedList<Voto>();
	private List<Candidato> coleccionDeCandidatos = new LinkedList<Candidato>();

	public Partido(String string) {
		
		this.setNombre(string);
	}

	public boolean tieneCandidato(Candidato candidato){
		
		return this.coleccionDeCandidatos.contains(candidato);
	}

	public void agregarVoto(Voto voto) {
		
		this.coleccionDeVotos.add(voto);
	}

	public int getNumeroDeVotosRecibidos() {
		
		return this.coleccionDeVotos.size();
	}

	public void agregarCandidato(Candidato candidato){
		
		this.coleccionDeCandidatos.add(candidato);
	}

	public void eliminarCandidato(Candidato candidato) throws Exception{		

		if(this.coleccionDeCandidatos.contains(candidato)){

			this.coleccionDeCandidatos.remove(candidato);	

		} else {

			throw new Exception("No puede eliminarse el candidato porque no se ha postulado en el partido");
			
		}

	}

	public String getNombre() {
		
		return nombre;
	}

	public void setNombre(String nombre) {
		
		this.nombre = nombre;
	}

	public List<Voto> getColeccionDeVotos() {
		
		return coleccionDeVotos;
	}

	public void setColeccionDeVotos(List<Voto> coleccionDeVotos) {
		
		this.coleccionDeVotos = coleccionDeVotos;
	}

	public List<Candidato> getColeccionDeCandidatos() {
		
		return coleccionDeCandidatos;
	}

	public void setColeccionDeCandidatos(List<Candidato> coleccionDeCandidatos) {
		
		this.coleccionDeCandidatos = coleccionDeCandidatos;
	}

}
