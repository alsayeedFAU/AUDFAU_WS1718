import java.util.Comparator;
import java.util.NoSuchElementException;

public class ZirkulaereDoppeltVerkettetePrioritaetswarteschlange<WertTyp>
		extends AbstrakteZirkulaereDoppeltVerkettetePrioritaetswarteschlange<WertTyp> {

	protected ZirkulaereDoppeltVerkettetePrioritaetswarteschlange(Comparator<WertTyp> vergleicher) {
		super(vergleicher);
	}

	@Override
	public void einfuegen(WertTyp wert) {
		if (super.kopf == null) {
			super.kopf = new DoppeltVerketteterKnoten<WertTyp>(wert);
		} else {
			if (kopf.holeNachfolger() == null) {
				DoppeltVerketteterKnoten<WertTyp> next = new DoppeltVerketteterKnoten<WertTyp>(wert);
				kopf.ersetzeNachfolger(next);
				kopf.ersetzeVorgaenger(next);
			} else {
				DoppeltVerketteterKnoten<WertTyp> tmp = kopf;
				while (vergleicher.compare(tmp.holeWert(), tmp.holeNachfolger().holeWert()) > 0) {
					tmp = tmp.holeNachfolger();
				}
				DoppeltVerketteterKnoten<WertTyp> next = new DoppeltVerketteterKnoten<WertTyp>(wert);
				next.ersetzeNachfolger(tmp.holeNachfolger());
				next.holeNachfolger().ersetzeVorgaenger(next);
				next.ersetzeVorgaenger(tmp);
				tmp.ersetzeNachfolger(next);
			}
		}

	}

	@Override
	public WertTyp wichtigstenEntfernen() throws NoSuchElementException {
		if (kopf == null) {
			throw new NoSuchElementException();
		}
		DoppeltVerketteterKnoten<WertTyp> tmp = kopf;
		kopf = kopf.holeNachfolger();
		kopf.ersetzeVorgaenger(tmp.holeVorgaenger());
		return tmp.holeWert();
	}

	@Override
	public WertTyp unwichtigstenEntfernen() throws NoSuchElementException {
		if (kopf == null) {
			throw new NoSuchElementException();
		} else if (kopf.holeNachfolger() == kopf) {
			DoppeltVerketteterKnoten<WertTyp> tmp = kopf;
			kopf = null;
			return tmp.holeWert();
		} else {
			DoppeltVerketteterKnoten<WertTyp> tmp = kopf.holeVorgaenger();
			kopf.ersetzeVorgaenger(tmp.holeVorgaenger());
			tmp.holeVorgaenger().ersetzeNachfolger(kopf);

			return null;
		}
	}

	@Override
	public WertTyp wichtigstenEntfernen(Comparator andererVergleicher) throws NoSuchElementException {
		if (kopf == null) {
			throw new NoSuchElementException();
		}
		DoppeltVerketteterKnoten<WertTyp> tmp = kopf;
		if (andererVergleicher.compare(tmp.holeWert(), tmp.holeNachfolger().holeWert()) <= 0) {
			while (andererVergleicher.compare(tmp.holeWert(), tmp.holeNachfolger().holeWert()) <= 0) {
				tmp = tmp.holeNachfolger();
			}
			return tmp.holeWert();
		}
		return null;
	}

	@Override
	public WertTyp unwichtigstenEntfernen(Comparator andererVergleicher) throws NoSuchElementException {
		if (kopf == null) {
			throw new NoSuchElementException();
		}
		if (kopf.holeNachfolger() == kopf) {
			DoppeltVerketteterKnoten<WertTyp> tmp = kopf;
			kopf = null;
			return tmp.holeWert();
		}

		DoppeltVerketteterKnoten<WertTyp> tmp = kopf;
		if (andererVergleicher.compare(tmp.holeWert(), tmp.holeNachfolger().holeWert()) > 0) {
			while (andererVergleicher.compare(tmp.holeWert(), tmp.holeNachfolger().holeWert()) > 0) {
				tmp = tmp.holeNachfolger();
			}
			return tmp.holeWert();
		}
		return null;
	}

}
