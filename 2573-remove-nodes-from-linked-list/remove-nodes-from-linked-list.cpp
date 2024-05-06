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
    ListNode* help(ListNode* curr, int& nextVal) {
        if(!curr) return nullptr;
        ListNode* temp = help(curr->next, nextVal);
        if(curr->val < nextVal) {
            return temp;
        }
        curr->next = temp;
        nextVal = curr->val;
        return curr;
    }

    ListNode* removeNodes(ListNode* head) {
        int nextVal = 0;
        return help(head, nextVal);

    }
};