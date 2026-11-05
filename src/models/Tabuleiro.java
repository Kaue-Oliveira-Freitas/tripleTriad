package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import enums.DonosDasCasas;
import enums.Elementos;

public class Tabuleiro {
	private static final String LINHA = "+---------+---------+---------+\n";

	private final Carta[][] tabuleiro;
	private final DonosDasCasas[][] donos;
	private int casasOcupadas;

	public Tabuleiro() {
		this.tabuleiro = new Carta[3][3];
		this.donos = new DonosDasCasas[3][3];
		this.casasOcupadas = 0;
	}

	
	public boolean estaVazia(int linha, int coluna) {
		return tabuleiro[linha][coluna] == null;
	}

	public boolean estaCheio() {
		return casasOcupadas >= 9;
	}

	public void colocarCarta(Carta carta, int linha, int coluna, DonosDasCasas dono) {
		tabuleiro[linha][coluna] = carta;
		donos[linha][coluna] = dono;
		casasOcupadas++;
		checarAscencion(carta);
	}

	public void mapearCaptura(int linha, int coluna, Jogador jogador, Jogador defensor) {
		DonosDasCasas atacante = donos[linha][coluna];
		Carta cartaJogada = tabuleiro[linha][coluna];
		int valorVizinho = 0;
		List<Integer> valoresPlus = new ArrayList<>();
		List<Integer> posicaoVizinhosPlus = new ArrayList<>();
		List<Integer> posicaoVizinhosSame = new ArrayList<>();
		
		// CIMA
		if (linha > 0 && !estaVazia(linha - 1, coluna)) {
			valorVizinho = tabuleiro[linha - 1][coluna].getDown();
			
			if(donos[linha - 1][coluna] != jogador.getDono()) {
				valoresPlus.add(valorVizinho + cartaJogada.getUp());
				posicaoVizinhosPlus.add(((linha - 1) * 3) + coluna + 1);
				
				if(valorVizinho == cartaJogada.getUp()) {
					posicaoVizinhosSame.add(((linha - 1) * 3) + coluna + 1);
				}
				
				if (capturarCarta(atacante, cartaJogada.getUp(), linha - 1, coluna, valorVizinho)) {
					jogador.ganharPontos();
					defensor.perderPontos();
				}
			}
		}
		// BAIXO
		if (linha < 2 && !estaVazia(linha + 1, coluna)) {
			
			valorVizinho = tabuleiro[linha + 1][coluna].getUp();
			
				if(donos[linha + 1][coluna] != jogador.getDono()) {
				valoresPlus.add(valorVizinho + cartaJogada.getDown());
				posicaoVizinhosPlus.add(((linha + 1) * 3) + coluna + 1);
				
				if(valorVizinho == cartaJogada.getDown()) {
					posicaoVizinhosSame.add(((linha + 1) * 3) + coluna + 1);
				}
				
				if (capturarCarta(atacante, cartaJogada.getDown(), linha + 1, coluna, valorVizinho)) {
					jogador.ganharPontos();
					defensor.perderPontos();
				}
			}
		}
		// ESQUERDA
		if (coluna > 0 && !estaVazia(linha, coluna - 1)) {
			valorVizinho = tabuleiro[linha][coluna - 1].getRight();
			
			if(donos[linha][coluna - 1] != jogador.getDono()) {
				valoresPlus.add(valorVizinho + cartaJogada.getLeft());
				posicaoVizinhosPlus.add((linha * 3) + coluna);
				
				if(valorVizinho == cartaJogada.getLeft()) {
					posicaoVizinhosSame.add(((linha) * 3) + coluna);
				}
				
				if (capturarCarta(atacante, cartaJogada.getLeft(), linha, coluna - 1, valorVizinho)) {
					jogador.ganharPontos();
					defensor.perderPontos();
				}
			}
		}
		// DIREITA
		if (coluna < 2 && !estaVazia(linha, coluna + 1)) {
			valorVizinho = tabuleiro[linha][coluna + 1].getLeft();
			
			if(donos[linha][coluna + 1] != jogador.getDono()) {
				valoresPlus.add(valorVizinho + cartaJogada.getRight());
				posicaoVizinhosPlus.add((linha * 3) + (coluna + 1) + 1);
				
				if(valorVizinho == cartaJogada.getRight()) {
					posicaoVizinhosSame.add(((linha) * 3) + coluna + 2);
				}
				
				if (capturarCarta(atacante, cartaJogada.getRight(), linha, coluna + 1, valorVizinho)) {
					jogador.ganharPontos();
					defensor.perderPontos();
				}
			}
		}
		
		//ATIVA REGRA PLUS
		checarSomaPlus(valoresPlus, posicaoVizinhosPlus, atacante, jogador, defensor);
		
		//ATIVA REGRA SAME
		checarIgualdadeSame(posicaoVizinhosSame, atacante, jogador, defensor);
	}

