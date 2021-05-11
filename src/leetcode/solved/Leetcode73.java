//Given an m x n matrix. If an element is 0, set its entire row and column to 0.
// Do it in-place. 
//
// Follow up: 
//
// 
// A straight forward solution using O(mn) space is probably a bad idea. 
// A simple improvement uses O(m + n) space, but still not the best solution. 
// Could you devise a constant space solution? 
// 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//Output: [[1,0,1],[0,0,0],[1,0,1]]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[0].length 
// 1 <= m, n <= 200 
// -231 <= matrix[i][j] <= 231 - 1 
// 
// Related Topics 数组 
// 👍 464 👎 0


package leetcode.solved;

public class Leetcode73 {
    public static void main(String[] args) {
        Solution solution = new Leetcode73().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;

            boolean isFirstRowZero = false, isFirstColZero = false;
            for (int x = 0; x < m; x++) {
                if (matrix[x][0] == 0) {
                    isFirstColZero = true;
                    break;
                }
            }
            for (int num : matrix[0]) {
                if (num == 0) {
                    isFirstRowZero = true;
                    break;
                }
            }

            for (int x = 1; x < m; x++) {
                for (int y = 1; y < n; y++) {
                    if (matrix[x][y] == 0) {
                        matrix[0][y] = 0;
                        matrix[x][0] = 0;
                    }
                }
            }

            for (int y = 1; y < n; y++) {
                if (matrix[0][y] == 0) {
                    for (int x = 1; x < m; x++) {
                        matrix[x][y] = 0;
                    }
                }
            }

            for (int x = 1; x < m; x++) {
                if (matrix[x][0] == 0) {
                    for (int y = 1; y < n; y++) {
                        matrix[x][y] = 0;
                    }
                }
            }

            if (isFirstRowZero) {
                for (int y = 0; y < n; y++) {
                    matrix[0][y] = 0;
                }
            }
            if (isFirstColZero) {
                for (int x = 0; x < m; x++) {
                    matrix[x][0] = 0;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}