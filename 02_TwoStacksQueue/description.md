题目：编成一个类，用两个栈实现队列，支持队列的基本操作(add,poll,peek)。<br/>
思路：
两个栈一进一出，顺序就正了。注意两点:<br/>
1. stackPop清空前不能向其继续push
2. stackPush向stackPop中压入数据时必须一次性全部压入。

