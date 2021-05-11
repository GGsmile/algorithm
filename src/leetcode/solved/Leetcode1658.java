//You are given an integer array nums and an integer x. In one operation, you ca
//n either remove the leftmost or the rightmost element from the array nums and su
//btract its value from x. Note that this modifies the array for future operations
//. 
//
// Return the minimum number of operations to reduce x to exactly 0 if it's poss
//ible, otherwise, return -1. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,4,2,3], x = 5
//Output: 2
//Explanation: The optimal solution is to remove the last two elements to reduce
// x to zero.
// 
//
// Example 2: 
//
// 
//Input: nums = [5,6,7,8,9], x = 4
//Output: -1
// 
//
// Example 3: 
//
// 
//Input: nums = [3,2,20,1,1,3], x = 10
//Output: 5
//Explanation: The optimal solution is to remove the last three elements and the
// first two elements (5 operations in total) to reduce x to zero.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 104 
// 1 <= x <= 109 
// 
// Related Topics 贪心算法 双指针 二分查找 Sliding Window 
// 👍 53 👎 0


package leetcode.solved;

public class Leetcode1658 {
    public static void main(String[] args) {
        Solution solution = new Leetcode1658().new Solution();
        int[] nums = {5};
        solution.minOperations(nums, 5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums, int x) {
            //prefix sum of nums, make preNums[0] = 0
            int[] preNums = new int[nums.length + 1];
            preNums[0] = 0;
            for (int i = 1; i < preNums.length; i++)
                preNums[i] = nums[i - 1] + preNums[i - 1];
            //suffix sum of nums
            int[] sufNums = new int[nums.length];
            sufNums[sufNums.length - 1] = nums[nums.length - 1];
            for (int i = sufNums.length - 2; i >= 0; i--)
                sufNums[i] = nums[i] + sufNums[i + 1];

            int left = 1;
            int right = sufNums.length - 1;
            int minSteps = 1000000;
            //find the left make preNums[left] >= x
            while (left < preNums.length && preNums[left] < x)
                left++;
            if (left == preNums.length) return -1;
            if (preNums[left] == x) minSteps = left;
            left--;

            while (left >= 0) {
                while (left < right && preNums[left] + sufNums[right] < x)
                    right--;
                if (preNums[left] + sufNums[right] == x)
                    minSteps = Math.min(minSteps, left + sufNums.length - right);
                left--;
            }
            if (minSteps == 1000000)
                return -1;
            else return minSteps;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}