
public class LeetCode_2_AddTwoNumbers {
	public static void main(String[] args) {
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode();
		ListNode node = result;
		int sum = 0; int carry = 0;
		
		while(l1 != null || l2 != null) {
			sum = carry;
			
			if(l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if(l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			carry = sum / 10;
			sum %= 10;
			
			ListNode next = new ListNode(sum);
			node.next = next;
			node = next;
		}
		
		if(carry == 1) {
			ListNode next = new ListNode(1);
			node.next = next;
		}
		
		
		return result.next;
    }
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}
