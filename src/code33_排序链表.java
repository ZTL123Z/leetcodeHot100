public class code33_排序链表 {
    /**
     * 快慢指针 找到中间节点，然后从这里分开为两个链表
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        // 如果链表为空或者只有一个节点，无需排序
        if (head == null || head.next == null) {
            return head;
        }
        // 找到中间节点，然后从这里分开为两个链表
        // 直到不能再分
        ListNode head2 =  middleNode(head);
        // 分治 排序后 再合拼
        head = sortList(head);
        head2 = sortList(head2);
        // 合并
        return mergeTwoLists(head, head2);
    }
    // 输入：链表头节点 head
    private ListNode middleNode(ListNode head) {
        ListNode pre = head;   // 慢指针的前一个节点（用来切断链表）
        ListNode slow = head;  // 慢指针：每次走1步
        ListNode fast = head;  // 快指针：每次走2步

        // 快指针没走到头，就一直走
        while (fast != null && fast.next != null ) {
            pre = slow;        // pre 跟着 slow 走，永远是 slow 的前一个
            slow = slow.next;  // 慢指针走1步
            fast = fast.next.next; // 快指针走2步
        }

        pre.next = null;  // 关键！从中间把链表切断
        return slow;      // 返回后半段链表的头节点（中间节点）
    }

    // 21. 合并两个有序链表（双指针）
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(); // 用哨兵节点简化代码逻辑
        ListNode cur = dummy; // cur 指向新链表的末尾
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1; // 把 list1 加到新链表中
                list1 = list1.next;
            } else { // 注：相等的情况加哪个节点都是可以的
                cur.next = list2; // 把 list2 加到新链表中
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2; // 拼接剩余链表
        return dummy.next;
    }
}
