public class StackArray<T> {
    private int index = 0;
    private T[] stack = (T[]) new Object[1];

    private void resize(int size) {
        T[] newStack = (T[]) new Object[size];
        for (int i = 0; i < index; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }
    public boolean isEmpty() {
        return index == 0;
    }
    public void push(T item) {
        if (index >= stack.length) {
            resize(stack.length*2);
        }
        stack[index++] = item;
    }
    public T pop() {
        T item = stack[--index];
        stack[index] = null;
        if (index <= stack.length/4) {
            resize(stack.length/2);
        }
        return item;
    }

    public static void main(String[] args) {
        StackArray<Integer> stack = new StackArray();
        int[] strings = {1, 3, 500};
        for (int arg : strings) {
            stack.push(arg);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}
