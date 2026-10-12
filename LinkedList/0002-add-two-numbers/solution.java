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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode temp = null;
        int carry = 0;
        while(temp1 != null && temp2 != null)
        {
            int sum = temp1.val + temp2.val + carry; 
            temp = new ListNode(sum%10);
            dummy.next = temp;
            dummy = temp; 
            carry = sum/10;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while(temp1 != null)
        {
            int sum = temp1.val + carry;
            temp = new ListNode(sum%10);
            dummy.next = temp;
            dummy = temp; 
            carry = sum/10;
            temp1 = temp1.next;
        }
        while(temp2 != null)
        {
            int sum = temp2.val + carry;
            temp = new ListNode(sum%10);
            dummy.next = temp;
            dummy = temp; 
            carry = sum/10;
            temp2 = temp2.next;
        }
        if(carry == 1)
        {
            temp = new ListNode(1);
            dummy.next = temp;
            dummy = temp;
        }
        dummy.next = null;
        return head.next;
    }
}
