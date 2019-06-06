package entities;

import java.time.LocalTime;

public class Voo {
	
	private Local partida;
	private Local destino;
	private LocalTime horaSaida;
	private LocalTime horaChegada;
	private boolean[] assentos;
	
	public Voo(Local partida, Local destino, LocalTime horaSaida, LocalTime horaChegada) {
		this.partida = partida;
		this.destino = destino;
		this.horaSaida = horaSaida;
		this.horaChegada = horaChegada;
	}
	
	public Voo(int assentosT) {
		this.assentos = new boolean[assentosT];
	}

	public Local getPartida() {
		return partida;
	}

	public void setPartida(Local partida) {
		this.partida = partida;
	}

	public Local getDestino() {
		return destino;
	}

	public void setDestino(Local destino) {
		this.destino = destino;
	}

	public LocalTime getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(LocalTime horaSaida) {
		this.horaSaida = horaSaida;
	}

	public LocalTime getHoraChegada() {
		return horaChegada;
	}

	public void setHoraChegada(LocalTime horaChegada) {
		this.horaChegada = horaChegada;
	}

	public boolean[] getAssentos() {
		return assentos;
	}

	public void setAssentos(boolean[] assentos) {
		this.assentos = assentos;
	}
	
	

}
