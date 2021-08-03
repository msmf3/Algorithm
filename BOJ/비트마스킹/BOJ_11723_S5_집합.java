package 비트마스킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 참고 : https://dragon-h.tistory.com/28
 */

public class BOJ_11723_S5_집합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		int bitset = 0;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String oper = st.nextToken();
			int num;
			switch(oper) {
			case "add":
				num = Integer.parseInt(st.nextToken());
				// OR 1 연산으로 해당 비트를 체킹함
				// num-1인 이유는 가장 오른쪽 비트가 0이기 때문
				bitset |= (1 << (num-1));
				break;
			case "remove":
				num = Integer.parseInt(st.nextToken());
				bitset &= ~(1 << (num-1));
				break;
			case "check":
				num = Integer.parseInt(st.nextToken());
				sb.append((bitset & (1 << (num-1))) != 0 ? "1\n" : "0\n");
				break;
			case "toggle":
				num = Integer.parseInt(st.nextToken());
				// XOR(서로다르면1을반환) 1 연산으로 해당 비트를 토글
				// 1 XOR 1 = 0, 0 XOR 1 = 1
				bitset ^= (1 << (num-1));
				break;
			case "all":
				bitset |= ~0;
				break;
			case "empty":
				bitset &= 0;
				break;
			}
		}
		System.out.println(sb.toString());
	}

}
