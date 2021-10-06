import java.util.PriorityQueue;

public class Prg_Level3_셔틀버스 {

	public static void main(String[] args) {
		int n = 1;
		int t = 1;
		int m = 1;
		String[] timetable = {"09:00", "09:05"};
		System.out.println(solution(n, t, m, timetable));
	}
	
	public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        PriorityQueue<Time> pq = new PriorityQueue<>();
        for(int i = 0; i < timetable.length; i++) {
        	String[] hm = timetable[i].split(":");
        	int hour = Integer.parseInt(hm[0]);
        	int minute = Integer.parseInt(hm[1]);
        	pq.add(new Time(hour, minute));
        }
        
        int sh = 9;
        int sm = 0;
        int ah = 9;
        int am = 0;
        while(true) {
    		for(int i = 0; i < m; i++) {
    			if(pq.isEmpty()) {
    				ah = sh;
    	        	am = sm;
    	        	break;
    			}
        		Time time = pq.peek();
        		if(time.h > sh) break;
        		if(time.h == sh) {
        			if(time.m > sm) break;
        		}
        		pq.poll();
        		ah = time.h;
        		am = time.m - 1;
        		if(am < 0) {
        			--ah;
        			am = 59;
        		}
        	}
        	
        	if(--n == 0) break;
        	
        	sm += t;
        	if(sm >= 60) {
        		++sh;
        		sm %= 60;
        	}
        	ah = sh;
        	am = sm;
        }
        answer = getTimeString(ah, am);
        return answer;
    }
	
	private static String getTimeString(int h, int m) {
		String time = "";
		if(h < 10) {
			time += "0";
		}
		time += h + ":";
		if(m < 10) {
			time += "0";
		}
		time += m;
		return time;
	}
	
	static class Time implements Comparable<Time> {
		int h, m;
		
		public Time(int h, int m) {
			this.h = h;
			this.m = m;
		}

		@Override
		public int compareTo(Time o) {
			if(this.h == o.h) {
				return Integer.compare(this.m, o.m);
			}
			return Integer.compare(this.h, o.h);
		}
	}
}
