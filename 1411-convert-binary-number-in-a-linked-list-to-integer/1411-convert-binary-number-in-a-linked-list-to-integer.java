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
    public int getDecimalValue(ListNode head) {
        int result = 0;
        String binary = "";
        while(head != null) {
            binary+=head.val;
            head = head.next;
        }
        System.out.println(binary);
        int len = binary.length();
        int i = len-1;
        while(i >= 0) {
            if(binary.charAt(i) == '1'){
                result += Math.pow(2, len-i-1);
                i--;
            }
            else{
                i--;
            }
        }
        return result;
    }
}