package entities;
import exceptions.*;

public class Bilhete {
	
	private Passageiro passageiro;
	private Voo voo;
	private int assento;
	private float valor;
	
	public Bilhete (Passageiro passageiro, Voo voo, int assento) 
			throws AssentoInvalidoException, AssentoOcupadoException {
		if (passageiro == null || voo == null || assento < 0) {
            throw new IllegalArgumentException();
        }
		this.valor = (float) ((voo.getDistancia()*50) + ((voo.getDistancia()*50)*0.2));
		this.passageiro = passageiro;
        this.voo = voo;
        this.assento = assento;
        this.voo.marcarAssento(assento);
	}
	
	public int getAssento() {
        return assento;
    }

    public void setAssento(int assento) {
        this.assento = assento;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public Voo getVoo() {
        return voo;
    }
    
    public String getNomePassageiro() {
        return passageiro.getNome();
    }

    public long getCpfPassageiro() {
        return passageiro.getCpf();
    }
    
    public void setValor(float valor) {
    	this.valor = valor;
    }
    
    public float getValor() {
    	return this.valor;
    }
}