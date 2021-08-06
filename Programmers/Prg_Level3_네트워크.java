
public class Prg_Level3_네트워크 {
	static int N;
	static int networks[][];
	static boolean visited[];

	public static void main(String[] args) {
		
	}
	
	private static int solution(int n, int[][] computers) {
		int answer = 0;
		visited = new boolean[n];
		N = n;
		networks = computers;
		for(int i = 0; i < n; i++) {
			if(dfs(i)) {
				++answer;
			}
		}
		return answer;
	}
	
	private static boolean dfs(int start) {
		if(visited[start]) return false;
		
		visited[start] = true;
		
		for(int i = 0; i < N; i++) {
			if(networks[start][i] == 1) {
				dfs(i);
			}
		}
		
		return true;
	}
}
