/**
This is a C++ code for removing the n^th node from the end of a linked list.
*/



/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
 
 
 //Given: a pointer the head of the list, and an integer n.
 //Returns: a pointer to the head of the same linked list, except that
 //         the n^th node from the end of the list has been removed from
 //         the list. 
ListNode* removeNthFromEnd(ListNode* head, int n) {
    int j = 0;
    ListNode* head1 = head;
    ListNode* head2 = head;
    ListNode* head3 = head;
    while (head != NULL)
    {
        j++;
        head = head->next;
    }
    
    if (j == 1)
        return NULL;
    int i = 0;
    if (i == 0 && i == j - n && head1->next != NULL)
    {
        head2 = head1->next;
    }
    while (head1 != NULL)
    {
         
        i++;
        if (i == j - n && head1->next != NULL)
        {
            head1->next = head1->next->next;
            break;
        }
        if (i == j - n && head1->next == NULL)
        {
            head3->next = NULL;
        }
        head3 = head1;
        head1 = head1->next;
    }
    
    return head2;
}