package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 참고 : https://jaimemin.tistory.com/760
 */

public class BOJ_1202_G2_보석도둑 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Diamond diamonds[] = new Diamond[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			diamonds[i] = new Diamond(m, v);
		}
		Arrays.sort(diamonds);
		int packs[] = new int[K];
		for(int i = 0; i < K; i++) {
			int c = Integer.parseInt(br.readLine());
			packs[i] = c;
		}
		Arrays.sort(packs);
		long value_sum = 0;
		int dIdx = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < K; i++) {	// 오름차순으로 정렬된 가방을 순서대로
			for(int j = dIdx; j < N; j++) {
				if(diamonds[j].weight <= packs[i]) {
					pq.add(diamonds[j].value);
					++dIdx;	// 이미 가방의 최대무게를 넘지 않는 보석은 다시 보지 않음. pq에 들어가 있음.
				}
				else {
					break;
				}
			}
			if(!pq.isEmpty()) {
				value_sum += pq.poll();
			}
		}
		System.out.println(value_sum);
	}
	
	static class Diamond implements Comparable<Diamond> {
		int weight, value;
		
		public Diamond(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}

		@Override
		public int compareTo(Diamond o) {
			return this.weight - o.weight;
		}
	}
}
