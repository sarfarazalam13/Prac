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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            int x = temp.val;
            int y = temp.next.val;
            int z = gcd(x, y);
            
            // Create a new node with the GCD value and insert it between temp and temp.next
            ListNode newNode = new ListNode(z);
            newNode.next = temp.next;
            temp.next = newNode;
            
            temp = temp.next.next; // Move temp to the node after the newly inserted node
        }
        return head;
    }
    
    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
