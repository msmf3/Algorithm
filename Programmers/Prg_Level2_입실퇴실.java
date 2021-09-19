import java.util.ArrayList;

public class Prg_Level2_입실퇴실 {

	public static void main(String[] args) {
		int[] enter = {1,4,2,3};
		int[] leave = {2,1,3,4};
		int[] answer = solution(enter, leave);
		for(int a : answer) {
			System.out.print(a + " ");
		}
	}
	
	public static int[] solution(int[] enter, int[] leave) {
		int n = enter.length;
        int[] answer = new int[n];
        int eIdx = 0; int lIdx = 0;
        ArrayList<Integer> room = new ArrayList<>();
        while(eIdx < n || lIdx < n) {
        	if(!room.contains(leave[lIdx])) {
        		room.add(enter[eIdx]);
        		++eIdx;
        	}
        	else {
        		room.remove(Integer.valueOf(leave[lIdx]));
        		// 나가는 사람은 회의실의 사람만큼 ++
        		answer[leave[lIdx]-1] += room.size();
        		// 회의실에 남은 나머지 사람들은 +1
        		for(int a : room) {
        			++answer[a-1];
        		}
        		++lIdx;
        	}
        }
        return answer;
    }
}
