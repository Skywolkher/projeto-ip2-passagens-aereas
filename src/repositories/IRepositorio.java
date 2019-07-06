package repositories;

import java.util.ArrayList;

import entities.Bilhete;
import exceptions.BilheteExisteException;
import exceptions.BilheteInexistenteException;

public interface IRepositorio {
	
	public void addBilhete (Bilhete bilhete) throws BilheteExisteException;
	public void removeBilhete (Bilhete bilhete) throws BilheteInexistenteException;
	public ArrayList<Bilhete> listarBilhetes ();
	public Bilhete getBilhete(Bilhete bilhete);
}
