package ctci.arraysstrings;

import java.util.Scanner;

import tutes.util.ds.HashTable;

class PalindromePermutation {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		String input = in.nextLine();
		System.out.println(isPalindrome(input));
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
}
