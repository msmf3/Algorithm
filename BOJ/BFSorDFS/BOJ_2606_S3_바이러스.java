package BFSorDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_S3_바이러스 {
	static int N, ans;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean visited[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
//		graph = new ArrayList<ArrayList<Integer>>(N);
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		visited = new boolean[N];
		ans = 0;
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a-1).add(b-1);
			graph.get(b-1).add(a-1);
		}
		virusSpread();
		System.out.println(ans-1);
	}
	
	private static void virusSpread() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		visited[0] = true;
		while(!q.isEmpty()) {
			int t = q.poll();
			++ans;
			ArrayList<Integer> list = graph.get(t);
			for(int i = 0; i < list.size(); i++) {
				if(!visited[list.get(i)]) {
					q.add(list.get(i));
					visited[list.get(i)] = true;
				}
			}
		}
	}
}
