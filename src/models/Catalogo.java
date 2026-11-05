package models;

import static enums.Elementos.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import enums.Elementos;

public class Catalogo {
	private final Map<Integer, Carta> cartas = new LinkedHashMap<>();
	private final Random random = new Random();

	public Catalogo() {
		carta(1, "Geezard", NEUTRAL, 1, 5, 1, 4);
		carta(2, "Funguar", NEUTRAL, 5, 3, 1, 1);
		carta(3, "Bite Bug", NEUTRAL, 1, 5, 3, 3);
		carta(4, "Red Bat", NEUTRAL, 6, 2, 1, 1);
		carta(5, "Blobra", NEUTRAL, 2, 5, 1, 3);
		carta(6, "Gayla", THUNDER, 2, 4, 4, 1);
		carta(7, "Gesper", NEUTRAL, 1, 1, 4, 5);
		carta(8, "Fastitocalon-F", EARTH, 3, 1, 2, 5);
		carta(9, "Blood Soul", NEUTRAL, 2, 1, 6, 1);
		carta(10, "Caterchipillar", NEUTRAL, 4, 3, 4, 2);
		carta(11, "Cockatrice", THUNDER, 2, 6, 2, 1);
		carta(12, "Grat", NEUTRAL, 7, 1, 3, 1);
		carta(13, "Buel", NEUTRAL, 6, 3, 2, 2);
		carta(14, "Mesmerize", NEUTRAL, 5, 4, 3, 3);
		carta(15, "Glacial Eye", ICE, 6, 3, 4, 1);
		carta(16, "Belhelmel", NEUTRAL, 3, 3, 5, 4);
		carta(17, "Thrustaevis", WIND, 5, 5, 2, 3);
		carta(18, "Anacondaur", POISON, 5, 5, 3, 1);
		carta(19, "Creeps", THUNDER, 5, 2, 5, 2);
		carta(20, "Grendel", THUNDER, 4, 2, 5, 4);
		carta(21, "Jelleye", NEUTRAL, 3, 7, 1, 2);
		carta(22, "Grand Mantis", NEUTRAL, 5, 3, 5, 2);
		carta(23, "Forbidden", NEUTRAL, 6, 2, 3, 6);
		carta(24, "Armadodo", EARTH, 6, 6, 1, 3);
		carta(25, "Tri-Face", POISON, 3, 5, 5, 5);
		carta(26, "Fastitocalon", EARTH, 7, 3, 1, 5);
		carta(27, "Snow Lion", ICE, 7, 3, 5, 1);
		carta(28, "Ochu", NEUTRAL, 5, 3, 3, 6);
		carta(29, "SAM08G", FIRE, 5, 4, 2, 6);
		carta(30, "Death Claw", FIRE, 4, 2, 7, 4);
		carta(31, "Cactuar", NEUTRAL, 6, 3, 6, 2);
		carta(32, "Tonberry", NEUTRAL, 3, 4, 4, 6);
		carta(33, "Abyss Worm", EARTH, 7, 5, 3, 2);
		carta(34, "Turtapod", NEUTRAL, 2, 7, 6, 3);
		carta(35, "Vysage", NEUTRAL, 6, 5, 4, 5);
		carta(36, "T-Rexaur", NEUTRAL, 4, 7, 2, 6);
		carta(37, "Bomb", FIRE, 2, 3, 6, 7);
		carta(38, "Blitz", THUNDER, 1, 7, 4, 6);
		carta(39, "Wendigo", NEUTRAL, 7, 6, 1, 3);
		carta(40, "Torama", NEUTRAL, 7, 4, 4, 4);
		carta(41, "Imp", NEUTRAL, 3, 6, 3, 7);
		carta(42, "Blue Dragon", POISON, 6, 3, 7, 2);
		carta(43, "Adamantoise", EARTH, 4, 6, 5, 5);
		carta(44, "Hexadragon", FIRE, 7, 3, 4, 5);
		carta(45, "Iron Giant", NEUTRAL, 6, 5, 6, 5);
		carta(46, "Behemoth", NEUTRAL, 3, 7, 5, 6);
		carta(47, "Chimera", WATER, 7, 3, 5, 6);
		carta(48, "PuPu", NEUTRAL, 3, 1, 2, 10);
		carta(49, "Elastoid", NEUTRAL, 6, 7, 6, 2);
		carta(50, "GIM47N", NEUTRAL, 5, 4, 7, 5);
		carta(51, "Malboro", POISON, 7, 2, 4, 7);
		carta(52, "Ruby Dragon", FIRE, 7, 4, 7, 2);
		carta(53, "Elnoyle", NEUTRAL, 5, 6, 7, 3);
		carta(54, "Tonberry King", NEUTRAL, 4, 4, 7, 6);
		carta(55, "Wedge, Biggs", NEUTRAL, 6, 7, 2, 6);
		carta(56, "Fujin Raijin", NEUTRAL, 2, 4, 8, 8);
		carta(57, "Elvoret", WIND, 7, 4, 3, 8);
		carta(58, "X-ATM092", NEUTRAL, 4, 3, 7, 8);
		carta(59, "Granaldo", NEUTRAL, 7, 5, 8, 2);
		carta(60, "Gerogero", POISON, 1, 3, 8, 8);
		carta(61, "Iguion", NEUTRAL, 8, 2, 8, 2);
		carta(62, "Abadon", NEUTRAL, 6, 5, 4, 8);
		carta(63, "Trauma", NEUTRAL, 4, 6, 5, 8);
		carta(64, "Oilboyle", NEUTRAL, 1, 8, 4, 8);
		carta(65, "Shumi", NEUTRAL, 6, 4, 8, 5);
		carta(66, "Krysta", NEUTRAL, 7, 1, 8, 5);
		carta(67, "Propagator", NEUTRAL, 8, 8, 4, 4);
		carta(68, "Jumbo Cactuar", NEUTRAL, 8, 4, 4, 8);
		carta(69, "Tri-Point", THUNDER, 8, 8, 2, 5);
		carta(70, "Gargantua", NEUTRAL, 5, 8, 6, 6);
		carta(71, "Mobile Type 8", NEUTRAL, 8, 3, 7, 6);
		carta(72, "Sphinxara", NEUTRAL, 8, 8, 5, 3);
		carta(73, "Tiamat", NEUTRAL, 8, 4, 5, 8);
		carta(74, "BGH251F2", NEUTRAL, 5, 5, 8, 7);
		carta(75, "Red Giant", NEUTRAL, 6, 7, 4, 8);
		carta(76, "Catoblepas", NEUTRAL, 1, 7, 7, 8);
		carta(77, "Ultima Weapon", NEUTRAL, 7, 8, 2, 7);
		carta(78, "Chubby Chocobo", NEUTRAL, 4, 9, 8, 4);
		carta(79, "Angelo", NEUTRAL, 9, 3, 7, 6);
		carta(80, "Gilgamesh", NEUTRAL, 3, 6, 9, 7);
		carta(81, "MiniMog", NEUTRAL, 9, 2, 9, 3);
		carta(82, "Chicobo", NEUTRAL, 9, 4, 8, 4);
		carta(83, "Quezacotl", THUNDER, 2, 4, 9, 9);
		carta(84, "Shiva", ICE, 6, 9, 4, 7);
		carta(85, "Ifrit", FIRE, 9, 8, 2, 6);
		carta(86, "Siren", NEUTRAL, 8, 2, 6, 9);
		carta(87, "Sacred", EARTH, 5, 9, 9, 1);
		carta(88, "Minotaur", EARTH, 9, 9, 2, 5);
		carta(89, "Carbuncle", NEUTRAL, 8, 4, 10, 4);
		carta(90, "Diablos", NEUTRAL, 5, 3, 8, 10);
		carta(91, "Leviathan", WATER, 7, 7, 1, 10);
		carta(92, "Odin", NEUTRAL, 8, 5, 3, 10);
		carta(93, "Pandemona", WIND, 10, 7, 7, 1);
		carta(94, "Cerberus", NEUTRAL, 7, 10, 6, 4);
		carta(95, "Alexander", HOLY, 9, 2, 4, 10);
		carta(96, "Phoenix", FIRE, 7, 10, 7, 2);
		carta(97, "Bahamut", NEUTRAL, 10, 6, 2, 8);
		carta(98, "Doomtrain", POISON, 3, 10, 10, 1);
		carta(99, "Eden", NEUTRAL, 4, 10, 9, 4);
		carta(100, "Ward", NEUTRAL, 10, 8, 2, 7);
		carta(101, "Kiros", NEUTRAL, 6, 10, 6, 7);
		carta(102, "Laguna", NEUTRAL, 5, 9, 3, 10);
		carta(103, "Selphie", NEUTRAL, 10, 4, 6, 8);
		carta(104, "Quistis", NEUTRAL, 9, 2, 10, 6);
		carta(105, "Irvine", NEUTRAL, 2, 10, 9, 6);
		carta(106, "Zell", NEUTRAL, 8, 6, 10, 5);
		carta(107, "Rinoa", NEUTRAL, 4, 10, 2, 10);
		carta(108, "Edea", NEUTRAL, 10, 3, 3, 10);
		carta(109, "Seifer", NEUTRAL, 6, 4, 10, 9);
		carta(110, "Squall", NEUTRAL, 10, 9, 6, 4);
	}

	private void carta(int id, String nome, Elementos elemento,
			int up, int left, int down, int right) {
		cartas.put(id, new Carta(id, nome, elemento, up, left, down, right));
	}

	public Carta porId(int id) {
		return cartas.get(id);
	}

	public List<Carta> todas() {
		return new ArrayList<>(cartas.values());
	}
	
	public Carta sortearCarta() {
		int id = random.nextInt(cartas.size()) + 1;
		return cartas.get(id).copiarCarta();
	}
	
	
}