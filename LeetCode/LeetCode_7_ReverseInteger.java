
public class LeetCode_7_ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
	}
	
	public static int reverse(int x) {
        int ans = 0;
        String s = Integer.toString(x);
        String a = "";
        int n = s.length();
        int l = 0;
        if(x < 0) {
        	l = 1;
        }
        for(int i = n-1; i >= l; --i) {
        	a += s.charAt(i);
        }
        long tmp = Long.parseLong(a);
        if(tmp > Integer.MAX_VALUE || tmp < Integer.MIN_VALUE) {
        	return 0;
        }
        ans = (int) tmp;
        if(x < 0) {
        	ans *= -1;
        }
		return ans;
    }
}
