package ar.edu.untref.aydoo;

public class Formateador {

	private Integer numeroAFactorizar;
	private String factorizacion;
	private String factorizacionFormateada;
	private String[] args;

	public Formateador(String[] args) {

		this.factorizacionFormateada = "";
		this.args = args;
	}	

	public void formatearFactorizacion(){	

		if(args.length == 1 || args[1].equalsIgnoreCase("--format=pretty")){

			this.formatoPretty();		

		} else if(args[1].equalsIgnoreCase("--format=quiet")){

			this.formatoQuiet();

		} else {

			this.factorizacionFormateada = "Formato no aceptado. Las opciones posibles son: pretty o quiet.";
		}

	}

	private void formatoPretty() {

		this.factorizacionFormateada = "Factores primos " + this.numeroAFactorizar + ": ";
		this.factorizacionFormateada += factorizacion;	
	}

	private void formatoQuiet() {

		this.factorizacionFormateada = "Factores primos " + this.numeroAFactorizar + ": ";
		String[] arregloDeLaFactorizacion = this.factorizacion.split(" ");

		for(int i = 0; i < arregloDeLaFactorizacion.length; i++){

			this.factorizacionFormateada += "\n";
			this.factorizacionFormateada += arregloDeLaFactorizacion[i];
		}

	}
	
	public void invertirFactorizacion() {
		
		if(args.length > 2 && args[2].equalsIgnoreCase("--sort:des")){
			
			String[] arregloDeLaFactorizacion = this.factorizacion.split(" ");
			Integer longitudDelArreglo = arregloDeLaFactorizacion.length;
			String[] arregloInvertidoDeLaFactorizacion = new String[longitudDelArreglo];
			
			for(int i = 0; i < longitudDelArreglo; i++){
				
				arregloInvertidoDeLaFactorizacion[i] = arregloDeLaFactorizacion[longitudDelArreglo - 1];
				longitudDelArreglo--;
			}
			
			this.factorizacion = "";
			
			for(int i = 0; i < arregloInvertidoDeLaFactorizacion.length; i++){
				
				this.factorizacion += arregloInvertidoDeLaFactorizacion[i];
				this.factorizacion += " ";
			}
				
		}
		
	}	

	public void setNumeroAFactorizar(Integer numeroAFactorizar) {

		this.numeroAFactorizar = numeroAFactorizar;
	}

	public void setFactorizacion(String factorizacion) {

		this.factorizacion = factorizacion;
	}	

	public String getFactorizacionFormateada(){

		return this.factorizacionFormateada;
	}

}
