package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Goorm_알고리즘먼데이4회_체크카드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int balance = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Queue<Integer> resv_queue = new LinkedList<Integer>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int amount = Integer.parseInt(st.nextToken());
			
			switch(command) {
			case "deposit":
				balance += amount;
				while(!resv_queue.isEmpty() && resv_queue.peek() <= balance) {
					balance -= resv_queue.poll();
				}
				break;
				
			case "pay":
				if(balance >= amount) {
					balance -= amount;
				}
				break;
				
			case "reservation":
				if(!resv_queue.isEmpty() || balance < amount) {
					resv_queue.add(amount);
				}
				else {
					balance -= amount;
				}
				break;
			}
		}
		
		System.out.println(balance);
	}

}
