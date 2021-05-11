//A split of an integer array is good if: 
//
// 
// The array is split into three non-empty contiguous subarrays - named left, mi
//d, right respectively from left to right. 
// The sum of the elements in left is less than or equal to the sum of the eleme
//nts in mid, and the sum of the elements in mid is less than or equal to the sum 
//of the elements in right. 
// 
//
// Given nums, an array of non-negative integers, return the number of good ways
// to split nums. As the number may be too large, return it modulo 109 + 7. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,1]
//Output: 1
//Explanation: The only good way to split nums is [1] [1] [1]. 
//
// Example 2: 
//
// 
//Input: nums = [1,2,2,2,5,0]
//Output: 3
//Explanation: There are three good ways of splitting nums:
//[1] [2] [2,2,5,0]
//[1] [2,2] [2,5,0]
//[1,2] [2,2] [5,0]
// 
//
// Example 3: 
//
// 
//Input: nums = [3,2,1]
//Output: 0
//Explanation: There is no good way to split nums. 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 105 
// 0 <= nums[i] <= 104 
// Related Topics 双指针 二分查找 
// 👍 26 👎 0


package leetcode.solved;

public class Leetcode1712{
	public static void main(String[] args) {
		Solution solution = new Leetcode1712().new Solution();
		
	}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int waysToSplit(int[] nums) {
		int total = 0;
		for (int num : nums)
			total += num;
		int left = 0;
		int mid = nums[0];
		int res = 0;
		int serj = 0;
		for (int i = 0; i < nums.length; i++) {
			left += nums[i];
			if (total < 3 * left)
				break;
			mid -= nums[i];
			for (int j = serj + 1; j < nums.length - 1; j++) {
				mid += nums[j];
				if (total - left - mid < mid)
					break;
				if (mid >= left) {
					res++;
					continue;
				}
				serj = j;
			}
		}
		return res % (1000000007);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}