public class QueueStack<T> {
    Stack<T> pushStack = new Stack<>();
    Stack<T> tempStack = new Stack<>();
    private void repile() {
        while (!tempStack.isEmpty()) pushStack.push(tempStack.pop());
    }
    private void unpile() {
        while (!pushStack.isEmpty()) tempStack.push(pushStack.pop());
    }
    public boolean isEmpty() {
        return pushStack.isEmpty() && tempStack.isEmpty();
    }
    public void add(T item) {
        if (!tempStack.isEmpty()) repile();
        pushStack.push(item);
    }
    public T remove() {
        unpile();
        if (tempStack.isEmpty()) return null;
        return tempStack.pop();
    }
    public T peek() {
        T item = remove();
        if (item != null) tempStack.push(item);
        return item;
    }
    public static void main(String[] args) {
        QueueStack<Integer> queue = new QueueStack<>();
        for (int i = 0; i < 100; i++) {
            if (i%3 == 0) queue.add(i);
        }
        while (!queue.isEmpty()) System.out.println(queue.remove());

    }

}
