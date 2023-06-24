package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 참고 : https://travelbeeee.tistory.com/433
 */

public class BOJ_1038_G5_감소하는수 {
	static ArrayList<String> ansArr;
	static boolean check[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ansArr = new ArrayList<String>();
		check = new boolean[10];
		int N = Integer.parseInt(br.readLine());
		if(N > 1022) {
			System.out.println(-1);
			return;
		}
		dfs(0);
		Collections.sort(ansArr, new StringComparator());
		System.out.println(ansArr.get(N+1));
	}
	
	private static void dfs(int idx) {
		String decNum = "";
		for(int i = 9; i >= 0; i--) {
			if(check[i]) decNum += i;
		}
		ansArr.add(decNum);
		
		
		for(int i = idx; i < 10; i++) {
			if(!check[i]) {
				check[i] = true;
				dfs(i+1);
				check[i] = false;
			}
		}
	}
	
	static class StringComparator implements Comparator<String> {
		@Override
		public int compare(String s1, String s2) {
			if(s1.length() == s2.length()) {
				for(int i = 0; i < s1.length(); i++) {
					int a1 = s1.charAt(i) - '0';
					int a2 = s2.charAt(i) - '0';
					if(a1 == a2) continue;
					return Integer.compare(a1, a2);
				}
			}
			return Integer.compare(s1.length(), s2.length());
		}
	}

}
