package tutes.dp;

import java.util.Scanner;

public class MaxSubarray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for (int i = 0; i < cases; i++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = in.nextInt();
			}
			findMax(arr);
		}
	}

	private static void findMax(int[] arr) {
		int maxEndingHere = arr[0], maxSoFar = arr[0];
		int nonContMax = arr[0];
		for (int i = 1; i < arr.length; i++) {
			nonContMax = Math.max(arr[i], nonContMax + (arr[i] > 0 ? arr[i] : 0) );
			maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		System.out.println(maxSoFar + " " + nonContMax);
	}

}
