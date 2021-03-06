package leetcode.solved;
//
//On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 i
//ndexed).
// 
//Once you pay the cost, you can either climb one or two steps. You need to find
// minimum cost to reach the top of the floor, and you can either start from the s
//tep with index 0, or the step with index 1.
// 
//
// Example 1: 
// 
//Input: cost = [10, 15, 20]
//Output: 15
//Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
// 
// 
//
// Example 2: 
// 
//Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//Output: 6
//Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[
//3].
// 
// 
//
// Note: 
// 
// cost will have a length in the range [2, 1000]. 
// Every cost[i] will be an integer in the range [0, 999]. 
// 
// Related Topics 数组 动态规划 
// 👍 485 👎 0

public class Leetcode746{
	public static void main(String[] args) {
		Solution solution = new Leetcode746().new Solution();
		
	}
//2020-12-23 11:25:58
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
		int left = 0, right = 0;
		for (int i = 2; i < cost.length; ++i) {
			int minstep = Math.min(left + cost[i - 2], right + cost[i - 1]);
			left = right;
			right = minstep;
		}
		return right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}