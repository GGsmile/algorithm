//Given a string S of lowercase letters, a duplicate removal consists of choosin
//g two adjacent and equal letters, and removing them. 
//
// We repeatedly make duplicate removals on S until we no longer can. 
//
// Return the final string after all such duplicate removals have been made. It 
//is guaranteed the answer is unique. 
//
// 
//
// Example 1: 
//
// 
//Input: "abbaca"
//Output: "ca"
//Explanation: 
//For example, in "abbaca" we could remove "bb" since the letters are adjacent a
//nd equal, and this is the only possible move.  The result of this move is that t
//he string is "aaca", of which only "aa" is possible, so the final string is "ca"
//.
// 
//
// 
//
// Note: 
//
// 
// 1 <= S.length <= 20000 
// S consists only of English lowercase letters. 
// 
// Related Topics 栈 
// 👍 247 👎 0


package leetcode.solved;

import java.util.Stack;

public class Leetcode1047 {
    public static void main(String[] args) {
        Solution solution = new Leetcode1047().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicates(String S) {
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < S.length(); i++) {
                if (!st.isEmpty() && st.peek() == S.charAt(i)) {
                    st.pop();
                } else {
                    st.push(S.charAt(i));
                }
            }
            StringBuilder res = new StringBuilder();
            while (!st.isEmpty()) {
                res.append(st.pop());
            }
            return res.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}