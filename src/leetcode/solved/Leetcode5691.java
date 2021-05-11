//You are given two arrays of integers nums1 and nums2, possibly of different le
//ngths. The values in the arrays are between 1 and 6, inclusive. 
//
// In one operation, you can change any integer's value in any of the arrays to 
//any value between 1 and 6, inclusive. 
//
// Return the minimum number of operations required to make the sum of values in
// nums1 equal to the sum of values in nums2. Return -1 if it is not possible to m
//ake the sum of the two arrays equal. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
//Output: 3
//Explanation: You can make the sums of nums1 and nums2 equal with 3 operations.
// All indices are 0-indexed.
//- Change nums2[0] to 6. nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2].
//- Change nums1[5] to 1. nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2].
//- Change nums1[2] to 2. nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2].
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,1,1,1,1,1,1], nums2 = [6]
//Output: -1
//Explanation: There is no way to decrease the sum of nums1 or to increase the s
//um of nums2 to make them equal.
// 
//
// Example 3: 
//
// 
//Input: nums1 = [6,6], nums2 = [1]
//Output: 3
//Explanation: You can make the sums of nums1 and nums2 equal with 3 operations.
// All indices are 0-indexed. 
//- Change nums1[0] to 2. nums1 = [2,6], nums2 = [1].
//- Change nums1[1] to 2. nums1 = [2,2], nums2 = [1].
//- Change nums2[0] to 4. nums1 = [2,2], nums2 = [4].
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length, nums2.length <= 105 
// 1 <= nums1[i], nums2[i] <= 6 
// 
// Related Topics 贪心算法 
// 👍 13 👎 0


package leetcode.solved;

import java.util.Arrays;

public class Leetcode5691 {
    public static void main(String[] args) {
        Solution solution = new Leetcode5691().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums1, int[] nums2) {
            int sumOfNums1 = sumOfNums(nums1);
            int sumOfNums2 = sumOfNums(nums2);
            if (sumOfNums1 == sumOfNums2) return 0;

            if (sumOfNums1 < sumOfNums2) return minOperations(nums2, nums1);

            int count = 0;
            int[] greedy = new int[6];

            for (int i = 0; i < nums1.length; i++) ++greedy[nums1[i] - 1];
            for (int j = 0; j < nums2.length; j++) ++greedy[6 - nums2[j]];

            int differ = sumOfNums1 - sumOfNums2;
            for (int k = greedy.length - 1; k > 0; k--) {
                while (greedy[k] > 0) {
                    differ -= k;
                    ++count;
                    --greedy[k];
                    if (differ <= 0) return count;
                }
            }
            return -1;
        }

        int sumOfNums(int[] nums) {
            int result = 0;
            for (int num : nums) result += num;
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}