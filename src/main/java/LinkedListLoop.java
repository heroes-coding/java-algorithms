import java.util.*;

public class LinkedListLoop {
    public static Node loopStart(Node head) {
        if (head == null) {
            return null;
        }
        Set<Node> usedNodes = new HashSet();
        List<Node> listo = new ArrayList();
        while (head != null) {
            if (usedNodes.contains(head)) {
                return head;
            }
            usedNodes.add(head);
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Node head = new Node (-1, null);
        Node oldHead = head;
        Node five = null;
        for (int i = 0; i < 10; i++) {
            Node node = new Node(i, null);
            head.next = node;
            head = node;
            if (i == 1) {
                five = node;
            }
        }
        head.next = five;
        Node loopHead = LinkedListLoop.loopStart(oldHead);
        System.out.println(loopHead.data);

    }


}
