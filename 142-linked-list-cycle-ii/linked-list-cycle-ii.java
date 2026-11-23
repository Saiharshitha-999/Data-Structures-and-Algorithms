/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) 
    {
        if(head == null || head.next == null)
        {
            return null;
        }

        ListNode slow  = head;
        ListNode fast = head;
        int f = 0;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                f = 1;
                break;
            }
        }

        slow = head;
        if(f == 0)
        {
            return null;
        }
        while(slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}