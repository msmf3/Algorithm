import java.util.HashMap;

public class Prg_Level3_다단계칫솔판매 {

	public static void main(String[] args) {
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"sam", "emily", "jaimie", "edward"};
		int[] amount = {2, 3, 5, 4};
		int[] answer = solution(enroll, referral, seller, amount);
		for(int a : answer) {
			System.out.println(a);
		}
	}
	
	static HashMap<String, Integer> map;
	static int[] parents;
	
	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        map = new HashMap<>();
        parents = new int[enroll.length+1];
        
        for(int i = 0; i < enroll.length; i++) {
        	map.put(enroll[i], i+1);
        }
        for(int i = 0; i < referral.length; i++) {
        	if(map.containsKey(referral[i])) {
        		int v = map.get(referral[i]);
        		parents[i+1] = v;
        	}
        }
        for(int i = 0; i <= enroll.length; i++) {
        	System.out.print(parents[i] + " ");
        }
        System.out.println();
        
        for(int i = 0; i < seller.length; i++) {
        	int u = map.get(seller[i]);
        	int proceeds = amount[i] * 100;
        	while(u != 0) {
        		int percent10 = proceeds / 10;
        		answer[u-1] += proceeds - percent10;
        		u = parents[u];
        		proceeds = percent10;
        		if(proceeds == 0) break;
        	}
        }
        
        return answer;
    }
}
