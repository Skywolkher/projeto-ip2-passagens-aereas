package exceptions;


public class VooNaoExisteException extends Exception{

	private static final long serialVersionUID = 3L;

	public VooNaoExisteException() {
		super("Este voo n�o � v�lido");
	}

}
