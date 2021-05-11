//You are assigned to put some amount of boxes onto one truck. You are given a 2
//D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]: 
//
// 
// numberOfBoxesi is the number of boxes of type i. 
// numberOfUnitsPerBoxi is the number of units in each box of the type i. 
// 
//
// You are also given an integer truckSize, which is the maximum number of boxes
// that can be put on the truck. You can choose any boxes to put on the truck as l
//ong as the number of boxes does not exceed truckSize. 
//
// Return the maximum total number of units that can be put on the truck. 
//
// 
// Example 1: 
//
// 
//Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
//Output: 8
//Explanation: There are:
//- 1 box of the first type that contains 3 units.
//- 2 boxes of the second type that contain 2 units each.
//- 3 boxes of the third type that contain 1 unit each.
//You can take all the boxes of the first and second types, and one box of the t
//hird type.
//The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.
// 
//
// Example 2: 
//
// 
//Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
//Output: 91
// 
//
// 
// Constraints: 
//
// 
// 1 <= boxTypes.length <= 1000 
// 1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000 
// 1 <= truckSize <= 106 
// 
// Related Topics 贪心算法 排序 
// 👍 4 👎 0


package leetcode.solved;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode1710{
	public static void main(String[] args) {
		Solution solution = new Leetcode1710().new Solution();
		
	}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int maximumUnits(int[][] boxTypes, int truckSize) {
		Arrays.sort(boxTypes, Comparator.comparingInt((o -> -o[1])));
		int leftSize = truckSize;
		int res = 0;
		for (int[] box : boxTypes) {
			if (leftSize - box[0] >= 0) {
				res += box[0] * box[1];
				leftSize -= box[0];
			} else {
				res += leftSize * box[1];
				break;
			}
		}
		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}