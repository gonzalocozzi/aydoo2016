package ar.edu.untref.aydoo;

public class Vaso {

	private int cucharadasDeAzucar;
	private boolean cafe;
	private boolean leche;

	public Vaso(){
		this.setAzucar(0);
		this.setCafe(false);
		this.setLeche(false);
	}

	public int getAzucar() {		
		return cucharadasDeAzucar;
	}

	public void setAzucar(int cucharadasDeAzucar) {

		if(cucharadasDeAzucar < 0){
			try {
				throw new Exception("No existen cantidades negativas de azucar.");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		this.cucharadasDeAzucar = cucharadasDeAzucar;
	}

	public boolean getCafe() {
		return cafe;
	}

	public void setCafe(boolean cafe) {
		this.cafe = cafe;		
	}

	public boolean getLeche() {
		return leche;
	}

	public void setLeche(boolean leche) {
		this.leche = leche;
	}
	
}
