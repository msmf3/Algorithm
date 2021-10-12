import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Prg_Level2_괄호회전하기 {

	public static void main(String[] args) {
		String s = "[](){}";
		System.out.println(solution(s));
	}
	
	static Map<Character, Character> bracketMap = new HashMap<Character, Character>();
	
	public static int solution(String s) {
        int answer = 0;
        bracketMap.put(')', '(');
        bracketMap.put(']', '[');
        bracketMap.put('}', '{');
        for(int i = 0; i < s.length(); i++) {
        	if(checkRightBracket(i, s)) {
        		++answer;
        	}
        }
        return answer;
    }
	
	private static boolean checkRightBracket(int startIdx, String s) {
		Stack<Character> stack = new Stack<>();
		int idx = startIdx;
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(idx);
			idx = (idx+1) % s.length();
			if(c == '(' || c == '[' || c == '{') {
				stack.add(c);
			}
			else {
				if(stack.isEmpty()) return false;
				if(stack.pop() != bracketMap.get(c)) return false;
			}
		}
		
		if(!stack.isEmpty()) {
			return false;
		}
		return true;
	}
}
