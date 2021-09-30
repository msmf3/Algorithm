import java.util.Arrays;

public class Prg_Weekly8_최소직사각형 {

	public static void main(String[] args) {
//		int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		int[][] sizes = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
		System.out.println(solution(sizes));
	}
	
	public static int solution(int[][] sizes) {
        int answer = 0;
        int maxW = 0; int maxH = 0;
        // w, h 를 비교해 큰 값을 w로 바꿈
        for(int i = 0; i < sizes.length; i++) {
        	int w = sizes[i][0];
        	int h = sizes[i][1];
        	// swap
        	if(h > w) {
        		int tmp = h;
        		sizes[i][1] = w;
        		sizes[i][0] = tmp;
        	}
        	maxW = Math.max(maxW, sizes[i][0]);
        	maxH = Math.max(maxH, sizes[i][1]);
        }
        answer = maxW * maxH;
        
//        int[][] widthDesc = new int[sizes.length][2];
//        int[][] heightDesc = new int[sizes.length][2];
//        for(int i = 0; i < sizes.length; i++) {
//        	widthDesc[i][0] = sizes[i][0];
//        	widthDesc[i][1] = sizes[i][1];
//        	heightDesc[i][0] = sizes[i][0];
//        	heightDesc[i][0] = sizes[i][1];
//        }
//        Arrays.sort(widthDesc, (s1, s2) -> {
//        	return Integer.compare(s2[0], s1[0]);
//        });
//        Arrays.sort(heightDesc, (s1, s2) -> {
//        	return Integer.compare(s2[1], s1[1]);
//        });
//        int maxW = widthDesc[0][0];
//        int maxH = heightDesc[0][1];
//        // l > s
//        int l, s;
//        if(maxW > maxH) {
//        	l = maxW;
//        	s = maxH;
//        }
//        else if(maxW < maxH){
//        	l = maxH;
//        	s = maxW;
//        }
//        else {
//        	// maxW == maxH 이면 지갑의 최소 크기는 maxW * maxH
//        	return maxW * maxH;
//        }
//        boolean flag = true;
//        while(flag) {
//        	for(int i = 0; i < heightDesc.length; i++) {
//        		int w = heightDesc[i][0];
//        		int h = heightDesc[i][1];
//        		// 회전하는 경우까지 고려해 명함이 지갑에 들어갈 수 있는지 확인
//        		if((l >= w && s >= h) || (l >= h && s >= w)) continue;
//        		flag = false;
//        		break;
//        	}
//        }
        
        return answer;
    }
}
