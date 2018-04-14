/**
**Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
**
**Note: Do not modify the linked list.
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
    ListNode *detectCycle(ListNode *head) {
        
        vector<ListNode*> add;
                if (head == NULL)
            return NULL;
        while(head->next != NULL)
        {
            if (find(add.begin(), add.end(), head) != add.end())
                return head;
            else
            {
                add.push_back(head); 
                head = head->next; 
            }
            
            if (head->next == NULL)
                return NULL;
        }
        
        return NULL;
    }
};