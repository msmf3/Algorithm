package 기본;

import java.util.Scanner;

/*
 * 참고 : https://st-lab.tistory.com/74
 */

public class BOJ_1193_B2_분수찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int x = 0; int y = 0;
		int prefix_sum = 0;	 // 누적합
		int cross_count = 1; // 대각선에 있는 분수들의 개수
		while(true) {
			prefix_sum += cross_count;
			if(X <= prefix_sum) {
				// 대각선에 X번째 분수가 포함됨.
				if(cross_count % 2 == 0) {
					// cross_count 가 짝수이면, 짝수번째 대각선
					// 이동하는 방향 : 왼쪽 아래
					x = 1 + (prefix_sum - X);
					y = cross_count - (prefix_sum - X);
					break;
				}
				else {
					// cross_count 가 홀수이면, 홀수번째 대각선
					// 이동하는 방향 : 오른쪽 위
					x = cross_count - (prefix_sum - X);
					y = 1 + (prefix_sum - X);
					break;
				}
			}
			++cross_count;
		}
		System.out.println(y + "/" + x);
		sc.close();
	}

}
