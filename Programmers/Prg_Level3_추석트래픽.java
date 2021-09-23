import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Prg_Level3_추석트래픽 {
	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	public static void main(String[] args) throws ParseException {
		String[] lines = {
						"2016-09-15 20:59:57.421 0.351s",
						"2016-09-15 20:59:58.233 1.181s",
						"2016-09-15 20:59:58.299 0.8s",
						"2016-09-15 20:59:58.688 1.041s",
						"2016-09-15 20:59:59.591 1.412s",
						"2016-09-15 21:00:00.464 1.466s",
						"2016-09-15 21:00:00.741 1.581s",
						"2016-09-15 21:00:00.748 2.31s",
						"2016-09-15 21:00:00.966 0.381s",
						"2016-09-15 21:00:02.066 2.62s"
						};
		System.out.println(solution(lines));
	}
	
	public static int solution(String[] lines) throws ParseException {
        int answer = 0;
        int n = lines.length;
        Date requestTimes[] = new Date[n];
        Date responseTimes[] = new Date[n];
        
        for(int i = 0; i < lines.length; i++){
        	String[] l = lines[i].split(" ");
            Date responseTime = simpleDateFormat.parse(l[0]+" "+l[1]);
            double processingTime = Double.parseDouble(l[2].substring(0, l[2].length()-1));
            requestTimes[i] = calTime(responseTime, processingTime, true);
            responseTimes[i] = responseTime;
        }
        
        for(int i = 0; i < n; i++) {
        	long sectionStart = responseTimes[i].getTime();
        	long sectionEnd = sectionStart + 1000;
        	int cnt = 1;
        	for(int j = i+1; j < n; j++) {
        		long requestTime = requestTimes[j].getTime();
        		long responseTime = responseTimes[j].getTime();
        		if(sectionStart <= requestTime && requestTime < sectionEnd) {
        			++cnt;
        		}
        		else if(sectionStart <= responseTime && responseTime < sectionEnd) {
        			++cnt;
        		}
        		else if(requestTime <= sectionStart && sectionEnd <= responseTime) {
        			++cnt;
        		}
        	}
        	answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
	
	private static Date calTime(Date responseTime, double processingSecond, boolean minus) throws ParseException {
		int pm = 1;
		if(minus) pm = -1;
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(responseTime);
		cal.add(Calendar.MILLISECOND, pm * (int)(1000 * processingSecond - 1));
		Date requestTime = cal.getTime();
		return requestTime;
	}
}
