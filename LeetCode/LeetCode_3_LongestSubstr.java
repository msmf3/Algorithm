import java.util.HashSet;
import java.util.Set;

public class LeetCode_3_LongestSubstr {

	public static void main(String[] args) {
		String s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	private static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Set<Character> set = new HashSet<Character>();
        // sIdx, eIdx : start, end 인덱스
        int sIdx = 0, eIdx = 0;
        int len = s.length();
        if(len == 0) {
        	return ans;
        }
        char start = s.charAt(0);
        while(eIdx < len) {
        	char end = s.charAt(eIdx);

        	if(!set.contains(end)) {
        		// set이 해당 문자열을 가지고 있지 않은 경우
        		// set에 해당 문자열을 추가
        		set.add(end);
        		eIdx++;
        		ans = Math.max(ans, set.size());	// 최장 Substring 갱신
        	} else {
        		// set에 해당 문자열이 있는 경우
        		// 슬라이딩 윈도우의 첫번째 문자를 set에서 빼내고
        		set.remove(start);
        		// 시작 인덱스를 증가시킴
        		sIdx++;
        		start = s.charAt(sIdx);
        	}
        }
		return ans;
    }

}
