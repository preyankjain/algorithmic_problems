/**
**You are given two non-empty linked lists representing two non-negative integers. 
**The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
**
**You may assume the two numbers do not contain any leading zero, except the number 0 itself.
**/

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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* l3 = l1;
        ListNode* l4;
        int sum;
        int bal = 0;
        while(l1 != NULL && l2 != NULL)
        {
            sum = (l1->val + l2->val + bal)%10;
            if (l1->val + l2->val + bal >= 10)
                bal = 1;
            else
                bal = 0;
            l1->val = sum;
            l4 = l1;
            l1 = l1->next;
            l2 = l2->next;
        }
        
        if (l2 != NULL)
        {
            l4->next = l2;
        }
        
        while (bal > 0)
        {
            if (l2 != NULL)
            {
                sum = (l2->val+bal)%10;
                if (l2->val + bal >= 10)
                    bal = 1;
                else
                    bal = 0;
                l2->val = sum;
                
                l4 = l2;
                l2 = l2->next;
            }
            else if (l1 != NULL)
            {
                sum = (l1->val+bal)%10;
                if (l1->val + bal >= 10)
                    bal = 1;
                else
                    bal = 0;
                l1->val = sum;
                
                l4 = l1;
                l1 = l1->next;
            }
            else if (bal > 0)
            {
                ListNode* n = new ListNode(bal);
                l4->next = n;
                n->next = NULL;
                bal = 0;
            }
        }
        
        
        
        return l3;
    }
};