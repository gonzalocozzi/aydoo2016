package ar.edu.untref.aydoo;

public class HacedorDeTeConLeche {
	
	private HacedorDeTe hacedorDeTe;
	private Lechero lechero;

	public Vaso prepararEnEsteVaso(Vaso vaso){

		this.hacedorDeTe = new HacedorDeTe();
		vaso = hacedorDeTe.prepararEnEsteVaso(vaso);
		
		this.lechero = new Lechero();
		vaso = lechero.prepararEnEsteVaso(vaso);
		
		return vaso;
	}

}
