package 문자열;

public class Programmers_Level1_신규아이디추천 {

	public static void main(String[] args) {
		String new_id = "=.=";
		System.out.println(solution(new_id));
	}
	
	public static String solution(String new_id) {
		String answer = "";
		answer = level_1(new_id);
		answer = level_2(answer);
		answer = level_3(answer);
		answer = level_4(answer);
		answer = level_5(answer);
		answer = level_6(answer);
		answer = level_7(answer);
		return answer;
	}
	
	private static String level_1(String s) {
		return s.toLowerCase();
	}
	
	private static String level_2(String s) {
		String match = "[^a-z0-9-_.]";
		s = s.replaceAll(match, "");
		return s;
	}

	private static String level_3(String s) {
		String match = "[.]+";
		s = s.replaceAll(match, ".");
		return s;
	}
	
	private static String level_4(String s) {
		if(!s.isEmpty() && s.charAt(0) == '.') {
			s = s.substring(1, s.length());
		}
		if(!s.isEmpty() && s.charAt(s.length()-1) == '.') {
			s = s.substring(0, s.length()-1);
		}
		return s;
	}
	
	private static String level_5(String s) {
		if(s.isEmpty()) {
			s = "a";
		}
		return s;
	}
	
	private static String level_6(String s) {
		if(s.length() > 15) {
			s = s.substring(0, 15);
		}
		s = level_4(s);
		return s;
	}
	
	private static String level_7(String s) {
		if(!s.isEmpty() && s.length() < 3) {
			char a = s.charAt(s.length()-1);
			while(s.length() < 3) {
				s = s + a;
			}
		}
		return s;
	}
}
