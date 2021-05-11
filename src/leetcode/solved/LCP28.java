package leetcode.solved;

import java.util.Arrays;

public class LCP28 {
    public static void main(String[] args) {
        Solution solution = new LCP28().new Solution();
        int[] a = {2, 2, 1, 9};
        solution.purchasePlans(a, 10);
    }

    class Solution {
        public int purchasePlans(int[] nums, int target) {
            Arrays.sort(nums);
            int left = 0, right = nums.length - 1;
            long res = 0L;
            while(right < nums.length && left < right){
                if(nums[left] + nums[right] > target){
                    right--;
                }else if(nums[left] + nums[right] <= target){
                    res = (res + right - left) % 1000000007;
                    left++;
                    if (right == nums.length - 1)
                        continue;
                    right++;
                }
            }
            return (int)res;
        }
    }
}
