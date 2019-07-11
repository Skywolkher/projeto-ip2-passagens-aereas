package repositories;

import java.util.ArrayList;

import entities.*;
import exceptions.*;

public class RepositorioBilhetes implements IRepositorioBilhetes{
	
	private static RepositorioBilhetes instance;
	private ArrayList<Bilhete> bilhetes = new ArrayList<>();
	
	public static RepositorioBilhetes getInstance() {
		if (instance == null) {
			instance = new RepositorioBilhetes();
		}
		return instance;
	}
	
	public RepositorioBilhetes() {}
	
	private Bilhete ProcuraBilhete (Passageiro passageiro, Voo voo, Companhia companhia) {
		for (Bilhete a : bilhetes) {
			if (a.getVoo().equals(voo) && a.getPassageiro().equals(passageiro) && a.getCompanhia().equals(companhia)) {
				return a;
			}
		}
		return null;
	}
	
	@Override
	public void addBilhete (Bilhete bilhete) throws BilheteExisteException{
		if (bilhete != null && ProcuraBilhete(bilhete.getPassageiro(), bilhete.getVoo(), bilhete.getCompanhia()) == null) {
			this.bilhetes.add(bilhete);
		} else {
			throw new BilheteExisteException();
		}
	}

	@Override
	public void removeBilhete (Bilhete bilhete) throws BilheteInexistenteException{
		if (bilhete != null && ProcuraBilhete(bilhete.getPassageiro(), bilhete.getVoo(), bilhete.getCompanhia()) != null) {
			this.bilhetes.remove(bilhete);
		} else {
			throw new BilheteInexistenteException();
		}
	}
	
	@Override
	public ArrayList<Bilhete> listarBilhetes () {
		return bilhetes;
	}
	
	@Override
	public Bilhete getBilhete(Bilhete bilhete) {
		return this.ProcuraBilhete(bilhete.getPassageiro(), bilhete.getVoo(), bilhete.getCompanhia());
	}
}
