package entities;

public enum Local {

	TORONTO ("Toronto", 6), VANCOUVER ("Vancouver", 9), WINNIPEG ("Winnipeg", 7), MONTREAL ("Montreal", 4), CALGARY ("Calgary", 8),
	OTTAWA ("Ottawa", 5), QUEBEC ("Quebec", 3), VICTORIA ("Victoria", 10), HALIFAX ("Halifax", 1), SAINT_JOHN ("Saint John", 2);

	private String nome;
	private int position;

	Local (String nome, int position) {
	    this.nome = nome;
	    this.position = position;
	}
	
	Local (String nome){
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public int getPosition() {
		return this.position;
	}

	@Override
	public String toString() {
		return this.nome + " " + this.position;
	}

}
