package main;

import java.util.HashSet;
import java.util.Set;

import enums.DonosDasCasas;
import models.Carta;
import models.Catalogo;
import models.Jogador;

public class Main {
	private static final int CARTAS_POR_JOGADOR = 5;

	public static void main(String[] args) {
		Console console = new Console();
		
		boolean rodando = true;
		while (rodando) {
			switch (console.menuPrincipal()) {
			case 1:
				iniciarPartida(console);
				break;
			case 0:
				rodando = false;
				break;
			}
		}

		System.out.println("FIM DE JOGO!");
	}

	private static void iniciarPartida(Console console) {
		Catalogo catalogo = new Catalogo();
		Jogador jogador1 = new Jogador(console.lerNome("Jogador 1"), DonosDasCasas.JOGADOR_1);
		Jogador jogador2 = new Jogador(console.lerNome("Jogador 2"), DonosDasCasas.JOGADOR_2);

		
		Set<Carta> sorteadas = new HashSet<Carta>();
		distribuirDeck(jogador1, catalogo, sorteadas);
		distribuirDeck(jogador2, catalogo, sorteadas);

		Sistema sis = new Sistema(jogador1, jogador2, console);
		sis.iniciarJogo();
	}

	private static void distribuirDeck(Jogador jogador, Catalogo catalogo, Set<Carta> sorteadas) {
		while (jogador.getDeck().size() < CARTAS_POR_JOGADOR) {
			Carta carta = catalogo.sortearCarta();
			if (sorteadas.add(carta)) {
				jogador.adicionarCartaNoDeck(carta);
			}
		}
	}
}