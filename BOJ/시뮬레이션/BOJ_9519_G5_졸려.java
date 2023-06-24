package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_9519_G5_졸려 {
	static int X, x;
	static String word, firstWord;
	static ArrayList<String> wordList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		X = Integer.parseInt(br.readLine());
		x = X;
		word = br.readLine();
		firstWord = word;
		wordList = new ArrayList<>();
		wordList.add(firstWord);
		int s = 0;
		// 1. 반복되는 단어를 찾거나 X번째까지 진행함
		// 	  s = 처음과 반복되는 단어를 찾을 때까지의 눈 깜빡임 횟수
		while(reverseBlink()) {
			++s;
			--x;
		}
		
		// 계속 똑같은 단어가 반복되는 경우
		if(s == 0) {
			System.out.println(word);
			return;
		}
		
		// 2. 아직 횟수가 남았다면 s의 나머지로 답을 구함
		if(x > 0) {
			x = X % (s+1);
		}
		else {
			x = X;
		}
		System.out.println(wordList.get(x));
		
	}
	
	private static boolean reverseBlink() {
		if(x < 1) return false;
		String newWord = "" + word.charAt(0);
		Stack<Character> st = new Stack<>();
		
		for(int i = 1; i < word.length(); i++) {
			char c = word.charAt(i);
			if(i % 2 == 1) {
				st.add(c);
			}
			else {
				newWord += c;
			}
		}
		
		while(!st.empty()) {
			newWord += st.pop();
		}
		wordList.add(newWord);
		word = newWord;
		
		return newWord.equals(firstWord) ? false : true;
	}

}
