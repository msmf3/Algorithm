package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 위상정렬을 이용하여 줄세우기

public class BOJ_2252_G2_줄세우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int in[] = new int[N+1];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			++in[b];
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1; i <= N; i++) {
			if(in[i] == 0) {
				q.add(i);
				sb.append(i + " ");
			}
		}
		while(!q.isEmpty()) {
			ArrayList<Integer> list = graph.get(q.poll());
			for(int i = 0; i < list.size(); i++) {
				int a = list.get(i);
				if(--in[a] == 0) {
					q.add(a);
					sb.append(a + " ");
				}
			}
		}
		System.out.println(sb.toString());
	}

}
