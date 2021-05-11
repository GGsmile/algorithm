//Given a string, find the first non-repeating character in it and return its in
//dex. If it doesn't exist, return -1. 
//
// Examples: 
//
// 
//s = "leetcode"
//return 0.
//
//s = "loveleetcode"
//return 2.
// 
//
// 
//
// Note: You may assume the string contains only lowercase English letters. 
// Related Topics 哈希表 字符串 
// 👍 332 👎 0


package leetcode.solved;

public class Leetcode387 {
    public static void main(String[] args) {
        Solution solution = new Leetcode387().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            int[] uni = new int[26];
            for (int i = 0; i < s.length(); ++i) {
                uni[s.charAt(i) - (int) 'a'] += 1;
            }
            for (int i = 0; i < s.length(); i++) {
                if (uni[s.charAt(i) - (int) 'a'] == 1)
                    return i;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}