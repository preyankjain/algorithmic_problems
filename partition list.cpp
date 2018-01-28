/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
ListNode* partition(ListNode* head, int x) {
    ListNode* head1 = NULL;
    
    if (head == NULL)
        return NULL;
    
    vector<ListNode*> lt, gt;
    
    while(head != NULL)
    {
        if (head->val >= x)
        {
            gt.push_back(head);
            head = head->next;
        }
        else
        {
            lt.push_back(head);
            head = head->next;
        }
    }
    
    
    if (lt.size() > 0)
    {
        head1 = lt.at(0);
        for (int i = 0; i< lt.size()-1; i++)
        {
            lt.at(i)->next = lt.at(i+1);
        }
    }
    else
        head1 = gt.at(0);
    
    
    if (gt.size() > 0)
    {
        if (lt.size() > 0)
        lt.at(lt.size()-1)->next = gt.at(0);
    
        for (int i = 0; i<gt.size()-1; i++)
        {
            gt.at(i)->next = gt.at(i+1);
        }
    
        gt.at(gt.size()-1)->next = NULL;
    }
    
    
    return head1;
}