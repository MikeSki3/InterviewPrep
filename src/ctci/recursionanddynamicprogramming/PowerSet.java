package ctci.recursionanddynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


//TAKEN FROM DA BOOK
public class PowerSet {

	public static void main(String[] args) {
		ArrayList<Integer> set2 = new ArrayList<>();
		set2.add(1); set2.add(2); set2.add(3);
		System.out.println(getSubsets(set2, 0));
	}
	
	static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> allSubsets;
		if(set.size() == index) {
			allSubsets = new ArrayList<ArrayList<Integer>>();
			allSubsets.add(new ArrayList<Integer>());
		} else {
			allSubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allSubsets){
				ArrayList<Integer> newsubset = new ArrayList<>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allSubsets.addAll(moresubsets);;
		}
		return allSubsets;
	}

}
