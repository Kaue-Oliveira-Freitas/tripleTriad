package main;

import models.Carta;
import models.Jogador;
import models.Tabuleiro;


public class Sistema {
	private final Console console;
	private final Tabuleiro tabuleiro;
	private Jogador atacante, defensor;

	public Sistema(Jogador jogador1, Jogador jogador2, Console console) {
		this.console = console;
		this.tabuleiro = new Tabuleiro();
		this.atacante = jogador1;
		this.defensor = jogador2;
	}

	public void iniciarJogo() {
		while (!tabuleiro.estaCheio()) {
			console.mostrarHub(atacante, defensor, tabuleiro);
			jogarTurno();
			trocarTurno();
		}
		console.mostrarResultado(atacante, defensor, tabuleiro);
	}


	private void jogarTurno() {
		Carta cartaDaVez = console.selecionarCarta(atacante);
		int casa = console.selecionarCasa(tabuleiro);

		int linha = (casa - 1) / 3;
		int coluna = (casa - 1) % 3;

		tabuleiro.colocarCarta(cartaDaVez, linha, coluna, atacante.getDono());
		atacante.jogarCarta(cartaDaVez);

		// logica para captura
		tabuleiro.mapearCaptura(linha, coluna, atacante, defensor);
	}

	private void trocarTurno() {
		Jogador aux = defensor;
		defensor = atacante;
		atacante = aux;
	}
}