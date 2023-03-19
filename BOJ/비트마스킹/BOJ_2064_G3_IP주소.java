package 비트마스킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 참고 : https://geniusjo-story.tistory.com/429

public class BOJ_2064_G3_IP주소 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] ipAddressArr = new int[N];
		// int형의 32번째가 1이 되면 2의 보수로 -로 찍힘.
		// 하지만 비트마스킹이기 때문에 상관없음
		for(int i = 0; i < N; i++) {
			String[] ipAddress = br.readLine().split("\\.");
			
			int ip1 = Integer.parseInt(ipAddress[0]) << 24;
			int ip2 = Integer.parseInt(ipAddress[1]) << 16;
			int ip3 = Integer.parseInt(ipAddress[2]) << 8;
			int ip4 = Integer.parseInt(ipAddress[3]);
			ipAddressArr[i] = ip1 + ip2 + ip3 + ip4;
		}
		
		int diffPoint = -1;
		for(int ipIdx = 0; ipIdx < N-1; ipIdx++) {
			int ipAddress1 = ipAddressArr[ipIdx];
			int ipAddress2 = ipAddressArr[ipIdx+1];
			for(int point = 31; point > diffPoint; point--) {
				if((ipAddress1 & (1 << point)) != (ipAddress2 & (1 << point))) {
					diffPoint = point;
					break;
				}
			}
		}
		
		int networkMask = 0;
		for(int i = 31; i > diffPoint; i--) {
			networkMask |= (1 << i);
		}
		
		int networkAddress = ipAddressArr[0] & networkMask;
		
		String na = "";
		String nm = "";
		// 100000000 - 1 = 11111111
		for(int i = 0; i < 4; i++) {
			int check = (1 << 8) - 1;
			
			na = (networkAddress & check) + "." + na; 
			nm = (networkMask & check) + "." + nm; 
			
			networkAddress >>= 8;
			networkMask >>= 8;
		}
		
		na = na.substring(0, na.length()-1);
		nm = nm.substring(0, nm.length()-1);
		
		System.out.println(na);
		System.out.println(nm);
	}

}
