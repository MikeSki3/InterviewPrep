package ctci.sortingandsearching;

public class FindDuplicates {
	public static void main(String[] args) {
		int[] arr = {2, 1, 4, 1, 5, 32000, 32000};
		checkDups(arr);
		
	}
	
	private static void checkDups(int[] arr) {
		BitVector vect = new FindDuplicates().new BitVector();
		for(int curr : arr){
			if(!vect.setIndex(curr)){
				System.out.print(curr + " ");
			}
		}
	}

	class BitVector{
		int vector;
		
		public BitVector(){
			vector = 0;
		}
		
		public boolean setIndex(int i){
			int mask = 1 << i;
			boolean checkBit = (vector ^ mask) == (vector | mask);
			vector = vector | mask;
			return checkBit;
		}

		@Override
		public String toString() {
			return "BitVector [vector=" + Integer.toBinaryString(vector) + "]";
		}
	}
}
