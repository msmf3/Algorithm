
public class LeetCode_5_LongestPalindromeSubstring {

	public static void main(String[] args) {

	}
	
	public String longestPalindrome(String s) {
		int n = s.length();
		String palindrome = Character.toString(s.charAt(0));
		for(int i = 0; i < n-1; i++) {
			// 팰린드롬인지 확인 ex) xabax
			int lIdx = i; int rIdx = i;
			while(s.charAt(lIdx) == s.charAt(rIdx)) {	
				--lIdx;
				++rIdx;
				if(lIdx < 0 || rIdx >= n) break;	// String s의 범위를 벗어나는 경우
			}
			if(rIdx-lIdx-1 > palindrome.length()) {
				palindrome = s.substring(lIdx+1, rIdx);
			}
			// 팰린드롬인지 확인 ex)abba 중간값이 2개인 경우?
			lIdx = i; rIdx = i+1;
			while(s.charAt(lIdx) == s.charAt(rIdx)) {	
				--lIdx;
				++rIdx;
				if(lIdx < 0 || rIdx >= n) break;
			}
			if(rIdx-lIdx-1 > palindrome.length()) {
				palindrome = s.substring(lIdx+1, rIdx);
			}
		}
		
		return palindrome;
    }
}
