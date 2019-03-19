public class SortStack {

    private static void extractMax(Stack<Integer> origin, Stack<Integer> dest, int count) {
        int max = Integer.MIN_VALUE;
        int reverseCount = count;
        while (count-- > 0) {
            int temp = origin.pop();
            if (temp > max) max = temp;
            dest.push(temp);
        }
        origin.push(max);
        boolean foundMax = false;
        while (reverseCount-- > 0) {
            int temp = dest.pop();
            if (temp == max && !foundMax) {
                foundMax = true;
            } else origin.push(temp);
        }

    }
    public static void sort(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        int count = 0;
        while (!stack.isEmpty()) {
            count++;
            tempStack.push(stack.pop());
        }
        while (!tempStack.isEmpty()) stack.push(tempStack.pop());
        while (count > 0) {
            extractMax(stack, tempStack, count);
            count--;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }
        SortStack.sort(stack);
        while (!stack.isEmpty()) System.out.println(stack.pop());



    }
}
