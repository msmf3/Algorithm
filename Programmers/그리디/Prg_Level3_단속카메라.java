package 그리디;

/*
 * 참고 : https://velog.io/@ahnick/programmers-%EB%8B%A8%EC%86%8D%EC%B9%B4%EB%A9%94%EB%9D%BC
 */

import java.util.Arrays;

public class Prg_Level3_단속카메라 {

	public static void main(String[] args) {
		int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
		System.out.println(solution(routes));
	}
	
	public static int solution(int[][] routes) {
        int answer = 1;
        
        // 가장 많은 자동차를 탐색할 수 있게 카메라를 배치 (그리디)
        
        // 이분탐색 log N ?? * 몇 개의 자동차를 탐지하는지 N * 카메라수(최악 N)
        
        // 자동차마다 진출 지점에 카메라 설치해서 몇 개를 탐지하는지 체크
        // N * N * 카메라 수(최악N)
        
        // 진출지점을 기준으로 오름차순 -> 진출지점에 카메라 설치 -> 다음 자동차의 진입지점이 겹치는지 확인
        // 시간복잡도 : N
        Arrays.sort(routes, (r1, r2) -> Integer.compare(r1[1], r2[1]));
        int cameraPos = routes[0][1];
        for(int i = 1; i < routes.length; i++) {
        	if(routes[i][0] <= cameraPos) continue;
        	
        	cameraPos = routes[i][1];
        	++answer;
        }
        
        return answer;
    }
}
