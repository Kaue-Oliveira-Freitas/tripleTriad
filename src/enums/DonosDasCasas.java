package enums;

public enum DonosDasCasas {
	JOGADOR_1("A"),
	JOGADOR_2("B");

	private final String cor;
	DonosDasCasas(String cor) {
		this.cor = cor;
	}
	
	public String getCor() {
		return this.cor;
	}
}
