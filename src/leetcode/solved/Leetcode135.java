//There are N children standing in a line. Each child is assigned a rating value
//. 
//
// You are giving candies to these children subjected to the following requireme
//nts: 
//
// 
// Each child must have at least one candy. 
// Children with a higher rating get more candies than their neighbors. 
// 
//
// What is the minimum candies you must give? 
//
// Example 1: 
//
// 
//Input: [1,0,2]
//Output: 5
//Explanation: You can allocate to the first, second and third child with 2, 1, 
//2 candies respectively.
// 
//
// Example 2: 
//
// 
//Input: [1,2,2]
//Output: 4
//Explanation: You can allocate to the first, second and third child with 1, 2, 
//1 candies respectively.
//             The third child gets 1 candy because it satisfies the above two c
//onditions.
// 
// Related Topics 贪心算法 
// 👍 359 👎 0


package leetcode.solved;

public class Leetcode135 {
    public static void main(String[] args) {
        Solution solution = new Leetcode135().new Solution();
        int[] rate = {0, 1, 1};
        int res = solution.candy(rate);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int candy(int[] ratings) {
            if (ratings.length == 1)
                return 1;

            //pos为遍历指针，res存储最终结果
            int pos = 0, res = 0;

            while (pos < ratings.length - 1) {
                //up表示上升序列的长度，down表示下降序列的长度
                int up = 0, down = 0;

                //记录上升序列长度
                while (pos < ratings.length - 1 && ratings[pos] < ratings[pos + 1]) {
                    ++up;
                    ++pos;
                }

                //前一下降序列末尾元素 与 当前上升序列头元素 会重复计算
                //当res不为0时，res减一去除重复计算
                if (res != 0)
                    --res;

                //记录下降序列长度
                while (pos < ratings.length - 1 && ratings[pos] > ratings[pos + 1]) {
                    ++down;
                    ++pos;
                }

                //当遇到相邻元素相等时，将后一个当作最小值，res加一
                while (pos < ratings.length - 1 && ratings[pos] == ratings[pos + 1]) {
                    ++res;
                    ++pos;
                }

                //根据等差数列公式，计算这一组（一个上升序列+一个下降序列）的总糖果值
                //上升序列和下降序列的顶点值由最长的序列决定
                res += (1 + up) * up / 2 + (1 + down) * down / 2 + Math.max(up, down) + 1;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}