package models;

import java.util.ArrayList;
import java.util.List;

import enums.DonosDasCasas;

public class Jogador {
	private final String nome;
	private final DonosDasCasas dono;
	private final List<Carta> deck;
	private int pontos;

	public Jogador(String nome, DonosDasCasas dono) {
		this.nome = nome;
		this.dono = dono;
		this.deck = new ArrayList<Carta>();
		this.pontos = 5;
	}

	public String getNome() {
		return nome;
	}

	public DonosDasCasas getDono() {
		return dono;
	}

	public List<Carta> getDeck() {
		return deck;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public String adicionarCartaNoDeck(Carta carta) {
		this.deck.add(carta);
		return carta.getTitulo() + " adicionada ao deck de " + this.nome;
	}

	public void jogarCarta(Carta carta) {
		this.deck.remove(carta);
	}

	public void ganharPontos() {
		this.setPontos(this.getPontos() + 1);
	}

	public void perderPontos() {
		this.setPontos(this.getPontos() - 1);
	}

	public String mostrarDeck() {
		String resultado = "DECK --> ";
		for (int i = 0; i < deck.size(); i++) {
			resultado = resultado + (i + 1) + "-" + deck.get(i).getTitulo() + "(" + deck.get(i).getElemento() + ")-" + "["
					+ deck.get(i).getUp() + "," +deck.get(i).getLeft()+ ","
					+ deck.get(i).getDown() + "," + deck.get(i).getRight() + "]   ";
		}
		return resultado;
	}

	public String exibirDados() {
		return "----" + this.nome + "----\n" + mostrarDeck();
	}
}