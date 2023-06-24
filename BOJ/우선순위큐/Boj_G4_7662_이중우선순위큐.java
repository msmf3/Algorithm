package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
 * 참고 : https://velog.io/@kimyj1234/JAVA-%EB%B0%B1%EC%A4%80-7662-%EC%9D%B4%EC%A4%91-%EC%9A%B0%EC%84%A0%EC%88%9C%EC%9C%84-%ED%81%90
 * 레드-블랙 트리 : https://code-lab1.tistory.com/62
 */

public class Boj_G4_7662_이중우선순위큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		while(T-- > 0) {
			int k = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> treeMap = new TreeMap<>();
			
			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				switch(command) {
				case "I":
					if(treeMap.containsKey(num)) {
						treeMap.put(num, treeMap.get(num)+1);
					}
					else {
						treeMap.put(num, 1);
					}
				break;
					
				case "D":
					if(treeMap.isEmpty()) break;
					int m;
					if(num == 1) { // 최대값 제거
						m = treeMap.lastKey();
					}
					else { // 최소값 제거
						m = treeMap.firstKey();
					}
					
					if(treeMap.get(m) > 1) {
						treeMap.put(m, treeMap.get(m)-1);
					}
					else {
						treeMap.remove(m);
					}
				break;
				}
				
			}
			
			if(treeMap.isEmpty()) System.out.println("EMPTY");
			else {
				System.out.println(treeMap.lastKey() + " " + treeMap.firstKey());
			}
		}
	}

}
