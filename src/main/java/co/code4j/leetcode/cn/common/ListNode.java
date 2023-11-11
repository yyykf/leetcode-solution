package co.code4j.leetcode.cn.common;

/**
 * @Description
 * @Author yukf02
 * @Date 2023/10/29 15:50
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
