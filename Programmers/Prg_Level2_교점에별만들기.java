import java.util.ArrayList;

public class Prg_Level2_교점에별만들기 {

	public static void main(String[] args) {
		int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
		
		String[] answer = solution(line);
		for(String s : answer) {
			System.out.println(s);
		}
	}
	
	public static String[] solution(int[][] line) {
        long minX = Long.MAX_VALUE; long minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE; long maxY = Long.MIN_VALUE;
        ArrayList<Point> starList = new ArrayList<>();
        
        for(int i = 0; i < line.length-1; i++) {
        	long A = line[i][0];
        	long B = line[i][1];
        	long E = line[i][2];
        	for(int j = i+1; j < line.length; j++) {
        		long C = line[j][0];
        		long D = line[j][1];
        		long F = line[j][2];
        		long p = A*D - B*C;
        		if(p == 0) continue;
        		double x = (double)(B*F - E*D) / (double) p;
        		double y = (double) (E*C - A*F) / (double) p;
        		if(x % 1 != 0 || y % 1 != 0) continue;
        		minX = Math.min(minX, (long)x);
        		maxX = Math.max(maxX, (long)x);
        		minY = Math.min(minY, (long)y);
        		maxY = Math.max(maxY, (long)y);
        		starList.add(new Point((long)x, (long)y));
        	}
        }
        int xSize = (int) (maxX - minX);
        int ySize = (int) (maxY - minY);
        StringBuilder[] sb = new StringBuilder[ySize+1];
        char[] l = new char[xSize+1];
        for(int i = 0; i <= xSize; i++) {
        	l[i] = '.';
        }
        for(int i = 0; i <= ySize; i++) {
        	sb[i] = new StringBuilder(new String(l));
        }
        for(Point star : starList) {
        	sb[(int) (maxY-star.y)].setCharAt((int) (star.x-minX), '*');
        }
        
        String[] answer = new String[ySize+1];
        for(int i = 0; i <= ySize; i++) {
        	answer[i] = sb[i].toString();
        }
        return answer;
    } 
	
	static class Point {
		long x, y;
		
		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
}
