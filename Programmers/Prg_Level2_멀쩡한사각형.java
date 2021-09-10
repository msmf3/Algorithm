/*
 * 참고 : https://taesan94.tistory.com/55
 */
public class Prg_Level2_멀쩡한사각형 {
	
	public static void main(String[] args) {
		System.out.println(solution(12, 8));
	}
	
	public static long solution(int w, int h) {
        return (long)w * (long)h - ((long)w + (long)h - gcd(w, h));
    }
	
	private static long gcd(long w, long h) {
		long a, b;
		
		if(w > h) {
			a = w;
			b = h;
		}
		else {
			b = w;
			a = h;
		}
		
		while(b > 0) {
			long gcd = a % b;
			a = b;
			b = gcd;
		}
		return a;
	}
}
