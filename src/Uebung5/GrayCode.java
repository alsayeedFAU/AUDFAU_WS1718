public class GrayCode {

	public static int prevLength(int len) {
		return len % 2 == 0 ? len / 2 : (int) Math.pow(2, Integer.toBinaryString(len).length() - 1);
	}

	public static String[] generate(GrayCodeControl gcc, int len) {
		gcc.logGenerate(gcc, len);
		if (len < 1) {
			return new String[] {};
		}
		if (len == 1) {
			return new String[] { "0" };
		}
		if (len == 2) {
			return new String[] { "0", "1" };
		}

		String[] lenK = generate(gcc, prevLength(len));
		String[] lenInverse = new String[lenK.length];
		for (int i = lenK.length - 1; i >= 0; i--) {
			lenInverse[lenK.length - i - 1] = lenK[i];
		}
		String[] tmp = new String[len];

		for (int i = 0; i < lenK.length; i++) {
			tmp[i] = "0" + lenK[i];
		}
		for (int i = lenK.length; i < len; i++) {
			tmp[i] = "1" + lenInverse[i - lenK.length];
		}
		return tmp;
	}
}
