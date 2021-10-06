import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Prg_Level2_전력망을둘로나누기 {

	public static void main(String[] args) {
		int n = 9;
		int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
		System.out.println(solution(n, wires));
	}
	
	static ArrayList<ArrayList<Integer>> graph;
	
	public static int solution(int n, int[][] wires) {
        int answer = 101;
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
        	graph.add(new ArrayList<>());
        }
        for(int i = 0; i < wires.length; i++) {
        	int u = wires[i][0];
        	int v = wires[i][1];
        	graph.get(u).add(v);
        	graph.get(v).add(u);
        }
        
        for(int i = 0; i < wires.length; i++) {
        	int u = wires[i][0];
        	int v = wires[i][1];
        	graph.get(u).remove((Integer)v);
        	graph.get(v).remove((Integer)u);
        	int uSize = getTreeSize(u, n);
        	int vSize = getTreeSize(v, n);
        	answer = Math.min(answer, Math.abs(uSize - vSize));
        	graph.get(u).add(v);
        	graph.get(v).add(u);
        }
        
        return answer;
    }
	
	private static int getTreeSize(int a, int n) {
		int size = 1;
		boolean[] visited = new boolean[n+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(a);
		visited[a] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			ArrayList<Integer> list = graph.get(cur);
			for(int i = 0; i < list.size(); i++) {
				int next = list.get(i);
				if(visited[next]) continue;
				visited[next] = true;
				q.add(next);
				++size;
			}
		}
		return size;
	}
}
