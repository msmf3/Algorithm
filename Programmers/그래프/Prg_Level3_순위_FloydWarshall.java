package 그래프;

import java.util.Arrays;

public class Prg_Level3_순위_FloydWarshall {

	public static void main(String[] args) {
//		int results[][] = {{1, 2}, {4, 5}, {3, 4}, {2, 3}};
		int results[][] = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		System.out.println(solution(5, results));
	}
	
	public static int solution(int n, int[][] results) {
        int answer = 0;
        boolean D[][] = new boolean[n+1][n+1];
        for(int i = 1; i <= n; i++) {
        	Arrays.fill(D[i], false);
        }
        
        for(int i = 0; i < results.length; i++) {
        	int w = results[i][0];
        	int l = results[i][1];
        	D[w][l] = true;
        }
        
        // 플로이드 워샬 알고리즘을 이용해 
        // a->b b->c 이면, a->c 의 경우를 구해줌
        for(int mid = 1; mid <= n; mid++) {
        	for(int start = 1; start <= n; start++) {
        		for(int end = 1; end <= n; end++) {
        			if(D[start][mid] && D[mid][end]) {
        				D[start][end] = true;
        			}
        		}
        	}
        }
        
        for(int i = 1; i <= n; i++) {
        	boolean flag = true;
        	for(int j = 1; j <= n; j++) {
        		if(i == j) continue;
        		if((D[i][j] || D[j][i]) == false) {
        			flag = false;
        			break;
        		}
        	}
        	if(flag) ++answer;
        }
        
        return answer;
    }
}
