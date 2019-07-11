package controllers;

import repositories.*;

public class Fachada {

	private static Fachada instance;
	private IRepositorioBilhetes instanceRepBilhetes = RepositorioBilhetes.getInstance();
	private IRepositorioCompanhias instanceRepCompanhias = RepositorioCompanhias.getInstance();
	private BilhetesController bilhetesController;
	private CompanhiasController companhiasController;

	public static Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}

	private Fachada () {
		this.bilhetesController = new BilhetesController(this.instanceRepBilhetes);
		this.companhiasController = new CompanhiasController(this.instanceRepCompanhias);
	}
	
	public BilhetesController bilhetesCont() {
		return this.bilhetesController;
	}
	
	public CompanhiasController companhiasCont() {
		return this.companhiasController;
	}
}
