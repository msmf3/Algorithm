package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_4386_G4_별자리만들기_크루스칼 {
	static int N;
	static double minCost;
	static ArrayList<Point> stars;
	static int parents[];
	static ArrayList<Edge> edgeList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		stars = new ArrayList<>();
		parents = new int[N+1];
		edgeList = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			Point p1 = new Point(x, y);
			stars.add(p1);
			for(int j = 1; j < i; j++) {
				Point p2 = stars.get(j-1);
				double dist = getDistance(p1, p2);
				edgeList.add(new Edge(i, j, dist));
			}
		}
		minCost = 0;
		kruskal();
		System.out.print(String.format("%.2f", minCost));
	}
	
	private static void kruskal() {
		int cnt = 0;
		Collections.sort(edgeList);
		make();
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				minCost += edge.distance;
				if(++cnt == N-1) return;
			}
		}
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	private static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static void make() {
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	private static double getDistance(Point p1, Point p2) {
		double dist = Math.sqrt(Math.pow(p1.x-p2.x, 2) + Math.pow(p1.y-p2.y, 2));
		return dist;
	}
	
	static class Point {
		double x, y;
		
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int from, to;
		double distance;
		
		public Edge(int from, int to, double distance) {
			this.from = from;
			this.to = to;
			this.distance = distance;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(this.distance, o.distance);
		}
	}
}
