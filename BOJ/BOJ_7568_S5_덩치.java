import java.util.Scanner;

public class BOJ_7568_S5_덩치 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[][] = new int[N][2];
		int ranks[] = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			int rank = 1;
			int a_weight = arr[i][0];
			int a_height = arr[i][1];
			for(int j = 0; j < N; j++) {
				int b_weight = arr[j][0];
				int b_height = arr[j][1];
				if(a_weight < b_weight && a_height < b_height) {
					++rank;
				}
			}
			ranks[i] = rank;
		}
		
		for(int i = 0; i < N; i++) {
			System.out.print(ranks[i] + " ");
		}
		sc.close();
	}

}
