package tutes;

import java.util.Scanner;

import tutes.util.sort.Merge;

public class CountInversions {

	public static void main(String[] args) {
		int[] arr = {2, 1, 3, 1, 2};
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        for(int a0 = 0; a0 < t; a0++){
//            int n = in.nextInt();
//            int arr[] = new int[n];
//            for(int arr_i=0; arr_i < n; arr_i++){
//                arr[arr_i] = in.nextInt();
//            }
//        }
		long swaps = Merge.sort(arr);
		System.out.println("Swaps: " + swaps);
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}

}
