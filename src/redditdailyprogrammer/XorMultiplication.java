package redditdailyprogrammer;
//URL - https://www.reddit.com/r/dailyprogrammer/comments/6ba9id/20170515_challenge_315_easy_xor_multiplication/

import java.util.Scanner;

public class XorMultiplication {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		System.out.println(xorMultiply(a, b));
		in.close();
	}

	private static int xorMultiply(int a, int b) {
		int result = 0;
		int bottom, top;
		if(Integer.toBinaryString(a).length() > Integer.toBinaryString(b).length()){
			bottom = b;
			top = a;
		} else {
			bottom = a;
			top = b;
		}
		int numLength = Integer.toBinaryString(bottom).length();
		for(int shift = 0; shift <= numLength; shift++){
			int bit = bottom & 1;
			int prod = top * bit;
			prod = prod << shift;
			result ^= prod;
			bottom = bottom >> 1;
		}
		
		return result;
	}
}
