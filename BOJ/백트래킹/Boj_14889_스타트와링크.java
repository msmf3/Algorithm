import java.util.ArrayList;
import java.util.Scanner;

public class Boj_14889_스타트와링크 {
	static int N, ans, stat[][];
	static int numbers[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		stat = new int[N][N];
		numbers = new int[N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				stat[i][j] = sc.nextInt();
			}
		}
		ans = Integer.MAX_VALUE;
		
		combination(0, 0);
		
		System.out.print(ans);
		
		sc.close();
	}
	
	private static void combination(int cnt, int cur) {
		if(cnt == N/2){
			ArrayList<Integer> start = new ArrayList<Integer>();
			ArrayList<Integer> link = new ArrayList<Integer>();
			int idx = 0;
			for(int i = 0; i < N; i++) {
				if(idx < N/2 && numbers[idx] == i) {
					start.add(i);
					++idx;
				}else {
					link.add(i);
				}
			}
			int start_sum = 0, link_sum = 0;
			for(int i = 0; i < N/2 - 1; i++) {
				int startFi = start.get(i);
				for(int j = i+1; j < N/2; j++) {
					int startSi = start.get(j);
					start_sum += stat[startFi][startSi];
					start_sum += stat[startSi][startFi];
				}
			}
			for(int i = 0; i < N/2 - 1; i++) {
				int linkFi = link.get(i);
				for(int j = i+1; j < N/2; j++) {
					int linkSi = link.get(j);
					link_sum += stat[linkFi][linkSi];
					link_sum += stat[linkSi][linkFi];
				}
			}
			
			ans = Math.min(ans, Math.abs(start_sum - link_sum));
			return;
		}
		
		for(int i = cur; i < N; i++) {
			numbers[cnt] = i;
			combination(cnt+1, i+1);
		}
	}

}
