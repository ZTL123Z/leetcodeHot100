public class code23_相交链表 {
    //循环结束时，如果两条链表相交，那么此时 p 和 q 都在相交的起始节点处，返回 p；如果两条链表不相交，那么 p 和 q 都走到空节点，所以也可以返回 p，即空节点。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode d = headB;
        while(p != d) { // 要把空节点也算进去，所以不能
            // p = p.next != null ? p.next : headB;
            // d = d.next != null ? d.next : headA;
            p = p != null ? p.next : headB;
            d = d != null ? d.next : headA;
        }
        return p;
    }
}



 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
