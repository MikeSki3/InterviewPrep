package tutes;

import java.util.Scanner;

public class CoinChange {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        System.out.println(makeChange(n, coins));
	}

	private static long makeChange(int amt, int[] coins) {
		long DP[] = new long[amt + 1];
		DP[0] = 1L;
		for(int i = 0; i < coins.length; i++){
			int coin = coins[i];
			for(int j = coin; j < DP.length; j++){
				DP[j] += DP[j - coin];
			}
		}
		return DP[amt];
	}

}
