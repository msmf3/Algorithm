
public class Prg_Level2_쿼드압축후개수세기 {

	public static void main(String[] args) {
		int[][] arr = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
		
		int[] answer = solution(arr);
		System.out.println(answer[0] + " " + answer[1]);
	}
	
	static int[] answer;
	
	public static int[] solution(int[][] arr) {
        answer = new int[2];
        int n = arr.length;
        
        alzip(arr, n, 0, 0);
        
        return answer;
    }
	
	private static boolean alzip(int[][] arr, int n, int sr, int sc) {
		if(n == 0) return true;
		
		int bit = arr[sr][sc];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(bit != arr[sr+i][sc+j]) {
					alzip(arr, n/2, sr, sc);
					alzip(arr, n/2, sr+n/2, sc);
					alzip(arr, n/2, sr, sc+n/2);
					alzip(arr, n/2, sr+n/2, sc+n/2);
					return false;
				}
			}
		}
		
		++answer[bit];
		
		return true;
	}
}
