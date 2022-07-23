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
public class addTwoNuminLL {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);    //actual head pointer
        ListNode cur = head;    //current pointer for the new linked list

        int newDigit = 0;       //the new digit for the sum of x,y
        int x,y = 0;

        while(l1!=null || l2!=null){
            if(l1!=null){
                x = l1.val;
            }else{
                x = 0;
            }
            if(l2!=null){
                y = l2.val;
            }else{
                y = 0;
            }

            int sum = x+y+newDigit;     //each sum will be the carry+x+y

            if(sum>=10){
                newDigit = sum/10;
            }else{
                newDigit=0;
            }

            sum = sum%10;

            cur.next = new ListNode(sum); //the next node with new sum as val

            cur = cur.next;

            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
        }
        // after the while loop both two linked lists are in the tail
        if(newDigit==1){
            cur.next = new ListNode(newDigit);
        }

        return head.next;
    }
}
