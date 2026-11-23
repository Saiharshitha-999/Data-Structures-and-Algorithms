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
    public ListNode oddEvenList(ListNode head) 
    {
        if(head == null || head.next == null)
        {
            return head;
        }

        ListNode odd1 = head;
        ListNode even1 = head.next;
        
        ListNode evenhead = even1;

        while(even1 != null && even1.next != null)
        {
            odd1.next = even1.next;
            odd1 = odd1.next;
            if(odd1 != null)
            {
                even1.next = odd1.next;
                even1 = even1.next;
            }
        }
        odd1.next = evenhead;
        return head;

    }
}