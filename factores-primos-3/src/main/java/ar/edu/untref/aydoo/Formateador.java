package ar.edu.untref.aydoo;

public class Formateador {

	private Integer numeroAFactorizar;
	private String factorizacion;
	private String factorizacionFormateada;
	private String[] args;

	public Formateador(Integer numeroAFactorizar, String factorizacion, String[] args) {

		this.numeroAFactorizar = numeroAFactorizar;
		this.factorizacion = factorizacion;
		this.factorizacionFormateada = new String("Factores primos " + this.numeroAFactorizar + ": ");
		this.args = args;
	}	

	public void setFactorizacionFormateada(){		

		if(args.length == 1 || args[1].equalsIgnoreCase("--format=pretty")){

			this.factorizacionPretty();		

		} else if(args[1].equalsIgnoreCase("--format=quiet")){

			this.factorizacionQuiet();

		} else {

			this.factorizacionFormateada = "Formato no aceptado. Las opciones posibles son: pretty o quiet.";
		}

	}

	private void factorizacionPretty(){
		
		this.factorizacionFormateada += factorizacion;		

	}

	private void factorizacionQuiet() {

		String[] arregloDeLaFactorizacion = this.factorizacion.split(" ");

		for(int i = 0; i < arregloDeLaFactorizacion.length; i++){

			this.factorizacionFormateada += "\n";
			this.factorizacionFormateada += arregloDeLaFactorizacion[i];
		}

	}
	
	public String getFactorizacionFormateada(){
		
		return this.factorizacionFormateada;
	}

}
