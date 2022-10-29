package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 참고 : https://kosaf04pyh.tistory.com/211
 */

public class BOJ_1722_G5_순열의순서 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int problem_no = Integer.parseInt(st.nextToken());
		
		long ans = 1;
		boolean[] check  = new boolean[N+1];
		long[] factorial = new long[N+1];
		factorial[0] = 1;
		for(int i = 1; i <= N; i++) {
			factorial[i] = factorial[i-1] * i;
		}
		switch(problem_no) {
		case 1:
			long k = Long.parseLong(st.nextToken());
			
			String ans_str = "";
			for(int i = 1; i <= N; i++) { // 자리수
				for(int j = 1; j <= N; j++) { // 자리수 안의 factorial
					if(check[j]) continue;
					// factorial이 k보다 작은 경우
					if(k > factorial[N-i]) {
						k -= factorial[N-i];
					}
					else {
						ans_str += j + " ";
						check[j] = true;
						break;
					}
				}
			}
			
			System.out.println(ans_str.substring(0, ans_str.length()-1));
			break;
		case 2:
			for(int i = 1; i <= N; i++) {
				int num = Integer.parseInt(st.nextToken());
				
				for(int j = 1; j < num; j++) {
					// check되지 않은 숫자들 중 경우의 수를 더해줌
					// ex) 3 * * * => 3(1,2) * * *(3!) => 2 * 3!
					// ex) 3 2 * * => 3 4(1,2) * *(2!) => 2 * 2!
					if(!check[j]) {
						ans += factorial[N-i];
					}
				}
				check[num] = true;
			}
			
			System.out.println(ans);
			break;
		}
	}

}
