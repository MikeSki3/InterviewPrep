package ctci.linkedlists;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class RemoveDups {
	public static void main(String args[]) {
		List<String> data = new LinkedList<>();
		data = populateList(data);
		data = removeDuplicates(data);
		for (String curr : data) {
			System.out.println(curr);
		}
	}

	private static List<String> removeDuplicates(List<String> data) {
		int j = 1;
		for(int i = 0; i < data.size(); i++){
			String first = data.get(i);
			ListIterator<String> iterJ = data.listIterator(j);
			while (iterJ.hasNext()) {
				String second = iterJ.next();
				if(first.equals(second)){
					iterJ.remove();
				}
			}
			j++;
		}
		return data;
	}

	private static List<String> populateList(List<String> data) {
		data.add("magic");
		data.add("Mike");
		data.add("magic");
		data.add("ferret");
		data.add("Mike");
		data.add("lil bits");
		data.add("Mike");
		return data;
	}
}
