package 힙;

import java.util.Collections;
import java.util.PriorityQueue;

public class Prg_Level3_이중우선순위큐 {

	public static void main(String[] args) {
		String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		int[] answer = solution(operations);
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
	
	public static int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> pqAsc = new PriorityQueue<>();
        PriorityQueue<Integer> pqDesc = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < operations.length; i++) {
        	// pq = heap
        	String[] command = operations[i].split(" ");
        	String oper = command[0];
        	int num = Integer.parseInt(command[1]);
        	if(oper.equals("I")) {
        		// 삽입연산 : log 2 n
        		pqAsc.add(num);
            	pqDesc.add(num);
        	} 
        	else {
        		if(num == 1) {
        			// 삭제연산 : log 2 n
        			if(!pqDesc.isEmpty()) {
        				int max = pqDesc.poll();
            			pqAsc.remove(max);
        			}
        		}
        		else {
        			if(!pqAsc.isEmpty()) {
        				int min = pqAsc.poll();
        				pqDesc.remove(min);
        			}
        		}
        	}
        }
        
        if(pqDesc.isEmpty()) {
        	answer[0] = answer[1] = 0;
        	return answer;
        }
        answer[0] = pqDesc.peek();
        answer[1] = pqAsc.peek();
        return answer;
    }
}
