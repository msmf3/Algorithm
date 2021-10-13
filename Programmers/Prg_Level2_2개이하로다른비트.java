
public class Prg_Level2_2개이하로다른비트 {

	public static void main(String[] args) {
		long[] numbers = {1001,337,0,1,333,673,343,221,898,997,121,1015,665,779,891,421,222,256,512,128,100};
		long[] answers = solution(numbers);
		for(long answer : answers) {
			System.out.println(answer);
		}
	}
	
	public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
        	long number = numbers[i];
        	if(number % 2 == 0) {
        		answer[i] = number + 1;
        	}
        	else {
        		long k = 1;
        		long n = 0;
        		while(true) {
        			k <<= 1;
        			if((number & k) == 0) {
        				break;
        			}
        			++n;
        		}
        		answer[i] = number + ((long)1 << n);
        	}
        }
        return answer;
    }
}
