package 동적계획법;

import java.util.ArrayList;

/*
 * 참고 : https://moondol-ai.tistory.com/272
 */

public class Prg_Level3_N으로표현 {

	public static void main(String[] args) {
		System.out.println(solution(5, 12));
	}

	public static int solution(int N, int number) {
        int answer = -1;
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        
        for(int i = 1; i <= 8; i++) {
        	ArrayList<Integer> tmp = new ArrayList<>();
        	int idx = 0, num = 0;
        	while(idx < i) {
        		num += N * Math.pow(10, idx);
        		++idx;
        	}
        	tmp.add(num);
        	for(int j = 1; j < i; j++) {
        		ArrayList<Integer> list1 = dp.get(j-1);
        		ArrayList<Integer> list2 = dp.get(i-j-1);
        		for(int k : list1) {
        			for(int l : list2) {
        				tmp.add(k+l);
        				if(k-l > 0) tmp.add(k-l);
        				tmp.add(k*l);
        				if(l != 0) tmp.add((int)(k/l));
        			}
        		}
        	}
        	for(int j : tmp) {
        		if(j == number) return i;
        	}
        	dp.add(tmp);
        }
        return answer;
    }
}
