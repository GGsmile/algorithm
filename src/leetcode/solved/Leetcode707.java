//Design your implementation of the linked list. You can choose to use a singly 
//or doubly linked list. 
//A node in a singly linked list should have two attributes: val and next. val i
//s the value of the current node, and next is a pointer/reference to the next nod
//e. 
//If you want to use the doubly linked list, you will need one more attribute pr
//ev to indicate the previous node in the linked list. Assume all nodes in the lin
//ked list are 0-indexed. 
//
// Implement the MyLinkedList class: 
//
// 
// MyLinkedList() Initializes the MyLinkedList object. 
// int get(int index) Get the value of the indexth node in the linked list. If t
//he index is invalid, return -1. 
// void addAtHead(int val) Add a node of value val before the first element of t
//he linked list. After the insertion, the new node will be the first node of the 
//linked list. 
// void addAtTail(int val) Append a node of value val as the last element of the
// linked list. 
// void addAtIndex(int index, int val) Add a node of value val before the indext
//h node in the linked list. If index equals the length of the linked list, the no
//de will be appended to the end of the linked list. If index is greater than the 
//length, the node will not be inserted. 
// void deleteAtIndex(int index) Delete the indexth node in the linked list, if 
//the index is valid. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex
//", "get"]
//[[], [1], [3], [1, 2], [1], [1], [1]]
//Output
//[null, null, null, null, 2, null, 3]
//
//Explanation
//MyLinkedList myLinkedList = new MyLinkedList();
//myLinkedList.addAtHead(1);
//myLinkedList.addAtTail(3);
//myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
//myLinkedList.get(1);              // return 2
//myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
//myLinkedList.get(1);              // return 3
// 
//
// 
// Constraints: 
//
// 
// 0 <= index, val <= 1000 
// Please do not use the built-in LinkedList library. 
// At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and 
//deleteAtIndex. 
// 
// Related Topics 设计 链表 
// 👍 223 👎 0


package leetcode.solved;

import java.util.ArrayList;
import java.util.List;

public class Leetcode707{
	public static void main(String[] args) {
		MyLinkedList solution = new Leetcode707().new MyLinkedList();
		
	}

//leetcode submit region begin(Prohibit modification and deletion)
class MyLinkedList {
	    List<Integer> linkList;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        linkList = new ArrayList<>();
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= 0 && index < linkList.size()) {
            return linkList.get(index);
        }
        return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        linkList.add(0,val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        linkList.add(val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            this.addAtHead(val);
        }
        else if (index == linkList.size()) {
            this.addAtTail(val);
        }
        else if (index < linkList.size()) {
            linkList.add(index, val);
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= 0 && index < linkList.size()) {
            linkList.remove(index);
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}