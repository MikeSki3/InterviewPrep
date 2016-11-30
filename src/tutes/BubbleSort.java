package tutes;

import java.util.Scanner;

import tutes.util.sort.Bubble;

public class BubbleSort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] toBeSorted = new int[n];
		for(int i = 0; i < n; i++){
			toBeSorted[i] = in.nextInt();
		}
		int swaps = Bubble.sort(toBeSorted);
		int first = toBeSorted[0];
		int last = toBeSorted[n - 1];
		System.out.println("Array is sorted in " + swaps + " swaps.");
		System.out.println("First Element: " + first);
		System.out.println("Last Element: " + last);
	}

}
