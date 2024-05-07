/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    void help(ListNode* head, int& carry) {
        if(!head) {
            return;
        }
        help(head->next, carry);
        int temp = head->val*2 + carry;
        head->val = temp%10;
        carry = temp / 10;
    }

    ListNode* doubleIt(ListNode* head) {
        if(!head) {
            return nullptr;
        }
        
        int carry = 0;
        help(head, carry);
        
        if(carry > 0) {
            ListNode* newNode = new ListNode(carry);
            newNode->next = head;
            head = newNode;
        }

        return head;
    }
};