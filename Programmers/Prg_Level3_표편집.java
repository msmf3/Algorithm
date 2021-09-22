import java.util.Collections;
import java.util.Stack;

/*
 * 참고 : https://moonsbeen.tistory.com/294
 */

public class Prg_Level3_표편집 {

	public static void main(String[] args) {
		String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
		System.out.println(solution(8, 2, cmd));
	}

	public static String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder(String.join("", Collections.nCopies(n, "O")));
        Stack<Node> deleteStack = new Stack<>();
        int[] nextNode = new int[n];
        int[] prevNode = new int[n];
        for(int i = 0; i < n; i++) {
        	nextNode[i] = i+1;
        	prevNode[i] = i-1;
        }
        nextNode[n-1] = -1;
        
        for(int i = 0; i < cmd.length; i++) {
        	String[] command = cmd[i].split(" ");
        	if(command[0].equals("C")) {
        		if(prevNode[k] != -1) nextNode[prevNode[k]] = nextNode[k];
        		if(nextNode[k] != -1) prevNode[nextNode[k]] = prevNode[k];
        		deleteStack.add(new Node(prevNode[k], k, nextNode[k]));
        		answer.setCharAt(k, 'X');
        		
        		// k 가 마지막 행인 경우 윗 행을 선택
        		if(nextNode[k] == -1) k = prevNode[k];
        		else k = nextNode[k];
        	}
        	else if(command[0].equals("Z")) {
        		Node node = deleteStack.pop();
        		if(node.prev != -1) nextNode[node.prev] = node.cur;
        		if(node.next != -1) prevNode[node.next] = node.cur;
        		answer.setCharAt(node.cur, 'O');
        	}
        	else if(command[0].equals("U")) {
        		int num = Integer.parseInt(command[1]);
        		int idx = 0;
        		while(idx++ < num) {
        			k = prevNode[k];
        		}
        	}
        	else {
        		int num = Integer.parseInt(command[1]);
        		int idx = 0;
        		while(idx++ < num) {
        			k = nextNode[k];
        		}
        	}
        }
        
        return answer.toString();
    }
	
	static class Node {
		int prev, cur, next;
		
		public Node(int prev, int cur, int next) {
			this.prev = prev;
			this.cur = cur;
			this.next = next;
		}
	}
}
