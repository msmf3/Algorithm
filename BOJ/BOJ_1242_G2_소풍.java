import java.util.Scanner;

public class BOJ_1242_G2_소풍 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N, K, M;
		N = sc.nextInt();
		K = sc.nextInt();
		M = sc.nextInt();
		int ans = 1;
		
		// 학생의 인덱스 : 1 ~ N
		// 다음 퇴장될 학생의 위치
		int next = K % N;
		if (next == 0) {	
			// 인덱스 범위가 1~N이므로 0번째를 N으로
			next = N;
		}
		
		while(true) {
			if(next == M) {
				// 퇴장할 학생의 위치가 동호의 위치랑 동일하면 break
				break;
			}
			// 퇴장한 학생의 위치로부터 동호의 순서를 다시 정해줌
			M -= next;
			if(M < 0) {	// M이 음수가 되면
				// 퇴장한 학생의 위치보다 뒤에 있는 것이므로
				// N을 더해 순서를 다시 정해줌
				M += N;
			}
			// 한명 제거
			--N;
			next = K % N;
			if (next == 0) {
				next = N;
			}
			
			++ans;
		}
		System.out.println(ans);
		
		sc.close();
	}

}
