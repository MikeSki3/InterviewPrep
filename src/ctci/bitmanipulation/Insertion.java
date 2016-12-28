package ctci.bitmanipulation;

public class Insertion {
	public static void main(String[] args) {
		
//		int N = (int) Math.pow(2, 10);
//		int M = 19;
//		int i = 2, j = 6;
		int N = 73;
		int M = 6;
		int i = 2, j = 4;
		System.out.println("N: " + Integer.toBinaryString(N) + " M: " + Integer.toBinaryString(M) + " Output: " + Integer.toBinaryString(insert(M, N, i, j)));
	}

	private static int insert(int m, int n, int i, int j) {
		int setN = getSetBits(i, j, n);
		int nPrefix = getPrefix(n, j);
		int nSuffix = getSuffix(n, i);
		return (setN & (m << i) | nPrefix | nSuffix);
	}

	private static int getSuffix(int n, int i) {
		int result = (1 << i) - 1;
//		System.out.println(Integer.toBinaryString(result & n));
		return result & n;
	}

	private static int getPrefix(int n, int j) {
		int shifted = n >> j;
		return shifted << j;
	}

	private static int getSetBits(int i, int j, int n) {
		int ones = ((1 << (j - i + 1)) - 1) << i;
		return n | ones;
	}
}
