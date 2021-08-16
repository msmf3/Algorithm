package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10775_G2_공항 {
	static int parents[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		parents = new int[G+1];
		for(int i = 1; i <= G; i++) {
			parents[i] = i;
		}
		int P = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int i = 0; i < P; i++) {
			int airplane = Integer.parseInt(br.readLine());
			int apRoot = find(airplane);
			if(apRoot == 0) {
				// gate에 자리가 없음 = airplane부터 1까지 채워져 있음
				break;
			}
			// N을 N-1에 union
			union(apRoot-1, apRoot);
			++cnt;
		}
		System.out.println(cnt);
	}
	
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
}
