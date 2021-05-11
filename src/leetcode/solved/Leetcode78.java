//Given an integer array nums of unique elements, return all possible subsets (t
//he power set). 
//
// The solution set must not contain duplicate subsets. Return the solution in a
//ny order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// Example 2: 
//
// 
//Input: nums = [0]
//Output: [[],[0]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// All the numbers of nums are unique. 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 1091 👎 0


package leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class Leetcode78 {
    public static void main(String[] args) {
        Solution solution = new Leetcode78().new Solution();
        int[] nums = {1,2,3};
        solution.subsets(nums);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> subsets(int[] nums) {
            List<Integer> cur = new ArrayList<>();
            dfs(nums, 0, cur);
            return this.ans;
        }

        void dfs(int[] nums, int index, List<Integer> cur) {
            if (nums.length == index) {
                this.ans.add(new ArrayList<>(cur));
                return;
            }

            cur.add(nums[index]);
            dfs(nums, index + 1, cur);
            cur.remove(cur.size() - 1);
            dfs(nums, index + 1, cur);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}