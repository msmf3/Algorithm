package 큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11866_S4_요세푸스문제0 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			q.add(i);
		}
		int arr[] = new int[N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < K-1; j++) {
				q.add(q.poll());
			}
			int num = q.poll();
			arr[i] = num;
		}
		sb.append("<");
		for(int i = 0; i < N-1; i++) {
			sb.append(arr[i] + ", ");
		}
		sb.append(arr[N-1] + ">");
		System.out.println(sb.toString());
	}

}
