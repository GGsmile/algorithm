package leetcode.editor.cn;


import java.util.HashMap;

public class W5713 {
    public static void main(String[] args) {
        Solution solution = new W5713().new Solution();
        int res = solution.numDifferentIntegers("5xm2g09yok4olmoxgljlo6141jas55v3cok94k8");
        System.out.println(res);
    }

    class Solution {
        public int numDifferentIntegers(String word) {
            int length = word.length();
            HashMap<String, Integer> nums = new HashMap<>();
            int index = 0;
            while (index < length) {
                String num = "", tmp = "";
                while (index < length && Character.isDigit(word.charAt(index))) {
                    tmp = tmp + word.charAt(index);
                    index++;
                }
                for (int i = 0; i < tmp.length(); i++) {
                    if(i == tmp.length() - 1){
                        num = tmp.substring(i);
                        break;
                    }
                    if (tmp.charAt(i) != '0') {
                        num = tmp.substring(i);
                        break;
                    }
                }

                if (num.length() > 0) {
                    nums.put(num, 1);
                }
                index++;
            }
            return nums.size();
        }
    }
}


//public class W5665 {
//    public static void main(String[] args) {
//        Solution solution = new W5665().new Solution();
//    }
//
//    class Solution {
//        public int[] restoreArray(int[][] adjacentPairs) {
//            HashMap<Integer,Integer[]> adj = new HashMap<>();
//            for(int[] pairs:adjacentPairs){
////                int[] pair = []
////                adj.put(pairs[0], pairs[1]);
//            }
//        }
//    }
//}
