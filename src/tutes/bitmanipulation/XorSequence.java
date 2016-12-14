package tutes.bitmanipulation;

import java.util.Scanner;

public class XorSequence {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int Q = in.nextInt();
		for (int a0 = 0; a0 < Q; a0++) {
			long L = in.nextLong();
			long R = in.nextLong();
			System.out.println(xOrGroup(L, R));
		}
	}

	private static long xOrGroup(long l, long r) {
		long groupDiff = (r - (r % 4)) - (l + (l % 4)); 
		if (groupDiff >= 8 && groupDiff % 8 == 0) {
			return xOrGroup(l, ((4 - (l % 4)) + l) - 1) ^ xOrGroup(r - (r % 4), r);
		} else if(groupDiff >= 8){
			return xOrGroup(l, ((4 - (l % 4)) + l) - 1) ^ xOrGroup(r - (r % 4), r) ^ 2;
		}
		long result = getValue((int)(l % 4), l);
		for(long i = l + 1; i <= r; i++){
			result ^= getValue((int)i % 4, i);
		}
		return result;
	}
	
	private static long getValue(int rem, long i) {
		switch (rem) {
		case 0:
			return i;
		case 1:
			return 1;
		case 2:
			return i + 1;
		case 3:
			return 0;
		}
		return 400000;
	}

}
