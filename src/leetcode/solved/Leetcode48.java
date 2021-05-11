package leetcode.solved;
//You are given an n x n 2D matrix representing an image, rotate the image by 90
// degrees (clockwise). 
//
// You have to rotate the image in-place, which means you have to modify the inp
//ut 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [[7,4,1],[8,5,2],[9,6,3]]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// Example 3: 
//
// 
//Input: matrix = [[1]]
//Output: [[1]]
// 
//
// Example 4: 
//
// 
//Input: matrix = [[1,2],[3,4]]
//Output: [[3,1],[4,2]]
// 
//
// 
// Constraints: 
//
// 
// matrix.length == n 
// matrix[i].length == n 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
// Related Topics 数组 
// 👍 729 👎 0

public class Leetcode48 {
    public static void main(String[] args) {
        Solution solution = new Leetcode48().new Solution();

    }

    //2020-12-23 11:39:14
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int row = 0; row < n / 2; ++row) {
                for (int col = row; col < n - 1 - row; ++col) {
                    int tmp = matrix[n - 1 - col][row];
                    matrix[n - 1 - col][row] = matrix[n - 1 - row][n - 1 - col];
                    matrix[n - 1 - row][n - 1 - col] = matrix[col][n - 1 - row];
                    matrix[col][n - 1 - row] = matrix[row][col];
                    matrix[row][col] = tmp;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}