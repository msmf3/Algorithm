package 그래프;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Prg_Level3_합승택시요금 {

	public static void main(String[] args) {
		int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
		System.out.println(solution(6,4,6,2,fares));
	}
	
	static ArrayList<ArrayList<Edge>> graph;
	
	public static int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
        	graph.add(new ArrayList<>());
        }
        for(int i = 0; i < fares.length; i++) {
        	int u = fares[i][0];
        	int v = fares[i][1];
        	int cost = fares[i][2];
        	graph.get(u).add(new Edge(v, cost));
        	graph.get(v).add(new Edge(u, cost));
        }
        
        int[] minCost = dijkstra(n, s);
        int[] minCostA = dijkstra(n, a);
        int[] minCostB = dijkstra(n, b);
        // 합승하지 않은 경우 
        // 각자 최저 요금 경로를 구함
        int answer = minCost[a] + minCost[b];
        
        // 합승한 경우를 생각
        // i까지 합승한 경우를 다 계산해봄
        for(int i = 1; i <= n; i++) {
        	answer = Math.min(answer, minCost[i] + minCostA[i] + minCostB[i]);
        }
        return answer;
    }
	
	private static int[] dijkstra(int n, int start) {
		int[] minCost = new int[n+1];
		Arrays.fill(minCost, Integer.MAX_VALUE);
		minCost[start] = 0;
		boolean[] visited = new boolean[n+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			int cur = pq.poll().to;
			visited[cur] = true;
			ArrayList<Edge> list = graph.get(cur);
			
			for(Edge edge : list) {
				int next = edge.to;
				if(visited[next]) continue;
				if(minCost[cur] + edge.cost < minCost[next]) {
					minCost[next] = minCost[cur] + edge.cost;
					pq.add(new Edge(next, minCost[next]));
				}
			}
		}
		
		return minCost;
	}
	
	static class Edge implements Comparable<Edge> {
		int to, cost;
		
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(cost, o.cost);
		}
	}
}
