package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549_G5_숨바꼭질3 {
	static int minTime;
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
	}
	
	private static void bfs() {
		Queue<Position> q = new LinkedList<Position>();
		q.add(new Position(N, 0));
		while(!q.isEmpty()) {
			Position p = q.poll();
			int curPos = p.pos;
			int curStep = p.step;
			visited[curPos] = true;
			/*
			// 1번
			if(curPos == K && curStep < minTime) {
				minTime = curStep;
				continue;
			}
			 */
			// 2번
			if(curPos == K) {
				minTime = curStep;
				return;
			}
			// * 2 를 먼저 queue에 넣고 2번으로하면 실행속도가 빨라진다.
			int nextPos = curPos * 2;
			if(nextPos <= 100000 && !visited[nextPos]) {
				q.add(new Position(nextPos, curStep));
			}
			nextPos = curPos - 1;
			if(nextPos >= 0 && !visited[nextPos]) {
				q.add(new Position(nextPos, curStep+1));
			}
			nextPos = curPos + 1;
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
