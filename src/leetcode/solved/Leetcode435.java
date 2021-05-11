//Given a collection of intervals, find the minimum number of intervals you need
// to remove to make the rest of the intervals non-overlapping. 
//
// 
// 
//
// 
//
// Example 1: 
//
// 
//Input: [[1,2],[2,3],[3,4],[1,3]]
//Output: 1
//Explanation: [1,3] can be removed and the rest of intervals are non-overlappin
//g.
// 
//
// Example 2: 
//
// 
//Input: [[1,2],[1,2],[1,2]]
//Output: 2
//Explanation: You need to remove two [1,2] to make the rest of intervals non-ov
//erlapping.
// 
//
// Example 3: 
//
// 
//Input: [[1,2],[2,3]]
//Output: 0
//Explanation: You don't need to remove any of the intervals since they're alrea
//dy non-overlapping.
// 
//
// 
//
// Note: 
//
// 
// You may assume the interval's end point is always bigger than its start point
//. 
// Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap
// each other. 
// 
// Related Topics 贪心算法 
// 👍 282 👎 0


package leetcode.solved;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode435 {
    public static void main(String[] args) {
        Solution solution = new Leetcode435().new Solution();
        int[][] inter = {{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}};
        int r = solution.eraseOverlapIntervals(inter);
        System.out.println(r);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            if (intervals.length == 0)
                return 0;
            int end = intervals[0][1];
            int res = 0;
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] < end) {
                    end = Math.min(end, intervals[i][1]);
                    res++;
                } else end = intervals[i][1];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}