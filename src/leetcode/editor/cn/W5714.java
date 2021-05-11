package leetcode.editor.cn;


import java.util.HashMap;
import java.util.List;

public class W5714 {
    public static void main(String[] args) {
        Solution solution = new W5714().new Solution();

    }

    class Solution {
        public String evaluate(String s, List<List<String>> knowledge) {
            HashMap<String, String> know = new HashMap<>();
            for (List<String> pair : knowledge) {
                know.put(pair.get(0), pair.get(1));
            }
            int i = 0;
            String res = "";
            while (i < s.length()) {
                String key = "";
                if (s.charAt(i) == '(') {
                    i++;
                    while (i < s.length() && s.charAt(i) != ')') {
                        key += s.charAt(i++);
                    }
                    if (know.containsKey(key)) {
                        res += know.get(key);
                    }else{
                        res += "?";
                    }
                } else {
                    res += s.charAt(i);
                }
                i++;
            }
            return res;
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
