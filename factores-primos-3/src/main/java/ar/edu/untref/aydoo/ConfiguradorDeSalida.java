package ar.edu.untref.aydoo;

public class ConfiguradorDeSalida {

	private Formateador formateador;
	private Ordenador ordenador;
	private String[] args;
	private String factorizacion;

	public ConfiguradorDeSalida(Integer numeroAFactorizar, String[] args, String factorizacion){
		
		this.formateador = new Formateador(numeroAFactorizar);
		this.ordenador = new Ordenador();
		this.args = args;
		this.factorizacion = factorizacion;
	}
 
	public String getSalidaConfigurada(){		 

		if(args.length > 2 && args[2].equalsIgnoreCase("--sort:des")){

			this.factorizacion = this.ordenador.invertirSalida(this.factorizacion);
		}

		this.factorizacion = this.formateador.formatearFactorizacion(this.args, this.factorizacion);
		
		return this.factorizacion;
	}
	
}
