### 删除单双链表倒数第k个Node
思路：
- 先遍历，每移动一步K--, 若K == 0， 说明要去除head， 若K > 0, 说明K大于了链表长度
- 若K<0, 从头遍历，每移动一步++K， 若K == 0， cur.next = cur.next.next
- 双向链表同理，仅多了个last node

