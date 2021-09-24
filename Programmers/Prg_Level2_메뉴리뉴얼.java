import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Prg_Level2_메뉴리뉴얼 {

	public static void main(String[] args) {
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		String[] answer = solution(orders, course);
		for(String s : answer) {
			System.out.println(s);
		}
	}
	
	static Map<String, Integer> courseMap;
	static int maxCnt;
	
	public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        ArrayList<String> answerList = new ArrayList<>();
        for(int i = 0; i < course.length; i++) {
        	int courseSize = course[i];
        	courseMap = new HashMap<>();
        	maxCnt = 0;
        	for(int j = 0; j < orders.length; j++) {
        		if(courseSize > orders[j].length()) continue;
        		// courseSize개의 메뉴 구성 조합을 모두 구해서 courseMap에 저장
        		combination(0, 0, courseSize, "", orders[j]);
        	}
        	
        	if(maxCnt < 2) continue;
        	Iterator<String> keys = courseMap.keySet().iterator();
        	while(keys.hasNext()) {
        		String key = keys.next();
        		// 최대 개수의 메뉴 구성이라면
        		if(courseMap.get(key) == maxCnt) {
        			answerList.add(key);
        		}
        	}
        }
        Collections.sort(answerList);
        answer = (String[]) answerList.toArray(answer);
        
        return answer;
    }
	
	private static void combination(int idx, int cnt, int size, String menuComb, String order) {
		if(cnt == size) {
			char[] menus = menuComb.toCharArray();
			// 주문마다 메뉴 주문 순서가 다를 수 있으므로 sorting
			Arrays.sort(menus);
			String course = new String(menus);
			if(courseMap.containsKey(course)) {
				courseMap.replace(course, courseMap.get(course)+1);
			}
			else {
				courseMap.put(course, 1);
			}
			// 최대 주문 개수 갱신
			maxCnt = Math.max(maxCnt, courseMap.get(course));
			return;
		}
		
		for(int i = idx; i < order.length(); i++) {
			char menu = order.charAt(i);
			combination(i+1, cnt+1, size, menuComb+menu, order);
		}
	}
}
