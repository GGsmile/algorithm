//You have a long flowerbed in which some of the plots are planted, and some are
// not. However, flowers cannot be planted in adjacent plots. 
//
// Given an integer array flowerbed containing 0's and 1's, where 0 means empty 
//and 1 means not empty, and an integer n, return if n new flowers can be planted 
//in the flowerbed without violating the no-adjacent-flowers rule. 
//
// 
// Example 1: 
// Input: flowerbed = [1,0,0,0,1], n = 1
//Output: true
// Example 2: 
// Input: flowerbed = [1,0,0,0,1], n = 2
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= flowerbed.length <= 2 * 104 
// flowerbed[i] is 0 or 1. 
// There are no two adjacent flowers in flowerbed. 
// 0 <= n <= flowerbed.length 
// 
// Related Topics 贪心算法 数组 
// 👍 281 👎 0


package leetcode.solved;


public class Leetcode605 {
    public static void main(String[] args) {
        Solution solution = new Leetcode605().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int res = 0;
            if (flowerbed.length == 1)
                return 1 - flowerbed[0] >= n;
            if (flowerbed.length == 2)
                return (flowerbed[0] + flowerbed[1] == 0 ? 1 : 0) >= n;
            res += flowerbed[0] + flowerbed[1] == 0 ? 1 : 0;
            flowerbed[0] = 1;
            for (int i = 1; i < flowerbed.length - 1; i++) {
                if (flowerbed[i - 1] + flowerbed[i] + flowerbed[i + 1] == 0) {
                    res++;
                    flowerbed[i] = 1;
                }
            }
            res += flowerbed[flowerbed.length - 1] + flowerbed[flowerbed.length - 2] == 0 ? 1 : 0;
            return res >= n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}