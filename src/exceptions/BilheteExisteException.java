package exceptions;

public class BilheteExisteException extends Exception{

	private static final long serialVersionUID = 4L;
	
	public BilheteExisteException() {
		super("O bilhete informado � inv�lido ou j� existe!");
	}

}
