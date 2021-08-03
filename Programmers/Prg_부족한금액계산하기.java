
public class Prg_부족한금액계산하기 {

	public static void main(String[] args) {
		System.out.println(solution(3, 20, 4));
	}
	
	private static long solution(int price, int money, int count) {
		long answer = money;
		long total_cost = count * (count+1) / 2;
		total_cost *= price;
		answer -= total_cost;
		if(answer > 0) {
			answer = 0;
		}
		else {
			answer = Math.abs(answer);
		}
		return answer;
	}

}
