package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20056_G4_마법사상어와파이어볼 {
	static int N, M, K;
	static int map[][];
	static int ans; // 남아있는 파이어볼 질량의 합
	static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};
	static Map<Integer, Queue<FireBall>> fbMap;
	static Map<Integer, Queue<FireBall>> nxt_fbMap;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		fbMap = new HashMap<Integer, Queue<FireBall>>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			Queue<FireBall> q = new LinkedList<>();
			q.add(new FireBall(m, s, d));
			fbMap.put(r*N + c, q);
		}
		
		while(K > 0) {
			ans = 0;
			--K;
			// 이동된 fireball이 저장된 map
			nxt_fbMap = new HashMap<Integer, Queue<FireBall>>();
			// 1단계
			move();
			
			fbMap = new HashMap<Integer, Queue<FireBall>>();
			// 2단계
			for(Map.Entry<Integer, Queue<FireBall>> entry : nxt_fbMap.entrySet()) {
				Queue<FireBall> fbq = entry.getValue();
				int pos = entry.getKey();
				
				if(fbq.size() > 1) {
					// 2-1. 같은 위치에 Fb이 2개 이상 있는 경우
					// 하나로 합쳐진다
					divFireBall(pos, fbq);
				}
				else {
					FireBall fb = fbq.poll();
					Queue<FireBall> q = new LinkedList<>();
					q.add(fb);
					fbMap.put(pos, q);
					
					ans += fb.m;
				}
			}
			
		}
		
		System.out.println(ans);
	}
	
	static private void move() {
		for(Map.Entry<Integer, Queue<FireBall>> entry : fbMap.entrySet()) {
			Queue<FireBall> fbq = entry.getValue();
			int pos = entry.getKey();
			int r = pos / N;
			int c = pos % N;
			
			while(!fbq.isEmpty()) {
				FireBall fb = fbq.poll();
				
				int nr = r + dr[fb.d] * fb.s;
				int nc = c + dc[fb.d] * fb.s;
				
				nr %= N;
				nc %= N;
				if(nr < 0) nr += N;
				if(nc < 0) nc += N;
				
				int newPos = nr*N + nc;
				if(nxt_fbMap.containsKey(newPos)) {
					// 해당 위치에 Fireball 이 존재하는 경우 Queue에 추가
					nxt_fbMap.get(newPos).add(fb);
				}
				else {
					// 해당 위치에 FireBall이 없는 경우 새로운 Queue를 만들어서 put
					Queue<FireBall> q = new LinkedList<>();
					q.add(fb);
					nxt_fbMap.put(newPos, q);
				}
				
			}
		}
	}
	
	static private void divFireBall(int pos, Queue<FireBall> fbq) {
		int sumM = 0; int sumS = 0;
		int cnt = fbq.size();
		// 합쳐지는 파이어볼의 방향이 모두 홀수이거나 짝수인지 확인
		boolean isAllEven = true; boolean isAllOdd = true;
		
		while(!fbq.isEmpty()) {
			FireBall fb = fbq.poll();
			sumM += fb.m;
			sumS += fb.s;
			if(fb.d % 2 == 0) {
				isAllOdd = false;
			}
			else {
				isAllEven = false;
			}
		}
		
		// 새로운 4개의 FireBall을 생성
		int newM = sumM / 5; int newS = sumS / cnt;
		if(newM == 0) return;
		
		Queue<FireBall> q = new LinkedList<>();
		for(int k = 0; k < 4; k++) {
			if(isAllEven || isAllOdd) {
				q.add(new FireBall(newM, newS, k*2));
			}
			else {
				q.add(new FireBall(newM, newS, k*2 + 1));
			}
		}
		fbMap.put(pos, q);
		ans += newM * 4;
	}
	
	static class FireBall {
		// 질량 : m, 속도 : s, 방향 : d
		int m, s, d;
		
		public FireBall(int m, int s, int d) {
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

}
