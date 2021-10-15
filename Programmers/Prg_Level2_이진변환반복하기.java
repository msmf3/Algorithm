import java.util.Stack;

public class Prg_Level2_이진변환반복하기 {

	public static void main(String[] args) {
		String s = "110010101001";
		int[] answer = solution(s);
		System.out.println(answer[0] + " " + answer[1]);
	}
	
	static int deleteZeroCnt;
	
	public static int[] solution(String s) {
        int[] answer = new int[2];
        int level = 0;
        deleteZeroCnt = 0;
        
        while(true) {
        	++level;
        	s = binaryConvert(s);
        	if(s.equals("1")) break;
        }
        
        answer[0] = level;
        answer[1] = deleteZeroCnt;
        return answer;
    }
	
	private static String binaryConvert(String s) {
        int oneCnt = 0;
        
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) == '1') {
        		++oneCnt;
        	}
        }
        
        deleteZeroCnt += s.length() - oneCnt;
        
        // Integer.toBinaryString
        Stack<Integer> stack = new Stack<>();
        
        while(oneCnt > 0) {
        	stack.add(oneCnt % 2);
        	oneCnt /= 2;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
        	sb.append(stack.pop());
        }
        
        return sb.toString();
	}
}
