import java.util.PriorityQueue;

public class code34_合并K个升序链表 {
    /**
     直接自底向上合并链表：

     两两合并：把 lists[0] 和 lists[1] 合并，合并后的链表保存在 lists[0] 中；把 lists[2] 和 lists[3] 合并，合并后的链表保存在 lists[2] 中；依此类推。
     四四合并：把 lists[0] 和 lists[2] 合并（相当于合并前四条链表），合并后的链表保存在 lists[0] 中；把 lists[4] 和 lists[6] 合并，合并后的链表保存在 lists[4] 中；依此类推。
     八八合并：把 lists[0] 和 lists[4] 合并（相当于合并前八条链表），合并后的链表保存在 lists[0] 中；把 lists[8] 和 lists[12] 合并，合并后的链表保存在 lists[8] 中；依此类推。
     依此类推，直到所有链表都合并到 lists[0] 中。最后返回 lists[0]。

     */
    /**
     * 因此，我们需要一个数据结构，它支持：
     *
     * 从数据结构中找到并移除最小节点。
     * 插入节点。
     * 这可以用最小堆实现。初始把所有链表的头节点入堆，然后不断弹出堆中最小节点 x，如果 x.next 不为空就加入堆中。循环直到堆为空。把弹出的节点按顺序拼接起来，就得到了答案。

     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head); // 把所有非空链表的头节点入堆
            }
        }

        ListNode dummy = new ListNode(); // 哨兵节点，作为合并后链表头节点的前一个节点
        ListNode cur = dummy;
        while (!pq.isEmpty()) { // 循环直到堆为空
            ListNode node = pq.poll(); // 剩余节点中的最小节点
            if (node.next != null) { // 下一个节点不为空
                pq.offer(node.next); // 下一个节点有可能是最小节点，入堆
            }
            cur.next = node; // 把 node 添加到新链表的末尾
            cur = cur.next; // 准备合并下一个节点
        }
        return dummy.next; // 哨兵节点的下一个节点就是新链表的头节点


    }
}
