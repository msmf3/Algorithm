package 기하학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 그룹 개수, 최대 수 참고 : https://onecoke.tistory.com/entry/BOJ-%EB%B0%B1%EC%A4%80-2162-%EC%84%A0%EB%B6%84-%EA%B7%B8%EB%A3%B9-%EC%84%A0%EB%B6%84-%EA%B5%90%EC%B0%A8
 */

public class BOJ_2163_G1_선분 {
	static int N; // N <= 3000
	static ArrayList<Line> lines = new ArrayList<>();
	static Integer[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			lines.add(new Line(x1, y1, x2, y2));
		}
		
		parents = new Integer[N+1];
		make();
		
		for(int i = 0; i < lines.size(); i++) {
			for(int j = i+1; j < lines.size(); j++) {
				if( isCross(lines.get(i), lines.get(j)) ) {
					union(i+1, j+1);
				}
			}
		}
		
		int[] cnt = new int[N+1];
		int group_max_size = 0;
		int group_cnt = 0;
		for(int i = 1; i <= N; i++) {
			if(parents[i] == i) ++group_cnt;
			
			++cnt[find(i)]; 
			if(cnt[find(i)] > group_max_size) group_max_size = cnt[find(i)];
		}
		
		System.out.println(group_cnt);
		System.out.print(group_max_size);
	}
	
	private static boolean isCross(Line l1, Line l2) {
		// CCW 활용 (참고 : BOJ_17386_G3_선분교차1.java)
		// 선분 A-B, 점 C
		int ccw1 = CCW(new Dot(l1.x1, l1.y1), new Dot(l1.x2, l1.y2), new Dot(l2.x1, l2.y1));
		// 선분 A-B, 점 D
		int ccw2 = CCW(new Dot(l1.x1, l1.y1), new Dot(l1.x2, l1.y2), new Dot(l2.x2, l2.y2));
		
		// 선분 C-D, 점 A
		int ccw3 = CCW(new Dot(l2.x1, l2.y1), new Dot(l2.x2, l2.y2), new Dot(l1.x1, l1.y1));
		// 선분 C-D, 점 B
		int ccw4 = CCW(new Dot(l2.x1, l2.y1), new Dot(l2.x2, l2.y2), new Dot(l1.x2, l1.y2));
		
		return (ccw1 * ccw2 <= 0) && (ccw3 * ccw4 <= 0);
	}
	
	private static int CCW(Dot d1, Dot d2, Dot d3) {
		long temp = (d2.x - d1.x) * (d3.y - d1.y) - (d2.y - d1.y) * (d3.x - d1.x);
		if(temp > 0) {
			return 1;
		}
		else if(temp < 0) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	private static void make() {
		for(int i = 0; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		//find(b); // 그룹의 내 모든 root를 바꿈
		return true;
	}
	
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static class Line {
		int x1, y1, x2, y2;
		
		public Line(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
	
	static class Dot {
		long x, y;
		
		public Dot(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
}
