package 이분탐색;

public class Prg_Level3_입국심사 {

	public static void main(String[] args) {
		int times[] = {7, 10};
		System.out.println(solution(6, times));
	}
	
	static int N;
	static int global_times[];
	static long answer;
	
	public static long solution(int n, int[] times) {
        N = n;
        global_times = times;
        long maxTime = 0;
        for(int i = 0; i < times.length; i++) {
        	maxTime = Math.max(maxTime, (long) times[i] * n);
        }
        binarySearch(1, maxTime);
        return answer;
    }
	
	private static void binarySearch(long left, long right) {
		// 시간이 middle 일 시에 몇 명을 심사할 수 있는지 이분탐색
		if(left >= right) return;
		long middle = (left + right) / 2;
		long sum = 0;
		for(int i = 0; i < global_times.length; i++) {
			sum += middle / global_times[i];
		}
		if(sum < N) {
			binarySearch(middle+1, right);
		}
		else if(sum >= N) {
			answer = middle;
			binarySearch(left, middle);
		}
	}
}
