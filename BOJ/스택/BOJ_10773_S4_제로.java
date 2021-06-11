package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773_S4_제로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		for(int i = 0; i < K; i++) {
			int a = Integer.parseInt(br.readLine());
			if(a == 0 && !s.isEmpty()) {
				s.pop();
			}
			else if(a != 0) {
				s.add(a);
			}
		}
		int sum = 0;
		while(!s.isEmpty()) {
			sum += s.pop();
		}
		System.out.println(sum);
	}

}
