package tutes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class SearchingForIceCream {

	static HashMap<Integer, LinkedList<Integer>> iceCreams;
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[n];
            iceCreams = new HashMap<>();
            for(int a_i=0; a_i < n; a_i++){
            	int curr = in.nextInt();
                a[a_i] = curr;
                addToHashMap(curr, a_i);
            }
            spendTheMoney(m, n);
        }
	}

	private static void spendTheMoney(int m, int n) {
		for(int i = 1; i <= m; i++){
			int partOne = i;
			int partTwo = m - i;
			if(iceCreams.get(partOne) != null && iceCreams.get(partTwo) != null){
				if((partOne == partTwo && iceCreams.get(partOne).size() >= 2) ||
						(partOne != partTwo)){
					printResults(iceCreams.get(partOne).poll(), iceCreams.get(partTwo).poll());
					break;
				}
			}
		}
	}

	private static void printResults(int partOne, int partTwo) {
		if(partOne < partTwo)
			System.out.println((partOne + 1) + " " + (partTwo + 1));
		else
			System.out.println((partTwo + 1) + " " + (partOne + 1));
	}

	private static void addToHashMap(int curr, int a_i) {
        if(iceCreams.get(curr) == null){
        	LinkedList<Integer> temp = new LinkedList<>();
        	temp.add(a_i);
        	iceCreams.put(curr, temp);
        } else {
        	iceCreams.get(curr).add(a_i);
        }		
	}

}
