package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9328_G1_열쇠 {
	static int h, w, key_bitset, ans;
	static ArrayList<Point> spList;
	static ArrayList<Door> doorList;
	static char map[][];
	static boolean visited[][];
	static boolean key_update;
	static Queue<Point> q;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			visited = new boolean[h][w];
			q = new LinkedList<>();
			spList = new ArrayList<>();
			doorList = new ArrayList<>();
			ans = 0;
			key_bitset = 0;
			
			for(int i = 0; i < h; i++) {
				String line = br.readLine();
				for(int j = 0; j < w; j++) {
					map[i][j] = line.charAt(j);
					if('A' <= map[i][j] && map[i][j] <= 'Z') {
						doorList.add(new Door(i, j, map[i][j] - 'A'));
					}
					if(i == 0 || j == 0 || i == h-1 || j == w-1) {
						if(map[i][j] == '$') {
							// 가장자리가 $인 경우 바로 ++ans
							++ans;
							map[i][j] = '.';
							spList.add(new Point(i, j));
						}
						else if(map[i][j] == '.') {
							// 시작점이 될 수 있는 지점
							spList.add(new Point(i, j));
						}
						else if('A' <= map[i][j] && map[i][j] <= 'Z') {
							spList.add(new Point(i,j));
						}
						else if('a' <= map[i][j] && map[i][j] <= 'z') {
							int num = map[i][j] - 'a';
							key_bitset |= (1 << num);
							map[i][j] = '.';
							spList.add(new Point(i, j));
						}
					}
				}
			}
			// bitset에 열쇠 추가
			String key = br.readLine();
			if(key != "0") {
				for(int i = 0; i < key.length(); i++) {
					int num = key.charAt(i) - 'a';
					key_bitset |= (1 << num);
				}
			}
			// 문들 중 시작점이 될 수 있는 경우 추가
			/*for(int i = 0; i < doorList.size(); i++) {
				Door door = doorList.get(i);
				if(door.r == 0 || door.c == 0 || door.r == h-1 || door.c == w-1) {
					if((key_bitset & (1 << door.num)) != 0) {
						spList.add(new Point(door.r, door.c));
					}
				}
			}*/
			key_update = true;
			// key를 획득한 상태가 달라진 경우 spList 다시 순회
			while(key_update) {
				key_update = false;
				visited = new boolean[h][w];
				// 시작점부터 bfs 실행
				for(int i = 0; i < spList.size(); i++) {
					Point sp = spList.get(i);
					if('A' <= map[sp.r][sp.c] && map[sp.r][sp.c] <= 'Z') {
						int num = map[sp.r][sp.c] - 'a';
						if((key_bitset & (1 << num)) == 0) {
							continue;
						}
					}
					bfs(sp);
				}
			}
			
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}
	
	private static void bfs(Point sp) {
		q.add(sp);
		visited[sp.r][sp.c] = true; 
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if(nr < 0 || h <= nr || nc < 0 || w <= nc) continue;
				if(visited[nr][nc] || map[nr][nc] == '*') continue;
				
				char c = map[nr][nc];
				if(c != '.') {	
					// 문서 or 열쇠 or 문을 만난 경우
					if(c == '$') {
						// 문서를 만난 경우
						++ans;
					}
					else if('A' <= c && c <= 'Z') {
						// 문을 만난 경우
						int door = c - 'A';
						if((key_bitset & (1 << door)) != 0) {
							// 해당 열쇠가 있는 경우
							map[nr][nc] = '.';
						}
						else {
							continue;
						}
					}
					else {
						// 열쇠를 만난 경우
						// 비트셋에 열쇠를 추가하고 기존에 못들어간 문을 확인
						key_update = true;
						int key = c - 'a';
						key_bitset |= (1 << key);
						for(int i = 0; i < doorList.size(); i++) {
							Door door = doorList.get(i);
							if(key == door.num) {
								map[door.r][door.c] = '.'; 
							}
						}
					}
					// 다시 체크하지 않도록 빈 공간으로 만듦
					map[nr][nc] = '.';
				}
				q.add(new Point(nr, nc));
				visited[nr][nc] = true;
			}
		}
	}
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static class Door {
		int r, c, num;
		
		public Door(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}
}
