import java.util.Arrays;

public class SkylineSolver {

	public static int area(int[] skylineClone) {
		int tmp = 0;
		for (int i = 0; i + 2 < skylineClone.length; i += 2) {
			tmp += skylineClone[i + 2] != 0 ? (skylineClone[i + 2] - skylineClone[i]) * skylineClone[i + 1]
					: skylineClone[i] * skylineClone[i + 1];
		}
		return tmp;
	}

	public static int[][] divide(int[][] orig, int num, boolean isLeft) {
		if (isLeft) {
			return Arrays.copyOfRange(orig, 0, num);
		}
		return Arrays.copyOfRange(orig, num, orig.length);
	}

	public static int[] conquer(SkylineSolverHelper ssh, int[][] b) {
		if (b.length == 1) {
			return new int[] {b[0][0],b[0][1],b[0][2],0};
		}

		return ssh.merge(conquer(ssh, divide(b, b.length/2 , true)), conquer(ssh, divide(b, b.length/2, false)));
	}

}
