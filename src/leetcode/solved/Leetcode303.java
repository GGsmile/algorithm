//Given an integer array nums, find the sum of the elements between indices left
// and right inclusive, where (left <= right). 
//
// Implement the NumArray class: 
//
// 
// NumArray(int[] nums) initializes the object with the integer array nums. 
// int sumRange(int left, int right) returns the sum of the elements of the nums
// array in the range [left, right] inclusive (i.e., sum(nums[left], nums[left + 1
//], ... , nums[right])). 
// 
//
// 
// Example 1: 
//
// 
//Input
//["NumArray", "sumRange", "sumRange", "sumRange"]
//[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
//Output
//[null, 1, -1, -3]
//
//Explanation
//NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
//numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
//numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
//numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 0 <= left <= right < nums.length 
// At most 104 calls will be made to sumRange. 
// 
// Related Topics 动态规划 
// 👍 318 👎 0


package leetcode.solved;

public class Leetcode303 {
    public static void main(String[] args) {
        NumArray solution = new Leetcode303().new NumArray();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {
        int[] prefix;

        public NumArray(int[] nums) {
            prefix = new int[nums.length + 1];
            prefix[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
        }

        public NumArray() {

        }

        public int sumRange(int left, int right) {
            return prefix[right + 1] - prefix[left];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}