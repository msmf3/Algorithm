package 기본;

import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

public class BOJ_2775_B2_부녀회장이될테야 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int apart[][] = new int[15][15];
		for(int i = 1; i < 15; i++) {
			apart[0][i] = i;
		}
		for(int i = 1; i < 15; i++) {
			for(int j = 1; j < 15; j++) {
				apart[i][j] = apart[i-1][j] + apart[i][j-1];
			}
		}
		
		for(int tc = 1; tc <= T; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(apart[k][n] + "\n");
		}
		System.out.println(sb.toString());
	}

}
