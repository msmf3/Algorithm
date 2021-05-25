import java.util.HashMap;
import java.util.Map;

public class LeetCode_13_RomanToInteger {
	static Map<Character, Integer> map;
	static char[] roman = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
	static int[] romanInt = {1, 5, 10, 50, 100, 500, 1000};
	
	public static void main(String[] args) {
		map = new HashMap<Character, Integer>();
        map.put('I', 0);
        map.put('V', 1);
        map.put('X', 2);
        map.put('L', 3);
        map.put('C', 4);
        map.put('D', 5);
        map.put('M', 6);
        
        System.out.println(romanToInt("MCMXCIV"));
	}
	
	public static int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
        	int idx = map.get(s.charAt(i));
        	int num = romanInt[idx];
        	if(i + 1 < n && idx < 5 && (s.charAt(i+1) == roman[idx+2] || 
        								s.charAt(i+1) == roman[idx+1])) {
        		num *= -1;
        	}
        	ans += num;
        }
		return ans;
    }

}
