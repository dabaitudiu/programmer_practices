### 如何仅用一个栈排序另一个栈
题目：一个栈的元素类型为整型，现在想将其按从栈顶到栈底从大到小排序，只允许申请一个栈，其他变量无限制。<br/>
思路：
- 当前弹出元素记为cur
- 原栈记为stack, 申请的栈记为help. 比较cur与help栈顶的元素，若cur > help.pop()就将help元素压入stack中， 若cur <= help.pop()就将cur压入help中
- 持续操作直到stack为空
- 将help元素倒回stack.

