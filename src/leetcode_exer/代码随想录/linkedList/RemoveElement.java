package leetcode_exer.代码随想录.linkedList;

import java.util.List;

/**
 * @author kevinyi
 * @date 2023-05-26 13:43
 * @NAME: RemoveElement
 * @PROJECT_NAME: Leetcode
 *
 * 203.移除链表元素
 * 题意：删除链表中等于给定值 val 的所有节点。
 *
 * 示例 1： 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]
 *
 * 示例 2： 输入：head = [], val = 1 输出：[]
 *
 * 示例 3： 输入：head = [7,7,7,7], val = 7 输出：[]
 *
 * #思路:
 *      两个特色情况：
 *      1.单链表需要考虑如果val在头节点我们需要将头节点移向下一个节点
 *      2.如果链表是空的则直接返回头节点
 *
 *      创建一个pre节点和current节点来遍历
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class RemoveElement {
    public ListNode removeElements(ListNode head, int val){
        //先检查是否头节点就包含了要移除的元素
        while(head != null && head.val == val){
            head = head.next;
        }

        //空的链表，直接返回头节点
        if(head == null){
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;

        //开始遍历
        while(cur!=null){
            if(cur.val == val){
                //直接将面一个节点连接当前节点的下一个节点
                pre.next = cur.next;
            }else{
                //pre移到cur
                pre = cur;
            }
            cur = cur.next;
        }

        return head;
    }
}
