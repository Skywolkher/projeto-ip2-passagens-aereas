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

}
