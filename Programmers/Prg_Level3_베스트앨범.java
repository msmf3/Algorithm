import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

public class Prg_Level3_베스트앨범 {

	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		int[] answer = solution(genres, plays);
		for(int a : answer) {
			System.out.print(a + " ");
		}
	}
	
	public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreCntMap = new HashMap<>();
        HashMap<String, ArrayList<Music>> genreMusicMap = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
        	if(genreMusicMap.containsKey(genres[i])) {
        		genreMusicMap.get(genres[i]).add(new Music(i, plays[i]));
        	}
        	else {
        		ArrayList<Music> list = new ArrayList<>();
        		list.add(new Music(i, plays[i]));
        		genreMusicMap.put(genres[i], list);
        	}
        	
        	genreCntMap.put(genres[i], genreCntMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        ArrayList<Entry<String, Integer>> sortGenreList = new ArrayList<>(genreCntMap.entrySet());
        sortGenreList.sort(Entry.comparingByValue(Comparator.reverseOrder()));
        
        ArrayList<Integer> answerList = new ArrayList<>();
        for(Entry<String, Integer> e : sortGenreList) {
        	String genre = e.getKey();
        	ArrayList<Music> list = genreMusicMap.get(genre);
        	Collections.sort(list);
        	for(int i = 0; i < list.size(); i++) {
        		if(i == 2) break;
        		answerList.add(list.get(i).idx);
        	}
        }
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++) {
        	answer[i] = answerList.get(i);
        }
        
        return answer;
    }
	
	static class Genre {
		String name;
		int plays;
		
		public Genre(String name, int plays) {
			this.name = name;
			this.plays = plays;
		}
	}
	
	static class Music implements Comparable<Music> {
		int idx, plays;
		
		public Music(int idx, int plays) {
			this.idx = idx;
			this.plays = plays;
		}

		@Override
		public int compareTo(Music o) {
			if(this.plays == o.plays) {
				return Integer.compare(this.idx, o.idx);
			}
			return Integer.compare(o.plays, this.plays);
		}
	}
}
