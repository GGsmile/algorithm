//There is a special kind of apple tree that grows apples every day for n days. 
//On the ith day, the tree grows apples[i] apples that will rot after days[i] days
//, that is on day i + days[i] the apples will be rotten and cannot be eaten. On s
//ome days, the apple tree does not grow any apples, which are denoted by apples[i
//] == 0 and days[i] == 0. 
//
// You decided to eat at most one apple a day (to keep the doctors away). Note t
//hat you can keep eating after the first n days. 
//
// Given two integer arrays days and apples of length n, return the maximum numb
//er of apples you can eat. 
//
// 
// Example 1: 
//
// 
//Input: apples = [1,2,3,5,2], days = [3,2,1,4,2]
//Output: 7
//Explanation: You can eat 7 apples:
//- On the first day, you eat an apple that grew on the first day.
//- On the second day, you eat an apple that grew on the second day.
//- On the third day, you eat an apple that grew on the second day. After this d
//ay, the apples that grew on the third day rot.
//- On the fourth to the seventh days, you eat apples that grew on the fourth da
//y.
// 
//
// Example 2: 
//
// 
//Input: apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
//Output: 5
//Explanation: You can eat 5 apples:
//- On the first to the third day you eat apples that grew on the first day.
//- Do nothing on the fouth and fifth days.
//- On the sixth and seventh days you eat apples that grew on the sixth day.
// 
//
// 
// Constraints: 
//
// 
// apples.length == n 
// days.length == n 
// 1 <= n <= 2 * 104 
// 0 <= apples[i], days[i] <= 2 * 104 
// days[i] = 0 if and only if apples[i] = 0. 
// 
// Related Topics 堆 贪心算法 
// 👍 18 👎 0


package leetcode.solved;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Leetcode1705 {
    public static void main(String[] args) {
        Solution solution = new Leetcode1705().new Solution();
        int[] a = {2}, b = {1};
        int res = solution.eatenApples(a, b);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eatenApples(int[] apples, int[] days) {
            //优先队列outDate存储保质期时间，哈希表dateMount以保质期时间为key，苹果个数为value
            //通过访问outDate队首可以获得当前情况下最先过期的苹果日期，再通过dateMount获得该日期下苹果个数
            PriorityQueue<Integer> outDate = new PriorityQueue<>();
            HashMap<Integer, Integer> dateMount = new HashMap<>();

            int res = 0;
            //for循环遍历apples和days数组
            //由于苹果最长保质期可能超过apples数组长度，因此这里不设置循环退出
            for (int i = 0; ; i++) {
                //删除已过期的保质期时间，dateMount哈希表相应项可删可不删
                while (!outDate.isEmpty() && outDate.peek() < i) {
                    outDate.poll();
                }
                //添加今天的苹果生产情况
                if (i < apples.length) {
                    int deadLine = days[i] + i - 1;
                    //若今天生产了苹果，则根据保质期和苹果数添加优先队列和哈希表项
                    if (apples[i] > 0) {
                        outDate.add(deadLine);
                        dateMount.put(deadLine, apples[i] + dateMount.getOrDefault(deadLine, 0));
                    }
                }
                //判断今天是否有的吃苹果，以及吃哪一个保质期的苹果
                //若outDate优先队列非空，则有苹果吃
                if (!outDate.isEmpty()) {
                    //吃一个outDate队首的保质期的苹果
                    dateMount.put(outDate.peek(), dateMount.get(outDate.peek()) - 1);
                    ++res;
                    //若这是该保质期最后一个苹果，则吃完后删除该保质期
                    if (dateMount.get(outDate.peek()) <= 0)
                        outDate.poll();
                }
                //若outDate队列为空，且苹果已不再生产（i超过apples.length），则退出for循环
                else if (i >= apples.length)
                    break;

            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}