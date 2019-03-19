import java.util.EmptyStackException;

public class Stack<T> {
    private Node first = null;
    class Node {
        T item;
        Node next;
        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    boolean isEmpty() {
        return first == null;
    }
    void push (T item) {
        Node newNode = new Node(item, first);
        first = newNode;
    }
    T pop () throws EmptyStackException {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        T item = first.item;
        first = first.next;
        return item;
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        int[] strings = {1, 3, 500};
        for (int arg: strings) {
            stack.push(arg);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
