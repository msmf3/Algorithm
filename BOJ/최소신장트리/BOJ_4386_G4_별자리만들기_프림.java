package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4386_G4_별자리만들기_프림 {
	static int N;
	static double minCost;
	static ArrayList<Point> stars;
	static boolean visited[];
	static ArrayList<ArrayList<Node>> graph;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		stars = new ArrayList<>();
		visited = new boolean[N+1];
		graph = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			Point p1 = new Point(x, y);
			stars.add(p1);
			for(int j = 1; j < i; j++) {
				Point p2 = stars.get(j-1);
				double dist = getDistance(p1, p2);
				graph.get(i).add(new Node(j, dist));
				graph.get(j).add(new Node(i, dist));
			}
		}
		minCost = 0;
		prim();
		System.out.print(String.format("%.2f", minCost));
	}
	
	private static void prim() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));
		while(!pq.isEmpty()) {
			Node edge = pq.poll();
			if(visited[edge.to]) continue;
			visited[edge.to] = true; 
			minCost += edge.distance;
			ArrayList<Node> list = graph.get(edge.to);
			for(Node next : list) {
				if(visited[next.to]) continue;
				pq.add(next);
			}
		}
	}
	
	private static double getDistance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.x-p2.x, 2) + Math.pow(p1.y-p2.y, 2));
	}
	
	static class Point {
		double x, y;
		
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Node implements Comparable<Node> {
		int to;
		double distance;
		
		public Node(int to, double distance) {
			this.to = to;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return Double.compare(this.distance, o.distance);
		}
	}
}
