package exceptions;

public class BilheteInexistenteException extends Exception {

	private static final long serialVersionUID = 5L;
	
	public BilheteInexistenteException () {
		super ("O bilhete informado � inv�lido ou n�o existe!");
	}

}
