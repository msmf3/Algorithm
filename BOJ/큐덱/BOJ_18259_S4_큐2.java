package 큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_18259_S4_큐2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			int num = 0;
			if(s.contains("push")) {
				String str[] = s.split(" ");
				s = str[0];
				num = Integer.parseInt(str[1]);
			}
			switch(s) {
			case "push":
				q.add(num);
				break;
			case "pop":
				if(!q.isEmpty()) {
					sb.append(q.poll() + "\n");
				}
				else {
					sb.append("-1\n");
				}
				break;
			case "size":
				sb.append(q.size() + "\n");
				break;
			case "empty":
				sb.append(q.isEmpty() ? 1 + "\n" : 0 + "\n");
				break;
			case "front":
				if(!q.isEmpty()) {
					sb.append(q.peek() + "\n");
				}
				else {
					sb.append("-1\n");
				}
				break;
			case "back":
				if(!q.isEmpty()) {
					sb.append(q.peekLast() + "\n");
				}
				else {
					sb.append("-1\n");
				}
				break;
			}
		}
		System.out.print(sb.toString());
	}

}
