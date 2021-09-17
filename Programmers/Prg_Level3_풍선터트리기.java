/*
 * 참고 : https://imksh.com/59
 */

public class Prg_Level3_풍선터트리기 {
	
	public static void main(String[] args) {
		int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
		System.out.println(solution(a));
	}
	
	public static int solution(int[] a) {
		int n = a.length;
		if(n == 1) return 1;
        int leftMin[] = new int[n];
        int rightMin[] = new int[n];
        
        leftMin[0] = a[0];
        for(int i = 1; i < n; i++) {
        	leftMin[i] = Math.min(leftMin[i-1], a[i]);
        }
        rightMin[n-1] = a[n-1];
        for(int i = n-2; i >= 0; i--) {
        	rightMin[i] = Math.min(rightMin[i+1], a[i]);
        }
        int cnt = 0;
        for(int i = 0; i < n; i++) {
        	// 최후에 남기는 것이 불가능한 풍선 -> 왼쪽, 오른쪽 두 경우 다 번호가 더 작은 풍선을 터뜨려야 함.
        	// -> 왼쪽, 오른쪽 둘 다 자기보다 작은 최소값이 있음
        	if(leftMin[i] < a[i] && rightMin[i] < a[i]) ++cnt;
        }
        return n-cnt;
    }
	
	
}
