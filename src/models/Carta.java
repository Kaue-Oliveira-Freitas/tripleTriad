package models;

import enums.Elementos;

public class Carta {
	private final int id;
	private final String titulo;
	private final Elementos elemento;
	private int up, left, down, right;

	public Carta(int id, String titulo, Elementos elemento, int up, int left, int down, int right) {
		this.id = id;
		this.titulo = titulo;
		this.elemento = elemento;
		this.up = up;
		this.left = left;
		this.down = down;
		this.right = right;
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public Elementos getElemento() {
		return elemento;
	}

	public int getUp() {
		return up;
	}

	public int getLeft() {
		return left;
	}

	public int getDown() {
		return down;
	}

	public int getRight() {
		return right;
	}

	public void boostValores() {
		if(!valorEhIgualDez(this.up)) {
			this.up ++;
		}
		if(!valorEhIgualDez(this.right)) {
			this.right ++;
		}
		if(!valorEhIgualDez(this.down)) {
			this.down ++;
		}
		if(!valorEhIgualDez(this.left)) {
			this.left ++;
		}
	}
	
	private boolean valorEhIgualDez(int valor) {
		return valor == 10;
	}

	public Carta copiarCarta() {
		return new Carta(id, titulo, elemento, up, left, down, right);
	}
	
}