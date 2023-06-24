package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * dfs 사이클 탐색 : https://eazymean.tistory.com/113
 */

public class BOJ_2668_G5_숫자고르기 {
	static int[] graph;
	static ArrayList<Integer> ansArr;
	static int N;
	static int[] check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		check = new int[N+1];
		graph = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			int to = Integer.parseInt(br.readLine());
			graph[i] = to;
		}
		
		ansArr = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			if(check[i] != 2) {
				check(i, 1);
			}
		}
		
		Collections.sort(ansArr);
		System.out.println(ansArr.size());
		for(int a : ansArr) {
			System.out.println(a);
		}
		
	}
	
	private static void check(int cur, int c) {
		int next = graph[cur];
		
		if(c == 2) {
			if(check[cur] != 2) {
				check[cur] = 2;
				ansArr.add(cur);
				check(next, 2);
			}
			return;
		}
		
		if(check[next] == 1) { // 사이클 발견
			check(next, 2);
			return;
		}
		
		check[cur] = 1;
		if(check[next] != 2) {
			check(next, 1);
		}
		// 2인 경우는 사이클인 노드들
		if(check[cur] == 1) {
			check[cur] = 0;
		}
	}

}
