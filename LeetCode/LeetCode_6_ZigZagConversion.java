public class LeetCode_6_ZigZagConversion {

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));
	}
	
	public static String convert(String s, int numRows) {
        String ans = "";
        if(numRows == 1) {
        	return s;
        }
        String zigzag[] = new String[numRows];
        for(int i = 0; i < numRows; i++) {
        	zigzag[i] = "";
        }
        int n = s.length();
        int row = 0; int dir = 1;
        for(int i = 0; i < n; i++) {
        	zigzag[row] += s.charAt(i);
        	row += dir;
        	if(row >= numRows) {
        		row = numRows - 2;
        		dir = -1;
        	}
        	else if(row < 0) {
        		row = 1;
        		dir = 1;
        	}
        }
        
        for(int i = 0; i < numRows; i++) {
        	ans += zigzag[i];
        }
        return ans;
    }

}
