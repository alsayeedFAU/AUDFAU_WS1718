import java.util.Collection;
import java.util.Iterator;

public class SkipList<E extends Comparable<? super E>> extends AbstractSkipList<E> {

	public int size = 0;

	@Override
	public boolean add(E arg0) {
		if (arg0 == null) {
			throw new NullPointerException();
		}

		if (contains(arg0)) {
			return false;
		}

		boolean hasAdded = false;
		int randomLevel = getRandomLevel();

		SkipListNode<E> newNode = new SkipListNode<>(arg0, randomLevel);
		SkipListNode<E> current = head;
		int ebene = MAX_LEVELS - 1;
		while (ebene >= 0) {
			while (current.next[ebene] != null && current.next[ebene].value.compareTo(arg0) < 0) {
				current = current.next[ebene];
			}
			// Schon drin?
			if (current.next[ebene] != null && current.next[ebene].value.compareTo(arg0) == 0) {
				return false;
			}
			if (ebene <= randomLevel) {
				// Es wurde was eingefuegt
				hasAdded = true;
				// am Ende?
				if (current.next[ebene] == null) {
					current.next[ebene] = newNode;
				}
				// Kommt danach noch was?
				else {
					newNode.next[ebene] = current.next[ebene];
					current.next[ebene] = newNode;
				}
			}
			// 1 tiefer und weiter geht es!
			ebene--;
		}
		if (hasAdded) {
			size++;
		}
		return hasAdded;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		if (c == null) {
			throw new NullPointerException();
		}
		boolean hasChanged = false;
		for (Iterator i = c.iterator(); i.hasNext();) {
			if (add((E) i.next())) {
				hasChanged = true;
			}
		}
		return hasChanged;
	}

	@Override
	public void clear() {
		head = new SkipListNode<E>(null, MAX_LEVELS - 1);
		size = 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(Object o) {
		if (o == null) {
			throw new NullPointerException();
		}
		SkipListNode<E> current = head;
		int ebene = MAX_LEVELS - 1;
		while (ebene >= 0) {
			while (current.next[ebene] != null && current.next[ebene].value.compareTo((E) o) < 0) {
				current = current.next[ebene];
			}
			// Dasselbe?
			if (current.next[ebene] != null && current.next[ebene].value.compareTo((E) o) == 0) {
				return true;
			}
			// 1 tiefer und weiter geht es!
			ebene--;
		}
		// Nicht gefunden?
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		if (c == null) {
			throw new NullPointerException();
		}
		for (Iterator<?> i = c.iterator(); i.hasNext();) {
			if (!contains(i.next())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean remove(Object o) {
		if (o == null) {
			throw new NullPointerException();
		}

		if (!contains(o)) {
			return false;
		}

		boolean hasRemoved = false;
		SkipListNode<E> current = head;

		int ebene = MAX_LEVELS - 1;
		while (ebene >= 0) {
			while (current.next[ebene] != null && current.next[ebene].value.compareTo((E) o) < 0) {
				current = current.next[ebene];
			}
			// Schon drin?
			if (current.next[ebene] != null && current.next[ebene].value.compareTo((E) o) == 0) {
				hasRemoved = true;
				// Referenz loeschen

				// Danach kommt nix mehr?
				if (current.next[ebene].next[ebene] == null) {
					current.next[ebene] = null;
				} else {
					current.next[ebene] = current.next[ebene].next[ebene];
				}
			}
			// 1 tiefer und weiter geht es!
			ebene--;
		}

		if (hasRemoved) {
			size--;
		}
		return hasRemoved;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		if (c == null) {
			throw new NullPointerException();
		}
		boolean hasChanged = false;
		for (Iterator<?> i = c.iterator(); i.hasNext();) {
			if (remove(i.next())) {
				hasChanged = true;
			}
		}
		return hasChanged;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	protected int getRandomLevel() {
		int lvl = 0;
		for (; nextBoolean() && lvl < MAX_LEVELS; lvl++)
			;
		return lvl;
	}

}