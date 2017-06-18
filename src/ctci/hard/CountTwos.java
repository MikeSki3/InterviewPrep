package ctci.hard;

public class CountTwos {
	public static void main(String[] args) {
		System.out.println(countTwosInRange(61523));
	}
	
	//ANSWER PROVIDED IN BOOK
	
	static int countTwosInRangeAtDigit (int number, int d){
		int powerOfTen = (int) Math.pow(10,  d);
		int nextPowerOfTen = powerOfTen * 10;
		int right = number % powerOfTen;
		
		int roundDown = number - number % nextPowerOfTen;
		int roundUp = roundDown + nextPowerOfTen;
		
		int digit = (number / powerOfTen) % 10;
		if(digit < 2) {
			return roundDown / 10;
		} else if (digit == 2) {
			return roundDown / 10 + right + 1;
		} else {
			return roundUp / 10;
		}
	}
	
	static int countTwosInRange (int number){
		int count = 0;
		int len = String.valueOf(number).length();
		for (int digit = 0; digit < len; digit++){
			count += countTwosInRangeAtDigit(number, digit);
		}
		return count;
	}
}
