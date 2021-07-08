package 큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_5430_G5_AC {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			String command = br.readLine();
			int N = Integer.parseInt(br.readLine());
			Deque<Integer> dq = new LinkedList<Integer>();
			String line = br.readLine();
			String nums[] = line.substring(1, line.length()-1).split(",");
			for(int i = 0; i < N; i++) {
				dq.add(Integer.parseInt(nums[i]));
			}
			
			boolean reverse = false;
			boolean flag = false;
			a:for(int i = 0; i < command.length(); i++) {
				char c = command.charAt(i);
				switch(c) {
				case 'R':
					reverse = !(reverse);
					break;
				case 'D':
					if(dq.isEmpty()) {
						sb.append("error\n");
						flag = true;
						break a;
					}
					if(reverse) {
						dq.pollLast();
					}
					else {
						dq.pollFirst();
					}
					break;
				}
			}
			if(!flag) {
				sb.append("[");
				if(reverse) {
					while(!dq.isEmpty()) {
						if(dq.size() == 1) {
							sb.append(dq.pollLast());
						}
						else {
							sb.append(dq.pollLast() + ",");
						}
					}
				}
				else {
					while(!dq.isEmpty()) {
						if(dq.size() == 1) {
							sb.append(dq.pollFirst());
						}
						else {
							sb.append(dq.pollFirst() + ",");
						}
					}
				}
				sb.append("]\n");
			}
		}
		System.out.print(sb.toString());
	}
	
}
