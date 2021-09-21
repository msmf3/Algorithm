import java.util.Arrays;

/*
 * 참고 : https://eno1993.tistory.com/80
 */

public class Prg_Level3_GPS {

	public static void main(String[] args) {
		int[][] edge_list = {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}};
		int[] gps_log = {1, 2, 4, 6, 5, 7};
		System.out.println(solution(7, 10, edge_list, 6, gps_log));
	}
	
	public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int[][] graph = new int[n+1][n+1];
        for(int i = 0; i < m; i++) {
        	int u = edge_list[i][0];
        	int v = edge_list[i][1];
        	graph[u][v] = graph[v][u] = 1;
        }
        
        // dp[x][y] = x번째에 방문노드가 y인 경우 최소변경회수
        int[][] dp = new int[k][n+1];
        int INF = 101;
        for(int i = 0; i < k; i++) {
        	Arrays.fill(dp[i], INF);
        }
        dp[0][gps_log[0]] = 0;
        for(int i = 1; i < k; i++) {
        	for(int j = 1; j <= n; j++) {
        		// 이전노드 그대로 유지 ex) 3 -> 3
        		dp[i][j] = dp[i-1][j];
        		
        		// 이전노드에서 변경된 경우
        		for(int prev = 1; prev <= n; prev++) {
        			// 이전노드에서 길이 있는지 확인
        			if(graph[prev][j] == 1) {
        				dp[i][j] = Math.min(dp[i][j], dp[i-1][prev]);
        			}
        		}
        		
        		// 로그와 j가 다른 경우 로그를 수정해야 함
        		if(gps_log[i] != j) ++dp[i][j];
        	}
        }
        int answer = dp[k-1][gps_log[k-1]];
        if(answer >= INF) {
        	answer = -1;
        }
        return answer;
    }

}
