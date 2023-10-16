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
    public ListNode doubleIt(ListNode head) {
        //basically the concept is if there is any first node which will be more than 4, that means there is the possibility of having a carry value so for that we will be having a dummy node initialized with dummy value of 0 , so if there is any case of carry that dummy node will have value of 2*0+carry(1)....yep.
        
        if(head.val  >= 5 )  {
             head = new ListNode(0,head);
        }
        for(ListNode node = head; node!=null; node=node.next){
            node.val=2*(node.val)%10;
            System.out.println(node.val);
            if(node.next!=null && node.next.val >4) node.val++;
        }
        return head;
    }
}