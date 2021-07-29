package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2623_G2_음악프로그램 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		int in[] = new int[N+1];
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			for(int j = 0; j < cnt-1; j++) {
				int b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b);
				++in[b];
				a = b;
			}
		}
		// 위상정렬
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1; i <= N; i++) {
			if(in[i] == 0) {
				q.add(i);
				sb.append(i + "\n");
			}
		}
		while(!q.isEmpty()) {
			ArrayList<Integer> list = graph.get(q.poll());
			for(int i = 0; i < list.size(); i++) {
				int num = list.get(i);
				if(--in[num] == 0) {
					q.add(num);
					sb.append(num + "\n");
				}
			}
		}
		for(int i = 1; i <= N; i++) {
			// 사이클이 발생한 경우 in 배열이 다 비워지지 않음
			if(in[i] > 0) {
				sb = new StringBuilder();
				sb.append(0);
				break;
			}
		}
		System.out.print(sb.toString());
	}
}
