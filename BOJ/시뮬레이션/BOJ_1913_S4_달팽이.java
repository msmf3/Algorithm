package 시뮬레이션;

import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;

public class BOJ_1913_S4_달팽이 {
	static int[][] map;
	static int x, y, step, M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int pos = Integer.parseInt(br.readLine());
		map = new int[N][N];
		x = y = N/2;
		
		step = 1;
		map[y][x] = step;
		M = 2;
		while(x != 0 || y != 0) {
			moveSnail();
			M += 2;
		}
		
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		int px = 0; int py = 0;
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				if(map[i][j] == pos) {
//					px = j+1; py = i+1;
//				}
//				bw.write(map[i][j] + " ");
//			}
//			bw.write("\n");
//		}
//		bw.write(py + " " + px);
//		bw.flush();
//		bw.close();
//		br.close();
		StringBuilder sb = new StringBuilder();
		int px = 0; int py = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == pos) {
					px = j+1; py = i+1;
				}
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		sb.append(py).append(" ").append(px);
		System.out.println(sb.toString());
	}
	
	private static void moveSnail() {
		// 상 1칸 -> 우 (M-1)칸
		map[--y][x] = ++step;
		for(int i = 0; i < M-1; i++) {
			map[y][++x] = ++step;
		}
		
		// 하 M칸
		for(int i = 0; i < M; i++) {
			map[++y][x] = ++step;
		}
		
		// 좌 M칸
		for(int i = 0; i < M; i++) {
			map[y][--x] = ++step;
		}
		
		// 상 M칸
		for(int i = 0; i < M; i++) {
			map[--y][x] = ++step;
		}
	}

}
