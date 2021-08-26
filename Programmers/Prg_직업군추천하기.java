import java.util.ArrayList;
import java.util.Collections;

public class Prg_직업군추천하기 {

	public static void main(String[] args) {
		
	}
	
	public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        String languageTable[][] = new String[5][6];
        int score[] = new int[5];
        for(int i = 0; i < 5; i++) {
        	// table을 2차원 string 배열로 저장
        	languageTable[i] = table[i].split(" ");
        }
        int maxScore = 0;
        // languageTable을 돌며 직업별 점수 계산
        for(int i = 0; i < 5; i++) {
        	for(int j = 1; j <= 5; j++) {
        		String language = languageTable[i][j];
        		for(int k = 0; k < languages.length; k++) {
        			if(language.equals(languages[k])) {
        				// 직업군 언어점수 * 언어 선호도
        				score[i] += (6-j) * preference[k];
        				break;
        			}
        		}
        	}
        	maxScore = Math.max(maxScore, score[i]);
        }
        // 총합이 같은 직업군이 여러 개인 경우 사전 순으로 앞서는 것 return
        ArrayList<String> answerList = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
        	if(score[i] == maxScore) {
        		answerList.add(languageTable[i][0]);
        	}
        }
        Collections.sort(answerList);
        answer = answerList.get(0);
        return answer;
    }
}
