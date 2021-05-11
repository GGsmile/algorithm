//Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to A[
//i] interpreted as a binary number (from most-significant-bit to least-significan
//t-bit.) 
//
// Return a list of booleans answer, where answer[i] is true if and only if N_i 
//is divisible by 5. 
//
// Example 1: 
//
// 
//Input: [0,1,1]
//Output: [true,false,false]
//Explanation: 
//The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10. 
// Only the first number is divisible by 5, so answer[0] is true.
// 
//
// Example 2: 
//
// 
//Input: [1,1,1]
//Output: [false,false,false]
// 
//
// Example 3: 
//
// 
//Input: [0,1,1,1,1,1]
//Output: [true,false,false,false,true,false]
// 
//
// Example 4: 
//
// 
//Input: [1,1,1,0,1]
//Output: [false,false,false,false,false]
// 
//
// 
//
// Note: 
//
// 
// 1 <= A.length <= 30000 
// A[i] is 0 or 1 
// 
// Related Topics 数组 
// 👍 74 👎 0


package leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1018 {
    public static void main(String[] args) {
        Solution solution = new Leetcode1018().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Boolean> prefixesDivBy5(int[] A) {
            List<Boolean> res = new ArrayList<>();
            int subNum = 0;
            for (int a : A) {
                subNum = (2 * subNum + a) % 5;
                res.add(subNum == 0);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}