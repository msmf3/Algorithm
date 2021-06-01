import java.util.Scanner;

public class BOJ_1065_S4_한수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			if(isHansoo(i)) {
				++ans;
			}
		}
		System.out.println(ans);
		sc.close();
	}
	
	private static boolean isHansoo(int a) {
		if(a / 100 == 0) {
			return true;
		}
		int prev_remain = a % 10;
		a /= 10;
		int diff = a % 10 - prev_remain;
		prev_remain = a % 10;
		while(a / 10 > 0) {
			a /= 10;
			int remain = a % 10;
			if(diff != remain - prev_remain) {
				return false;
			}
		}
		return true;
	}
}
