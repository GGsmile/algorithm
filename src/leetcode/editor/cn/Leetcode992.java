//Given an array A of positive integers, call a (contiguous, not necessarily dis
//tinct) subarray of A good if the number of different integers in that subarray i
//s exactly K. 
//
// (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.) 
//
// Return the number of good subarrays of A. 
//
// 
//
// Example 1: 
//
// 
//Input: A = [1,2,1,2,3], K = 2
//Output: 7
//Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1],
// [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
// 
//
// Example 2: 
//
// 
//Input: A = [1,2,1,3,4], K = 3
//Output: 3
//Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2
//,1,3], [1,3,4].
// 
//
// 
//
// Note: 
//
// 
// 1 <= A.length <= 20000 
// 1 <= A[i] <= A.length 
// 1 <= K <= A.length 
// Related Topics 哈希表 双指针 Sliding Window 
// 👍 293 👎 0


package leetcode.solved;

import java.util.HashMap;

public class Leetcode992 {
    public static void main(String[] args) {
        Solution solution = new Leetcode992().new Solution();
        String a = "abcdefg";
        String b = a.substring(7);



        //int[] a = {1, 2, 1, 2, 3};
        //solution.subarraysWithKDistinct(a, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraysWithKDistinct(int[] A, int K) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int left = 0, right = 0, ans = 0;
            while (left <= A.length - K) {
                int count = 0;
                while (right < A.length && count < K) {
                    if (map.containsKey(A[right])) {
                        right++;
                    } else {
                        map.put(A[right], 1);
                        right++;
                        count++;
                    }
                }
                if (right == A.length) return ans;
                ans++;
                while (right < A.length && map.containsKey(A[right])) {
                    right++;
                    ans++;
                }
                map.clear();
                left++;
                right = left;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}