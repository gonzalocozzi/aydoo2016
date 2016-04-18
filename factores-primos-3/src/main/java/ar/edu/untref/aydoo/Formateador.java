package ar.edu.untref.aydoo;

public class Formateador {

	private Integer numeroAFactorizar;
	private String factorizacion;
	private String factorizacionFormateada;
	
	public Formateador(Integer numeroAFactorizar){
		
		this.setNumeroAFactorizar(numeroAFactorizar);
		this.factorizacionFormateada = "Factores primos " + this.numeroAFactorizar + ": ";
	}	

	public String formatearFactorizacion(String[] args, String factorizacion){	
		
		this.setFactorizacion(factorizacion);

		if(args.length == 1 || args[1].equalsIgnoreCase("--format=pretty")){

			this.formatoPretty();		

		} else if(args[1].equalsIgnoreCase("--format=quiet")){

			this.formatoQuiet();

		} else {

			this.factorizacionFormateada = "Formato no aceptado. Las opciones posibles son: pretty o quiet.";
		}
		
		return this.factorizacionFormateada;
	}

	private void formatoPretty() {

		this.factorizacionFormateada += this.factorizacion;	
	}

	private void formatoQuiet() {

		String[] arregloDeLaFactorizacion = this.factorizacion.split(" ");

		for(int i = 0; i < arregloDeLaFactorizacion.length; i++){

			this.factorizacionFormateada += "\n";
			this.factorizacionFormateada += arregloDeLaFactorizacion[i];
		}

	}

	public void setNumeroAFactorizar(Integer numeroAFactorizar) {

		this.numeroAFactorizar = numeroAFactorizar;
	}

	public void setFactorizacion(String factorizacion) {

		this.factorizacion = factorizacion;
	}

}
