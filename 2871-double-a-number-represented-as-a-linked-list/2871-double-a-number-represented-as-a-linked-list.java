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
    int mul(ListNode head)
    {
        if(head==null)
        {
            return 0;
        }
        int t=head.val*2+mul(head.next);
        head.val=t%10;
        return t/10;
    }
    public ListNode doubleIt(ListNode head) {
        int t=mul(head);
        if(t!=0)
        {
            head=new ListNode(t,head);
        }
        return head;
        
    }
}
// class Solution {
//     private int multiply(ListNode head){
//         if(head == null) return 0;
//         int t = head.val*2 + multiply(head.next);
//         head.val = t%10;
//         return t/10;
//     }
//     public ListNode doubleIt(ListNode head) {
//         int t = multiply(head);
//         if(t != 0) head = new ListNode(t, head);
//         return head;
//     }
// }