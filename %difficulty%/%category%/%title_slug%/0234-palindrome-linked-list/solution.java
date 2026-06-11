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
    public boolean isPalindrome(ListNode head) 
    {
        if(head.next == null)
        {
            return true;
        }
          ListNode slow = head;
          ListNode fast = head;
          while(fast != null && fast.next != null)
          {
            slow = slow.next;
            fast = fast.next.next;
          }
          ListNode curr = head;
          ListNode next = null;
          ListNode prev = null;
          ListNode temp = null;
          while(curr!=slow)
          {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
          }
          temp = prev;
          if(fast != null)
          {
            slow = slow.next;
          }
            while(temp!=null && slow!=null)
            {
                if(temp.val!=slow.val)
                {
                    return false;
                }
                temp=temp.next;
                slow=slow.next;
            }
          
          return true;
    }
}
