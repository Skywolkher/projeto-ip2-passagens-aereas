package controllers;

import repositories.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

import entities.*;
import exceptions.*;

public class CompanhiasController {

	private IRepositorioCompanhias instanceRepCompanhias;
	
	public CompanhiasController(IRepositorioCompanhias instanceRepCompanhias) {
		this.instanceRepCompanhias = instanceRepCompanhias;
	}
	
	public ArrayList<Companhia> getCompanhias() {
		ArrayList<Companhia> arr = this.instanceRepCompanhias.listarCompanhias();
		arr = (ArrayList<Companhia>) arr.stream().filter(x -> x != null).collect(Collectors.toList());
		
		return arr;
	}
	
	public Companhia getCompanhia(Companhia companhia) {
		for (Companhia c: this.instanceRepCompanhias.listarCompanhias()) {
			if (c == companhia) {
				return c;
			}
		}
		
		return null;
	}
	
	public boolean addCompanhia(Companhia companhia) throws CompanhiaExisteException{
		
		try {
			if (companhia != null) {
				instanceRepCompanhias.addCompanhia(companhia);
				return true;
			}
		} catch (CompanhiaExisteException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean removeCompanhia(Companhia companhia) throws CompanhiaInexistenteException{
		try {
			if (companhia != null) {
				instanceRepCompanhias.removeCompanhia(companhia);
				return true;
			}
		} catch (CompanhiaInexistenteException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean vooInvalido(Voo voo) {
		for (Companhia c: this.instanceRepCompanhias.listarCompanhias()) {
			for (Voo v: c.getVoos()) {
				if (v.vooInvalido(voo)) {
					return true;
				}
			}
		}
		
		return false;
	}
}
