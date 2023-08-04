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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head.next.next==null) return new int[]{-1,-1};
        int index=2;                 // to see the index it is 2 because 1st node cant be critical point
        ListNode prev=head;          // point to previous node of current node
        ListNode curr=head.next;     // to traverse linked list
        int min=Integer.MAX_VALUE;  //to store first critical point
        int max=Integer.MIN_VALUE;  // to store last critical point
        int min_diff=Integer.MAX_VALUE; //to store the minimum distance btw to critical point
        int prevs=0;               // to store value of previous critical point
        while(curr.next!=null){
        if((curr.val>prev.val && curr.val>curr.next.val) || (curr.val<prev.val && curr.val<curr.next.val)){ // condition
            max=Math.max(max,index); // finding last critical point
            min=Math.min(min,index); // finding first critical point
            if(prevs!=0)            //  if this is the second critical point then find its distance with the previous critical point
                min_diff=Math.min(min_diff,index-prevs);
            prevs=index;             // shift the previous critical point to the current one
        }
        prev=curr;               // update the previous pointer   
        curr=curr.next;         // move to the next node
        index++;               // increase the index  
        }
       
        if(min!=Integer.MAX_VALUE && max!=Integer.MIN_VALUE && min!=max){
            return new int[]{min_diff,max-min};  // max distance is always between first and last critical point and minimum we have already maintained;
        }
        else{
            return new int[]{-1,-1};
        }

    }
}