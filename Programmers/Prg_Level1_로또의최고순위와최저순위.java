public class Prg_Level2_로또의최고순위와최저순위 {

	public static void main(String[] args) {

	}
	
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCnt = 0;
        int correctCnt = 0;
        int rank = 6;
        
        for(int i = 0; i < 6; i++) {
        	int num = lottos[i];
        	if(num == 0) ++zeroCnt;
        	else {
        		for(int j = 0; j < 6; j++) {
        			if(num == win_nums[j]) {
        				++correctCnt;
        				break;
        			}
        		}
        	}
        } 
        if(correctCnt > 1) {
        	answer[1] = rank - correctCnt + 1;
        }
        else {
        	answer[1] = rank;
        }
        correctCnt += zeroCnt;
        if(correctCnt > 1) {
        	answer[0] = rank - correctCnt + 1;
        }
        else {
        	answer[0] = rank;
        }
        return answer;
    }
}
