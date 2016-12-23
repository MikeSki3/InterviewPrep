package ctci.arraysstrings;

import java.util.Scanner;

import tutes.util.ds.HashTable;

class PalindromePermutation {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
//		System.out.println(isPalindrome(input));
		System.out.println(isPermutationPalindrome(input));
		in.close();
	}

	private static boolean isPalindrome(String input) {
		HashTable<Character, Integer> visited = new HashTable<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char curr = input.charAt(i);
			if (curr != ' ') {
				if (visited.get(curr) != null) {
					visited.put(curr, visited.get(curr) + 1);
				} else {
					visited.put(curr, 1);
				}
				sb.append(curr);
			}
		}
		return checkVisited(visited, sb.toString());
	}

	private static boolean checkVisited(HashTable<Character, Integer> visited, String input) {
		boolean foundOdd = false;
		Character oddFound = null;
		boolean lengthOdd = (input.length() % 2) != 0;
		for (int i = 0; i < input.length(); i++) {
			if (visited.get(input.charAt(i)) % 2 != 0) {
				if (foundOdd && oddFound != input.charAt(i))
					return false;
				else {
					foundOdd = true;
					oddFound = input.charAt(i);
				}
			}
		}
		return true;
	}
	
	//BOOK ANSWER-------------------------------------------------
	private static boolean isPermutationPalindrome(String phrase){
		int bitVector = createBitVector(phrase);
		return bitVector == 0 || checkExactlyOneBitSet(bitVector);
	}
	
	private static int createBitVector(String phrase){
		int bitVector = 0;
		for(char c : phrase.toCharArray()){
			int x = getCharNumber(c);
			bitVector = toggle(bitVector, x);
		}
		return bitVector;
	}
	
	private static int toggle(int bitVector, int index){
		if(index < 0) return bitVector;
		
		int mask = 1 << index;
		//book had the commented out section, but I feel like XORing works and is simpler?
		bitVector ^= mask;
//		if((bitVector & mask) == 0){
//			bitVector |= mask;
//		} else {
//			bitVector &= ~mask;
//		}
		return bitVector;
	}
	
	private static boolean checkExactlyOneBitSet(int bitVector){
		return (bitVector & (bitVector - 1)) == 0;
	}
	
	private static int getCharNumber(Character c){
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if(a <= val && val <= z){
			return val - a;
		}
		return -1;
	}
	//BOOK ANSWER-------------------------------------------------
}
