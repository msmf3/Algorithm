package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949_S4_균형잡힌세상 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = br.readLine();
			if(s.equals(".")) System.exit(0);
			if(isBalance(s)) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
		}
	}
	
	private static boolean isBalance(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(' || c == '[') {
				stack.add(c);
			}
			else if(c == ')' || c == ']') {
				if(stack.isEmpty()) {
					return false;
				}
				if(c == ')') {
					if(stack.pop() != '(') {
						return false;
					}
				}
				else {
					if(stack.pop() != '[') {
						return false;
					}
				}
			}
		}
		if(!stack.isEmpty()) {
			return false;
		}
		return true;
	}

}
