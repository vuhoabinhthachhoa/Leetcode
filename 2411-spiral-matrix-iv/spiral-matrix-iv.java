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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        while(true) {
            // fill top
            for(int i = left ; i <= right ; i++) {
                res[top][i] = head == null ? -1 : head.val;
                if(head != null) {
                    head = head.next;
                }

            }
            top++;
            if(top > bottom) break;

            // fill right
            for(int i = top ; i <= bottom ; i++) {
                res[i][right] = head == null ? -1 : head.val;
                if(head != null) {
                    head = head.next;
                }

            }
            right--;
            if(left > right) break;

            // fill bottom
            for(int i = right ; i >= left ; i--) {
                res[bottom][i] = head == null ? -1 : head.val;
                if(head != null) {
                    head = head.next;
                }


            }
            bottom--;
            if(top > bottom) break;

            // fill left
            for(int i = bottom ; i >= top ; i--) {
                res[i][left] = head == null ? -1 : head.val;
                if(head != null) {
                    head = head.next;
                }

            }
            left++;
            if(left > right) break;
        }
        return res;
    }
}