import java.util.LinkedList;
import java.util.Queue;

/*
 * 참고 : https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%BA%90%EC%8B%9C-Java
 */

public class Prg_Level2_캐시 {
	public static void main(String[] args) {
		
	}
	
	static final int CACHE_HIT = 1;
	static final int CACHE_MISS = 5;
	
	public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0) return 5 * cities.length;
        
        Queue<String> cache = new LinkedList<String>();
        for(String city : cities) {
        	city = city.toLowerCase();
        	// CACHE HIT
        	if(cache.remove(city)) {
        		cache.add(city);
        		answer += CACHE_HIT;
        	}
        	// CACHE MISS
        	else {
        		int currentSize = cache.size();
        		if(currentSize == cacheSize) {
        			cache.poll();
        		}
        		cache.add(city);
        		answer += CACHE_MISS;
        	}
        }
        
        return answer;
    }
}
