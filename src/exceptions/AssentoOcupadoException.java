package exceptions;

public class AssentoOcupadoException extends Exception {

	private static final long serialVersionUID = 2L;

	private int assento;
	
	public AssentoOcupadoException(int assento) {
        super(String.format("O assento (ID: %s) já está ocupado", assento));
        this.assento = assento;
    }

    public int getAssento() {
        return assento;
    }

    public void setIAssento(int assento) {
        this.assento = assento;
    }
	
}
