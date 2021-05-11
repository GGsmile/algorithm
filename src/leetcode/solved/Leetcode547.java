//There are n cities. Some of them are connected, while some are not. If city a 
//is connected directly with city b, and city b is connected directly with city c,
// then city a is connected indirectly with city c. 
//
// A province is a group of directly or indirectly connected cities and no other
// cities outside of the group. 
//
// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the 
//ith city and the jth city are directly connected, and isConnected[i][j] = 0 othe
//rwise. 
//
// Return the total number of provinces. 
//
// 
// Example 1: 
//
// 
//Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] is 1 or 0. 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 396 👎 0


package leetcode.solved;

import java.util.*;

public class Leetcode547 {
    public static void main(String[] args) {
        Solution solution = new Leetcode547().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            //bfs遍历，记录连通分量数量
            int length = isConnected.length;
            boolean[] visited = new boolean[length];
            Queue<Integer> connected = new LinkedList<>();
            int provinces = 0;
            for (int i = 0; i < length; i++) {
                if (!visited[i]) {
                    connected.offer(i);
                    while (!connected.isEmpty()) {
                        int city = connected.poll();
                        if (!visited[city]) {
                            visited[city] = true;
                            for (int j = 0; j < length; j++) {
                                if (isConnected[city][j] == 1 && !visited[j]) {
                                    connected.offer(j);
                                }
                            }
                        }
                    }
                    provinces++;
                }
            }
            return provinces;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}