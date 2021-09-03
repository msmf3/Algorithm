package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 참고 : https://suhwanc.tistory.com/26
 */

public class BOJ_2263_G3_트리의순회 {
	static int in_order[], post_order[];
	static int in_idx[];
	static StringBuilder sb = new StringBuilder();
	// 후위 표기법에서 마지막에 나오는 수가 루트 노드이다.
	// 루트 노드 기준으로 왼쪽과 오른쪽으로 나뉘어진 노드들을 알기 위해
	// 루트 노드를 중위 표기법에서 몇 번째에 위치하는지 찾고
	// 이 과정을 분할 정복 방법을 통해 반복하면 전위 표기법으로 나타낼 수 있다.

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		in_order = new int[n];
		post_order = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			in_order[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			post_order[i] = Integer.parseInt(st.nextToken());
		}
		// 루트 노드가 중위 표기법에 몇 번째에 위치하는지 알기 위해
		// 중위 표기법의 idx를 담은 배열을 생성한다.
		in_idx = new int[n+1];
		for(int i = 0; i < n; i++) {
			in_idx[in_order[i]] = i;
		}
		solve(0, n-1, 0, n-1);
		System.out.println(sb.toString());
	}
	
	private static void solve(int in_start, int in_end, int post_start, int post_end) {
		if(in_start > in_end || post_start > post_end) return;
		
		int root = post_order[post_end];
		int root_idx = in_idx[root];
		sb.append(root + " ");
		// 루트노드 기준으로 좌측부터
		solve(in_start, root_idx-1, post_start, post_start + (root_idx - in_start) - 1);
		// 우측
		solve(root_idx+1, in_end, post_start + (root_idx - in_start), post_end-1);
	}
}
