//Remove all elements from a linked list of integers that have value val. 
//
// Example: 
//
// 
//Input:  1->2->6->3->4->5->6, val = 6
//Output: 1->2->3->4->5
// 
// Related Topics 链表 
// 👍 502 👎 0


package leetcode.solved;

public class Leetcode203 {
    public static void main(String[] args) {
        Solution solution = new Leetcode203().new Solution();

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode res = new ListNode(0);
            res.next = head;
            ListNode pre = res, cur = head;
            while (cur != null) {
                if (cur.val == val)
                    pre.next = cur.next;
                else pre = pre.next;
                cur = cur.next;
            }
            return res.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}