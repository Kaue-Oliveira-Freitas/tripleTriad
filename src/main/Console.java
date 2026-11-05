package main;

import java.util.Scanner;

import models.Carta;
import models.Jogador;
import models.Tabuleiro;


public class Console {
	private final Scanner sc = new Scanner(System.in);

	public int menuPrincipal() {
		System.out.println("\n==============================");
		System.out.println("         TRIPLE TRIAD         ");
		System.out.println("==============================");
		System.out.println("1 - Jogar");
		System.out.println("0 - Sair");
		return lerInteiro("Escolha uma opção: ", 0, 1);
	}

	public String lerNome(String jogador) {
		System.out.print("Nome do " + jogador + ": ");
		String nome = sc.nextLine().trim();
		return nome.isEmpty() ? jogador : nome;
	}

	public void mostrarHub(Jogador atacante, Jogador defensor, Tabuleiro tabuleiro) {
		//regra all open
		System.out.println();
		System.out.println("VEZ DE " + atacante.getNome());
		System.out.println(atacante.exibirDados());

		System.out.println(tabuleiro.desenharTabuleiro());

		System.out.println(defensor.exibirDados());
		System.out.println("Pontos: " + atacante.getNome() + " " + atacante.getPontos() + " x " + defensor.getPontos() + " " + defensor.getNome());
	}

	public Carta selecionarCarta(Jogador atacante) {
		int tamanhoDeck = atacante.getDeck().size();
		int escolha = lerInteiro("Seleciona uma carta (1-" + tamanhoDeck + "): ", 1, tamanhoDeck);
		return atacante.getDeck().get(escolha - 1);
	}

	public int selecionarCasa(Tabuleiro tabuleiro) {
		int casa;
		do {
			casa = lerInteiro("Selecione uma casa (1-9): ", 1, 9);
			if (!tabuleiro.estaVazia((casa - 1) / 3, (casa - 1) % 3)) {
				System.out.println("Essa casa já está ocupada!");
				casa = 0;
			}
		} while (casa == 0);
		return casa;
	}

	public void mostrarResultado(Jogador jogador1, Jogador jogador2, Tabuleiro tabuleiro) {
		System.out.println("========== FIM DE JOGO ==========");
		System.out.println(tabuleiro.desenharTabuleiro());
		System.out.println(jogador1.getNome() + ": " + jogador1.getPontos() + " pontos");
		System.out.println(jogador2.getNome() + ": " + jogador2.getPontos() + " pontos");

		if (jogador1.getPontos() > jogador2.getPontos()) {
			System.out.println("Vencedor: " + jogador1.getNome() + "!");
		} else if (jogador2.getPontos() > jogador1.getPontos()) {
			System.out.println("Vencedor: " + jogador2.getNome() + "!");
		} else {
			System.out.println("Empate!");
		}
	}


	private int lerInteiro(String mensagem, int min, int max) {
		while (true) {
			System.out.print(mensagem);
			String linha = sc.nextLine().trim();
			try {
				int valor = Integer.parseInt(linha);
				if (valor >= min && valor <= max) {
					return valor;
				}
			} catch (NumberFormatException e) {
			}
			System.out.println("Entrada inválida. Digite um número entre " + min + " e " + max + ".");
		}
	}
}