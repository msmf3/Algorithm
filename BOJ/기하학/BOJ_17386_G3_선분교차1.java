package 기하학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * CCW(Counter Clock Wise) : https://johoonday.tistory.com/102 
 * 코드 참고 : https://johoonday.tistory.com/103?category=901651
 */

public class BOJ_17386_G3_선분교차1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Dot A = new Dot(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		Dot B = new Dot(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		Dot C = new Dot(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		Dot D = new Dot(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		if(isCross(A, B, C, D)) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
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
	
	private static boolean isCross(Dot d1, Dot d2, Dot d3, Dot d4) {
		int ccw1 = CCW(d1, d2, d3) * CCW(d1, d2, d4);
		int ccw2 = CCW(d3, d4, d1) * CCW(d3, d4, d2);
		// ccw1, ccw2 둘다 시계(-1) 반시계(1) 방향인 경우
		// 교차하는거라고 볼 수 있음
		return (ccw1 < 0) && (ccw2 < 0);
	}
	
	static class Dot {
		long x, y;
		
		public Dot(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
}
