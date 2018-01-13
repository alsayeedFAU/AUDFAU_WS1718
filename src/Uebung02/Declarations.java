public class Declarations {
	// TODO: declare a constant named "AUD_EXAM_GRADES" with a value of
	// -10131720232730333740.4347 * 10^(-50)
	static final double AUD_EXAM_GRADES = Math.pow(10, -50) * -10131720232730333740.4347;
	// TODO: declare an enumeration named "Tutors" containing the first (only the
	// first ONE!)
	// given names (e.g. "John" from "John Doe") of all 22 tutors of the AuD winter
	// term 2017/18:
	// https://www2.cs.fau.de/teaching/WS2017/AuD/uebungen/index.html
	// IMPORTANT: Although Java coding conventions advise you to write enum
	// constants in CAPITAL_LETTERS,
	// please use simple CamelCase for the names here!!

	enum Tutors {
		Athanassios, Janina, Fabian, Anatoliy, Eva, Oliver, Christian, Adrian, Sara, Tom, Immanuel, Johannes, Andreas, Yannik, Stefan, Daniel, Benedikt, Julius, Rebekka
	}

	public static char[] lowerCaseLetters() {
		// TODO: declare, fill and return an 1-dimensional
		// array containing the ASCII-letters a to z (lower case letters, ASCII 97(10)
		// to 0x7A)
		char[] tmp = new char[26];
		for (char c = 'a'; c <= 'z'; c++) {
			tmp[c - 'a'] = c;
		}

		return tmp;
	}

	public static char[][] aFewChars() {
		// TODO: declare, fill and return a 2-dimensional array containing
		// 0) the ASCII-letters A to Z (capital letters) in the first row,
		// 1) the ASCII-letters a to z (lower case letters) in the second row,
		// 2) the values (!) 0 to 25 in the third row,
		// 3) the ASCII-characters (!) 0 to 9, than 0 to 9 again and finally 0 to 5 in
		// the fourth row
		char[][] tmp = new char[4][26];
		for (int i = 0, j = 65, k = 97, l = 48; i < tmp[0].length; i++, j++, k++, l = i % 10 + 48) {
			tmp[0][i] = (char) j;
			tmp[1][i] = (char) k;
			tmp[2][i] = (char) i;
			tmp[3][i] = (char) l;
		}

		return tmp;
	}

	// TODO: declare a constant String named "DINGBATS" containing the
	// Dingbats arrow symbols from [2798] to [27BE]
	// with a horizontal tabulator \t between groups of seven symbols each
	// (e.g. after [279E], after [27A5], ...)
	// and finally followed by a line feed \n
	// (no spaces or other symbols than those above!!)

	static String DINGBATS = helper();

	private static String helper() {
		String tmp = "";
		tmp +=  "\u2798" + "\u2799" + "\u279A" + "\u279B" + "\u279C" + "\u279D" + "\u279E" +"\t" + 
				"\u279F" + "\u27A0" + "\u27A1" + "\u27A2" + "\u27A3" + "\u27A4" + "\u27A5" +"\t" + 
				"\u27A6" + "\u27A7" + "\u27A8" + "\u27A9" + "\u27AA" + "\u27AB" + "\u27AC" +"\t" + 
				"\u27AD" + "\u27AE" + "\u27AF" + "\u27B0" + "\u27B1" + "\u27B2" + "\u27B3" +"\t" + 
				"\u27B4" + "\u27B5" + "\u27B6" + "\u27B7" + "\u27B8" + "\u27B9" + "\u27BA" +"\t" + 
				"\u27BB" + "\u27BC" + "\u27BD" + "\u27BE" + "\n";

		return tmp;
	}

	public static String[][][] theHyperCube() {
		// TODO: declare, fill and return a 3-dimensional array of size 3x3x3 where
		// each cell contais its coordinates encoded as String (e.g. cube[2][1][0] ==
		// "210")
		String[][][] tmp = new String[3][3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					tmp[i][j][k] = Integer.toString(i) + Integer.toString(j) + Integer.toString(k);
				}
			}

		}
		return tmp;
	}
}