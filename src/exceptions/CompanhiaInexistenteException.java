package exceptions;

public class CompanhiaInexistenteException extends Exception{

	private static final long serialVersionUID = 7L;
	
	public CompanhiaInexistenteException () {
		super("A companhia é inválida ou inexistente");
	}

}
