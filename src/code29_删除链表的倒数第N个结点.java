public class code29_删除链表的倒数第N个结点 {
    /**
     * 可能会删除头结点，要注意这种情况
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = head;
        ListNode cur = head;
        //先遍历一遍，统计链表长度
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        // 如果删除的是头结点，直接返回头结点的下一个结点
        if (len == n) {
            return head.next;
        }
        // 否则，遍历链表，找到要删除的结点的前一个结点
        cur = head;
        for (int i = 0; i < len - n - 1; i++) {
            cur = cur.next;
        }
        // 删除要删除的结点
        cur.next = cur.next.next;
        return ans;
    }
}
