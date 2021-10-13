/*
 * 참고 : https://velog.io/@dolarge/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%82%BC%EA%B0%81%EB%8B%AC%ED%8C%BD%EC%9D%B4
 */

public class Prg_Level2_삼각달팽이 {

	public static void main(String[] args) {
		int[] answer = solution(4);
		for(int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}
	
	public static int[] solution(int n) {
        int[] answer = new int[n*(n+1) / 2];
        int[][] map = new int[n][n];
        int r = -1; int c = 0;
        int num = 1;
        for(int i = n; i > 0; i-=3) {
        	for(int j = 0; j < i; j++) {
        		map[++r][c] = num++;
        	}
        	for(int j = 0; j < i-1; j++) {
        		map[r][++c] = num++;
        	}
        	for(int j = 0; j < i-2; j++) {
        		map[--r][--c] = num++;
        	}
        }
        
        int idx = 0;
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j <= i; j++) {
        		answer[idx++] = map[i][j];
        	}
        }
        
        return answer;
    }
}
