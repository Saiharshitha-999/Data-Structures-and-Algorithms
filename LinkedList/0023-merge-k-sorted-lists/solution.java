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
    public ListNode mergeKLists(ListNode[] heads) 
    {
         PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        for(ListNode node : heads)
        {
            if(node!=null)
            {
                heap.offer(node);
            }
        }
        while(!heap.isEmpty())
        {
            ListNode element = heap.poll();

            dummy.next = element;
            dummy = dummy.next;
            if(element.next != null)
            {
                heap.offer(element.next);
            }

        }
        return temp.next;
    }
}
