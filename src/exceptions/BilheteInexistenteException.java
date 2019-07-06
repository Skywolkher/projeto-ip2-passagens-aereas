package exceptions;

public class BilheteInexistenteException extends Exception {

	private static final long serialVersionUID = 5L;
	
	public BilheteInexistenteException () {
		super ("O bilhete informado é inválido ou não existe!");
	}

}
