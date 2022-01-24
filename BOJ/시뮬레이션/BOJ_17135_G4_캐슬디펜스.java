package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17135_G4_캐슬디펜스 {
	
	static int N, M, D, kill_cnt, ans = 0;
	static int map[][], tmp_map[][];
	static int numbers[] = new int[3];
	// 좌 상 우 우선순위 순으로 탐색
	static int dx[] = {-1, 0, 1};
	static int dy[] = {0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 행의 수
		M = Integer.parseInt(st.nextToken());	// 열의 수
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		tmp_map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 궁수 배치를 어떻게 할것인가? 궁수 배치 경우의 수 : 최대 15C3
		Combination(0, 0);
		// 궁수의 공격으로 제거할 수 있는 적의 최대 수를 구해야 함
		
		System.out.print(ans);
	}
	
	private static void Combination(int cur, int cnt) {		
		if(cnt == 3) {	// 3개의 열 인덱스를 뽑았다면
						// 궁수 배치 후 공격 시작
			Copy();		// map -> tmp_map  copy
			Game();
			return;
		}
		
		for(int i = cur; i < M; i++) {
			numbers[cnt] = i;
			Combination(cur+1, cnt+1);
		}
	}
	
	private static void Game() {
		int ranger1_col = numbers[0];
		int ranger2_col = numbers[1];
		int ranger3_col = numbers[2];
		
		kill_cnt = 0;
		int height = N;
		while(height > 0) {
			// 표적 정함
			// 궁수는 N열에 있음
			BFS(N, ranger1_col);
			BFS(N, ranger2_col);
			BFS(N, ranger3_col);
			// 공격
			Shoot();
			// 궁수의 공격이 끝나면 적이 이동
			Move();
			height--;
		}
		
		if(ans < kill_cnt) {
			ans = kill_cnt;
		}
	}
	
	private static void BFS(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c, 0));
		boolean bfs_flag = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			int pr = p.r;
			int pc = p.c;
			int pd = p.depth;
			if(pd >= D) {		// depth가 D 이상이면 더 탐색할 필요가 없음 break
				break;
			}
			
			for(int k = 0; k < 3; k++) {
				int nr = pr + dy[k];
				int nc = pc + dx[k];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				// 적을 만나기 전까지 거리가 D 이내에서 탐색해야하므로 조건 없이 일단 offer
				q.offer(new Point(nr, nc, pd+1));
				
				if(tmp_map[nr][nc] != 0) {	// 적을 찾았다면 더 탐색할 필요가 없음 break
					tmp_map[nr][nc] = 2;
					bfs_flag = false;
					break;
				}
				if(bfs_flag == false) break;
			}
			
			if(bfs_flag == false) break;
		}
	}
	
	
	private static void Shoot() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tmp_map[i][j] == 2) {	// 쏠 표적이라면
					tmp_map[i][j] = 0;		// 쏴서 죽임
					++kill_cnt;				// kill_cnt 1 증가시키기
				}
			}
		}
	}
	
	private static void Move() {	// 적 움직이는 함수
		
		for(int i = N-1; i >= 1; i--) {	// 밑으로 이동해야 하기 때문에 밑에서 부터 위의 행을 땡겨옴
			for(int j = 0; j < M; j++) {
				tmp_map[i][j] = tmp_map[i-1][j];
				tmp_map[i-1][j] = 0;
			}
		}	
	}
	
	private static void Copy() {	// 조합마다 처음 입력받은 map을 활용하기 위해
									// tmp_map에 map을 복사
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tmp_map[i][j] = map[i][j];
			}
		}
	}
	
	static class Point{
		// depth 멤버 변수를 이용해 D초과해서 BFS를 진행하지 않도록 해줌.
		int r, c, depth;
		
		Point(int r, int c, int depth){
			this.r = r;
			this.c = c;
			this.depth = depth;
		}
	}

}
