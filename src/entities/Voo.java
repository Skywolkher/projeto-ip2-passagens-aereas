package entities;

import java.time.LocalTime;

import exceptions.AssentoInvalidoException;
import exceptions.AssentoOcupadoException;

public class Voo {

	private Local partida;
	private Local destino;
	private LocalTime horaSaida;
	private LocalTime horaChegada;
	private int distancia;
	private boolean[] assentos;

	public Voo(Local partida, Local destino, LocalTime horaSaida, LocalTime horaChegada) {
		this.partida = partida;
		this.destino = destino;
		this.horaSaida = horaSaida;
		this.horaChegada = horaChegada;
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

}
