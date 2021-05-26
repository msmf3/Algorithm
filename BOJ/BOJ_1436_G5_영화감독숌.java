import java.util.Scanner;

/*
 * 참고 사이트 : https://st-lab.tistory.com/103
 */

public class BOJ_1436_G5_영화감독숌 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N == 1) {
			System.out.println(666);
		}
		else {
			System.out.println(findNthEndNum(N));
		}
		sc.close();
	}
	
	private static int findNthEndNum(int n) {
		/*
		 * N <= 10,000 이고, 10,000번째 종말의 수는 2,666,799.
		 * 즉 7자리 수까지만 고려해서 설계
		 */
		int pre_digit = 0;
		int post_digit = 666;
		// post_digit 은 0, 600, 660, 666 의 경우의 수를 가진다.
		while(true) {
			System.out.println(pre_digit + " | " + post_digit);
			if(post_digit == 666 && pre_digit % 10 != 6) {	
				/*
				 * 끝자리가 666이면서 그 앞자리가 6이 아닌 경우
				 * ex) 12 | 666
				 */
				--n;
				if(n == 0) {
					return (pre_digit * 1000 + post_digit);
				}
				++pre_digit;
			}
			// 선수 판별 순서 중요
			else if(pre_digit % 1000 == 666) {
				/*
				 * 선수가 666으로 끝나는 경우
				 * ex) 1666 | 000
				 */
				post_digit = 0;
				for(int i = 0; i < 1000; i++) {
					System.out.println(pre_digit + " | " + post_digit);
					--n;
					if(n == 0) {
						return (pre_digit * 1000 + post_digit);
					}
					++post_digit;
				}
				++pre_digit;
				post_digit = 666;
			}
			
			else if(pre_digit % 100 == 66) {
				/*
				 * 선수가 66으로 끝나는 경우
				 * ex) 166 | 600
				 */
				post_digit = 600;
				for(int i = 0; i < 100; i++) {
					System.out.println(pre_digit + " | " + post_digit);
					--n;
					if(n == 0) {
						return (pre_digit * 1000 + post_digit);
					}
					++post_digit;
				}
				++pre_digit;
				post_digit = 666;
			}
			
			else if(pre_digit % 10 == 6) {
				/*
				 * 선수가 6으로 끝나는 경우
				 * ex) 126 | 660
				 */
				post_digit = 660;
				for(int i = 0; i < 10; i++) {
					System.out.println(pre_digit + " | " + post_digit);
					--n;
					if(n == 0) {
						return (pre_digit * 1000 + post_digit);
					}
					++post_digit;
				}
				++pre_digit;
				post_digit = 666;
			}
		}
	}
}
