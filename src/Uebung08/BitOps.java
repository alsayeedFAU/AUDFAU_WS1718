
public class BitOps {

	public static long set(long bitSet, int bitIndex) {
		return (1L << bitIndex);
		//setzt den Bit an der Stelle bitIndex auf "1"
	}

	public static boolean isSet(long bitSet, int i) {
		return (((bitSet >>> i) & 1) != 0);
		//prüft den Bit an der Stelle bitIndex == "1"
	}

	public static long clear(long bitSet, int bitIndex) {
		if(isSet(bitSet, bitIndex)) {
			return bitSet - (1L << bitIndex);
		}
		return bitSet;
		//setzt den Bit an der Stelle bitIndex auf "0"
	}

	public static long flip(long bitSet, int bitIndex) {
		if(isSet(bitSet, bitIndex)) {
			return bitSet - (1L << bitIndex);
		}
		return bitSet + (1L << bitIndex);
		
		//setzt den Bit an der Stelle bitIndex auf == 1 ? 0 : 1
	}

}
