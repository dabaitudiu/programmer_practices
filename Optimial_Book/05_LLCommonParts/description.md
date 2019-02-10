## 打印两个有序链表的公共部分
### 题目：如题
### 解答：
```java
public class Node {
    private int value;
    private Node next;

    public Node(int data) {
        this.value = data;
    }
}

public void printCommonPart(Node nodeA, Node nodeB) {
    System.out.println("Common part: ");
    while(nodeA != null && nodeB !=null) {
        if (nodeA.value > nodeB.value) {
            nodeB = nodeB.next;
        } else if (nodeA.value < nodeB.value) {
            nodeA = nodeA.next;
        } else {
            System.out.println(nodeA.value + " ");
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
    }
}
```
