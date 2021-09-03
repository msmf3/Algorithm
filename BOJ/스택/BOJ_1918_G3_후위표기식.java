package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1918_G3_후위표기식 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String infix = br.readLine();
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			if('A' <= c && c <= 'Z') {
				sb.append(c);
			}
			else if(c == '(') {
				stack.add(c);
			}
			else if(c == ')') {
				// 괄호 안에 있는 모든 연산을 pop
				while(true) {
					char o = stack.pop();
					if(o == '(') break;
					sb.append(o);
				}
			}
			else if(c == '+' || c == '-'){
				// 연산자 우선순위가 높거나 같은 것을 pop
				// '('를 만나기 전까지 stack에 남아있는 모든 연산을 pop
				while(!stack.isEmpty()) {
					char o = stack.peek();
					if(o == '(') {
						break;
					}
					sb.append(o);
					stack.pop();
				}
				stack.add(c);
			}
			else {	// c == '*' || c == '/'
				// 연산자 우선순위가 높거나 같은 것을 pop
				// +, - 이면 break;
				while(!stack.isEmpty()) {
					char o = stack.peek();
					if(o == '(' || o == '+' || o == '-') {
						break;
					}
					sb.append(o);
					stack.pop();
				}
				stack.add(c);
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
	}

}
