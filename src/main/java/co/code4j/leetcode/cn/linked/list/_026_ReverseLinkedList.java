package co.code4j.leetcode.cn.linked.list;

import co.code4j.leetcode.cn.common.ListNode;

/**
 * @Description
 * @Author yukf02
 * @Date 2023/10/29 15:52
 */
public class _026_ReverseLinkedList {

    public ListNode reverseList_1(ListNode head) {
        if (head == null) {
            return null;
        }

        // 遍历重新指向
        ListNode newHead = null;
        ListNode cur = head;

        while (cur != null) {

            // 将当前结点插入到新链表中，头插法
            if (newHead == null) {
                newHead = new ListNode(cur.val);
            } else {
                newHead = new ListNode(cur.val, newHead);
            }

            cur = cur.next;
        }

        return newHead;
    }

    public ListNode reverseList_2(ListNode head) {
        if (head == null) {
            return null;
        }

        // 遍历重新指向
        ListNode newHead = null;
        ListNode cur = head;
        ListNode next;

        while (cur != null) {
            // 先保存下一结点的引用
            next = cur.next;

            // 将当前结点插入到新链表中，头插法
            if (newHead == null) {
                newHead = cur;
                // 原结点从原链表中摘除
                cur.next = null;
            } else {
                cur.next = newHead;
                newHead = cur;
            }

            cur = next;
        }

        return newHead;
    }

    public ListNode reverseList_3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList_3(head.next);
        newHead.next = head;
        head.next = null;

        return head;
    }
}
