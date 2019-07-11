package repositories;

import java.time.LocalDateTime;
import java.util.ArrayList;

import exceptions.*;
import entities.*;

public class RepositorioCompanhias  implements IRepositorioCompanhias{
	
	private static RepositorioCompanhias instance;
	private ArrayList<Companhia> companhias = new ArrayList<>();
	
	public static RepositorioCompanhias getInstance() {
		if (instance == null) {
			instance = new RepositorioCompanhias();
		}
		return instance;
	}
	
	public RepositorioCompanhias () {}
	
	@Override
	public Voo ProcurarVoo (Companhia comp, Local partida, Local destino, LocalDateTime saida, LocalDateTime chegada){
		for (Companhia a: companhias) {
			if (a == comp) {
				for (Voo v: a.getVoos()) {
					if (v.getPartida().equals(partida) && v.getDestino().equals(destino) && 
							v.getHoraSaida().equals(saida) && v.getHoraChegada().equals(chegada)) {
						return v;
					}
				}
			}
		}
		return null;
	}
	
	@Override
	public Companhia ProcurarCompanhia (Companhia comp) {
		for (Companhia a: companhias) {
			if (a == comp) {
				return a;
			}
		}
		return null;
	}
	
	@Override
	public void addCompanhia(Companhia comp) throws CompanhiaExisteException{
		if (comp != null && ProcurarCompanhia(comp) == null) {
			this.companhias.add(comp);
		}
		else {
			throw new CompanhiaExisteException();
		}
	}
	
	@Override
	public void removeCompanhia(Companhia comp) throws CompanhiaInexistenteException{
		if (comp != null && ProcurarCompanhia(comp) != null) {
			this.companhias.remove(comp);
		}
		else {
			throw new CompanhiaInexistenteException();
		}
	}
	
	public ArrayList<Companhia> listarCompanhias(){
		return companhias;
	}
}
