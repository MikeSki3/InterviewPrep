package tutes.util.sort;

public class Bubble {
	public static int sort(int[] unsortedArray){
		int numSwapped = 0;
		for(int i = 0; i < unsortedArray.length; i++){
			for(int j = 0; j + 1 < unsortedArray.length; j++){
				if(unsortedArray[j] > unsortedArray[j + 1]){
					numSwapped++;
					swap(unsortedArray, j, j + 1);
				}
			}
		}
		return numSwapped;
	}

	private static void swap(int[] unsortedArray, int j, int i) {
		int temp = unsortedArray[j];
		unsortedArray[j] = unsortedArray[i];
		unsortedArray[i] = temp;
	}
}
