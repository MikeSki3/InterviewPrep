package ctci.arraysstrings;

import java.util.Scanner;

public class PermutationOfTwo {
	public static void main(String args[]){
		int used[] = new int[126];
		Scanner in = new Scanner(System.in);
		String first = in.next();
		String second = in.next();
		
		populateUsed(used, first);
		System.out.println(isPermutation(used, first, second));
		in.close();
	}

	private static boolean isPermutation(int[] used, String first, String second) {
		int foundCount = 0;
		for(int i = 0; i < second.length(); i++){
			foundCount 	+= (used[second.charAt(i)]-- > 0 ? 1 : 0);
		}
		return foundCount == first.length();
	}

	private static void populateUsed(int[] used, String curr) {
		for(char currChar : curr.toCharArray()){
			used[currChar]++;
		}
	}
}
