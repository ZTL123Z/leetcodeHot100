import java.util.HashSet;
import java.util.Set;

/**
 * 修改一下返回值就好了
 */

public class code26_环形链表II {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while(head != null) {
            if (!seen.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
