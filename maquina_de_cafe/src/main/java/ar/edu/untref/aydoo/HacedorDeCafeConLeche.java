package ar.edu.untref.aydoo;

public class HacedorDeCafeConLeche {
	
	private Cafetero cafetero;
	private Lechero lechero;
	
	public Vaso prepararEnEsteVaso(Vaso vaso){
		
		this.cafetero = new Cafetero();
		vaso = cafetero.prepararEnEsteVaso(vaso);
		
		this.lechero = new Lechero();
		vaso = lechero.prepararEnEsteVaso(vaso);
		
		return vaso;
	}

}
