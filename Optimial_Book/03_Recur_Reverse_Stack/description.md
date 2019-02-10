## 如何仅用递归函数和栈操作逆序一个栈
### 题目：一个栈一次压入1，2，3，4，5， 那么从栈顶到栈底分别为5，4，3，2，1. 将这个栈转置后，从栈顶到栈底为1，2，3，4，5， 也就是实现栈中元素的逆序，但是只能用递归函数来实现，不能用其他数据结构。<br/>
### 思路：
1. 递归函数1：将栈stack的栈底元素返回并移除。
2. 逆序一个栈，用1里的函数。
### 解答：
```java
import java.util.Stack;

public class RecursiveStack {
    public static int getLastElementAndRemove(Stack<Integer> stack) {
        int a = stack.pop();
        if (stack.isEmpty()) {
            return a;
        } else {
            a = getLastElementAndRemove(stack);
            stack.push(a);
            return a;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return ;
        } else {
            int a = getLastElementAndRemove(stack);
            reverse(stack);
            stack.push(a);
        }
    }
}
```

