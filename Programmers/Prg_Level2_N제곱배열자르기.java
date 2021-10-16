
public class Prg_Level2_N제곱배열자르기 {

	public static void main(String[] args) {
		int[] answer = solution(3, 2, 5);
		for(int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}
	
	public static int[] solution(int n, long left, long right) {
		long size = right-left+1;
        int[] answer = new int[(int) size];
        
        // int + long = long
        for(int i = 0; i < size; i++) {
        	long r = (i+left) / n;
        	long c = (i+left) % n;
        	long m = Math.max(r, c);
        	answer[(int) i] = (int) (m+1);
        }
        
        return answer;
    }
}
