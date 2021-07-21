package 정수론및조합론;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_3036_S3_링 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N-1; i++) {
			int B = Integer.parseInt(st.nextToken());
			int gcd = getGCD(A, B);
			bw.write((A/gcd) + "/" + (B/gcd) + "\n"); 
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static int getGCD(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

}
