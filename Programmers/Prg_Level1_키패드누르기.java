
public class Prg_Level1_키패드누르기 {

	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		System.out.println(solution(numbers, hand));
	}
	
	static int[][] numberCoordinate = {{3,1}, {0,0}, {0,1}, {0,2}, {1,0}, {1,1}, {1,2}, {2,0}, {2,1}, {2,2}};
	
	public static String solution(int[] numbers, String hand) {
        String answer = "";
        int lx = 0; int ly = 3;
        int rx = 2; int ry = 3;
        if(hand.equals("right")) hand = "R";
        else hand = "L";
        for(int number : numbers) {
        	int[] numCoord = numberCoordinate[number];
        	if(number == 1 || number == 4 || number == 7) {
        		answer += "L";
        		ly = numCoord[0];
        		lx = numCoord[1];
        	}
        	else if(number == 3 || number == 6 || number == 9) {
        		answer += "R";
        		ry = numCoord[0];
        		rx = numCoord[1];
        	}
        	else {
            	int l_distance = Math.abs(ly - numCoord[0]) + Math.abs(lx - numCoord[1]);
            	int r_distance = Math.abs(ry - numCoord[0]) + Math.abs(rx - numCoord[1]);
            	
            	if(l_distance < r_distance) {
            		answer += "L";
            		ly = numCoord[0];
            		lx = numCoord[1];
            	}
            	else if(l_distance > r_distance) {
            		answer += "R";
            		ry = numCoord[0];
            		rx = numCoord[1];
            	}
            	else {
            		if(hand.equals("R")) {
            			ry = numCoord[0];
                		rx = numCoord[1];
            		}
            		else {
            			ly = numCoord[0];
                		lx = numCoord[1];
            		}
            		answer += hand;
            	}
        	}
        }
        
        return answer;
    }
}
