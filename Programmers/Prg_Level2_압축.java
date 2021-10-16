import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Prg_Level2_압축 {

	public static void main(String[] args) {
//		int[] answer = solution("TOBEORNOTTOBEORTOBEORNOT");
		int[] answer = solution("KAKAO");
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
		
	}
	
	public static int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 1; i <= 26; i++) {
        	char c = (char) (64 + i);
        	map.put(""+c, i);
        }
        
        ArrayList<Integer> idxList = new ArrayList<>();
        int idx = 0; int mIdx = 27;
        while(idx < msg.length()) {
        	String s = "";
        	s += msg.charAt(idx);
        	while(map.containsKey(s) && ++idx < msg.length()) {
        		s += msg.charAt(idx);
        	}
        	
        	if(idx == msg.length()) {
        		if(!map.containsKey(s)) {
        			map.put(s, mIdx++);
        		}
        		idxList.add(map.get(s));
        		break;
        	}
        	idxList.add(map.get(s.substring(0, Math.max(s.length()-1, 1))));
        	
        	map.put(s, mIdx++);
        }
        int[] answer = idxList.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}
