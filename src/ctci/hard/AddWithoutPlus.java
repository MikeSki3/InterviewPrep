package ctci.hard;

public class AddWithoutPlus {
	//this is way more difficult than it needs to be...dumbass...
	public static void main(String[] args) {
		System.out.println(add(3, 3));
	}

	private static String add(int a, int b) {
		String binA = reverse(Integer.toBinaryString(a));
		String binB = reverse(Integer.toBinaryString(b));
		String shortest, longest;
		boolean equal = false;
		if(binA.length() < binB.length()){
			shortest = binA;
			longest = binB;
		} else if(binA.length() > binB.length()){
			shortest = binB;
			longest = binA;
		} else {
			shortest = binA;
			longest = binB;
			equal = true;
		}
		StringBuilder sb = new StringBuilder();
		boolean carry = false;
		RetBit ret;
		int i;
		for(i = 0; i < shortest.length(); i++){
			ret = addBits(binA.charAt(i), binB.charAt(i), carry);
			carry = ret.carry;
			sb.append(ret);
		}
		
		if(!equal){
			while(i < longest.length()){
				ret = addBits(longest.charAt(i), '0', carry);
				carry = ret.carry;
				sb.append(ret);
				i++;
			}
		}
		if(carry)
			sb.append('1');
		return sb.reverse().toString();
	}

	private static String reverse(String curr) {
		StringBuilder sb = new StringBuilder(curr);
		return sb.reverse().toString();
	}

	private static RetBit addBits(char a, char b, boolean carry) {
		RetBit result = new AddWithoutPlus().new RetBit();
		if(threeOnes(a, b, carry)){
			result.setBit('1', true);
		} else if(twoOnes(a, b, carry)){
			result.setBit('0', true);
		} else if(oneOne(a, b, carry)){
			result.setBit('1', false);
		} else {
			result.setBit('0', false);
		}
		return result;
	}

	private static boolean oneOne(char a, char b, boolean carry) {
		return a == '1' || b == '1' || carry;
	}

	private static boolean twoOnes(char a, char b, boolean carry) {
		if(a == '1' && b == '1')
			return true;
		else if(a == '1' && carry)
			return true;
		else if(b == '1' && carry)
			return true;
		return false;
	}

	private static boolean threeOnes(char a, char b, boolean carry) {
		return (a == '1' && b == '1' && carry);
	}
	
	class RetBit {
		char bit;
		boolean carry;
		
		public void setBit(char bit, boolean carry){
			this.bit = bit;
			this.carry = carry;
		}

		@Override
		public String toString() {
			return String.valueOf(bit);
		}
		
		
	}
}
