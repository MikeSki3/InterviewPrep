package ctci.sortingandsearching;

public class SortedMerge {
	public static void main(String[] args) {
		int aSize = 5;
		int bSize = 5;
		
		int[] A = new int[aSize];
//		{5, 8, 9, 34}
		int[] B = {10};
		A[0] = 5;
		A[1] = 19;
		A[2] = 22;
		A[3] = 34;
		A = mergeSorted(A, B);
		printArray(A);
	}
	
	private static void printArray(int[] a) {
		for(int curr : a){
			System.out.print(curr + " ");
		}
	}

	private static int[] mergeSorted(int[] A, int[] B){
		int lengthA = (A.length - B.length);
		int ptrA = lengthA - 1;
		int ptrB = B.length - 1;
		int insertI = A.length - 1;
		while(ptrA >= 0 && ptrB >= 0){
			if(A[ptrA] > B[ptrB]){
				A[insertI--] = A[ptrA--];
			} else {
				A[insertI--] = B[ptrB--];
			}
		}
		if(ptrB >= 0){
			drainB(A, B, ptrB, insertI);
		}
		return A;
	}
	
	private static void drainB(int[] A, int[] B, int ptrB, int insertI){
		while(ptrB >= 0){
			A[insertI--] = B[ptrB--];
		}
	}
}
