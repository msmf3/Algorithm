
public class BOJ_4673_S5_셀프넘버 {
	static boolean isNotSelfNum[];

	public static void main(String[] args) {
		isNotSelfNum = new boolean[10001];
		for(int i = 1; i <= 10000; i++) {
			if(!isNotSelfNum[i]) {
				d(i);
			}
		}
		
		for(int i = 1; i <= 10000; i++) {
			if(!isNotSelfNum[i]) {
				System.out.println(i);
			}
		}
	}
	
	private static void d(int n) {
		int num = n;
		while(n/10 > 0) {
			num += n % 10;
			if(num > 10000) {
				return;
			}
			n /= 10;
		}
		num += n % 10;
		if(num <= 10000 && !isNotSelfNum[num]) {
			isNotSelfNum[num] = true;
			d(num);
		}
	}
}
