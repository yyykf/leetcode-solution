package co.code4j.leetcode.cn.linked.list;

import co.code4j.leetcode.cn.common.ListNode;

/**
 * 21 - MergeTwoLists
 *
 * @author YuKaiFan
 * @date 2022/4/27
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        // Input: list1 = [1,2,4], list2 = [1,3,4]
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));

        // Output: [1,1,2,3,4,4]
        ListNode result = new MergeTwoLists().mergeTwoLists(list1, list2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
    /**
     * 迭代法合并链表
     *
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的链表
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 创建一个虚拟头结点
        ListNode dummy = new ListNode();
        // 再创建一个移动的指针
        ListNode cur = dummy;

        // 同时遍历两个链表，直到某一个链表结束
        while (list1 != null && list2 != null) {
            /*
                比较两个链表的当前结点，找到较小值之后：
                    1. 将新链表的当前结点的next指向较小结点
                    2. 移动新链表的当前指针
                    3. 移动较小链表的当前指针
             */
            // 比较两个链表的当前结点，获取更小值
            if (list1.val <= list2.val) {
                // 更新当前节点
                cur.next = list1;
                // 移动新链表的指针
                cur = cur.next;
                // 更新较小结点所在的链表指针
                list1 = list1.next;
            } else {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }

        // 来到这里说明有一个链表已经完成遍历了，这时候只需要将另外一个链表的所有结点依次插入到新的链表中即可
        cur.next = list1 != null ? list1 : list2;

        return dummy.next;
    }
}
