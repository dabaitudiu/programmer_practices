题目：实现一个特殊的栈，在实现栈的基本功能的基础上，再返回栈中最小元素的操作。<br/>
要求：
(1).pop,push,getMin操作的时间复杂度都是O(1)
(2).设计的栈类型可以使用现成的栈结构。<br/>
思路：
两种方法:
- 压入时比较`data` 和 `minStack.peek()`的大小， `data <= minStack.peek()`则把data也压入minStack. <br/>弹出时 `data == minStack`则弹出
- 压入时比较`data` 和 `minStack.peek()`的大小， `data < minStack.peek()`则压入minStack, `data == minStack.peek()`则向minStack中再次压入当前最小值。
弹出时每次直接从dataStack和minStack中弹出
