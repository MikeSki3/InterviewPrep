package tutes;

import java.util.Arrays;
import java.util.Scanner;

public class LonelyInteger {

	public static void main(String[] args) {
//		System.out.println(200 & 3);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        int compare[] = new int[101];
        Arrays.fill(compare, -1);
        int lonelyInt = -1;
        for(int a_i=0; a_i < n; a_i++){
        	int curr = in.nextInt();
        	if(compare[curr] != curr) {
        		compare[curr] = curr;
        	} else {
        		compare[curr] = -1;
        	}
//            a[a_i] = in.nextInt();
        }
        for(int i = 0; i < compare.length; i++){
        	if(compare[i] != -1) {
        		lonelyInt = compare[i];
        		break;
        	}
        }
        System.out.println(lonelyInt);
	}
	
	public static int lonelyInteger(int[] a) {
	    int value = 0;

	    for (int i : a) {
	        value ^= i;
	    }
	    return value;
	}

}
