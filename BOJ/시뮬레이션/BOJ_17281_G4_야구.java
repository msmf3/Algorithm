package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17281_G4_야구 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] results = new int[N][9];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				results[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] player = new int[8];
		for(int i = 0; i < 8; i++) {
			player[i] = i+1;
		}
		
		int maxScore = 0;
		while(nextPermutation(player)) {
			ArrayList<Integer> battingOrder = new ArrayList<>();
			for(int i = 0; i < 3; i++) {
				battingOrder.add(player[i]);
			}
			battingOrder.add(0);
			for(int i = 3; i < 8; i++) {
				battingOrder.add(player[i]);
			}
			
			int[] base = new int[4];
			int score = 0;
			int hitterIdx = 8;
			int out = 0;
			for(int inning = 0; inning < N; inning++) {
				while(true) {
					hitterIdx = (hitterIdx+1) % 9;
					int hitter = battingOrder.get(hitterIdx);
					int r = results[inning][hitter];
					if(r == 0) {
						if(++out == 3) {
							out = 0;
							for(int i = 0; i < 3; i++) {
								base[i] = 0;
							}
							break;
						}
					}
					else {
						score += hit(base, r);
					}
				}
			}
			maxScore = Math.max(maxScore, score);
		}
		System.out.println(maxScore);
	}
	
	private static int hit(int[] base, int hitNum) {
		int score = 0;
		
		switch(hitNum) {
		case 1:
			for(int i = 2; i >= 0; i--) {
				if(base[i] == 1) {
					base[i+1] = 1;
					base[i] = 0;
				}
			}
			base[0] = 1;
			break;
		case 2:
			for(int i = 2; i >= 0; i--) {
				if(base[i] == 1) {
					if(i+2 >= 3) {
						base[3] += 1;
					}
					else {
						base[i+2] = 1;
					}
					base[i] = 0;
				}
			}
			base[1] = 1;
			break;
		case 3:
			for(int i = 2; i >= 0; i--) {
				if(base[i] == 1) {
					base[3] += 1;
					base[i] = 0;
				}
			}
			base[2] = 1;
			break;
		case 4:
			for(int i = 2; i >= 0; i--) {
				if(base[i] == 1) {
					base[3] += 1;
					base[i] = 0;
				}
			}
			base[3] += 1;
			break;
		}
		
		score += base[3];
		base[3] = 0;
		return score;
	}
	
	private static boolean nextPermutation(int[] arr) {
		int i = 7;
		
		while(i > 0 && arr[i-1] >= arr[i]) --i;
		
		if(i == 0) return false;
		
		int j = 7;
		
		while(arr[i-1] >= arr[j]) --j;
		
		swap(arr, i-1, j);
		
		j = 7;
		while(i < j) {
			swap(arr, i, j);
			++i; --j;
		}
		
		return true;
	}
	
	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
}
