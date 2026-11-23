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
    public ListNode reverseList(ListNode head) 
    {
        ListNode curr,next1,prev;
        curr = head;
        prev = null;

        while(curr != null)
        {
            next1 = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next1;
        }
        head = prev;
        return head;
    }
}