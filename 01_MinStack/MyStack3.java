import java.util.Stack;

public class MyStack3 {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MyStack3() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int a) {
        dataStack.push(a);
        if (minStack.isEmpty()) {
            minStack.push(a);
        } else {
            if (a < this.getMin()) {
                minStack.push(a);
            } else {
                minStack.push(this.getMin());
            }
        }
    }

    public int pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        } else {
            int result = dataStack.pop();
            minStack.pop();
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
