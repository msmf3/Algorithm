package 힙;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 참고 : https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%94%94%EC%8A%A4%ED%81%AC-%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC-Java
 */

public class Prg_Level3_디스크컨트롤러 {

	public static void main(String[] args) {
		int[][] jobs = {{0,3},{1,9},{2,6}};
		System.out.println(solution(jobs));
	}
	
	public static int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (j1, j2) ->{
        	return j1[0] - j2[0];
        });
        
        Queue<Job> waitingQueue = new LinkedList<>();
        for(int[] job : jobs) {
        	waitingQueue.add(new Job(job[0], job[1]));
        }
        PriorityQueue<Job> pq = new PriorityQueue<>();
        
        // 작업완료개수
        int cnt = 0;
        // 첫 요청시간부터 시작
        int time = jobs[0][0];
        while(cnt < jobs.length) {
        	// 현재 시간이하의 요청시간을 갖는 작업들 pq에 추가
        	while(!waitingQueue.isEmpty() && waitingQueue.peek().requestTime <= time) {
        		pq.add(waitingQueue.poll());
        	}
        	
        	if(!pq.isEmpty()) {
        		Job job = pq.poll();
        		time += job.workingTime;
        		answer += (time - job.requestTime);
        		++cnt;
        	}
        	// 진행되는 작업이 없는 경우
        	else {
        		// 1초증가
        		++time;
        	}
        }
        answer /= jobs.length;
        return answer;
    }
	
	static class Job implements Comparable<Job> {
		int requestTime, workingTime;
		
		public Job(int requestTime, int workingTime) {
			this.requestTime = requestTime;
			this.workingTime = workingTime;
		}

		@Override
		public int compareTo(Job o) {
			return this.workingTime - o.workingTime;
		}
	}
}
