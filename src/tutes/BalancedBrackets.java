package tutes;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

	public static boolean isBalanced(String expression) {
		Stack<Character> bunchOBrackets = new Stack<>();
		boolean matches = false;
		for (int i = 0; i < expression.length(); i++) {
			char curr = expression.charAt(i);
			if (curr == '{' || curr == '[' || curr == '(') {
				bunchOBrackets.push(curr);
			} else if(bunchOBrackets.size() > 0){
				char lastBracket = bunchOBrackets.pop();
				if((curr == '}' && lastBracket == '{') 
						|| (curr == ')' && lastBracket == '(') 
						|| (curr == ']' && lastBracket == '['))
					matches = true;
				else {
					matches = false;
					break;
				}
					
			}
		}
		if(bunchOBrackets.size() != 0)
			matches = false;
		return matches;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			boolean answer = isBalanced(expression);
			if (answer)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
