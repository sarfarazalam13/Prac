/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
   int length(ListNode* head) {
      int count = 0;
      while (head != NULL) {
         head = head->next;
         count++;
      }
      return count;
   }

   ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
      int a = length(headA);
      int b = length(headB);
      int d = abs(a - b);

      if (a > b) {
         for (int i = 0; i < d; i++) {
            headA = headA->next;
         }
      } else if (b > a) {
         for (int i = 0; i < d; i++) {
            headB = headB->next;
         }
      }

      while (headA != NULL && headB != NULL) {
         if (headA == headB) {
            return headA;
         }
         headA = headA->next;
         headB = headB->next;
      }

      return NULL;
   }
};
