//You are given an array of integers nums, there is a sliding window of size k w
//hich is moving from the very left of the array to the very right. You can only s
//ee the k numbers in the window. Each time the sliding window moves right by one 
//position. 
//
// Return the max sliding window. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [3,3,5,5,6,7]
//Explanation: 
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// Example 2: 
//
// 
//Input: nums = [1], k = 1
//Output: [1]
// 
//
// Example 3: 
//
// 
//Input: nums = [1,-1], k = 1
//Output: [1,-1]
// 
//
// Example 4: 
//
// 
//Input: nums = [9,11], k = 2
//Output: [11]
// 
//
// Example 5: 
//
// 
//Input: nums = [4,-2], k = 2
//Output: [4]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 776 👎 0


package leetcode.solved;

import java.util.PriorityQueue;
import java.util.Queue;

public class Leetcode239 {
    public static void main(String[] args) {
        Solution solution = new Leetcode239().new Solution();
        int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] b = solution.maxSlidingWindow(a, 50000);
        System.out.println(b);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            Queue<Integer> windowMax = new PriorityQueue<Integer>(k, (o1, o2) -> o2 - o1);
            int[] maxRes = new int[nums.length - k + 1];
            for (int i = 0; i < k; i++)
                windowMax.offer(nums[i]);
            maxRes[0] = windowMax.peek();
            for (int i = k; i < nums.length; i++) {
                windowMax.remove(nums[i - k]); //时间复杂度klogK
                windowMax.offer(nums[i]);
                maxRes[i - k + 1] = windowMax.peek();
            }
            return maxRes;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}