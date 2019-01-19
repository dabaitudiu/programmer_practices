import java.util.Stack;

public class TwoStacksQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStacksQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void add(int a) {
        stackPush.push(a);
    }

    public int poll() {
        // Mistake happened here. Forget to add exceptions.
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        if (!stackPop.isEmpty()) {
            return stackPop.pop();
        } else {
            while(!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
            return stackPop.pop();
        }
    }

    public int peek() {
        if (!stackPop.isEmpty()) {
            return stackPop.peek();
        } else {
            if (stackPush.isEmpty()) {
                throw new RuntimeException("There are no elements in the list.");
            }
            while(!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
            return stackPop.peek();
        }
    }
}
