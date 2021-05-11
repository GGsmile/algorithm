package leetcode.editor.cn;

public class W5706 {
    public static void main(String[] args) {
        Solution solution = new W5706().new Solution();
    }

    class Solution {
        public boolean areSentencesSimilar(String sentence1, String sentence2) {
            String[] tmp1 = sentence1.split(" ");
            String[] tmp2 = sentence2.split(" ");
            if (tmp1.length == tmp2.length) {
                for (int k = 0; k < tmp1.length; k++) {
                    if (!tmp1[k].equals(tmp2[k])) {
                        return false;
                    }
                }
                return true;
            }
            String[] words1;
            String[] words2;
            if (tmp1.length > tmp2.length) {
                words1 = tmp1;
                words2 = tmp2;
            } else {
                words1 = tmp2;
                words2 = tmp1;
            }
            int index1 = 0, index2 = 0;
            boolean[] matched = new boolean[words1.length];
            while (index1 < words1.length && index2 < words2.length) {
                if (words1[index1].equals(words2[index2])) {
                    matched[index1] = true;
                    index1++;
                    index2++;
                } else {
                    matched[index1] = false;
                    index1++;
                }
            }
            if (index2 != words2.length) return false;
            int i = 0, j = words1.length - 1;
            while (i < words1.length && matched[i]) {
                i++;
            }
            while (j >= 0 && matched[j]) {
                j--;
            }
            for (int k = i; k < j; k++) {
                if (matched[k]) return false;
            }
            return true;
        }
    }
}
