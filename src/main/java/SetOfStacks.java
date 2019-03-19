import java.util.*;


public class SetOfStacks {
    List<SizedStack<Integer>> stacks = new ArrayList<SizedStack<Integer>>();
    int threshold;

    private void addStack() {
        SizedStack<Integer> stack = new SizedStack<Integer>();
        stacks.add(stack);
    }

    public SetOfStacks(int threshold) {
        this.threshold = threshold;
    }

    public void push(int value) {
        int index = stacks.size() - 1;
        if (index < 0) {
            addStack();
            push(value);
            return;
        }
        SizedStack<Integer> stack = stacks.get(index);
        if (stack.size() >= threshold) {
            addStack();
            push(value);
        } else {
            stack.push(value);
        }

    }
    public Integer pop() {
        int index = stacks.size()-1;
        if (index < 0) return null;
        SizedStack<Integer> stack = stacks.get(index);
        if (stack.isEmpty()) {
            stacks.remove(index);
            return pop(index-1);
        }
        return stack.pop();
    }
    public Integer pop(int index) {
        if (index >= stacks.size()) return null;
        SizedStack<Integer> stack = stacks.get(index);
        if (stack.isEmpty()) {
            stacks.remove(index);
            return pop(index);
        }
        return stack.pop();
    }


    class SizedStack<T extends Integer> extends Stack{
        int count = 0;
        public void push(T item) {
            count++;
            super.push(item);
        }
        public T pop() {
            count--;
            return (T)super.pop();
        }
        public int size() {
            return count;
        }
    }


    public static void main(String[] args) {
        SetOfStacks set = new SetOfStacks(10);
        for (int i = 0; i < 100; i++) {
            set.push(i);
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(set.pop(2));
        }

    }

}
