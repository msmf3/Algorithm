package 분할정복;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10830_G4_행렬제곱 {
	static int N;
	static long mat[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		mat = new long[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				mat[i][j] = Long.parseLong(st.nextToken()) % 1000;
			}
		}
		
		long ans[][] = matrixPower(B);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				bw.write(ans[i][j] + " ");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	
	private static long[][] matrixPower(long b){
		if(b == 1) {
			return mat;
		}
		
		long matrix[][] = matrixPower(b/2);
		if(b % 2 == 0) {
			return product(matrix, matrix); 
		}
		else {
			return product(matrix, product(matrix, mat)); 
		}
		
	}

	private static long[][] product(long A[][], long B[][]) {
		long matrix[][] = new long[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				long tmp = 0;
				for(int k = 0; k < N; k++) {
					tmp += (A[i][k] * B[k][j]) % 1000;
				}
				matrix[i][j] = tmp % 1000;
			}
		}
		return matrix;
	}
	

}
