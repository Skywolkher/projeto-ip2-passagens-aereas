package exceptions;

public class CompanhiaExisteException extends Exception{

	private static final long serialVersionUID = 6L;
	
	public CompanhiaExisteException () {
		super("Esta companhia é inválida ou já existe!");
	}

}
