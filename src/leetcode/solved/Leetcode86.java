//Given a linked list and a value x, partition it such that all nodes less than 
//x come before nodes greater than or equal to x. 
//
// You should preserve the original relative order of the nodes in each of the t
//wo partitions. 
//
// Example: 
//
// 
//Input: head = 1->4->3->2->5->2, x = 3
//Output: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针 
// 👍 347 👎 0


package leetcode.solved;

import java.util.List;

public class Leetcode86 {
    public static void main(String[] args) {
        Solution solution = new Leetcode86().new Solution();

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
        public ListNode partition(ListNode head, int x) {
            ListNode lHead = new ListNode(0);
            ListNode sHead = new ListNode(0);
            ListNode lCur = lHead;
            ListNode sCur = sHead;
            ListNode cur = head;
            while (cur != null) {
                if (cur.val < x) {
                    sCur.next = cur;
                    cur = cur.next;
                    sCur = sCur.next;
                } else {
                    lCur.next = cur;
                    cur = cur.next;
                    lCur = lCur.next;
                }
            }
            sCur.next = lHead.next;
            lCur.next = null;
            return sHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}