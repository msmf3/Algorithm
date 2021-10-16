
public class Prg_Level2_방문길이 {

	public static void main(String[] args) {
		String dirs = "LULLLLLLU";
		System.out.println(solution(dirs));
	}
	
	public static int solution(String dirs) {
        int answer = 0;
        boolean[][] visitedHorizon = new boolean[11][10];
        boolean[][] visitedVertical = new boolean[10][11];
        int r = 5; int c = 5;
        
        for(int i = 0; i < dirs.length(); i++) {
        	char dir = dirs.charAt(i);
        	switch(dir) {
        	case 'L':
        		if(c == 0) continue;
        		--c;
        		if(!visitedHorizon[r][c]) {
        			visitedHorizon[r][c] = true;
        			++answer;
        		}
        		break;
        	case 'R':
        		if(c == 10) continue;
        		if(!visitedHorizon[r][c]) {
        			visitedHorizon[r][c] = true;
        			++answer;
        		}
        		++c;
        		break;
        	case 'D':
        		if(r == 0) continue;
        		--r;
        		if(!visitedVertical[r][c]) {
        			visitedVertical[r][c] = true;
        			++answer;
        		}
        		break;
        	case 'U':
        		if(r == 10) continue;
        		if(!visitedVertical[r][c]) {
        			visitedVertical[r][c] = true;
        			++answer;
        		}
        		++r;
        		break;
        	}
        }
        
        return answer;
    }
}
