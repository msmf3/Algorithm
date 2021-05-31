import java.util.Scanner;

public class BOJ_2941_S5_크로아티아알파벳 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int ans = s.length();
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(ch == '=') {
				--ans;
				if(i > 0 && s.charAt(i-1) == 'z') {
					if(i > 1 && s.charAt(i-2) == 'd') {
						--ans;
					}
				}
			}
			else if(ch == '-') {
				--ans;
			}
			else if(ch == 'j' && i > 0) {
				char prev_ch = s.charAt(i-1);
				if(prev_ch == 'l' || prev_ch == 'n') {
					--ans;
				}
			}
		}
		System.out.println(ans);
		sc.close();
	}

}
