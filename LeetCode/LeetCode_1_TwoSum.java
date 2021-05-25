import java.util.HashMap;

public class LeetCode_1_TwoSum {

	public static void main(String[] args) {
		int nums[] = {2, 7, 11, 15};
		int target = 9;
		
		int a[] = twoSum(nums, target);
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static int[] twoSum(int[] nums, int target) {
		int ans[] = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		// hash map에 target-nums[i]를 key로 저장하고
		// 그 뒤에 nums배열에 담긴 값들이 hash map key에 담겨있는지 확인
		// 담겨있으면 sum을 이루는 조합임
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				ans[0] = map.get(nums[i]);
				ans[1] = i;
				break;
			}
			map.put(target-nums[i], i);
		}
		
		return ans;
    }
}
