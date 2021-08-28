package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 인접행렬 N제곱 : N번의 이동으로 x번 노드에서 출발하고 y로 돌아오는 경우의 수를 알 수 있음
 * ex) 2제곱의 (0,0) = 0행 X 0열, 0번에서 나가고 0번으로 들어오는 경우
 * 정보과학관을 0으로 두면 인접행렬 N제곱의 (0,0)을 구하면 된다.
 */

public class BOJ_12850_G1_본대산책2 {
	static long div = 1_000_000_007;
	static long graph[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int D = Integer.parseInt(br.readLine());
		graph = new long[8][8];
		graph[0][1] = graph[1][0] = 1;
		graph[0][2] = graph[2][0] = 1;
		graph[1][2] = graph[2][1] = 1;
		graph[1][3] = graph[3][1] = 1;
		graph[2][3] = graph[3][2] = 1;
		graph[2][4] = graph[4][2] = 1;
		graph[3][4] = graph[4][3] = 1;
		graph[3][5] = graph[5][3] = 1;
		graph[4][5] = graph[5][4] = 1;
		graph[4][6] = graph[6][4] = 1;
		graph[5][7] = graph[7][5] = 1;
		graph[6][7] = graph[7][6] = 1;
		
		graph = matPow(graph, D);
		System.out.println(graph[0][0]);
	}
	
	private static long[][] matMul(long A[][], long B[][]) {
		long result[][] = new long[8][8];
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				long sum = 0;
				for(int k = 0; k < 8; k++) {
					sum += A[i][k] * B[k][j];
					sum %= div;
				}
				result[i][j] = sum;
			}
		}
		return result;
	}
	
	private static long[][] matPow(long matrix[][], int N) {
		if(N == 1) {
			return graph;
		}
		long tmp[][] = matPow(matrix, N/2);
		if(N % 2 == 1) {
			tmp = matMul(tmp, tmp);
			return matMul(graph, tmp);
		}
		else {
			tmp = matMul(tmp, tmp);
			return tmp;
		}
	}
}
