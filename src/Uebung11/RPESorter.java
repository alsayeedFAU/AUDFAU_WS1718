import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

public class RPESorter<T> implements RPESorterInterface<T> {
	Comparator<T> c;

	public RPESorter(Comparator<T> c) {
		this.c = c;
	}

	@Override
	public LinkedList<T> extract(LinkedList<T> in) {
		LinkedList<T> list = new LinkedList<>();
		list.addFirst(in.getFirst());
		ListIterator<T> next = in.listIterator(1);
		while (next.hasNext()) {
			T n = next.next();
			if (c.compare(n, list.getLast()) >= 0) {
				list.add(n);
			}
		}

		return list;
	}

	@Override
	public LinkedList<T> merge(LinkedList<T> a, LinkedList<T> b) {
		LinkedList<T> list = new LinkedList<>();
		if (a.size() == 0 && b.size() == 0) {
			return list;
		} else if (a.size() == 0 || b.size() == 0) {
			return a.size() == 0 ? b : a;
		}

		ListIterator<T> nextA = a.listIterator();
		ListIterator<T> nextB = b.listIterator();
		T neA = nextA.next();
		T neB = nextB.next();

		while (nextA.hasNext() || nextB.hasNext()) {
			if (neA != null && neB != null && c.compare(neA, neB) <= 0) {
				list.add(neA);
				if (nextA.hasNext()) {
					neA = nextA.next();
				} else {
						if(list.contains(neA)) {
							neA = null;
						}
						list.add(neB);
						neB = nextB.next();
				}
			} else {
				list.add(neB);
				if (nextB.hasNext()) {
					neB = nextB.next();
				} else {
						if(list.contains(neB)) {
							neB = null;
						}
						list.add(neA);
						neA = nextA.next();
				}
			}
		}
		if(neA != null) {
			list.add(neA);
		}
		if(neB != null) {
			list.add(neB);
		}
		
		if(!list.contains(neA)) {
			System.err.println("Missing A");
		}
		if(!list.contains(neB)) {
			System.err.println("Missing B");
		}
		

		return list;

	}

	@Override
	public LinkedList<T> sort(LinkedList<T> in) {
		LinkedList<T> i = in;
		LinkedList<T> o = new LinkedList<>();

		while (i.size() != 0) {
			LinkedList<T> t = extract(i);
			i.removeAll(t);

			if (t.size() == 4 && o.size() == 12 && false) {
				for (T x : o) {
					System.out.println(x);
				}
				System.out.println();
				for (T y : t) {
					System.out.println(y);
				}
				System.out.println();
				o = merge(t, o);
				for (T x : o) {
					System.out.println(x);
				}
				System.out.println();
			} else {
				o = merge(o, t);
			}
		}
		return o;
	}

}
