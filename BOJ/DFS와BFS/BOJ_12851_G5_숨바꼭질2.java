package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851_G5_숨바꼭질2 {
	static int minTime, cases;
	static int N, K;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		minTime = Integer.MAX_VALUE;
		bfs();
		System.out.println(minTime);
		System.out.println(cases);
	}
	
	private static void bfs() {
		Queue<Position> q = new LinkedList<Position>();
		q.add(new Position(N, 0));
		while(!q.isEmpty()) {
			Position p = q.poll();
			int curPos = p.pos;
			// 여기서 방문처리를 하는 이유는 ex) 1 4 에서 
			// +1, *2 방문 중복처리를 하지 않기 위해서
			visited[curPos] = true;
			int curStep = p.step;
			if(curStep > minTime) continue;
			if(curPos == K) {
				minTime = curStep;
				++cases;
				continue;
			}
			int nextPos = curPos - 1;
			if(nextPos >= 0 && !visited[nextPos]) {
				q.add(new Position(nextPos, curStep+1));
			}
			nextPos = curPos + 1;
			if(nextPos <= 100000 && !visited[nextPos]) {
				q.add(new Position(nextPos, curStep+1));
			}
			nextPos = curPos * 2;
			if(nextPos <= 100000 && !visited[nextPos]) {
				q.add(new Position(nextPos, curStep+1));
			}
		}
	}
	
	static class Position {
		int pos, step;
		
		public Position(int pos, int step) {
			this.pos = pos;
			this.step = step;
		}
	}

}
