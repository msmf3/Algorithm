package 기본;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10250_B3_ACM호텔 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int Y = N % H;
			int X = N / H + 1;
			if(Y == 0) {
				Y = H;
				X = N / H;
			}
			sb.append(String.format("%2d", Y).replace(" ", ""));
			sb.append(String.format("%2d\n", X).replace(" ", "0"));
		}
		System.out.print(sb.toString());
	}

}
