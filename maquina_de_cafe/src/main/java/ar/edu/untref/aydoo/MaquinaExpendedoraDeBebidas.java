package ar.edu.untref.aydoo;

public class MaquinaExpendedoraDeBebidas {
	
	private Vaso vaso;
	private HacedorDeCafeConLeche hacedorDeCafeConLeche;
	private HacedorDeTeConLeche hacedorDeTeConLeche;
	private Azucarero azucarero;	
	
	public Vaso hacerCafeConLecheConNDeAzucar(int azucar){
		
		this.vaso = new Vaso();
		
		this.hacedorDeCafeConLeche = new HacedorDeCafeConLeche();
		this.vaso = hacedorDeCafeConLeche.prepararEnEsteVaso(vaso);
		
		this.azucarero = new Azucarero();
		this.vaso = azucarero.ponerNEnEsteVaso(azucar, vaso);
		
		return this.vaso;
	}
	
	public Vaso hacerTeConLecheConNDeAzucar(int azucar){
		
		this.vaso = new Vaso();
		
		this.hacedorDeTeConLeche = new HacedorDeTeConLeche();
		this.vaso = hacedorDeTeConLeche.prepararEnEsteVaso(vaso);
		
		this.azucarero = new Azucarero();
		this.vaso = azucarero.ponerNEnEsteVaso(azucar, vaso);
		
		return this.vaso;
	}

}
