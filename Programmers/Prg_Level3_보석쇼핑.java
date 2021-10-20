import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 참고 : https://tosuccess.tistory.com/133
 */

public class Prg_Level3_보석쇼핑 {

	public static void main(String[] args) {
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		int[] answer = solution(gems);
		System.out.println(answer[0] + " " + answer[1]);
	}
	
	static HashSet<String> gemSet;
	static HashMap<String, Integer> gemMap;
	
	public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        gemSet = new HashSet<>();
        gemMap = new HashMap<>();
        for(int i = 0; i < gems.length; i++) {
        	gemSet.add(gems[i]);
        }
        Queue<String> q = new LinkedList<String>();
        int start = 1; int end = gems.length;
        int left = 0; int right = 0;
        for(int i = 0; i < gems.length; i++) {
        	String gem = gems[i];
        	q.add(gem);
        	gemMap.put(gem, gemMap.getOrDefault(gem, 0)+1);
        	
        	if(gemMap.size() == gemSet.size()) {
        		right = i;
        		while(true) {
        			String g = q.poll();
        			if(gemMap.containsKey(g) && gemMap.get(g) > 1) {
        				gemMap.put(g, gemMap.get(g)-1);
        				++left;
        			}
        			else {
        				++left;
        				gemMap.remove(g);
        				break;
        			}
        		}
        		if(right - left + 1 < end - start) {
            		start = left;
            		end = right+1;
            	}
        	}
        }
        
        answer[0] = start; answer[1] = end;
        return answer;
    }
}