import java.util.Arrays;

public class Prg_Level3_숫자게임 {

	public static void main(String[] args) {
		int[] A = {5,1,3,7};
		int[] B = {2,2,6,8};
		System.out.println(solution(A, B));
	}
	
	// B의 최소 원소값이 A의 최소값보다 작으면 A의 최대값에 매칭 A최대값 idx++
	// B의 최소 원소값이 A의 최소값보다 크면 매칭
	// A 내림차순하고, 최소값 구해놓자.
	// B의 최대 원소값이 A의 최대값보다 크면 매칭
	// B의 최대 원소값이 A의 최대값보다 작으면 B의 최소값을 매칭
	// 투포인터로 ㄱ?
	public static int solution(int[] A, int[] B) {
        int answer = 0;
        int n = A.length;
        // A 오름차순 
        Arrays.sort(A);
        // B 오름차순
        Arrays.sort(B);
        int aMaxIdx = n-1; int aMinIdx = 0;
//        int bMaxIdx = n-1; 
        int bMinIdx = 0;
        while(bMinIdx < n && 0 <= aMaxIdx) {
        	int aMin = A[aMinIdx];
        	int bMin = B[bMinIdx];
        	
        	// B의 최소 원소값이 A의 최소값보다 크면 매칭
        	if(bMin > aMin) {
        		++bMinIdx;
        		++aMinIdx;
        		++answer;
        	}
        	// B의 최소 원소값이 A의 최소값보다 작으면 A의 최대값에 매칭 A최대값 idx--
        	else {
        		++bMinIdx;
        		--aMaxIdx;
        	}
        }
        
        
        return answer;
    }
}
