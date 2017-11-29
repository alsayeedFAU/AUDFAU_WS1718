import java.util.LinkedList;
import java.util.Queue;

public class SozialesNetzwerk {
	public static boolean[][] freundschaft;

	// the number of currently registered users
	// TODO
	public static int anzahlNutzer;

	// initialize the network for max. n users
	public static void initialisiere(int n) {
		freundschaft = new boolean[n][n];
		anzahlNutzer = 0;
	}

	// adds a user with the given name
	public static int fuegeNutzerHinzu(String name) {
		for (int i = 0; i < freundschaft.length; i++) {
			if (!freundschaft[i][i]) {
				freundschaft[i][i] = true;
				anzahlNutzer++;
				return i;
			}
		}
		return -1;
	}

	// adds a friendship relationship between the users with the given IDs
	// (regardless of the current state)
	public static void fuegeFreundschaftHinzu(int id0, int id1) {
		freundschaft[id0][id1] = true;
		freundschaft[id1][id0] = true;
	}

	// removes a friendship relationship between the users with the given IDs
	// (regardless of the current state)
	public static void entferneFreundschaft(int id0, int id1) {
		freundschaft[id0][id1] = false;
		freundschaft[id1][id0] = false;
	}

	// returns true if the users with the given IDs are friends and false if not
	public static boolean testeFreundschaft(int id0, int id1) {
		return freundschaft[id0][id1];
	}

	// returns true if the users with the given IDs are reachable within the given
	// distance e, false otherwise
	public static boolean istErreichbar(SozialesNetzwerkMethodenProtokoll snmp, int id0, int id1, int e) {
		snmp.istErreichbar(id0, id1, e); // DO NOT REMOVE OR CHANGE THIS LINE!
		if (testeFreundschaft(id0, id1) && e > 0) {
			return true;
		}
		if (e > 0) {
			for (int i = 0; i < freundschaft.length; i++) {
				if (testeFreundschaft(id0, i) && id0 != i) {
					if (istErreichbar(snmp, i, id1, e - 1)) {
						return true;
					}
				}
			}
		}

		return false;
	}
}