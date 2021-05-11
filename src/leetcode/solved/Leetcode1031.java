//Given an array A of non-negative integers, return the maximum sum of elements 
//in two non-overlapping (contiguous) subarrays, which have lengths L and M. (For 
//clarification, the L-length subarray could occur before or after the M-length su
//barray.) 
//
// Formally, return the largest V for which V = (A[i] + A[i+1] + ... + A[i+L-1])
// + (A[j] + A[j+1] + ... + A[j+M-1]) and either: 
//
// 
// 0 <= i < i + L - 1 < j < j + M - 1 < A.length, or 
// 0 <= j < j + M - 1 < i < i + L - 1 < A.length. 
// 
//
// 
//
// 
// 
//
// 
// Example 1: 
//
// 
//Input: A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2
//Output: 20
//Explanation: One choice of subarrays is [9] with length 1, and [6,5] with leng
//th 2.
// 
//
// 
// Example 2: 
//
// 
//Input: A = [3,8,1,3,2,1,8,9,0], L = 3, M = 2
//Output: 29
//Explanation: One choice of subarrays is [3,8,1] with length 3, and [8,9] with 
//length 2.
// 
//
// 
// Example 3: 
//
// 
//Input: A = [2,1,5,6,0,9,5,0,3,8], L = 4, M = 3
//Output: 31
//Explanation: One choice of subarrays is [5,6,0,9] with length 4, and [3,8] wit
//h length 3.
// 
//
// 
//
// Note: 
//
// 
// L >= 1 
// M >= 1 
// L + M <= A.length <= 1000 
// 0 <= A[i] <= 1000 
// 
// 
// 
// 
// Related Topics 数组 
// 👍 90 👎 0


package leetcode.solved;

public class Leetcode1031 {
    public static void main(String[] args) {
        Solution solution = new Leetcode1031().new Solution();
        int[] A = {0, 6, 5, 2, 2, 5, 1, 9, 4};
        int res = solution.maxSumTwoNoOverlap(A, 1, 2);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSumTwoNoOverlap(int[] A, int L, int M) {
            // 前缀和
            int[] prefix = new int[A.length + 1];
            prefix[0] = 0;
            for (int i = 1; i < A.length + 1; i++) prefix[i] = prefix[i - 1] + A[i - 1];

            int res = 0;
            for (int tern = 2; tern > 0; tern--) {
                for (int i = L; i < prefix.length - M; i++) {
                    int maxM = 0;
                    for (int j = i + M; j < prefix.length; j++) maxM = Math.max(maxM, prefix[j] - prefix[j - M]);
                    res = Math.max(res, maxM + prefix[i] - prefix[i - L]);
                }
                if (L == M) tern--;
                else {
                    int tmp = L;
                    L = M;
                    M = tmp;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}