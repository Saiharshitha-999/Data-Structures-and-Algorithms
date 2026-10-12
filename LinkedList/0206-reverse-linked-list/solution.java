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
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        return reverse(curr,prev,next);
    }
    public ListNode reverse(ListNode curr,ListNode prev,ListNode next)
    {
        if(curr == null)
        {
            return prev;
        }
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        return reverse(curr,prev,next);
    }
    
}
