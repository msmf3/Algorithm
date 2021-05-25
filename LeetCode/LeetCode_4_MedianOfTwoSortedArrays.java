
public class LeetCode_4_MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length; int n = nums2.length;
		int mIdx = (m+n)/2;
		int arr[] = new int[mIdx+1];
		double median = 0;
		int aIdx = 0; int bIdx = 0;
		int idx = 0;
		while(aIdx < m && bIdx < n && idx <= mIdx) {
			if(nums1[aIdx] < nums2[bIdx]) {
				arr[idx] = nums1[aIdx];
				++aIdx;
			}else {
				arr[idx] = nums2[bIdx];
				++bIdx;
			}
			++idx;
		}
		if(idx <= mIdx) {	// arr 배열이 중간값까지 도달하지 못한 경우
			if(aIdx == m) {	// nums2 배열의 값만 남음
				for(; idx <= mIdx; idx++) {
					arr[idx] = nums2[bIdx];
					++bIdx;
				}
			}
			else if(bIdx == n) {	// nums1 배열의 값만 남음
				for(; idx <= mIdx; idx++) {
					arr[idx] = nums1[aIdx];
					++aIdx;
				}
			}
		}
		
		if((m+n)%2 == 0) median = (double)(arr[mIdx-1] + arr[mIdx]) / 2;
		else median = arr[mIdx];
		return median;
    }
}
