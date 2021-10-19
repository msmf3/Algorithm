import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
 * 참고 : https://loosie.tistory.com/265
 */

public class Prg_Level2_순위검색_효율성 {

	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
		int[] answer = solution(info, query);
		for (int a : answer) {
			System.out.println(a);
		}
	}
	
	static HashMap<String, ArrayList<Integer>> infoMap;
	
	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		infoMap = new HashMap<>();
		// 키(언어, 직군, 경력, 소울푸드) - 점수
		for(String s : info) {
			String[] inf = s.split(" ");
			setInfoMap(inf, 0, "");
		}
		
		// 이분탐색을 위한 정렬
		for(String key : infoMap.keySet()) {
			Collections.sort(infoMap.get(key));
		}
		
		// 이분탐색
		for(int i = 0; i < query.length; i++) {
			String s = query[i];
			s = s.replaceAll(" and ", "");
			String[] q = s.split(" ");
			String qInfo = q[0];
			if(infoMap.containsKey(qInfo)) {
				int score = Integer.parseInt(q[1]);
				answer[i] = binarySearch(infoMap.get(qInfo), score);
			}
			else {
				answer[i] = 0;
			}
		}
		ArrayList<Integer> list = infoMap.get("----");
		for(int score : list) {
			System.out.println(score);
		}
		return answer;
	}
	
	private static int binarySearch(ArrayList<Integer> list, int score) {
		int start = 0; int end = list.size();
		while(start <= end) {
			int mid = (start + end) / 2;
			if(score <= list.get(mid)) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		return list.size() - start;
	}
	
	private static void setInfoMap(String[] information, int depth, String inf) {
		if(depth == 4) {
			int score = Integer.parseInt(information[4]);
			if(infoMap.containsKey(inf)) {
				infoMap.get(inf).add(score);
			}
			else {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(score);
				infoMap.put(inf, list);
			}
			return;
		}
		
		setInfoMap(information, depth+1, inf+"-");
		setInfoMap(information, depth+1, inf+information[depth]);
	}
}
