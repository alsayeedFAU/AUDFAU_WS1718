import java.util.Arrays;

public class Statistik {
	// ==================== min ====================
	public static double min2(double a, double b) {
		return a <= b ? a : b;
	}

	public static double min3(double a, double b, double c) {
		return min2(a, b) == a ? min2(a, c) : min2(b, c);
	}

	public static double min7(double a, double b, double c, double d, double e, double f, double g) {
		return min3(min3(a, b, c), min3(d, e, f), g);
	}

	// ==================== max ====================
	public static double max2(double a, double b) {
		return a >= b ? a : b;
	}

	public static double max3(double a, double b, double c) {
		return max2(a, b) == a ? max2(a, c) : max2(c, b);
	}

	public static double max7(double a, double b, double c, double d, double e, double f, double g) {
		return max3(max3(a, b, c), max3(d, e, f), g);
	}

	// ==================== Mittelwert ====================
	// Hinweis: hier ist ausnahmsweise keine Behandlung von double-overflow
	// (Ueberlauf) notwendig...
	public static double mittelwert3(double a, double b, double c) {
		return (a + b + c) / 3;
	}

	// Hinweis: hier ist ausnahmsweise keine Behandlung von double-overflow
	// (Ueberlauf) notwendig...
	public static double mittelwert7(double a, double b, double c, double d, double e, double f, double g) {
		return (a + b + c + d + e + f + g) / 7;
	}

	// ==================== Median ====================
	public static double median3(double a, double b, double c) {
		return min3(a, b, c) == a ? min2(b, c) : min3(a, b, c) == b ? min2(a, c) : min2(a, b);
	}

	public static double median7(double a, double b, double c, double d, double e, double f, double g) {
		double[] tmp = { a, b, c, d, e, f, g };
		for (int sort = 0; sort < 7; sort++) {
			for (int i = 0; i < 6; i++) {
				if (tmp[i] > tmp[i + 1]) {
					double t = tmp[i];
					tmp[i] = tmp[i + 1];
					tmp[i + 1] = t;
				}
			}
		}
		return tmp[3];
	}
}