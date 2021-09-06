package 최단경로;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Prg_Level3_가장먼노드 {

	public static void main(String[] args) {
		int edge[][] = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution(6, edge));
	}
	
	static ArrayList<ArrayList<Integer>> graph;
	
	public static int solution(int n, int[][] edge) {
        int answer = 0;
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
        	graph.add(new ArrayList<>());
        }
        for(int i = 0; i < edge.length; i++) {
        	int a = edge[i][0];
        	int b = edge[i][1];
        	graph.get(a).add(b);
        	graph.get(b).add(a);
        }
        int maxDist = 0;
        Queue<Integer> q = new LinkedList<>(); 
		q.add(1);
		int dist[] = new int[n+1];
		while(!q.isEmpty()) {
			int cur = q.poll();
			ArrayList<Integer> list = graph.get(cur);
			for(int next : list) {
				if(dist[next] > 0) continue;
				dist[next] = dist[cur] + 1;
				q.add(next);
				maxDist = Math.max(maxDist, dist[next]);
			}
		}
        for(int i = 2; i <= n; i++) {
        	if(dist[i] == maxDist) {
        		++answer;
        	}
        }
        return answer;
    }
}
