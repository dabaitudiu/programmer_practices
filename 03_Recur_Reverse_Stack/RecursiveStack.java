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
