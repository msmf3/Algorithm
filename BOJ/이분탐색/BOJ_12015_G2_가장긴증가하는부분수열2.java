package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 참고 : https://dragon-h.tistory.com/2
 */

public class BOJ_12015_G2_가장긴증가하는부분수열2 {
	static List<Integer> list;
	static int value;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList<>();
		list.add(0);
		for(int i = 0; i < N; i++) {
			value = Integer.parseInt(st.nextToken());
			int lastValue = list.get(list.size()-1);
			if(value > lastValue) {
				list.add(value);
			}
			else if(value < lastValue){
				binarySearch(0, list.size()-1);
			}
		}
		System.out.print(list.size()-1);
	}
	
	private static void binarySearch(int left, int right) {
		if(left >= right) {
			list.set(right, value);
			return;
		}
		int mid = (left + right) / 2;
		if(list.get(mid) < value) {
			binarySearch(mid+1, right);
		}
		else {
			binarySearch(left, mid);
		}
	}

}
