package leetcode.solved;

import java.util.PriorityQueue;

public class LCCUP3 {
    public static void main(String[] args) {
        Solution solution = new LCCUP3().new Solution();
    }

    class Solution {
        public int magicTower(int[] nums) {
            int addi = 0;
            for (int num : nums) addi += num;
            if (addi < 0) return -1;

            PriorityQueue<Integer> neg = new PriorityQueue<>();
            long hp = 1L;
            int pos = 0;
            int count = 0;
            while (pos < nums.length && hp > 0) {
                if (nums[pos] >= 0) {
                    hp += nums[pos];
                } else {
                    hp += nums[pos];
                    neg.offer(nums[pos]);
                    if (hp <= 0) {
                        while (!neg.isEmpty() && hp <= 0) {
                            int tmp = neg.poll();
                            hp -= tmp;
                            count++;
                        }
                    }
                }
                pos++;
            }
            return count;
        }
    }
}
