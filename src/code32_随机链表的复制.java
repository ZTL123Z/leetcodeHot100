import java.util.ArrayList;

public class code32_随机链表的复制 {
    /**
     * 先用一个数组存进去，再遍历一次，根据 random 指针，复制 random 指针指向的节点到新链表
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        // 复制每个节点，把新节点直接插到原节点的后面
        for (Node cur = head; cur != null; cur = cur.next.next) {
            cur.next = new Node(cur.val, cur.next);
        }

        for (Node cur = head; cur != null; cur = cur.next.next) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
        }

        // 把交错链表分离成两个链表
        Node dummy = new Node(0);
        Node tail = dummy;
        for (Node cur = head; cur != null; cur = cur.next, tail = tail.next) {
            Node copy = cur.next;
            tail.next = copy;
            cur.next = copy.next;
        }

        return dummy.next;

    }
}



// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
