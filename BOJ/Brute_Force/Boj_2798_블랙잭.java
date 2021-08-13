package Brute_Force;
import java.util.Arrays;
import java.util.Scanner;

public class Boj_2798_블랙잭 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N, M;
		N = sc.nextInt();
		M = sc.nextInt();
		int arr[] = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int max = 0;
		
		for(int i = 0; i < N-2; i++) {
			int sum = arr[i];
			for(int j = i+1; j < N-1; j++) {
				sum += arr[j];
				for(int k = j+1; k < N; k++) {
					sum += arr[k];
					if(sum <= M && max < sum) {
						max = sum;
					}
					sum -= arr[k];
				}
				sum -= arr[j];
			}
		}
		
		System.out.println(max);
		
		sc.close();
	}

}
