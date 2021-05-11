package leetcode.editor.cn;

import java.util.HashMap;

public class W5654 {
    public static void main(String[] args) {
        Solution solution = new W5654().new Solution();
        int com = solution.countBalls(19,28);
        System.out.println(com);
    }

    class Solution {
        public int countBalls(int lowLimit, int highLimit) {
            HashMap<Integer, Integer> box = new HashMap<>();
            for (int ball = lowLimit; ball < highLimit + 1; ball++) {
                int boxNum = 0;
                int tmp = ball;
                while (tmp != 0) {
                    boxNum += tmp % 10;
                    tmp /= 10;
                }
                box.put(boxNum, 1 + box.getOrDefault(boxNum, 0));
            }
            int res = 0;
            for (int ballNum : box.values())
                res = Math.max(res, ballNum);
            return res;
        }
    }
}
