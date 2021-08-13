package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1766_G2_문제집 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int in[] = new int[N+1];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph.get(A).add(B);
			++in[B];
		}
		// 가능하면 쉬운문제(숫자가 작은 것부터) -> 우선순위 큐
		// 위상정렬 + 우선순위 큐
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 1; i <= N; i++) {
			if(in[i] == 0) {
				pq.add(i);
			}
		}
		while(!pq.isEmpty()) {
			int a = pq.poll();
			sb.append(a + " ");
			ArrayList<Integer> list = graph.get(a);
			for(int i = 0; i < list.size(); i++) {
				int b = list.get(i);
				if(--in[b] == 0) {
					pq.add(b);
				}
			}
		}
		System.out.println(sb.toString());
	}

}
