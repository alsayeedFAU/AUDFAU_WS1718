public class Lotterie {
	// (1) computes the binomial coefficient ("n-choose-m")
	public static double binomialkoeffizient(int m, int n) {
		return (fakultaet(n) / (fakultaet(m) * fakultaet(n - m)));
	}

	// (2) computes k!
	public static double fakultaet(int k) {
		double tmp = 1;
		for (int i = 1; i <= k; i++) {
			tmp *= i;
		}
		return k > 0 ? tmp : 1;

	}

	// (3) computes probability p of winning a "n-choose-m" lottery game
	public static double gewinnchance(int m, int n) {
		return 1 / binomialkoeffizient(m, n);
	}
}