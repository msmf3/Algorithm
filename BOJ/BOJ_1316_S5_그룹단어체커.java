import java.util.Scanner;

public class BOJ_1316_S5_그룹단어체커 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0;
		for(int i = 0; i < N; i++) {
			String s = sc.next();
			boolean arr[] = new boolean[26];
			char c = s.charAt(0);
			boolean flag = true;
			for(int j = 1; j < s.length(); j++) {
				if(c != s.charAt(j)) {
					if(!arr[c-97]) {
						arr[c-97] = true;
						c = s.charAt(j);
						if(arr[c-97]) {
							flag = false;
							break;
						}
					}
				}
			}
			if(flag) {
				++ans;
			}
		}
		System.out.println(ans);
		sc.close();
	}

}
