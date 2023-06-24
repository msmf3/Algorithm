package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719_G5_빗물 {
	static int H, W, ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		int block[][] = new int[H+1][W+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < W; i++) {
			int h = Integer.parseInt(st.nextToken());
			for(int j = 0; j < h; j++) {
				block[H-j][i] = 1;
			}
		}
		
		ans = 0;
		for(int r = 0; r < H; r++) {
			int area = 0;
			boolean leftBlock = false;
			for(int c = 0; c < W; c++) {
				if(block[H-r][c] == 1) {
					leftBlock = true;
					ans += area;
					area = 0;
				}
				else if(block[H-r][c] == 0 && leftBlock) {
					area++;
				}
			}
		}
		
		System.out.println(ans);
	}

}
