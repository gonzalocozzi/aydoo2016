package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Provincia {

	private String nombre;
	private List<Partido> coleccionDePartidos = new LinkedList<Partido>();

	public Provincia(String string) {
		this.setNombre(string);
	}

	public boolean tienePartido(Partido partido){
		return this.coleccionDePartidos.contains(partido);
	}

	public void agregarVotoAlPartido(Partido partido, Voto voto) throws Exception{

		if(this.tienePartido(partido)){

			int posicionDelPartidoEnLaColeccion = this.coleccionDePartidos.indexOf(partido);
			this.coleccionDePartidos.get(posicionDelPartidoEnLaColeccion).agregarVoto(voto);

		} else {		

			throw new Exception("El partido indicado no ha sido habilitado en la provincia");

		}
	}	

	public Partido getPartido(Partido partido){

		Partido partidoObtenido = null;

		if(this.tienePartido(partido)){

			int posicionDelPartidoEnLaColeccion = this.coleccionDePartidos.indexOf(partido);
			partidoObtenido = this.coleccionDePartidos.get(posicionDelPartidoEnLaColeccion);
		}

		return partidoObtenido;
	}

	public void agregarPartido(Partido partido){		
		this.coleccionDePartidos.add(partido);
	}

	public void eliminarPartido(Partido partido) throws Exception{

		if(this.tienePartido(partido)){

			this.coleccionDePartidos.remove(partido);			

		} else {			

			throw new Exception("La provincia no posee el partido que desea eliminar");

		}
	}

	public Partido getPartidoMasVotado(){

		ListIterator<Partido> iteradorDePartidos = this.coleccionDePartidos.listIterator();
		Partido partidoMasVotado = null;
		int votos = 0;

		while(iteradorDePartidos.hasNext()){
			
			Partido partidoactual = iteradorDePartidos.next();

			if(partidoactual.getNumeroDeVotosRecibidos() > votos){

				partidoMasVotado = partidoactual;
				votos = partidoactual.getNumeroDeVotosRecibidos();
			}
		}

		return partidoMasVotado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toLowerCase();
	}

	public List<Partido> getColeccionDePartidos() {
		return coleccionDePartidos;
	}

	public void setColeccionDePartidos(List<Partido> coleccionDePartidos) {
		this.coleccionDePartidos = coleccionDePartidos;
	}

}
