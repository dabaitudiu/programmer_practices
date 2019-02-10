### 题目：编成一个类，用两个栈实现队列，支持队列的基本操作(add,poll,peek)。<br/>
### 思路：
两个栈一进一出，顺序就正了。注意两点:<br/>
1. stackPop清空前不能向其继续push
2. stackPush向stackPop中压入数据时必须一次性全部压入。
### 解答:
```java
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
```

