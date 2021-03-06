//On a 2D plane, we place n stones at some integer coordinate points. Each coord
//inate point may have at most one stone. 
//
// A stone can be removed if it shares either the same row or the same column as
// another stone that has not been removed. 
//
// Given an array stones of length n where stones[i] = [xi, yi] represents the l
//ocation of the ith stone, return the largest possible number of stones that can 
//be removed. 
//
// 
// Example 1: 
//
// 
//Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
//Output: 5
//Explanation: One way to remove 5 stones is as follows:
//1. Remove stone [2,2] because it shares the same row as [2,1].
//2. Remove stone [2,1] because it shares the same column as [0,1].
//3. Remove stone [1,2] because it shares the same row as [1,0].
//4. Remove stone [1,0] because it shares the same column as [0,0].
//5. Remove stone [0,1] because it shares the same row as [0,0].
//Stone [0,0] cannot be removed since it does not share a row/column with anothe
//r stone still on the plane.
// 
//
// Example 2: 
//
// 
//Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
//Output: 3
//Explanation: One way to make 3 moves is as follows:
//1. Remove stone [2,2] because it shares the same row as [2,0].
//2. Remove stone [2,0] because it shares the same column as [0,0].
//3. Remove stone [0,2] because it shares the same row as [0,0].
//Stones [0,0] and [1,1] cannot be removed since they do not share a row/column 
//with another stone still on the plane.
// 
//
// Example 3: 
//
// 
//Input: stones = [[0,0]]
//Output: 0
//Explanation: [0,0] is the only stone on the plane, so you cannot remove it.
// 
//
// 
// Constraints: 
//
// 
// 1 <= stones.length <= 1000 
// 0 <= xi, yi <= 104 
// No two stones are at the same coordinate point. 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 135 👎 0


package leetcode.solved;

import java.util.HashMap;
import java.util.Map;

public class Leetcode947 {
    public static void main(String[] args) {
        Solution solution = new Leetcode947().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeStones(int[][] stones) {
            Map<Integer, Integer> row = new HashMap<>();
            Map<Integer, Integer> col = new HashMap<>();
            for (int[] stone : stones) {
                row.put(stone[0], row.getOrDefault(stone[0], 0) + 1);
                col.put(stone[1], col.getOrDefault(stone[1], 0) + 1);
            }
            int res = 0;
            for (int[] stone : stones) {
                if (row.get(stone[0]) > 1 || col.get(stone[1]) > 1) {
                    row.put(stone[0], row.get(stone[0]) - 1);
                    col.put(stone[1], col.get(stone[1]) - 1);
                    res++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}