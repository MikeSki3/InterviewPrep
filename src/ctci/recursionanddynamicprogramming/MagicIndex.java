package ctci.recursionanddynamicprogramming;

public class MagicIndex {
	public static void main(String[] args) {
		int[] values = {-30, -27, -23, -20, -15, -12, -11, -9, -8, -2, 10, 10, 13, 17};
		System.out.println(hasMagicIndex(values));
	}

	private static int hasMagicIndex(int[] values) {
		return findMagicIndex(values, values.length / 2, 0, values.length - 1);
	}

	private static int findMagicIndex(int[] values, int mid, int start, int end) {
		if(values[mid] == mid){
			return mid;
		}
		if(mid == start || mid == end)
			return -1;
		if(values[mid] > mid){
			return findMagicIndex(values, ((mid - start) / 2) + start, start, mid);
		} else {
			return findMagicIndex(values, ((end - mid) / 2) + mid, mid, end);
		}
	}
}
