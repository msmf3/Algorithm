/*
 * 참고 : https://redbinalgorithm.tistory.com/696
 * 참고 : https://bladejun.tistory.com/166
 */

public class Prg_Level3_금과은운반하기 {

	public static void main(String[] args) {
		
	}
	
	public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = (long) (10e9 * 10e5 * 2 * 2);
        int N = g.length;
        long start = 0; 
        // 시간의 최대값은 w = 1 일 때, 10e9(광물의 최대값) * 10e5(시간의최대값) * 2(금 왕복) * 2(은 왕복) 
        long end = (long) (10e9 * 10e5 * 2 * 2);
        while(start <= end) {
        	long mid = (start + end) / 2;
        	int gold_max = 0;
        	int silver_max = 0;
        	int add = 0;
        	
        	for(int i = 0; i < N; i++) {
        		int now_gold = g[i];
        		int now_silver = s[i];
        		int now_weight = w[i];
        		int now_time = t[i];
        		
        		// mid 시간에 왕복으로 이동할 수 있는 횟수
        		long move_cnt = mid / (now_time * 2);
        		
        		// 왕복으로 왔다갔다해도 편도로 갈 시간이 남는 경우 -> +1
        		if(mid % (now_time * 2) >= now_time) ++move_cnt;
        		
        		long maxMineralInMidTime = move_cnt * now_weight;
        		// i번째 도시가 갖고 있는 금이 광물을 나를 수 있는 양보다 작은 경우 도시의 금을 모두 더해줌
        		// 금이 더 많은 경우 mid 시간내에 최대로 금을 나름
        		gold_max += (now_gold < maxMineralInMidTime) ? now_gold : maxMineralInMidTime;
        		silver_max += (now_silver < maxMineralInMidTime) ? now_silver : maxMineralInMidTime;
        		add += (now_gold + now_silver < maxMineralInMidTime) ? now_gold + now_silver : maxMineralInMidTime;
        	}
        	
        	// 해당 시간에 조건을 만족
        	if(gold_max >= a && silver_max >= b && add >= a+b) {
        		// 더 짧은 시간내에 할 수 있는지 계속 찾아봄
        		end = mid - 1;
        		answer = Math.min(answer, mid);
        	}
        	// 시간이 부족
        	else {
        		// 더 긴 시간쪽으로 찾아봄
        		start = mid + 1;
        	}
        }
        
        // 시간 복잡도 : O(N * Log Tmax)
        // Tmax = (10e9 * 10e5 * 2 * 2)
        return answer;
    }
}
