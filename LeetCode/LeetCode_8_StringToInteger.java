
public class LeetCode_8_StringToInteger {

	public static void main(String[] args) {
		System.out.println(myAtoi("+-12"));
	}

	public static int myAtoi(String s) {
        int ans = 0;
        int idx = 0;
        int sign = 1;
        int n = s.length();
        while(idx < n && s.charAt(idx) == ' ') {
        	++idx;
        }
        if(idx < n && (s.charAt(idx) == '-' || s.charAt(idx) == '+')) {
        	if(s.charAt(idx) == '-') {
        		sign = -1;
        	}
        	++idx;
        }
        while(idx < n && '0' <= s.charAt(idx) && s.charAt(idx) <= '9') {
        	int a = s.charAt(idx) - '0';
        	System.out.println(a);
        	if(ans > Integer.MAX_VALUE / 10 ||
        		ans == Integer.MAX_VALUE / 10 && (a > Integer.MAX_VALUE % 10)) {
        		return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        	}
        	ans = 10 * ans + a;
        	++idx;
        }
        ans = ans * sign;
        return ans;
    }
}
