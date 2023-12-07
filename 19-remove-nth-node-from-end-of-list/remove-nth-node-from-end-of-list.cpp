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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
	ListNode* traver1 = head;
	
	for (int i = 0; i < n; i++) {
		traver1 = traver1->next;
	}

	// the nth node is the head node.
	if (!traver1) return head->next;

	ListNode* traver2 = head;
	while (traver1->next) {
		traver1 = traver1->next;
		traver2 = traver2->next;
	}

	traver2->next = traver2->next->next;
	return head;
}
};