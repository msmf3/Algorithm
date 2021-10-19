import java.util.Arrays;

public class Prg_Level2_순위검색 {

	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
		int[] answer = solution(info, query);
		for (int a : answer) {
			System.out.println(a);
		}
	}

	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		Info[] infos = new Info[info.length];
		for(int i = 0; i < info.length; i++) {
			String[] inf = info[i].split(" ");
			infos[i] = new Info(inf[0], inf[1], inf[2], inf[3], Integer.parseInt(inf[4]));
		}
		Arrays.sort(infos);
		
		for (int i = 0; i < query.length; i++) {
			String q[] = query[i].split(" and ");
			int cnt = 0;
			for (int j = 0; j < info.length; j++) {
				int c = satisfyQuery(infos[j], q);
				if(c == -1) break;
				cnt += c;
			}
			answer[i] = cnt;
		}

		return answer;
	}

	private static int satisfyQuery(Info info, String[] query) {
		String qLanguage = query[0];
		String qJob = query[1];
		String qCareer = query[2];
		String fs[] = query[3].split(" ");
		String qFood = fs[0];
		String qScore = fs[1];
		if (!qLanguage.equals("-")) {
			if (!qLanguage.equals(info.language))
				return 0;
		}
		if (!qJob.equals("-")) {
			if (!qJob.equals(info.job))
				return 0;
		}
		if (!qCareer.equals("-")) {
			if (!qCareer.equals(info.career))
				return 0;
		}
		if (!qFood.equals("-")) {
			if (!qFood.equals(info.soulFood))
				return 0;
		}
		if (info.score < Integer.parseInt(qScore))
			return -1;

		return 1;
	}

	static class Info implements Comparable<Info> {
		String language, job, career, soulFood;
		int score;
		
		public Info(String language, String job, String career, String soulFood, int score) {
			this.language = language;
			this.job = job;
			this.career = career;
			this.soulFood = soulFood;
			this.score = score;
		}

		@Override
		public int compareTo(Info o) {
			return Integer.compare(o.score, score);
		}
	}
}
