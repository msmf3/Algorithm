package 기본;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 참고 : https://st-lab.tistory.com/72
 */

public class BOJ_2839_B1_설탕배달 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		if(N == 4 || N == 7) {
			ans = -1;
		}
		else if(N % 5 == 0) {
			ans = N / 5;
		}
		else if(N % 5 == 1 || N % 5 == 3) {
			ans = N / 5 + 1;
		}
		else if(N % 5 == 2 || N % 5 == 4) {
			ans = N / 5 + 2;
		}
		
		System.out.println(ans);
	}

}
