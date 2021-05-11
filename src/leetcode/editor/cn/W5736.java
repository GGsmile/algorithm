package leetcode.editor.cn;

import java.util.*;

public class W5736 {
    public static void main(String[] args) {
        Solution solution = new W5736().new Solution();
        //solution.getOrder();
    }

    class Solution {
        public int[] getOrder(int[][] task) {
            int[] ans = new int[task.length];
            int[][] tasks = new int[task.length][3];
            for (int i = 0; i < task.length; i++) {
                tasks[i][0] = task[i][0];
                tasks[i][1] = task[i][1];
                tasks[i][2] = i;
            }
            Arrays.sort(tasks, Comparator.comparingInt(value -> value[0]));
            Comparator<int[]> t = new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1]) {
                        if (o1[0] > o2[0])
                            return 1;
                        else
                            return -1;
                    }

                    if (o1[1] > o2[1])
                        return 1;
                    return -1;
                }
            };
            Queue<int[]> queue = new PriorityQueue<int[]>(t);
            long now = tasks[0][0];
            int right = 0, left = 0;
            while (left < tasks.length) {
                while (right < tasks.length && tasks[right][0] <= now) {
                    int[] ta = {tasks[right][2], tasks[right][1]};
                    queue.offer(ta);
                    right++;
                }
                if (queue.isEmpty()) break;
                int[] tmp = queue.poll();
                ans[left] = tmp[0];
                now += tmp[1];
                left++;
            }
            return ans;


            //Queue<int[]> q = new PriorityQueue<int[]>(Comparator.comparing(a -> a[1]).thenComparing(a -> a[0]));
        }
    }
}
