import java.util.Arrays;

public class R {
	public static int[] r(int[] content) {
		int length = content.length;
		int[] result = new int[length];
		int cur = 0;
		while (cur < length) {
			int ra = 0;
			int j = 0;
			while (j < length) {
				if (j == cur) {
					j = j + 1;
					continue;
				}
				if (content[j] < content[cur]) {
					ra = ra + 1;
				}
				// 1) --> cur j ra result <--
				System.out.println("1:");
				System.out.println(cur);
				System.out.println(j);
				System.out.println(ra);
				System.out.println(Arrays.toString(result));
				System.out.println();

				j = j + 1;
			}
			result[cur] = ra;
			cur = cur + 1;
			// 2) --> cur j ra result <--
			System.out.println("2:");
			System.out.println(cur);
			System.out.println(j);
			System.out.println(ra);
			System.out.println(Arrays.toString(result));
			System.out.println();
		}
		return result;
	}

	public static void main(String[] args) {
		int[] test = { 5, 2, 3 };
		int[] result = r(test);
		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i] + " " + result[i]);
		}
	}
}