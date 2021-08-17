
public class Prg_상호평가 {

	public static void main(String[] args) {
		
	}
	
	public String solution(int[][] scores) {
        String answer = "";
        int n = scores.length;
        for(int i = 0; i < n; i++) {
        	int sum = 0; int cnt = n;
        	int max = 0; int min = 100;
        	for(int j = 0; j < n; j++) {
        		int score = scores[j][i];
        		max = Math.max(max, score);
        		min = Math.min(min, score);
        		sum += score;
        	}
        	int selfScore = scores[i][i];
        	if(selfScore == max || selfScore == min) {
        		for(int k = 0; k < n; k++) {
        			if(i == k) continue;
        			if(selfScore == scores[k][i]) {
        				sum += selfScore;
                		++cnt;
                		break;
        			}
        		}
        		sum -= selfScore;
        		--cnt;
        	}
        	answer += getGrade(sum / cnt);
        }
        return answer;
    }
	
	private static char getGrade(int score) {
		if(score >= 90) {
			return 'A';
		}
		if(score >= 80) {
			return 'B';
		}
		if(score >= 70) {
			return 'C';
		}
		if(score >= 50) {
			return 'D';
		}
		return 'F';
	}
}
