package application;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import controllers.*;
import entities.*;
import exceptions.*;
import repositories.*;

public class Program {

	public static void main(String[] args) throws CompanhiaExisteException, AssentoInvalidoException, AssentoOcupadoException, VooNaoExisteException {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm");
	
		Voo v11 = new Voo(Local.valueOf("TORONTO"), Local.valueOf("HALIFAX"), LocalDateTime.parse("11-07-2019 17:00", formatter), LocalDateTime.parse("11-07-2019 19:00", formatter), 100);
		Voo v12 = new Voo(Local.valueOf("VICTORIA"), Local.valueOf("SAINT_JOHN"), LocalDateTime.parse("11-07-2019 15:00", formatter), LocalDateTime.parse("11-07-2019 22:30", formatter), 150);
		Voo v13 = new Voo(Local.valueOf("QUEBEC"), Local.valueOf("VANCOUVER"), LocalDateTime.parse("11-07-2019 18:00", formatter), LocalDateTime.parse("12-07-2019 01:00", formatter), 150);
		Voo v14 = new Voo(Local.valueOf("OTTAWA"), Local.valueOf("CALGARY"), LocalDateTime.parse("11-07-2019 20:00", formatter), LocalDateTime.parse("12-07-2019 00:00", formatter), 100);
		
		Companhia bluSky = new Companhia("Blu Sky Airlines", 0.2, 50.0);
		Companhia redLeaf = new Companhia("Red Leaf Airlines", 0.19, 50.5);
		
		bluSky.adicionarVoos(v11);
		bluSky.adicionarVoos(v12);
		bluSky.adicionarVoos(v13);
		bluSky.adicionarVoos(v14);
		redLeaf.adicionarVoos(v11);
		redLeaf.adicionarVoos(v12);
		redLeaf.adicionarVoos(v13);
		redLeaf.adicionarVoos(v14);
		
		Fachada.getInstance().companhiasCont().addCompanhia(bluSky);
		Fachada.getInstance().companhiasCont().addCompanhia(redLeaf);
		
		Passageiro p1 = new Passageiro("Hugo", 1234567890);
		Bilhete bil = new Bilhete(p1, redLeaf, v13, 12);
		
		int choice = 0;
		
		System.out.println("Bem Vindo ao AirDecolar!!");
		System.out.println("--------------------------");
		do {
			System.out.println("---------- MENU ----------");
			System.out.println("1 - Voos");
			System.out.println("2 - Companhias aereas");
			System.out.println("3 - ");
			
			switch (choice) {
				
				case 1:
				
			}
		}while (choice != 0);
		
	}

}
