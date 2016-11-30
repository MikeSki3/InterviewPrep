package tutes;

import java.util.Comparator;

public class Checker implements Comparator<Player> {

	@Override
	public int compare(Player arg0, Player arg1) {
		if (arg0.score > arg1.score)
			return -1;
		else if (arg0.score < arg1.score)
			return 1;
		else
			return sortByName(arg0.name, arg1.name);
	}

	private int sortByName(String arg0, String arg1) {
		if (arg0.length() < 1 && arg1.length() < 1) {
			return 0;
		} else if (arg0.length() < 1) {
			return -1;
		} else if (arg1.length() < 1) {
			return 1;
		} else if ((arg0.charAt(0) < arg1.charAt(0)))
			return -1;
		else if ((arg0.charAt(0) > arg1.charAt(0)))
			return 1;
		else
			return sortByName(arg0.substring(1), arg1.substring(1));
	}

}
