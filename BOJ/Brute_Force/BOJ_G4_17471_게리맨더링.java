package Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_G4_17471_게리맨더링 {
	static int N, population[], sum, aSum, ans;
	static boolean matrix[][], visited[], check[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		population = new int[N];
		matrix = new boolean[N][N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			sum += population[i];
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for(int j = 0; j < M; j++) {
				int v = Integer.parseInt(st.nextToken());
				matrix[i][v-1] = true;
			}
		}
		
		ans = Integer.MAX_VALUE;
		subset(0);
		if(ans == Integer.MAX_VALUE) {
			ans = -1;
		}
		System.out.print(ans);
	}
	
	private static void subset(int idx) {
		if(idx == N) {
			aSum = 0;
			if(isConnect()) {
				ans = Math.min(Math.abs(2*aSum - sum), ans);
			}
			return;
		}
		
		visited[idx] = false;
		subset(idx+1);
		
		visited[idx] = true;
		subset(idx+1);
	}
	
	private static boolean isConnect() {
		ArrayList<Integer> aList = new ArrayList<Integer>();
		ArrayList<Integer> bList = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			if(visited[i]) {
				aList.add(i);
				aSum += population[i];
			}else {
				bList.add(i);
			}
		}
		
		if(aSum == 0 || aSum == sum) return false;
		
		check = new boolean[N];
		dfs(aList, aList.size(), aList.get(0));
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(check[i]) ++cnt;
		}
		if(cnt != aList.size()) return false;
		
		check = new boolean[N];
		dfs(bList, bList.size(), bList.get(0));
		cnt = 0;
		for(int i = 0; i < N; i++) {
			if(check[i]) ++cnt;
		}
		if(cnt != bList.size()) return false;
		
		return true;
	}
	
	private static void dfs(ArrayList<Integer> list, int size, int cur) {
		check[cur] = true;
		
		for(int i = 0; i < size; i++) {
			int idx = list.get(i);
			if(check[idx] || !matrix[cur][idx]) continue;
			dfs(list, size, idx);
		}
	}
}
