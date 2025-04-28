
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curNode1 = list1;
        ListNode curNode2 = list2;
        ListNode dummy = new ListNode();
        ListNode mergedList = dummy;
        
        while(curNode1!=null && curNode2!=null){
            if(curNode1.val>curNode2.val){
                mergedList.next = curNode2;
                curNode2 = curNode2.next;
            }
            else{
                mergedList.next = curNode1;
                curNode1 = curNode1.next;
            }
            mergedList = mergedList.next;
        }
        if(curNode1==null){
            while(curNode2!=null){
                mergedList.next = curNode2;
                mergedList = mergedList.next;
                curNode2 = curNode2.next;
            }
        }
        else if(curNode2==null){
            while(curNode1!=null){
                mergedList.next = curNode1;
                mergedList = mergedList.next;
                curNode1 = curNode1.next;
            }
        }
        return dummy.next;
    }
}