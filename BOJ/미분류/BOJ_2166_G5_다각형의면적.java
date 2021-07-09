package 미분류;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 참고 : https://velog.io/@hammii/%EB%B0%B1%EC%A4%80-2166-%EB%8B%A4%EA%B0%81%ED%98%95%EC%9D%98-%EB%A9%B4%EC%A0%81-java
 */

public class BOJ_2166_G5_다각형의면적 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double ans = 0;
		ArrayList<Point> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			Point p = new Point(x, y);
			list.add(p);
		}
		list.add(list.get(0));
		double num1 = 0; double num2 = 0;
		for(int i = 0; i < N; i++) {
			Point p1 = list.get(i);
			Point p2 = list.get(i+1);
			num1 += p1.x * p2.y;
			num2 += p1.y * p2.x;
		}
		ans = Math.abs(num1 - num2) / 2;
		System.out.printf("%.1f", ans);
	}
	
	static class Point {
		double x, y;
		
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

}
