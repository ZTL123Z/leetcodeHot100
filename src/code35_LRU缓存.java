import java.util.HashMap;
import java.util.Map;

public class code35_LRU缓存 {
    /**
     * 用一个hashmap来实现LRU缓存
     * k是LRU的key,v是LRU的实体
     * get方法:
     * 1.如果key存在,则返回value
     * 2.如果key不存在,则返回-1
     * put方法:
     * 1.如果key存在,则更新value
     * 2.如果key不存在,则添加到缓存中
     * 3.如果缓存已满,则删除LRU的key
     * */
}
class LRUCache { // 利用HashMap, 快速获得节点，和长度。用双链表快速插入和删除
    private static class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int capacity;
    private final Node dummy = new Node(0, 0); // 哨兵节点
    private final Map<Integer, Node> keyToNode = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.prev = dummy;
        dummy.next = dummy;
    }

    public int get(int key) {
        Node node = getNode(key); // 使用他就放到最前面
        return node != null ? node.value : -1;
    }

    public void put(int key, int value) {
        Node node = getNode(key); // 更新也放到最前面
        if (node != null) {
            node.value = value;
            return;
        }
        node = new Node(key, value);
        keyToNode.put(key, node);
        pushFront(node);
        if (keyToNode.size() > capacity) {
            Node backNode = dummy.prev;
            keyToNode.remove(backNode.key);
            remove(backNode);
        }
    }

    // 获取 key 对应的节点，同时把该节点移到链表的头部
    private Node getNode(int key) {
        if(!keyToNode.containsKey(key)) {
            return null;
        }

        Node node = keyToNode.get(key);
        remove(node);
        pushFront(node);
        return node;
    }
    // 删除节点
    private void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }
    // 在链表头部添加一个节点
    private void pushFront(Node x) {
        x.prev = dummy;
        x.next = dummy.next;
        dummy.next = x;
        x.next.prev = x;
    }
}

