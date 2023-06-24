package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
 * Map 정렬 : https://developer-talk.tistory.com/395
 * TreeMap sorted by value : https://beginnersbook.com/2014/07/how-to-sort-a-treemap-by-value-in-java/
 */

public class BOJ_17140_G4_이차원배열과연산 {
	static int r, c, k; // 1 <= r,c,k <= 100
	static int[][] map;
	static TreeMap<Integer, Integer> numCntMap;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[101][101];
		for(int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int second = 0;
		int R = 3, C = 3;
		
		while(second <= 100) {
			if(map[r][c] == k) break;
			
			++second;
			int[][] tmpMap = new int[101][101];
			
			if(R >= C) { // R연산
				int maxR = 0;
				
				for(int i = 1; i <= R; i++) {
					numCntMap = new TreeMap<>();
					for(int j = 1; j <= C; j++) {
						int num = map[i][j];
						if(num == 0) continue;	// 숫자 0은 count에서 제외
						
						if(!numCntMap.containsKey(num)) {
							numCntMap.put(num, 1);
						}
						else {
							numCntMap.put(num, numCntMap.get(num)+1);
						}
					}
					
					maxR = Math.max(maxR, 2*numCntMap.size());
					
					int idx = 0;
					Map<Integer, Integer> sortedMap = sortByValues(numCntMap);
					Set set = sortedMap.entrySet();
					Iterator iter = set.iterator();
					
					while(iter.hasNext() && idx < 100) {
				       Map.Entry me = (Map.Entry)iter.next();
				       tmpMap[i][++idx] = (int) me.getKey();
				       tmpMap[i][++idx] = (int) me.getValue();
				    }
				} // end for R연산
				
				C = maxR;
			}
			else { // C연산
				int maxC = 0;
				
				for(int i = 1; i <= C; i++) {
					numCntMap = new TreeMap<>();
					for(int j = 1; j <= R; j++) {
						int num = map[j][i];
						if(num == 0) continue;	// 숫자 0은 count에서 제외
						
						if(!numCntMap.containsKey(num)) {
							numCntMap.put(num, 1);
						}
						else {
							numCntMap.put(num, numCntMap.get(num)+1);
						}
					}
					
					maxC = Math.max(maxC, 2*numCntMap.size());
					
					int idx = 0;
					Map<Integer, Integer> sortedMap = sortByValues(numCntMap);
					Set set = sortedMap.entrySet();
					Iterator iter = set.iterator();
					
					while(iter.hasNext() && idx < 100) {
				       Map.Entry me = (Map.Entry)iter.next();
				       tmpMap[++idx][i] = (int) me.getKey();
				       tmpMap[++idx][i] = (int) me.getValue();
				    }
				} // end for C연산
				
				R = maxC;
			}
			
			// copy Map
			for(int i = 1; i <= R; i++) {
				map[i] = tmpMap[i].clone();
			}
		}
		
		System.out.print(second <= 100 ? second : -1);
	}
	
	//Method for sorting the TreeMap based on values
	  public static <K, V extends Comparable<V>> Map<K, V> 
	    sortByValues(final Map<K, V> map) {
	    Comparator<K> valueComparator = new Comparator<K>() {
	      public int compare(K k1, K k2) {
	        int compare = 
	              map.get(k1).compareTo(map.get(k2));
	        if (compare == 0) 
	          return ((Integer) k1).compareTo((Integer) k2);
	        else 
	          return compare;
	      }
	    };
	 
	    Map<K, V> sortedByValues = 
	      new TreeMap<K, V>(valueComparator);
	    sortedByValues.putAll(map);
	    return sortedByValues;
	  }
}
