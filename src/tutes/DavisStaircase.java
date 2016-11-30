package tutes;

import java.util.HashMap;
import java.util.Scanner;

public class DavisStaircase {
	static HashMap<Integer, Integer> climbed = new HashMap<>();
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            System.out.println(climbPossibilities(n));
        }
	}

	private static int climbPossibilities(int n) {
		if(climbed.containsKey(n))
			return climbed.get(n);
		
		if(n < 0)
			return 0;
		if(n == 0)
			return 1;
		int value = climbPossibilities(n - 1) + climbPossibilities(n - 2) + climbPossibilities(n - 3);
		climbed.put(n, value);
		return value;
	}

}
