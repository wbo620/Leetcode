import java.util.List;

public class Leetcode19 {


    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    /*
     * 声明两个节点.一前一后指向头结点
     * cur的最终位置是指向要删除元素的前一个位置
     * 前面的指针往前走,当他俩的距离=n时,cur开始往后走
     * 他俩一起动,当pre的下一个位置为空时说明到结尾了
     * 此时cur指向的位置就是要删除的
     * */
    class Solution {
        /*
        * 添加一个虚拟头节点，可以避免处理头节点为空的问题；
        使用双指针，快指针先走n步，然后快慢指针一起走，当快指针走到结尾时，慢指针指向的就是要删除的节点的前一个节点；
        直接修改慢指针的next指针，完成删除操作；
        返回虚拟头节点的next节点即可*/
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //声明一个虚拟的头结点,next指向原来链表的头
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            //再声明两个指针指向虚拟头
            ListNode fast = dummy;
            ListNode slow = dummy;
            //找到后面指针开始移动的时机,就是他俩相差n+1个距离
            for (int i = 0; i < n + 1; i++) {
                fast = fast.next;
            }
            //两个指针一起往后走,前面的指针为空,表示遍历到链表尾巴,表示后面的指针正指向要删除节点的前一个位置
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            //删除节点
            slow.next = slow.next.next;
            //返回虚拟头部的下一个结点
            return dummy.next;
        }
    }


//runtime:0 ms
//memory:39.7 MB

}
