package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541_S2_잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String expression = br.readLine();
		String s[] = expression.split("-");
		int ans = 0;
		for(int i = 0; i < s.length; i++) {
			// 덧셈부터 계산
			String tmpEx[] = s[i].split("\\+");
			int sum = 0;
			for(int j = 0; j < tmpEx.length; j++) {
				sum += Integer.parseInt(tmpEx[j]); 
			}
			
			if(i == 0) {	// 초기값
				ans = sum;
			}
			else {
				ans -= sum;
			}
		}
		System.out.println(ans);
	}

}
