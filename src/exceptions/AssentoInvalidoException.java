package exceptions;

public class AssentoInvalidoException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private int assento;
    
    public AssentoInvalidoException(int assento) {
        super("Assento não válido para este Voo. Assento: " + assento);
        this.assento = assento;
    }

    public int getAssento() {
        return assento;
    }

    public void setAssento(int assento) {
        this.assento = assento;
    }

}
