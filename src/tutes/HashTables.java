package tutes;

import java.util.Hashtable;
import java.util.Scanner;

public class HashTables {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Hashtable<String, Integer> magWords = new Hashtable<>();
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
            Integer currVal = magWords.get(magazine[magazine_i]);
            if(currVal == null){
            	magWords.put(magazine[magazine_i], 0);
            } else {
            	magWords.put(magazine[magazine_i], currVal++);
            }
        }
        String ransom[] = new String[n];
        
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
            
        }
	}

}
