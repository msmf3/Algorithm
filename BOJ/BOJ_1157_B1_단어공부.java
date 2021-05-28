import java.util.Scanner;

public class BOJ_1157_B1_단어공부 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		s = s.toUpperCase();
		int alp_cnt[] = new int[26];
		for(int i = 0; i < s.length(); i++) {
			++alp_cnt[s.charAt(i) - 65];
		}
		int max = 0;
		char alp = '?';
		for(int i = 0; i < 26; i++) {
			if(alp_cnt[i] > max) {
				alp = (char)(i+65);
				max = alp_cnt[i];
			}
			else if(alp_cnt[i] == max) {
				alp = '?';
			}
		}
		System.out.println(alp);
		sc.close();
	}

}
