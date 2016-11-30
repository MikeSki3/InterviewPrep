package tutes.dp;

import java.util.Scanner;

public class NikitaGame {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for (int i = 0; i < cases; i++) {
			int n = in.nextInt();
			long[] arr = new long[n];
			for (int j = 0; j < n; j++) {
				arr[j] = in.nextLong();
			}
			findMaxScore(arr);
		}
	}

	private static void findMaxScore(long[] arr) {
//		int[][] memo = new int[arr.length][arr.length];
//		int min = Integer.MIN_VALUE;
//		for (int i = 0; i < memo.length; i++) {
//			for (int j = 0; j < memo[i].length; j++) {
//				memo[i][j] = min;
//			}
//		}
		int startI = 0;
		int endI = arr.length;
		int middle = 1;
		int score = 0;
		while (endI - startI >= 2 && middle < endI) {
			long leftSum = 0;
			long rightSum = 0;
//			if (memo[startI][middle - 1] != min)
//				leftSum = memo[startI][middle - 1];
//			else {
				for (int leftI = startI; leftI < middle; leftI++) {
					leftSum += arr[leftI];
//					memo[leftI][middle] = leftSum;
				}
//			}
//			if (memo[middle][endI - 1] != min)
//				rightSum = memo[middle][endI - 1];
//			else {
				for (int rightI = middle; rightI < endI; rightI++) {
					rightSum += arr[rightI];
//					memo[middle][rightI] = rightSum;
				}
//			}
			if (leftSum == rightSum) {
				score++;
				if (middle - startI < endI - middle)
					startI = middle;
				else
					endI = middle;
				middle = startI + 1;
			} else {
				middle++;
			}
		}
		System.out.println(score);
	}

}
