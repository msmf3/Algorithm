
/*
 * 수식을 통한 계산 코드 : https://hello-backend.tistory.com/38
 */

public class Prg_모음사전 {

	public static void main(String[] args) {
		String word = "EIO";
		System.out.println(solution(word));
	}
	
	static char moeum[] = {' ', 'A', 'E', 'I', 'O', 'U'};
	
	public static int solution(String word) {
        int answer = 0;
        // moeum 의 idx를 크기가 5인 int 배열에 저장
        int tmp[] = new int[5];
        int idx = 0;
        // 사전 순으로 증가시키며 비교
        while(!word.equals(getStr(tmp))) {
        	++answer;
        	if(tmp[idx] == 0) {
        		tmp[idx] = 1;
        		idx = Math.min(idx+1, 4);
        	}
        	else if(tmp[idx] == 5) {
        		while(tmp[idx] == 5) {
        			tmp[idx] = 0;
            		--idx;
        		}
        		tmp[idx] += 1;
        		++idx;
        	}
        	else {
        		tmp[idx] += 1;
        	}
        }
        return answer;
    }
	
	private static String getStr(int a[]) {
		String s = "";
		for(int i = 0; i < a.length; i++) {
			s += moeum[a[i]];
		}
		return s.trim();
	}
}
