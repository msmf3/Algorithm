package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 참고 : https://dragon-h.tistory.com/35
 */

public class BOJ_14003_P5_가장긴증가하는부분수열5 {
	static int idx, num;
	static int arr[], idxArr[];
	static ArrayList<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		idxArr = new int[N];
		list = new ArrayList<>();
		list.add(Integer.MIN_VALUE);
		StringTokenizer st = new StringTokenizer(br.readLine());
		idx = 0;
		while(idx < N) {
			num = arr[idx] = Integer.parseInt(st.nextToken());
			int lastNum = list.get(list.size()-1);
			if(lastNum < arr[idx]) {
				list.add(arr[idx]);
				idxArr[idx] = list.size()-1;
			}
			else if(lastNum > arr[idx]) {
				binarySearch(0, list.size()-1);
			}
			++idx;
		}
		int maxLength = list.size()-1;
		sb.append(maxLength + "\n");
		Stack<Integer> stack = new Stack<>();
		int i = N-1;
		while(maxLength > 0 && i >= 0) {
			if(idxArr[i] == maxLength) {
				--maxLength;
				stack.push(arr[i]);
			}
			--i;
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
		System.out.print(sb.toString());
	}
	
	private static void binarySearch(int left, int right) {
		if(left >= right) {
			list.set(right, num);
			idxArr[idx] = right;
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
