//Given an array of integers nums, sort the array in increasing order based on t
//he frequency of the values. If multiple values have the same frequency, sort the
//m in decreasing order. 
//
// Return the sorted array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2,2,2,3]
//Output: [3,1,1,2,2,2]
//Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a
// frequency of 3.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,3,1,3,2]
//Output: [1,3,3,2,2]
//Explanation: '2' and '3' both have a frequency of 2, so they are sorted in dec
//reasing order.
// 
//
// Example 3: 
//
// 
//Input: nums = [-1,1,-6,4,5,-6,1,4,1]
//Output: [5,-1,4,4,-6,-6,1,1,1] 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// -100 <= nums[i] <= 100 
// 
// Related Topics 排序 数组 
// 👍 11 👎 0


package leetcode.solved;

import java.util.Arrays;
import java.util.HashMap;


public class Leetcode1636 {
    public static void main(String[] args) {
        Solution solution = new Leetcode1636().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] frequencySort(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++)
                map.put(nums[i], 1 + map.getOrDefault(nums[i], 0));
            Integer[] arr = new Integer[nums.length];
            for(int i = 0;i<nums.length;i++)
                arr[i] = nums[i];
            Arrays.sort(arr, (a,b)->map.get(a)==map.get(b)?b-a: map.get(a)-map.get(b));
            for (int i = 0; i < nums.length; i++) {
                nums[i] = arr[i];
            }
            return nums;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}