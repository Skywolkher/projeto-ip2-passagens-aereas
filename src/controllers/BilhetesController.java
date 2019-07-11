package controllers;

import java.util.ArrayList;
import entities.*;
import exceptions.*;
import repositories.IRepositorioBilhetes;

public class BilhetesController {
	
	private IRepositorioBilhetes instanceRepBilhetes;
	
	public BilhetesController (IRepositorioBilhetes instaceRepBilhetes) {
		this.instanceRepBilhetes = instaceRepBilhetes;
	}
	
	public ArrayList<Bilhete> getBilhetes(){
		return this.instanceRepBilhetes.listarBilhetes();
	}
	
	public Bilhete getBilhete (Bilhete bilhete) {
		for (Bilhete b: this.instanceRepBilhetes.listarBilhetes()) {
			if (b == bilhete) {
				return b;
			}
		}
		
		return null;
	}
	
	public boolean addBilhete (Bilhete bilhete) throws BilheteExisteException{
		
		try {
			if (bilhete != null) {
				instanceRepBilhetes.addBilhete(bilhete);
				return true;
			}
		} catch (BilheteExisteException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean removeBilhete (Bilhete bilhete) throws BilheteInexistenteException{
		
		try {
			if (bilhete != null) {
				instanceRepBilhetes.removeBilhete(bilhete);
				return true;
			}
		} catch (BilheteInexistenteException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	

}
