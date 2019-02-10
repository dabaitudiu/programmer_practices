### 题目：实现一个特殊的栈，在实现栈的基本功能的基础上，再返回栈中最小元素的操作。<br/>
### 要求：
(1).pop,push,getMin操作的时间复杂度都是O(1)
(2).设计的栈类型可以使用现成的栈结构。<br/>
### 思路：
两种方法:
- 压入时比较data和minStack.peek()的大小， data <= minStack.peek()则把data也压入minStack. <br/>弹出时 data == minStack则弹出
- 压入时比较data和minStack.peek()的大小， data < minStack.peek()则压入minStack, data == minStack.peek()则向minStack中再次压入当前最小值。
弹出时每次直接从dataStack和minStack中弹出

### 方法1：
```java
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
```
### 方法2：
```java
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
```