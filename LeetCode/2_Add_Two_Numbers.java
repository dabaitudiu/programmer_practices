// class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
// }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int sum = 0;
        int carry = 0;
        while (l1 != null || l2 !=null) {
            if (l1 == null && l2 == null) break;
            sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (carry != 0) {
                sum += 1;
                carry = 0;
            }
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            }
            temp.next = new ListNode(sum);
            temp = temp.next;
        }
        if (carry != 0)
            temp.next = new ListNode(1);
        return result.next;
    }
}
