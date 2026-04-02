public class code31_K个一组翻转链表 {
    /**
     * 加一组循环处理
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 统计节点个数
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            n++;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        ListNode pre = null;
        ListNode cur = head;

        // k 个一组处理
        for (; n >= k; n -= k) {
            for (int i = 0; i < k; i++) {
                ListNode nxt = cur.next;
                cur.next = pre; // 每次循环只修改一个 next，方便大家理解
                pre = cur;
                cur = nxt;
            }

            // 见视频
            ListNode nxt = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = nxt;
        }
        return dummy.next;
    }
}
