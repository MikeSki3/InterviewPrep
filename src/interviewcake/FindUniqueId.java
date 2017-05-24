package interviewcake;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;


/*
 * This one was from interview cake and about drones delivering breakfast.
 * Naive solution works in O(n) time but takes up a little more space due
 * to the addition of a hashmap and a set.
 * 
 * Using the int field and XORing with it allows you to use constant space
 * because XORing values constantly with itself will result in duplicate
 * values canceling themselves out. Neat, huh?
 */
public class FindUniqueId {

	public static void main(String[] args) {
		int[] ids = generateIdArray();
		System.out.println(findUniqueId(ids));
	}

	private static Integer findUniqueId(int[] ids) {
		HashMap<Integer, Boolean> colls = new HashMap<>();
		int uniqueId = ids[0];
		int curr = ids[0];
		colls.put(curr, true);
		for(int i = 1; i < ids.length; i++){
			curr = ids[i];
			uniqueId = curr ^ uniqueId;
			if(!colls.containsKey(curr)){
				colls.put(curr, true);
			} else {
				colls.remove(curr);
			}
		}
		Set<Integer> keys = colls.keySet();
		
		return uniqueId;
//		return (Integer) keys.toArray()[0];
		
	}

	private static int[] generateIdArray() {
		Random rand = new Random();
		HashMap<Integer, Boolean> used = new HashMap<>();
		int unique = 121243;
		
		int[] ids = new int[99];
		for(int i = 0; i < 48; i++) {
			int value = rand.nextInt();
			while(used.containsKey(value) || value == unique){
				value = rand.nextInt();
			}
			used.put(value, true);
			ids[i] = value;
		}
		ids[49] = unique;
		for(int i = 0; i + 50 < ids.length; i++){
			ids[i + 50] = ids[i];
		}
		return ids;
	}

}
