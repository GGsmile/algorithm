package leetcode.editor.cn;

import java.util.Arrays;

public class W5708 {
    public static void main(String[] args) {
        Solution solution = new W5708().new Solution();
    }

    class Solution {
        public int countNicePairs(int[] nums) {
            long[] revNums = new long[nums.length];
            for (int i = 0; i < nums.length; i++) {
                revNums[i] = rev(nums[i]);
            }
            long[] diff = new long[nums.length];
            for (int i = 0; i < nums.length; i++) {
                diff[i] = nums[i] - revNums[i];
            }
            Arrays.sort(diff);
            int k = 0;
            long ans = 0;
            while (k < diff.length - 1) {
                while (k < diff.length - 1 && diff[k] != diff[k + 1]) {
                    k++;
                }
                long count = 1;
                while (k < diff.length - 1 && diff[k] == diff[k + 1]) {
                    k++;
                    count++;
                }
                ans = (ans + ((count) * (count - 1) / 2) % 1000000007) % 1000000007;
            }
            return (int)ans;
        }


        public long rev(int num) {
            long res = 0;
            int x = num;
            while (x != 0) {
                res = res * 10 + x % 10;
                x = x / 10;
            }
            return res;
        }

    }
}
