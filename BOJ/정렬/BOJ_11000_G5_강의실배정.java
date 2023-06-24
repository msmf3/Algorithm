package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11000_G5_강의실배정 {
	static PriorityQueue<Lecture> lq;
	static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		lq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			lq.add(new Lecture(s, t));
		}
		
		pq = new PriorityQueue<>();
		pq.add(lq.poll().t);
		while(!lq.isEmpty()) {
			Lecture l = lq.poll();
			int prevT = pq.peek();
			int curS  = l.s;
			if(prevT <= curS) {
				pq.poll();
			}
			pq.add(l.t);
		}
		
		System.out.println(pq.size());
	}
	
	static class Lecture implements Comparable<Lecture> {
		int s, t;
		
		public Lecture(int s, int t) {
			this.s = s;
			this.t = t;
		}

		@Override
		public int compareTo(Lecture o) {
			if(s == o.s) {
				return Integer.compare(t, o.t);
			}
			return Integer.compare(s, o.s);
		}
	}
}
