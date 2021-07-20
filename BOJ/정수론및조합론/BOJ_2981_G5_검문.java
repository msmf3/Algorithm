package 정수론및조합론;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

/*
 * 참고 : https://st-lab.tistory.com/155
 */

public class BOJ_2981_G5_검문 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int g = Math.abs(arr[0] - arr[1]);
		for(int i = 1; i < N; i++) {
			g = gcd(g, Math.abs(arr[i] - arr[i-1]));
		}
		// arr[i] arr[i-2] 는 왜 안해도 되는지 반례를 생각해봤으나 안나옴
		// 필터링 되는 개념이기 때문에 arr[i] arr[i-1]만 해도 되는듯
		/*  생각해본 반례
		 *  7 22 52
			 15 30
			
			22 7 52
			 15 45
			
			52 22 7
			 30 15
		 */
		ArrayList<Integer> ansList = new ArrayList<>();
		ansList.add(g);
		for(int i = 2; i * i <= g; i++) {
			if(i * i == g) {
				ansList.add(i);
			}
			else if(g % i == 0) {
				ansList.add(i);
				ansList.add(g / i);
			}
		}
		Collections.sort(ansList);
		for(int i = 0; i < ansList.size(); i++) {
			bw.write(ansList.get(i) + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static int gcd(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		
		return a;
	}

}
