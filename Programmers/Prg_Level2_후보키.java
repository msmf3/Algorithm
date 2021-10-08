import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * 참고 : https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%9B%84%EB%B3%B4%ED%82%A4-Java
 */

public class Prg_Level2_후보키 {

	public static void main(String[] args) {
		
	}
	static String[][] relations;
	static ArrayList<HashSet<Integer>> candidateKey;
	
	public static int solution(String[][] relation) {
		relations = relation;
        candidateKey = new ArrayList<>();
        
        // 속성의 집합 중 후보키 조건을 만족하는지 확인
        for(int i = 1; i <= relation[0].length; i++) {
        	combination(0, 0, i, new HashSet<>());
        }
        
        return candidateKey.size();
    }
	
	private static void combination(int idx, int cnt, int target, HashSet<Integer> set) {
		if(cnt == target) {
			for(HashSet<Integer> ck : candidateKey) {
				// ck 가 set의 부분집합인지 확인 -> 부분집합이면 최소성 만족하지 않음
				if(set.containsAll(ck)) {
					return;
				}
			}
			// 유일성을 만족하는지 확인
			if(isUnique(set)) {
				candidateKey.add(set);
			}
			return;
		}
		
		for(int i = idx; i < relations[0].length; i++) {
			HashSet<Integer> newKeySet = new HashSet<>(set);
			newKeySet.add(i);
			combination(i+1, cnt+1, target, newKeySet);
		}
	}
	
	private static boolean isUnique(HashSet<Integer> keySet) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		
		for(int i = 0; i < relations.length; i++) {
			String s = "";
			for(int j : keySet) {
				s += relations[i][j];
			}
			if(map.containsKey(s)) {
				return false;
			}
			map.put(s, true);
		}
		
		return true;
	}
}
