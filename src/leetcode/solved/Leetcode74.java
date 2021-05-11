//Write an efficient algorithm that searches for a value in an m x n matrix. Thi
//s matrix has the following properties: 
//
// 
// Integers in each row are sorted from left to right. 
// The first integer of each row is greater than the last integer of the previou
//s row. 
// 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 367 👎 0


package leetcode.solved;

public class Leetcode74 {
    public static void main(String[] args) {
        Solution solution = new Leetcode74().new Solution();
        int[][] a = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        solution.searchMatrix(a, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int x = binarySearch(matrix, 0, matrix.length - 1, target, 0, 1, 0, 0);
            if (x > 0 && matrix[x][0] > target) x--;
            int y = binarySearch(matrix, 0, matrix[0].length - 1, target, x, 0, 1, 1);
            return matrix[x][y] == target;
        }

        int binarySearch(int[][] matrix, int left, int right, int target, int x, int x1, int x2, int y) {
            int mid = 0;
            while (left < right) {
                mid = (left + right) / 2;
                if (matrix[x1 * mid + x2 * x][y * mid] == target) {
                    return mid;
                } else if (matrix[x1 * mid + x2 * x][y * mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}