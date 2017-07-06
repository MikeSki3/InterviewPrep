package ctci.recursionanddynamicprogramming;

import java.util.ArrayList;

public class PermWithoutDups {

	public static void main(String[] args) {
		String test = "mike";
		System.out.println(getPermutations(test));
	}

	private static ArrayList<String> getPermutations(String test) {		
		return getPermsHelper(test, 0);
	}

	private static ArrayList<String> getPermsHelper(String test, int index) {
		if(index == test.length())
			return new ArrayList<String>();
		ArrayList<String> perms = getPermsHelper(test, index + 1);
		char curr = test.charAt(index);
		if(perms.isEmpty()) {
			perms.add(curr + "");
			return perms;
		}
		ArrayList<String> newPerms = new ArrayList<>();
		for(int j = 0; j < perms.size(); j++){
			String currPerm = perms.get(j);
			for(int i = 0; i < currPerm.length(); i++){
				String newPerm = currPerm.substring(0, i) + curr + currPerm.substring(i);
				newPerms.add(newPerm);
			}
			newPerms.add(currPerm + curr);
		}
		
		return newPerms;
	}

}
