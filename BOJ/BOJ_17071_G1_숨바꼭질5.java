import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_17071_G1_숨바꼭질5 {
	static int timeTable[][];
	static final int MAX = 500000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		// timeTable[홀수(1)or짝수(0)][0~500000 범위]
		timeTable = new int[2][500001];
		for(int a[]: timeTable) {
			Arrays.fill(a, -1);
		}
		record(N, 0);	// 수빈이의 기록을 timeTable 배열에 남겨놓음
		
		int time = 0, ans = -1;
		while(true) {
			if(K > MAX) {
				break;
			}
			if(timeTable[time%2][K] != -1 && timeTable[time%2][K] <= time) {
				// 수빈이가 홀수 or 짝수 시간에 방문할 수 있는 곳이고
				// 같은 홀수 or 짝수 시간에 수빈이가 먼저 도착한 경우
				ans = time;
				break;
			}
			K += ++time;
		}
		System.out.println(ans);
		sc.close();
	}
	
	private static void record(int n, int t) {
		Queue<Position> q = new LinkedList<Position>();
		q.offer(new Position(n, t));
		while(!q.isEmpty()) {
			Position p = q.poll();
			int pos = p.pos;
			int time = p.time;
			if(pos < 0 || pos > MAX) continue;			// 범위를 벗어난다면
			if(timeTable[time%2][pos] != -1) continue;	// 홀수 or 짝수 시간대에 이미 방문한 적이 있다면
			
			timeTable[time%2][pos] = time;
			
			q.offer(new Position(pos-1, time+1));
			q.offer(new Position(pos+1, time+1));
			q.offer(new Position(2*pos, time+1));
		}
	}
	
	static class Position {
		int pos;
		int time;
		
		public Position(int pos, int time) {
			this.pos = pos;
			this.time = time;
		}
	}

}
