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
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode a = head;
    ListNode b = head;

    while (n-- > 0)
      b = b.next;
    if (b == null)
      return head.next;

    while (b.next != null) {
      a = a.next;
      b = b.next;
    }
    a.next = a.next.next;

    return head;
  }
}