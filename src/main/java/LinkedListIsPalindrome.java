

public class LinkedListIsPalindrome {
    public static boolean isPal(Node head) {
        if (head == null) return false;
        Node curNode = head;
        int n = 0;
        while (curNode != null) {
            n++;
            curNode = curNode.next;
        }


        int halfLength = n / 2;
        int midPoint = halfLength + (n % 2 == 1 ? 1 : 0);
        Node tail = head;
        n = 0;
        while (n < midPoint) {
            n++;
            tail = tail.next;
        }
        int i = 0;
        int[] tailData = new int[halfLength];
        while (i < halfLength) {
            tailData[halfLength - i - 1] = tail.data;
            tail = tail.next;
            i++;
        }

        System.out.println(java.util.Arrays.toString(tailData));
        n = 0;
        while (n < halfLength) {
            if (head.data != tailData[n]) return false;
            head = head.next;
            n++;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] list = {2, 3, 4,5,5,3,4,3,2,1};
        Node head = new Node(1, null);
        for (int i : list) {
            Node newNode = new Node(i, head);
            head = newNode;
        }
        System.out.println(LinkedListIsPalindrome.isPal(head));
    }


}
