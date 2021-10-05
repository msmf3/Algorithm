
public class Prg_Level2_거리두기확인하기 {

	public static void main(String[] args) {
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		int[] answer = solution(places);
		for(int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[] ddr = {-1, 1, 1, -1};
	static int[] ddc = {1, 1, -1, -1};

	public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int kd = 1;
        for(int i = 0; i < places.length; i++) {
        	kd = 1;
        	String[] map = places[i];
        	a:for(int j = 0; j < 5; j++) {
        		for(int k = 0; k < 5; k++) {
        			if(map[j].charAt(k) == 'P') {
        				if(!keepDistance(map, j, k)) {
        					kd = 0;
        					break a;
        				}
        			}
        		}
        	}
        	answer[i] = kd;
        }
        
        return answer;
    }
	
	private static boolean keepDistance(String[] map, int r, int c) {
		// 맨해튼 거리 1
		for(int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if(nr < 0 || 4 < nr || nc < 0 || 4 < nc) continue;
			
			if(map[nr].charAt(nc) == 'P') return false;
		}
		
		// 맨해튼 거리 2 - 직선
		for(int k = 0; k < 4; k++) {
			int nr = r + 2*dr[k];
			int nc = c + 2*dc[k];
			if(nr < 0 || 4 < nr || nc < 0 || 4 < nc) continue;
			
			if(map[nr].charAt(nc) == 'P') {
				int br = r + dr[k];
				int bc = c + dc[k];
				if(map[br].charAt(bc) == 'O') {
					return false;
				}
			}
		}
		
		// 맨해튼 거리 2 - 대각선
		for(int k = 0; k < 4; k++) {
			int nr = r + ddr[k];
			int nc = c + ddc[k];
			if(nr < 0 || 4 < nr || nc < 0 || 4 < nc) continue;
			
			if(map[nr].charAt(nc) == 'P') {
				int br1 = r + dr[k];
				int bc1 = c + dc[k];
				int br2 = r + dr[(k+1)%4];
				int bc2 = c + dc[(k+1)%4];
				if(map[br1].charAt(bc1) == 'O' || map[br2].charAt(bc2) == 'O') {
					return false;
				}
			}
		}
		
		return true;
	}
}
