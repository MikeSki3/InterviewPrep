package tutes.dp;

import java.math.BigInteger;
import java.util.Scanner;

public class ModifiedFib {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger first = in.nextBigInteger();
		BigInteger second = in.nextBigInteger();
		int limit = in.nextInt();
		
		System.out.println(computeFib(first, second, limit));
	}

	private static BigInteger computeFib(BigInteger first, BigInteger second, int limit) {
		BigInteger[] res = new BigInteger[limit];
		res[0] = first; 
		res[1] = second;
		for(int i = 2; i < limit; i++){
			res[i] = res[i - 2].add((res[i - 1].multiply(res[i - 1])));
		}
		return res[limit - 1];
	}

}
