import java.util.PriorityQueue;

public class Prg_Weekly6_복서정렬하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] weights = {50,82,75,120};
		String[] head2head = {"NLWL","WNLL","LWNW","WWLN"};
		int answer[] = solution(weights, head2head);
		for(int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}
	
	public static int[] solution(int[] weights, String[] head2head) {
        int[] answer;
        PriorityQueue<Boxer> pq = new PriorityQueue<>();
        for(int i = 0; i < head2head.length; i++) {
        	String record = head2head[i];
        	double win = 0, winRate = 0, total = 0;
        	int win2heavy = 0;
        	for(int j = 0; j < record.length(); j++) {
        		char c = record.charAt(j);
        		if(c == 'N') continue;
        		if(c == 'W') {
        			++win;
        			// 자신보다 몸무게가 높은 복서를 이긴경우
        			if(weights[i] < weights[j]) {
        				++win2heavy;
        			}
        		}
        		++total;
        	}
        	if(total != 0) {
        		winRate = 100 * win / total;
        	}
        	pq.add(new Boxer(i+1, weights[i], win2heavy, winRate));
        }
        
        answer = new int[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()) {
        	answer[idx++] = pq.poll().idx;
        }
        return answer;
    }
	
	static class Boxer implements Comparable<Boxer> {
		int idx, weight, win2heavy;
		double winRate;
		
		public Boxer(int idx, int weight, int win2heavy, double winRate) {
			this.idx = idx;
			this.weight = weight;
			this.win2heavy = win2heavy;
			this.winRate = winRate;
		}

		@Override
		public int compareTo(Boxer o) {
			if(winRate == o.winRate) {
				if(win2heavy == o.win2heavy) {
					if(weight == o.weight) {
						return Integer.compare(idx, o.idx);
					}
					return Integer.compare(o.weight, weight);
				}
				return Integer.compare(o.win2heavy, win2heavy);
			}
			return Double.compare(o.winRate, winRate);
		}
	}
}
