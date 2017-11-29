public class RucksackPacken {
	/**
	 * @param groessen
	 *            Die Groessen der einzupackenden Elemente.
	 * @param werte
	 *            Die Werte der einzupackenden Elemente.
	 * @param sackGroesse
	 *            Die Groesse des leeren Rucksacks.
	 * @return Der Gesamtwert des optimal gepackten Rucksacks.
	 */
	public static int packeSack(RucksackPackenProtokoll rpp, int groessen[], int werte[], int sackGroesse) {
		if (groessen == null || werte == null || sackGroesse <= 0) {
			return 0;
		}
		return packeSackHelfer(rpp, groessen, werte, sackGroesse, groessen.length - 1);
	}

	/**
	 * @param groessen
	 *            Die Groessen der einzupackenden Elemente.
	 * @param werte
	 *            Die Werte der einzupackenden Elemente.
	 * @param platzFrei
	 *            Der noch verfuegbare (freie) Platz im Rucksack.
	 * @param naechsterGegenstand
	 *            Index des als naechstes zu betrachtenden Gegenstand.
	 * @return Der Gesamtwert des optimal gepackten Rucksacks.
	 */
	public static int packeSackHelfer(RucksackPackenProtokoll rpp, int groessen[], int werte[], int platzFrei,
			int naechsterGegenstand) {
		rpp.packeSackHelferAufgerufen(rpp, groessen, werte, platzFrei, naechsterGegenstand); // DO NOT REMOVE OR CHANGE
																								// THIS LINE!
		if (naechsterGegenstand >= 0) {
			if (platzFrei < werte[naechsterGegenstand]) {
				return 0 + packeSackHelfer(rpp, groessen, werte, platzFrei, naechsterGegenstand - 1);
			}

			return packeSackHelfer(rpp, groessen, werte, platzFrei - groessen[naechsterGegenstand],
					naechsterGegenstand - 1) <= packeSackHelfer(rpp, groessen, werte, platzFrei,
							naechsterGegenstand - 1)
									? werte[naechsterGegenstand] + packeSackHelfer(rpp, groessen, werte,
											platzFrei - groessen[naechsterGegenstand], naechsterGegenstand - 1)
									: 0 + packeSackHelfer(rpp, groessen, werte, platzFrei, naechsterGegenstand - 1);
		} else {
			return 0;
		}

	}
}