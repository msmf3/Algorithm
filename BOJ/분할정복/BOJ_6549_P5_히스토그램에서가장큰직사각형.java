package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 참고 : https://st-lab.tistory.com/255
 */

public class BOJ_6549_P5_히스토그램에서가장큰직사각형 {
	static int rectangles[];
	static long max_size;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if(N == 0) {
				System.out.print(sb.toString());
				System.exit(0);
			}
			rectangles = new int[N];
			for(int i = 0; i < N; i++) {
				rectangles[i] = Integer.parseInt(st.nextToken());
			}
			max_size = 0;
			sb.append(getMaxSize(0, N-1) + "\n");
		}
	}
	
	private static long getMaxSize(int start, int end) {
		if(start == end) {
			return rectangles[start];
		}
		int middle = (start + end) / 2;
		long leftSize = getMaxSize(start, middle);
		long rightSize = getMaxSize(middle+1, end);
		long maxSize = Math.max(leftSize, rightSize);
		
		// 중간을 지나가는 직사각형의 최대값
		int lIdx = middle; int rIdx = middle;
		long minHeight = rectangles[middle];
		long size = rectangles[middle];
		while(lIdx > start && rIdx < end) {
			// 높이가 더 큰쪽으로 뻗어나가면서 비교
			if(rectangles[lIdx - 1] < rectangles[rIdx + 1]) {
				++rIdx;
				minHeight = Math.min(minHeight, rectangles[rIdx]);
			}
			else {
				--lIdx;
				minHeight = Math.min(minHeight, rectangles[lIdx]);
			}
			size = Math.max(size, minHeight * (rIdx - lIdx + 1));
		}
		
		while(rIdx < end) {
			++rIdx;
			minHeight = Math.min(minHeight, rectangles[rIdx]);
			size = Math.max(size, minHeight * (rIdx - lIdx + 1));
		}
		
		while(lIdx > start) {
			--lIdx;
			minHeight = Math.min(minHeight, rectangles[lIdx]);
			size = Math.max(size, minHeight * (rIdx - lIdx + 1));
		}
		
		maxSize = Math.max(maxSize, size);
		
		return maxSize;
	}
}
