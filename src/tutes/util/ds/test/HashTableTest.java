package tutes.util.ds.test;

import java.util.Random;

import tutes.util.ds.HashTable;

public class HashTableTest {

	public static void main(String[] args) {
		HashTable<Integer, Integer> hash = new HashTable<>();
		Random rand = new Random();
		int oneOfDem = 12;
		for(int i = 0; i < 40000; i++){
			int key = rand.nextInt(30000);
			int value = rand.nextInt(50000);
			hash.put(key, value);
			oneOfDem = key;
		}
		
//		hash.put(3, 1);
//		hash.put(5, 3);
//		hash.put(5, 4);
//		hash.put(12, 2000);
		System.out.println(hash.get(oneOfDem));
		System.out.println(hash.getCollisionRatio());
	}

}
