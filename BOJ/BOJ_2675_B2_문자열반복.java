import java.util.Scanner;

public class BOJ_2675_B2_문자열반복 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int R = sc.nextInt();
			String S = sc.next();
			for(int i = 0; i < S.length(); i++) {
				for(int j = 0; j < R; j++) {
					System.out.print(S.charAt(i));
				}
			}
			System.out.println();
		}
	}

}
