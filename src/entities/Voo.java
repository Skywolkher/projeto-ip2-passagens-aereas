package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import exceptions.AssentoInvalidoException;
import exceptions.AssentoOcupadoException;

public class Voo {

	private Local partida;
	private Local destino;
	private LocalDateTime horaSaida;
	private LocalDateTime horaChegada;
	private int distancia;
	private boolean[] assentos;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm");

	public Voo(Local partida, Local destino, LocalDateTime horaSaida, LocalDateTime horaChegada, int assentos) {
		this.partida = partida;
		this.destino = destino;
		this.horaSaida = horaSaida;
		this.horaChegada = horaChegada;
		this.assentos = new boolean[assentos];
		this.distancia = Math.abs(this.partida.getPosition() - this.destino.getPosition());
	}

	public Voo(int assentos) {
		this.assentos = new boolean[assentos];
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

	public LocalDateTime getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(LocalDateTime horaSaida) {
		this.horaSaida = horaSaida;
	}

	public LocalDateTime getHoraChegada() {
		return horaChegada;
	}

	public void setHoraChegada(LocalDateTime horaChegada) {
		this.horaChegada = horaChegada;
	}

	public boolean[] getAssentos() {
		return assentos;
	}

	public void setAssentos(boolean[] assentos) {
		this.assentos = assentos;
	}

	public int getDistancia() {
		return this.distancia;
	}

	public void marcarAssento(int assento) throws AssentoInvalidoException, AssentoOcupadoException{
		if (assento >= 1 && assento <= this.assentos.length) {
			if (this.assentos[assento] == false) {
				this.assentos[assento] = true;
			} else {
				throw new AssentoOcupadoException(assento);
			}
		} else {
			throw new AssentoInvalidoException(assento);
		}
	}
	
	/*
	* Um voo é inválido quando este tem os horários iguais, os mesmos locais de partida e destino
	* ou quando o dia de partida é posterior ao dia de chegada
	*/
	public boolean vooInvalido(Voo voo) {
		if ((voo.getHoraSaida() == voo.getHoraChegada()) || (voo.getPartida() == voo.getDestino()) ||
				voo.getHoraSaida().getDayOfMonth()>voo.getHoraChegada().getDayOfMonth()){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voo other = (Voo) obj;
		if (destino != other.destino)
			return false;
		if (horaChegada == null) {
			if (other.horaChegada != null)
				return false;
		} else if (!horaChegada.equals(other.horaChegada))
			return false;
		if (horaSaida == null) {
			if (other.horaSaida != null)
				return false;
		} else if (!horaSaida.equals(other.horaSaida))
			return false;
		if (partida != other.partida)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return ("Partida: " +this.partida.getNome()+ "\nDestino: " +this.destino.getNome()+ "\nSaída: " +
				this.getHoraSaida().format(formatter)+ "\nChegada: "
				+this.getHoraChegada().format(formatter)+ "\n");
	}

}
