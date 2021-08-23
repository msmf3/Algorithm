import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Prg_Level2_오픈채팅방 {

	public static void main(String[] args) {
		
	}
	
	public String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String> map = new HashMap<String, String>();
        for(int i = 0; i < record.length; i++) {
        	String line[] = record[i].split(" ");
        	// line[0] = oper, line[1] = id, line[2] = nickname
        	if(line[0].equals("Enter")) {
        		map.put(line[1], line[2]);
        	}
        	else if(line[0].equals("Change")) {
        		map.put(line[1], line[2]);
        	}
        }
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < record.length; i++) {
        	String line[] = record[i].split(" ");
        	if(line[0].equals("Enter")) {
        		list.add(map.get(line[1]) + "님이 들어왔습니다.");
        	}
        	else if(line[0].equals("Leave")) {
        		list.add(map.get(line[1]) + "님이 나갔습니다.");
        	}
        }
        answer = list.toArray(new String[list.size()]);
        return answer;
    }
}
