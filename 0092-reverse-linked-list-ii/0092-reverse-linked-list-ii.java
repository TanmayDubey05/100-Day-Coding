/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode reverseBetween(ListNode head, int lindex, int rindex) {
    ListNode ptr, l = null;
    var i = 1;
    
    for (ptr = head; i < lindex; ptr = ptr.next, i++)
      if (i+1 == lindex) l = ptr;

    var left = ptr;
    
    for (; i < rindex; ptr = ptr.next, i++);
    var right = ptr;
    
    if (l == null) head = right;
    else l.next = right;
  
    if (left != right) {
      var p1 = left;
      var p2 = p1.next;
      var p3 = p2.next;
      left.next = right.next;
      
      while (p2 != right) {
        p2.next = p1;
        p1 = p2;
        p2 = p3;
        p3 = p3.next;
      }
      p2.next = p1;
    }   
    return head;
  }
}