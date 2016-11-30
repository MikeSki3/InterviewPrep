package tutes.util.sort;

import java.util.Arrays;

public class Merge {
	
	public static long sort(int[] a){
		return sortAndMerge(Arrays.copyOf(a, a.length), a, 0, a.length);
	}

	private static long sortAndMerge(int[] a, int[] b, int begin, int end) {
		if(end - begin < 2)
			return 0;
		long result = 0;
		int middle = (end + begin) / 2;
		result += sortAndMerge(b, a, begin, middle);
		result += sortAndMerge(b, a, middle, end);
		result += merge(a, b, begin, middle, end);
		
		return result;
	}

	private static long merge(int[] a, int[] b, int begin, int middle, int end) {
		long invCount = 0;
		int leftPointer = begin, rightPointer = middle;
		for(int i = begin; i < end; i++){
			if(leftPointer < middle && (rightPointer >= end || a[leftPointer] <= a[rightPointer])){
				b[i] = a[leftPointer];
				leftPointer++;
			} else {
				if(a[leftPointer] > a[rightPointer]){
					invCount += middle - leftPointer;
				}
				b[i] = a[rightPointer];
				rightPointer++;
			}
		}
		return invCount;
	}
	
}
