import java.util.Stack;

public class MyStack2 {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MyStack2() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int a) {
        dataStack.push(a);
        if (minStack.isEmpty()) {
            minStack.push(a);
        } else {
            if (a <= this.getMin()) {
                minStack.push(a);
            }
        }
    }

    public int pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        } else {
            int result = dataStack.pop();
            if (result == this.getMin()) {
                minStack.pop();
            }
            return result;
        }
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        } else {
            return minStack.peek();
        }
    }
}
