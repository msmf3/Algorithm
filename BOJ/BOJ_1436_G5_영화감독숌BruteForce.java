import java.util.Scanner;

public class BOJ_1436_G5_영화감독숌BruteForce {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num = 666;
		while(true) {
			if(isEnd(num)) {
				--N;
			}
			if(N == 0) {
				break;
			}
			++num;
		}
		System.out.println(num);
		sc.close();
	}

	private static boolean isEnd(int num) {
		String s = Integer.toString(num);
		return s.contains("666");
	}

}
