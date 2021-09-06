package DFS와BFS;

import java.util.*;

public class Prg_Level3_단어변환 {

	public static void main(String[] args) {
		String words[] = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution("hit", "cog", words));
	}
	
	static int n, answer;
    static ArrayList<ArrayList<Integer>> graph;

    public static int solution(String begin, String target, String[] words) {
        n = words.length;
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
        	graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n; i++) {
            if(check(begin, words[i])){
                graph.get(0).add(i+1);
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(check(words[i], words[j])) {
                    graph.get(i+1).add(j+1);
                    graph.get(j+1).add(i+1);
                }
            }
        }
        
        answer = 0;
        bfs(target, words);
        
        return answer;
    }
    
    // 한 글자만 차이가 나는지 확인
    private static boolean check(String cur, String next) {
        int cnt = 0;
        for(int i = 0; i < cur.length(); i++) {
            if(cur.charAt(i) != next.charAt(i)) {
                if(++cnt > 1) {
                    return false;
                }
            }
        }
        if(cnt == 0) return false;
        return true;
    }
    
    private static void bfs(String target, String[] words) {
        boolean visited[] = new boolean[n+1];
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(0, 0));
        visited[0] = true;
        while(!q.isEmpty()) {
            Word cur = q.poll();
            ArrayList<Integer> list = graph.get(cur.idx);
            for(int next : list) {
            	if(visited[next]) continue;
            	visited[next] = true;
                if(words[next-1].equals(target)) {
                    answer = cur.cnt + 1;
                    return;
                }
            	q.add(new Word(next, cur.cnt+1));
            }
        }
    }
    
    static class Word {
        int idx, cnt;
        
        public Word(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}
