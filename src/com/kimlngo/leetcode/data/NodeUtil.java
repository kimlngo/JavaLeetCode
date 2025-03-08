package com.kimlngo.leetcode.data;

public class NodeUtil {
    public static void printList(ListNode head) {
        ListNode cur = head;
        StringBuilder sb = new StringBuilder();

        while (cur != null) {
            sb.append(cur.val);
            sb.append(" -> ");
            cur = cur.next;
        }

        System.out.println(sb.substring(0, sb.length() - 4)
                             .toString());
    }
}
