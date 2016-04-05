package ar.edu.untref.aydoo;

public class Voto {

	private Candidato candidato;
	private Provincia provincia;

	public Voto(Candidato candidato, Provincia provincia) {
		
		this.setCandidato(candidato);		
		this.setProvincia(provincia);	
	}
	
	public Candidato getCandidato() {
		
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		
		this.candidato = candidato;		
	}

	public Provincia getProvincia() {
		
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		
		this.provincia = provincia;
	}

}
