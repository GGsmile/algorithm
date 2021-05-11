package leetcode.solved;

public class LCCUP2 {
    public static void main(String[] args) {
        Solution solution = new LCCUP2().new Solution();
        int a = solution.orchestraLayout(1000000000, 0, 5);
    }

    class Solution {
        public int orchestraLayout(int num, int xPos, int yPos) {
            long layer = Math.min(Math.min(xPos, num - 1 - xPos), Math.min(yPos, num - 1 - yPos));
            if (xPos < yPos)
                return (int) ((4 * (layer * (long) num - layer * layer) + 1 + xPos - layer + yPos - layer - 1) % 9 + 1);
            layer += 1;
            return (int) ((4 * (layer * (long) num - layer * layer) + 1 - (xPos - (layer - 1) + yPos - (layer - 1)) - 1) % 9 + 1);
        }
    }
}
