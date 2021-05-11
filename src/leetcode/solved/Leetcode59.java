//Given a positive integer n, generate an n x n matrix filled with elements from
// 1 to n2 in spiral order. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: [[1,2,3],[8,9,4],[7,6,5]]
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 
// 👍 399 👎 0


package leetcode.solved;

public class Leetcode59 {
    public static void main(String[] args) {
        Solution solution = new Leetcode59().new Solution();
        solution.generateMatrix(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];
            if (n == 1) {
                res[0][0] = 1;
                return res;
            }
            int ele = 1, n2 = n * n, count = n - 1, start = 0;
            while (ele <= n2) {
                int x = start, y = start;
                if (ele == n2) {
                    res[x][y] = n2;
                    break;
                }

                int tmp = count;
                while (ele <= n2 && tmp-- > 0) {
                    res[x][y++] = ele++;
                }

                tmp = count;
                while (ele <= n2 && tmp-- > 0) {
                    res[x++][y] = ele++;
                }

                tmp = count;
                while (ele <= n2 && tmp-- > 0) {
                    res[x][y--] = ele++;
                }

                tmp = count;
                while (ele <= n2 && tmp-- > 0) {
                    res[x--][y] = ele++;
                }

                count -= 2;
                start++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}