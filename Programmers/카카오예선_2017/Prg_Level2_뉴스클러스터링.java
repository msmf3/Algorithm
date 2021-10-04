package 카카오예선_2017;

import java.util.ArrayList;
import java.util.Collections;

public class Prg_Level2_뉴스클러스터링 {

	public static void main(String[] args) {
		System.out.println(solution("E=M*C^2", "e=m*c^2"));
		
	}
	
	public static int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        ArrayList<String> multiSet1 = new ArrayList<>();
        for(int i = 0; i < str1.length()-1; i++) {
        	char c = str1.charAt(i);
        	char n = str1.charAt(i+1);
        	if(c < 'a' || c > 'z' || n < 'a' || n > 'z') continue;
        	String s = ""+c+n;
        	multiSet1.add(s);
        }
        ArrayList<String> multiSet2 = new ArrayList<>();
        for(int i = 0; i < str2.length()-1; i++) {
        	char c = str2.charAt(i);
        	char n = str2.charAt(i+1);
        	if(c < 'a' || c > 'z' || n < 'a' || n > 'z') continue;
        	String s = ""+c+n;
        	multiSet2.add(s);
        }
        Collections.sort(multiSet1);
        Collections.sort(multiSet2);
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();
        for(int i = 0; i < multiSet1.size(); i++) {
        	String s = multiSet1.get(i);
        	// set2에서 교집합 한개 제거
        	if(multiSet2.remove(s)) {
        		intersection.add(s);
        	}
        	union.add(s);
        }
        for(int i = 0; i < multiSet2.size(); i++) {
        	union.add(multiSet2.get(i));
        }
        if(union.size() == 0) {
        	return 65536;
        }
        double jakard = (double)intersection.size() / (double) union.size();
        answer = (int)(jakard * 65536);
        return answer;
    }
}
