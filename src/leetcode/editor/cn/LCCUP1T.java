package leetcode.editor.cn;

public class LCCUP1T {
    public static void main(String[] args) {
        Solution solution = new LCCUP1T().new Solution();
    }

    class Solution {
        public int storeWater(int[] bucket, int[] vat) {
            int count = 0;
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] == 0 && vat[i] == 0) {
                    bucket[i] = 1;
                    vat[i] = 1;
                } else if (bucket[i] == 0 && vat[i] != 0) {
                    bucket[i] = 1;
                    count++;
                }
            }
            int ans = 0;
            for (int maxPos = 0; maxPos < bucket.length; maxPos++) {
                int minCount = (int) Math.ceil((double) vat[maxPos] / (double) bucket[maxPos]);
                for (int i = 0; i <= vat[maxPos] - bucket[maxPos]; i++) {
                    int tmp = i + (int) Math.ceil((double) (vat[maxPos] - bucket[maxPos]) / (double) (bucket[maxPos] + i));
                    minCount = Math.min(minCount, tmp);
                }
                ans = Math.max(ans, minCount);
            }
            return ans + count;
        }
    }
}
