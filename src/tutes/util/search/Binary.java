package tutes.util.search;

public class Binary {
	public static int findIndex(int value, int[] all){
		int left = 0;
		int right = all.length;
		int mid = (left + right) / 2;
		while(left <= right){
			if(all[mid] == value)
				return mid;
			else if(all[mid] < value){
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
}
