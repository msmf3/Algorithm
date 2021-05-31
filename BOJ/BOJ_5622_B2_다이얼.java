import java.util.Scanner;

public class BOJ_5622_B2_다이얼 {
	static String arr[] = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int time = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			for(int j = 0; j < arr.length; j++) {
				if(arr[j].contains(Character.toString(c))) {
					time += 3 + j;
					break;
				}
			}
		}
		System.out.println(time);
		sc.close();
	}

}
