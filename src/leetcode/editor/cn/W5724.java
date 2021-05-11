package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class W5724 {
    public static void main(String[] args) {
        Solution solution = new W5724().new Solution();
    }

    class Solution {
        public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
            int[] diff = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                diff[i] = Math.abs(nums1[i] - nums2[i]);
            }

            int maxDiff = 0;
            for (int i = 0; i < diff.length; i++) {
                if (diff[i] > maxDiff) {
                    maxDiff = diff[i];
                }
            }

            List<Integer> maxDiffIndexList = new ArrayList<>();
            for (int i = 0; i < diff.length; i++) {
                if (diff[i] == maxDiff) {
                    maxDiffIndexList.add(i);
                }
            }

            int minDiff = maxDiff;
            for (int maxDiffIndex : maxDiffIndexList) {
                int tmp = diff[maxDiffIndex];
                for (int i = 0; i < nums1.length; i++) {
                    if (Math.abs(nums1[i] - nums2[maxDiffIndex]) < tmp) {
                        tmp = Math.abs(nums1[i] - nums2[maxDiffIndex]);
                    }
                }
                minDiff = Math.min(minDiff, tmp);
            }

            diff[maxDiffIndexList.get(0)] = minDiff;

            long res = 0;
            for (int d : diff) {
                res = (res + d) % 1000000007;
            }
            return (int) res;
        }
    }
}
