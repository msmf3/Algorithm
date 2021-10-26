import java.util.Arrays;

public class Prg_Level2_피로도 {

	public static void main(String[] args) {
		int k = 80;
		int[][] dungeon = {{80,20},{30,10},{30,10}};
		System.out.println(solution(k, dungeon));
	}
	
	static int N;
	static int[] numbers;
	
	public static int solution(int k, int[][] dungeons) {
        int answer = -1;
        N = dungeons.length;
        numbers = new int[N];
        for(int i = 0; i < N; i++) {
        	numbers[i] = i;
        }
        
        Arrays.sort(dungeons, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        do {
        	int fatigue = k;
        	int cnt = 0;
        	for(int i = 0; i < N; i++) {
        		if(fatigue < dungeons[i][0]) break;
        		fatigue -= dungeons[i][1];
        		++cnt;
        	}
        	answer = Math.max(answer, cnt);
        } while(nextPermutation(dungeons));
        
        return answer;
    }
	
	
	private static boolean nextPermutation(int[][] arr) {
		int i = N-1;
		// step1 
		while(i > 0 && numbers[i-1] >= numbers[i]) --i;
		
		// i가 0인 경우는 내림차순 정렬이 된 형태라는 것
		if(i == 0) return false;
		
		// step2
		// 내가 찾은 교환위치 i 와 교환할 큰 값을 찾는 과정
		int j = N-1;
		while(numbers[i-1] >= numbers[j]) --j;
		
		// step3
		// j와 i-1번째의 값을 swap
		int temp = numbers[i-1];
		numbers[i-1] = numbers[j];
		numbers[j] = temp;
		
		int temp1 = arr[i-1][0]; int temp2 = arr[i-1][1];
		arr[i-1][0] = arr[j][0]; arr[i-1][1] = arr[j][1];
		arr[j][0] = temp1; arr[j][1] = temp2;
		
		// step4
		// i부터 배열 끝까지 오름차순으로 교환
		int k = N-1;
		while(i < k) {
			temp = numbers[i];
			numbers[i] = numbers[k];
			numbers[k] = temp;
			
			temp1 = arr[i][0]; temp2 = arr[i][1];
			arr[i][0] = arr[k][0]; arr[i][1] = arr[k][1];
			arr[k][0] = temp1; arr[k][1] = temp2;
			++i; --k;
		}
		
		return true;
	}
}
