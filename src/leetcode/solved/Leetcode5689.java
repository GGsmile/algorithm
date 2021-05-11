//You are given an array items, where each items[i] = [typei, colori, namei] des
//cribes the type, color, and name of the ith item. You are also given a rule repr
//esented by two strings, ruleKey and ruleValue. 
//
// The ith item is said to match the rule if one of the following is true: 
//
// 
// ruleKey == "type" and ruleValue == typei. 
// ruleKey == "color" and ruleValue == colori. 
// ruleKey == "name" and ruleValue == namei. 
// 
//
// Return the number of items that match the given rule. 
//
// 
// Example 1: 
//
// 
//Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phon
//e","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
//Output: 1
//Explanation: There is only one item matching the given rule, which is ["comput
//er","silver","lenovo"].
// 
//
// Example 2: 
//
// 
//Input: items = [["phone","blue","pixel"],["computer","silver","phone"],["phone
//","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
//Output: 2
//Explanation: There are only two items matching the given rule, which are ["pho
//ne","blue","pixel"] and ["phone","gold","iphone"]. Note that the item ["computer
//","silver","phone"] does not match. 
//
// 
// Constraints: 
//
// 
// 1 <= items.length <= 104 
// 1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10 
// ruleKey is equal to either "type", "color", or "name". 
// All strings consist only of lowercase letters. 
// 
// Related Topics 数组 字符串 
// 👍 1 👎 0


package leetcode.solved;

import java.util.Arrays;
import java.util.List;

public class Leetcode5689 {
    public static void main(String[] args) {
        Solution solution = new Leetcode5689().new Solution();
        List<String> item1 = Arrays.asList(new String[]{"phone", "blue", "pixel"});
        List<String> item2 = Arrays.asList(new String[]{"computer", "silver", "lenovo"});
        List<String> item3 = Arrays.asList(new String[]{"phone", "silver", "iphone"});
        List<List<String>> items = Arrays.asList(new List[]{item1, item2, item3});
        String ruleKey = "color";
        String ruleValue = "silver";
        int c = solution.countMatches(items, ruleKey, ruleValue);
        System.out.println(c);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
            int count = 0;
            int keyID = 2;

            if (ruleKey.equals("type")) keyID = 0;
            else if (ruleKey.equals("color")) keyID = 1;

            for (int i = 0; i < items.size(); i++) {
                List<String> item = items.get(i);
                if (item.get(keyID).equals(ruleValue)) count++;
            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}