	private boolean capturarCarta(DonosDasCasas atacante, int valorAtacante, int linhaVizinha, int colunaVizinha, int valorVizinho) {
		if (valorAtacante > valorVizinho) {
			donos[linhaVizinha][colunaVizinha] = atacante;
			return true;
		}
		return false;
	}
	
	// Regra ASCENCION: Se uma carta de determinado elemento é colocada na arena todas as cartas com o mesmo elemento recebem +1 nos valores, com o limite sendo 10
	private void checarAscencion(Carta cartaJogada) {
		Elementos elemento = cartaJogada.getElemento();
		if(elemento != Elementos.NEUTRAL) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					if(tabuleiro[i][j] != null) {
						if(tabuleiro[i][j].getElemento() == elemento) {
							tabuleiro[i][j].boostValores();
						}
					}
				}
			}
		}
	}

	//Regra PLUS: Se as bordas de duas ou mais cartas adjacentes somarema mesma quantidade (somando o valor de uma borda dacarta do jogador e a borda da carta adversária ao lado),ambas as cartas são capturadas.
	private void checarSomaPlus(List<Integer> valoresPlus, List<Integer> posicoes, DonosDasCasas atacante, Jogador jogador, Jogador defensor) {
		Set<Integer> indexSomasIguais = new HashSet<>();
		
		for (int i = 0; i < valoresPlus.size(); i++) {
			for (int j = i + 1; j < valoresPlus.size(); j++) {
				if (valoresPlus.get(i).intValue() == valoresPlus.get(j).intValue()) {
					indexSomasIguais.add(i);
					indexSomasIguais.add(j);
				}
			}
		}
		for (int index : indexSomasIguais) {
			int casa = posicoes.get(index);
			int linha = (casa - 1) / 3;
			int coluna = (casa - 1) % 3;
			if (donos[linha][coluna] != atacante) {
				donos[linha][coluna] = atacante;
				jogador.ganharPontos();
				defensor.perderPontos();
			}
		}
	}
	
	//Regra SAME: Se os valores nas bordas de duas ou mais cartas adjacentes forem iguais, a carta do oponente é capturada.
	
	private void checarIgualdadeSame(List<Integer> indexSame, DonosDasCasas atacante, Jogador jogador, Jogador defensor) {
		if(indexSame.size() >= 2) {
			for(int index : indexSame) {
				int linha = (index - 1) / 3;
				int coluna = (index - 1) % 3;
				
				if (donos[linha][coluna] != atacante) {
					donos[linha][coluna] = atacante;
					jogador.ganharPontos();
					defensor.perderPontos();
				}
			}
		}
	}
	
	public String desenharTabuleiro() {
		StringBuilder sb = new StringBuilder();
		sb.append(LINHA);

		for (int i = 0; i < 3; i++) {
			for (int linhaInterna = 0; linhaInterna < 3; linhaInterna++) {
				sb.append("|");

				for (int j = 0; j < 3; j++) {
					if (estaVazia(i, j)) {
						int numeroCasa = i * 3 + j + 1;

						if (linhaInterna == 1) {
							sb.append("    " + numeroCasa + "    ");
						} else {
							sb.append("         ");
						}
					} else {
						Carta cartaCasa = tabuleiro[i][j];

						switch (linhaInterna) {
						case 0:
							sb.append("    " + formatarPontuacao(cartaCasa.getUp()) + "    ");
							break;
						case 1:
							sb.append(formatarPontuacao(cartaCasa.getLeft()) + "   "
									+ donos[i][j].getCor() + "   "
									+ formatarPontuacao(cartaCasa.getRight()));
							break;
						case 2:
							sb.append("    " + formatarPontuacao(cartaCasa.getDown()) + "    ");
							break;
						}
					}
					sb.append("|");
				}
				sb.append("\n");
			}
			sb.append(LINHA);
		}
		return sb.toString();
	}

	private String formatarPontuacao(int ponto) {
		if (ponto >= 10) {
			return "A";
		}
		return String.valueOf(ponto);
	}
}