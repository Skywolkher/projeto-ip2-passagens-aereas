package entities;

public enum Local {

	TORONTO ("Toronto"), VANCOUVER ("Vancouver"), WINNIPEG ("Winnipeg"), MONTREAL ("Montreal"), CALGARY ("Calgary"),
	OTTAWA ("Ottawa"), QUEBEC ("Quebec"), VICTORIA ("Victoria"), HALIFAX ("Halifax");

	private String nome;

	Local (String nome) {
	    this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return this.nome;
	}

}
