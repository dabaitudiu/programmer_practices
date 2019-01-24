public static void sortStackbyStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while(!stack.isEmpty()) {
            int cur = stack.pop();
            while(!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while(!help.isEmpty()) {
            stack.push(help.pop());
        }
        for (int e:stack) {
            System.out.println(e);
        }
}