package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_12738_G2_가장긴증가하는부분수열3 {
	static ArrayList<Integer> list;
	static int num;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList<>();
		list.add(Integer.MIN_VALUE);
		for(int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			int lastNum = list.get(list.size()-1);
			if(num < lastNum) {
				binarySearch(0, list.size());
			}
			else if(num > lastNum){
				list.add(num);
			}
		}
		System.out.print(list.size()-1);
	}
	
	private static void binarySearch(int left, int right) {
		if(left >= right) {
			list.set(right, num);
			return;
		}
		int mid = (left + right) / 2;
		if(list.get(mid) < num) {
			binarySearch(mid+1, right);
		}
		else {
			binarySearch(left, mid);
		}
	}

}
