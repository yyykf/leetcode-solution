package co.code4j.leetcode.cn.linked.list;

import co.code4j.leetcode.cn.common.ListNode;
import java.util.*;

/**
 * @Description
 * @Author yukf02
 * @Date 2023/10/31 14:45
 */
public class _214_LinkedListCycle {

    public boolean hasCycle_1(ListNode head) {
        HashMap<ListNode, Boolean> accessFlagMap = new HashMap<>();

        while (head != null) {
            if (accessFlagMap.containsKey(head)) {
                return true;
            }

            accessFlagMap.put(head, true);

            head = head.next;
        }

        return false;
    }

    public boolean hasCycle_2(ListNode head) {
        while (head != null) {
            if (head.val == Integer.MIN_VALUE) {
                return true;
            }

            head.val = Integer.MIN_VALUE;

            head = head.next;
        }

        return false;
    }

    public boolean hasCycle_3(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null) {
                // 如果没环的话，快指针一定先到达链表尾，即 null
                return false;
            }

            // 慢指针每次移动一步
            slow = slow.next;
            // 快指针每次移动两步
            fast = fast.next == null ? null : fast.next.next == null ? null : fast.next.next;
        }

        // 跳出循环，那就说明两个指针在环内相遇了，否则 fast 为 null 的话已经返回了
        return true;
    }
}
