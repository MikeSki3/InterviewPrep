package ctci.arraysstrings;

import java.util.Scanner;

public class Urlify {

	static String urlSpace = "%20";
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String inputString = in.nextLine();
		inputString = makeRoomyString(inputString);
		System.out.println(toUrl(inputString));
	}

	private static String makeRoomyString(String inputString) {
		StringBuilder sb = new StringBuilder(inputString);
		int count = 0;
		for(char curr : inputString.toCharArray()){
			if(curr == ' '){
				count += 2;
			}
		}
		for(int i = count; i > 0; i--){
			sb.append(' ');
		}
		return sb.toString();
	}

	private static char[] toUrl(String inputString) {
		char[] urlString = new char[inputString.toCharArray().length];
		char[] inputArr = inputString.toCharArray();
		for(int i = 0, j = 0; i < urlString.length; i++, j++){
			if(inputArr[j] == ' '){
				urlString[i++] = '%';
				urlString[i++] = '2';
				urlString[i] = '0';
			} else {
				urlString[i] = inputArr[j]; 
			}
		}
		
		return urlString;
	}

}
