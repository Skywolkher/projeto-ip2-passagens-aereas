package entities;

import java.util.List;

import exceptions.*;

public class Companhia{
	
	private String nome;
	private double taxa;
	private double preco;
	private List<Voo> voo;
	
	public Companhia(String nome, double taxa, double preco) {
		this.nome = nome;
		this.taxa = taxa;
		this.preco = preco;
	}
	
	public void adicionarVoos(Voo voo) {
		this.voo.add(voo);
	}
	
	public void removerVoos(Voo voo) {
		this.voo.remove(voo);
	}
	
	public double valorBilhete(Voo voo) throws VooNaoExisteException{
		for (Voo v : this.voo) {
			if (v.equals(voo)) {
				return (this.preco * voo.getDistancia() + (this.preco * voo.getDistancia()) * this.taxa);
			}
		}
		throw new VooNaoExisteException();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getTaxa() {
		return taxa;
	}

	public double getPreco() {
		return preco;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Companhia other = (Companhia) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		if (Double.doubleToLongBits(taxa) != Double.doubleToLongBits(other.taxa))
			return false;
		if (voo == null) {
			if (other.voo != null)
				return false;
		} else if (!voo.equals(other.voo))
			return false;
		return true;
	}
	
}
