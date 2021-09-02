package 카카오본선_2017;

public class Prg_Level2_단체사진찍기_수정 {

	public static void main(String[] args) {
//		go(0, 0);
//		System.out.println(sb.toString());
		String data[] = {"N~F=0", "R~T>2"};
		System.out.println(solution(2, data));
	}
	static char friends[] = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	static char order[] = new char[8];
	static boolean visited[] = new boolean[8];
	static StringBuilder sb = new StringBuilder();
	static String global_data[];
	static int ans;
	
	public static int solution(int n, String[] data) {
        global_data = data;
        ans = 0;
        go(0, 0);
        return ans;
    }
	
	private static void go(int idx, int cnt) {
		if(cnt == 8) {
			if(check()) {
				++ans;
			}
			return;
		}
		for(int i = 0; i < 8; i++) {
			if(visited[i]) continue;
			order[idx] = friends[i];
			
			visited[i] = true;
			go(idx+1, cnt+1);
			visited[i] = false;
		}
	}
	
	private static boolean check() {
		String friends_order = new String(order);
		
		for(int i = 0; i < global_data.length; i++) {
			String cond = global_data[i];
			int aIdx = friends_order.indexOf(cond.charAt(0));
			int bIdx = friends_order.indexOf(cond.charAt(2));
			char c = cond.charAt(3);
			int interval_cond = cond.charAt(4) - '0';
			int interval_ab = Math.abs(aIdx-bIdx) - 1;
			switch(c) {
			case '=':
				if(interval_ab != interval_cond) {
					return false;
				}
				break;
			case '>':
				if(interval_ab <= interval_cond) {
					return false;
				}
				break;
			case '<':
				if(interval_ab >= interval_cond) {
					return false;
				}
				break;
			}
		}
		return true;
	}

}
